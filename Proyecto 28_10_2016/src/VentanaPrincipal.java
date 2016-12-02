import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAlumno;
	private JPasswordField psswField;
	
	
	public VentanaPrincipal(final Universidad universidad)  
	{
		//Aspecto Nimbus a la interfaz
		try{			
			JFrame.setDefaultLookAndFeelDecorated(true);
		  	JDialog.setDefaultLookAndFeelDecorated(true);
		  	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		}catch (Exception e){
			e.printStackTrace();
		}	
	
		
		setTitle("Sistema de Gestion de Recetas");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 500);
		setResizable(false);
		
		Toolkit pantallaNativa = Toolkit.getDefaultToolkit();//Sistema nativo de ventana
		Dimension pantallaTamano = pantallaNativa.getScreenSize(); //Obtener resolucion pantalla
		
		int alturaPantalla = pantallaTamano.height;
		int anchoPantalla = pantallaTamano.width;
		
		setSize(400, 545); //Dar tamano
		setLocation(anchoPantalla/3, alturaPantalla/4); //Centrarlo
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPontificiaUniversidadCatolica = new JLabel("PONTIFICIA UNIVERSIDAD CATOLICA DE GASTRONOMIA");
		lblPontificiaUniversidadCatolica.setForeground(Color.WHITE);
		lblPontificiaUniversidadCatolica.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPontificiaUniversidadCatolica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontificiaUniversidadCatolica.setBounds(0, 24, 392, 14);
		contentPane.add(lblPontificiaUniversidadCatolica);
		
				
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//PANEL INGRESAR DATOS DE INICIO SESION
		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setForeground(Color.BLACK);
		panelInicioSesion.setBorder(new TitledBorder(new MatteBorder(2, 20, 2, 2, (Color) new Color(255, 255, 255)), 
					"Ingrese su RUT y contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, 
						new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		
		panelInicioSesion.setBackground(new Color(0, 153, 255));
		panelInicioSesion.setBounds(19, 215, 354, 104);
		contentPane.add(panelInicioSesion);
		panelInicioSesion.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(38, 37, 73, 14);
		panelInicioSesion.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(23, 68, 88, 14);
		panelInicioSesion.add(lblContrasena);
		
		textFieldAlumno = new JTextField();
		textFieldAlumno.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textFieldAlumno.setBounds(123, 32, 214, 25);
		panelInicioSesion.add(textFieldAlumno);
		textFieldAlumno.setColumns(10);
		
		psswField = new JPasswordField();
		psswField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		psswField.setBounds(123, 62, 214, 25);
		panelInicioSesion.add(psswField);
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------	
		
		//PANEL TIPO Alumno
		JPanel paneltipoUsuario = new JPanel();
		paneltipoUsuario.setBackground(new Color(0, 153, 255));
		paneltipoUsuario.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true), "Tipo Usuario", 
				TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		
		paneltipoUsuario.setBounds(41, 335, 202, 63);
		contentPane.add(paneltipoUsuario);
		paneltipoUsuario.setLayout(null);
		
		JLabel lblTipoUsuario = new JLabel("Usuario");
		lblTipoUsuario.setBounds(18, 27, 64, 14);
		paneltipoUsuario.add(lblTipoUsuario);
		lblTipoUsuario.setForeground(Color.WHITE);
		lblTipoUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		String[] tipoUsuario = {"Alumno","Docente"};
		
		final JComboBox comboBoxtipoUsuario = new JComboBox(tipoUsuario);
		comboBoxtipoUsuario.setBounds(79, 22, 105, 25);
		paneltipoUsuario.add(comboBoxtipoUsuario);
		comboBoxtipoUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		
		
		
		
		
				
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//BOTON INICIAR SESION
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIniciarSesion.setBounds(255, 348, 107, 39);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoUsuario = (String) comboBoxtipoUsuario.getSelectedItem();
				
				//verifica que se seleccionó alumno
				if(tipoUsuario.equals("Alumno"))
				{
					//verifica que el alumno existe
					if(universidad.getListaAlumnos().existe(textFieldAlumno.getText()))
					{
						Alumno alumno=universidad.getListaAlumnos().busqueda(textFieldAlumno.getText());
						//verifica que la contraseña ingresada es valida
						try {
							if(universidad.getListaAlumnos().verificacion(alumno.getContrasena(),psswField.getText()))
							{
							Alumno Alumno = universidad.getListaAlumnos().getAlumno(textFieldAlumno.getText(),psswField); 
							JOptionPane.showMessageDialog(VentanaPrincipal.this,"Se inició sesión correctamente","Bienvenido",1);
							//creo la ventanaAlumnoEstandar
							VentanaAlumno ventanaAlumno = new VentanaAlumno(universidad,Alumno,VentanaPrincipal.this);
							ventanaAlumno.setVisible(true);
							dispose();
							
							//Dejar en blanco los campos de rut y contraseña
							textFieldAlumno.setText("");
							psswField.setText("");
							}
							else
								JOptionPane.showMessageDialog(VentanaPrincipal.this,"Contraseña incorrecta","Error",0);
						} catch (HeadlessException | CorreoException e1) {
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"No se encontró Alumno","Error",0);
					}
					
				}
				//verifica que selecciono docente
				if(tipoUsuario.equals("Docente"))
				{	
					//verifica que exista el docente
					if(universidad.getListaDocentes().existe(textFieldAlumno.getText()))
					{
						Docente docente=(Docente)universidad.getListaDocentes().busqueda(textFieldAlumno.getText());
						//verifica que la contraseña ingresada es valida
						try {
							if(universidad.getListaDocentes().verificacion(docente.getContrasena(),psswField.getText()))
							{
								JOptionPane.showMessageDialog(VentanaPrincipal.this,"Se inició sesión correctamente","Bienvenido",1);		
								VentanaDocente ventanadocente = new VentanaDocente(docente,universidad);
								ventanadocente.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(VentanaPrincipal.this,"Contraseña incorrecta","Error",0);
						} catch (HeadlessException | CorreoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else
					{
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"No se encontró docente registrado","Error",0);
					}	
				}
			}}
		);
			
		contentPane.add(btnIniciarSesion);
		
		
		
		
		
		
		
		
		
		
