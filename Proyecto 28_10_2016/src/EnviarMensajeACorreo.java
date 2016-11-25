import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnviarMensajeACorreo{

    public static String correo = "projectGRDC@gmail.com";
    public static String contrasena = "GRDCproject1234";
    private String mensaje;
    private String destinatario;
    private String asunto;
	private Multipart contenido;
    
    // Autentifica los datos de smtp y luego envia un mensaje con la contraseña al correo del alumno
    public void EnviarCorreo() 
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
        	new javax.mail.Authenticator() {
            	protected PasswordAuthentication getPasswordAuthentication() {
            		return new PasswordAuthentication(correo, contrasena);
            	}
            });
        session.setDebug(true);

        try {
        	
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            message.setContent(contenido);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Se ha enviado correctamente a su correo!");
        } catch (MessagingException e) {
        	JOptionPane.showMessageDialog(null, "No se ha enviado el mensaje, revise si escribio bien el correo");
            System.out.println(e.getCause());
        }
    }
    
    
    
   
    //Crea el mensaje y llama a la funcion que lo envia
    public void crearMensajeConLaContrasena(Universidad universidad,String correoAlumnoBuscado, int posAlumnoRecuperado) 
	{	
    	Alumno alumno = universidad.getListaAlumnos().getPosAlumno(posAlumnoRecuperado);
		mensaje = "Hola, "+alumno.getNombrePersona()+":\n"
				+ "Su contraseña para ingresar a la Pontificia Universidad Católica de Gastronomia es "
				+alumno.getContrasena()
				+".\n\nAtentamente,\nEl Equipo de GRDC";
		destinatario = correoAlumnoBuscado;
		asunto = "Ud. ha solicitado recuperar contraseña";
		
		BodyPart mensajeB = new MimeBodyPart();
        try {
        	mensajeB.setText(mensaje);
		    MimeMultipart multiParte = new MimeMultipart();
		    multiParte.addBodyPart(mensajeB); 
		    
	        contenido = multiParte;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		EnviarCorreo();	
	}
    
    
    public void crearMensajeConArchivoAdjunto(String correoAlumno)
    {
    	mensaje = "Hola,\nLe enviamos como adjunto en este mensaje un documento pdf con sus recetas."
    				+ "\nGracias por usar nuestro Software.\nAtentamente,\nEl equipo de GRDC.";
    	asunto = "Ud. ha solicitado un documento con sus recetas";
    	destinatario = correoAlumno;
    	
    	BodyPart mensajeB = new MimeBodyPart();
    	BodyPart adjunto = new MimeBodyPart();      
    	
    	try {
        	mensajeB.setText(mensaje);
        	adjunto.setDataHandler(
                    new DataHandler(new FileDataSource("MisRecetas.pdf")));
            adjunto.setFileName("MisRecetas.pdf");
            
	        MimeMultipart multiParte = new MimeMultipart();
	        multiParte.addBodyPart(adjunto);
	        multiParte.addBodyPart(mensajeB);
        
	        contenido = multiParte;
	        
		} catch (MessagingException e) {
        	JOptionPane.showMessageDialog(null, "No se ha enviado el mensaje, revise si escribio bien el correo o si tiene conexion a internet");
            System.out.println(e.getCause());
		}
        EnviarCorreo();	
    }
    
    
    
    
    
    


}