//-----------------------------------------------------------------------------------------------------------------------
		
		//BOTON SALIR
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorder(null);
		btnSalir.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSalir.setBounds(309, 466, 75, 39);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);

		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON RECUPERAR CONTRASEÑA
		JButton btnRecuperarContrasena = new JButton("Recuperar Contrase\u00F1a");
		btnRecuperarContrasena.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRecuperarContrasena.setBounds(103, 417, 185, 43);
		btnRecuperarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posAlumnoRecuperado;
				String correoAlumnoBuscado = JOptionPane.showInputDialog(null, "Ingrese su correo: ", "Para recuperar contraseña", JOptionPane.QUESTION_MESSAGE);	
				if(correoAlumnoBuscado != null)
					if(universidad.getListaAlumnos().existeAlumnoCorreo(correoAlumnoBuscado)){			
						String ingreseNombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ", "Para recuperar contraseña", JOptionPane.QUESTION_MESSAGE);
						posAlumnoRecuperado = universidad.getListaAlumnos().posicionAlumno(ingreseNombre);
						if(posAlumnoRecuperado != -1){
							EnviarMensajeACorreo enviarCorreo = new EnviarMensajeACorreo();
							enviarCorreo.crearMensajeConLaContrasena(universidad,correoAlumnoBuscado, posAlumnoRecuperado);
						}
					}else{
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "No se encontró Alumno");
					}
			}
		});
		contentPane.add(btnRecuperarContrasena);
	
	}//FIN CONTRUCTOR

	

}//FIN CLASE