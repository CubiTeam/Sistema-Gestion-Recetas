import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.lang.System;
import java.io.IOException;
import java.awt.Font;

public class VentanaCrearUsuario extends JFrame 
{
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtRUT;
	private JTextField txtCorreo;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDigVer;
	private Archivos archivo;
	
	public VentanaCrearUsuario(final Universidad universidad,final VentanaDocente ventanaAnterior, final boolean esDocente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Nuevo alumno");
		setResizable(false);
        setDefaultCloseOperation(0);
        
		Toolkit myNativeScreen = Toolkit.getDefaultToolkit(); //Sistema nativo de ventana
		Dimension sizeScreen = myNativeScreen.getScreenSize(); //Obtener resolucion pantalla
		
		int alturaPantalla = sizeScreen.height;
		int anchoPantalla = sizeScreen.width;
		
		setSize(315, 366); //Dar tamano
		setLocation(anchoPantalla/3, alturaPantalla/4); //Centrarlo
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		//JLabel
		
		JLabel lblIngreseLosSiguientes = new JLabel("Ingrese los siguientes datos :");
		lblIngreseLosSiguientes.setForeground(new Color(255, 255, 255));
		lblIngreseLosSiguientes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblIngreseLosSiguientes.setBounds(10, 53, 255, 14);
		contentPane.add(lblIngreseLosSiguientes);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNombre.setBounds(25, 78, 70, 14);
		contentPane.add(lblNombre);
		
		JLabel lblRut = new JLabel("RUT :");
		lblRut.setForeground(new Color(255, 255, 255));
		lblRut.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblRut.setBounds(25, 100, 46, 14);
		contentPane.add(lblRut);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCorreo.setBounds(25, 125, 70, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblEdad.setBounds(25, 150, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblSexo.setBounds(25, 177, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setForeground(new Color(255, 255, 255));
		lblTelfono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTelfono.setBounds(25, 230, 70, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblDirección = new JLabel("Direcci\u00F3n :");
		lblDirección.setForeground(new Color(255, 255, 255));
		lblDirección.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDirección.setBounds(25, 205, 70, 14);
		contentPane.add(lblDirección);
		
		JLabel label = new JLabel("-");
		label.setBounds(237, 100, 38, 14);
		contentPane.add(label);
		
		final JLabel lblVerifCorreo = new JLabel();
		lblVerifCorreo.setBounds(280, 120, 29, 20);
		contentPane.add(lblVerifCorreo);
		
		final JLabel lblVerifTelefono = new JLabel();
		lblVerifTelefono.setBounds(280, 227, 46, 14);
		contentPane.add(lblVerifTelefono);
		
		final JLabel lblVerifEdad = new JLabel();
		lblVerifEdad.setBounds(280, 150, 46, 14);
		contentPane.add(lblVerifEdad);
		
		final JLabel lblVerifRUT = new JLabel();
		lblVerifRUT.setBounds(280, 100, 46, 14);
		contentPane.add(lblVerifRUT);
		
		final JLabel lblVerifDireccion = new JLabel();
		lblVerifDireccion.setBounds(280, 202, 46, 14);
		contentPane.add(lblVerifDireccion);
		
		final JLabel lblVerifNombre = new JLabel();
		lblVerifNombre.setBounds(280, 75, 46, 14);
		contentPane.add(lblVerifNombre);
		
		
		
		
		
		
		
		
		
		
		
//-----------------------------------------------------------------------------------------------------------------------------
		//JTextField

		txtNombre = new JTextField();
		txtNombre.setToolTipText("Ej: Luis Perez");
		txtNombre.setBounds(89, 72, 186, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRUT = new JTextField();
		txtRUT.setToolTipText("Ej: 12345678");
		txtRUT.setBounds(89, 97, 144, 26);
		contentPane.add(txtRUT);
		txtRUT.setColumns(10);
		
		txtDigVer = new JTextField();
		txtDigVer.setToolTipText("0-9 o K");
		txtDigVer.setBounds(251, 97, 24, 26);
		contentPane.add(txtDigVer);
		txtDigVer.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("example@domain.com");
		txtCorreo.setBounds(89, 122, 186, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
			
		txtEdad = new JTextField();
		txtEdad.setBounds(89, 147, 46, 26);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);	
		
		String[] sexoStrings = {"Masculino", "Femenino"};
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(89, 199, 186, 26);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setToolTipText("Ej: 12345678");
		txtTelefono.setBounds(89, 224, 186, 26);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		
		
		
		
		
		
		
		
		
		
//---------------------------------------------------------------------------------------------------------------------------
		//VALIDACIONES
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//validacion del nombre
		
		
		
		//valida que el nombre sea ingresado
		txtNombre.addKeyListener(new KeyListener()
		{
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){

			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtNombre.getText().length() == 0){
					txtNombre.setBackground(Color.red);
					lblVerifNombre.setText("\u2717");
				}
				
				if(txtNombre.getText().length() > 0 ){
					txtNombre.setBackground(Color.green);
					lblVerifNombre.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtNombre.getText().length() == 0){
					txtNombre.setBackground(Color.red);
					lblVerifNombre.setText("\u2717");
				}
			}
		});
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		//validacion del rut
		
		
		
		//limita la cantidad de numeros a 8
		txtRUT.addKeyListener(new KeyListener()
		{	
			int tamanoRUT = 8;
		
			public void keyTyped(KeyEvent e){
				if (txtRUT.getText().length() == tamanoRUT)
					e.consume();
			}
			public void keyPressed(KeyEvent e){
				if(txtRUT.getText().length() < tamanoRUT){
					txtRUT.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
				
				if(txtRUT.getText().length() == (tamanoRUT - 1)){
					txtRUT.setBackground(Color.green);
					lblVerifRUT.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtRUT.getText().length() < tamanoRUT){
					txtRUT.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
			}
		});
		
		
		
		//limita la cantidad de numeros del digito verificador a 1
		txtDigVer.addKeyListener(new KeyListener()
		{
			int tamanoDigVerf = 1;
			public void keyTyped(KeyEvent e){
				if (txtDigVer.getText().length() == tamanoDigVerf)
					e.consume();
			}
			public void keyPressed(KeyEvent e){
				if(txtDigVer.getText().length() == (tamanoDigVerf - 1)){
					txtDigVer.setBackground(Color.green);
					lblVerifRUT.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtDigVer.getText().length() < tamanoDigVerf){
					txtDigVer.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
			}
		});
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//validacion de la edad
		
		txtEdad.addKeyListener(new KeyListener()
		{
			int tamanoEdad = 2;
			
			public void keyTyped(KeyEvent e){
				if(txtEdad.getText().length() == tamanoEdad){
					e.consume(); 
				}
			}
			public void keyPressed(KeyEvent e){
				if(txtEdad.getText().length() < tamanoEdad){
					txtEdad.setBackground(Color.red);
					lblVerifEdad.setText("\u2717");
				}
				
				if(txtEdad.getText().length() == (tamanoEdad - 1)){
					txtEdad.setBackground(Color.green);
					lblVerifEdad.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtEdad.getText().length() < tamanoEdad){
					txtEdad.setBackground(Color.red);
					lblVerifEdad.setText("\u2717");
				}
			}
		});
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		//validacion de dirección
		
		
		
		
		
		//valida que la dirección exista
		txtDireccion.addKeyListener(new KeyListener()
		{
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){

			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtDireccion.getText().length() == 0){
					txtDireccion.setBackground(Color.red);
					lblVerifDireccion.setText("\u2717");
				}
				
				if(txtDireccion.getText().length() > 0 ){
					txtDireccion.setBackground(Color.green);
					lblVerifDireccion.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtDireccion.getText().length() == 0){
					txtDireccion.setBackground(Color.red);
					lblVerifDireccion.setText("\u2717");
				}
			}
		});

		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		//validacion del telefono
		
		
		
		
		
		//Limitar a escribir 8 numeros 
		txtTelefono.addKeyListener(new KeyListener(){
			int tamanoTelefono = 8;
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){
			if(txtTelefono.getText().length() == tamanoTelefono)
				e.consume(); //limita la cantidad de caracteres
			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtTelefono.getText().length() < tamanoTelefono){
					txtTelefono.setBackground(Color.red);
					lblVerifTelefono.setText("\u2717");
				}
							
				if(txtTelefono.getText().length() == (tamanoTelefono - 1)){
					txtTelefono.setBackground(Color.green);
					lblVerifTelefono.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtTelefono.getText().length() < tamanoTelefono){
					txtTelefono.setBackground(Color.red);
					lblVerifTelefono.setText("\u2717");
				}
			}
		});
		final JComboBox comboBoxSexo = new JComboBox(sexoStrings);
		comboBoxSexo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboBoxSexo.setBounds(89, 172, 100, 25);
		contentPane.add(comboBoxSexo);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton de registrar
		JButton btnRegistrarse = new JButton("Registrar"); 
		btnRegistrarse.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sexoUsuario = (String) comboBoxSexo.getSelectedItem();
				if(!txtNombre.getText().isEmpty() && !txtRUT.getText().isEmpty()
						&& !txtDireccion.getText().isEmpty() && !txtEdad.getText().isEmpty()
						&& !txtTelefono.getText().isEmpty())
				{
					if(esDocente){
						Docente nuevoDocente = new Docente(txtNombre.getText(),
								txtRUT.getText(),txtDireccion.getText(),txtCorreo.getText(),
								sexoUsuario,Integer.parseInt(txtEdad.getText()),
								Integer.parseInt(txtTelefono.getText()));
						nuevoDocente.generarContrasena();
						
						if(universidad.getListaDocentes().agregar(nuevoDocente))
						{
							lblVerifCorreo.setText("\u2713");
							txtCorreo.setBackground(Color.GREEN);
							JOptionPane.showMessageDialog(VentanaCrearUsuario.this,"Su contraseña es\n"+
									nuevoDocente.getContrasena(),"Datos ingresados correctamente",1);
						
						
						}else{
							
							Alumno nuevoAlumno = new Alumno(txtNombre.getText(),
									txtRUT.getText(),txtDireccion.getText(),txtCorreo.getText(),
									sexoUsuario,Integer.parseInt(txtEdad.getText()),
									Integer.parseInt(txtTelefono.getText()));
							nuevoAlumno.generarContrasena();
						
							if(universidad.getListaAlumnos().agregar(nuevoAlumno))
							{
								lblVerifCorreo.setText("\u2713");
								txtCorreo.setBackground(Color.GREEN);
								JOptionPane.showMessageDialog(VentanaCrearUsuario.this,"Su contraseña es\n"+
										nuevoAlumno.getContrasena(),"Datos ingresados correctamente",1);
							}
					}
						
				}else{			
					lblVerifCorreo.setText("\u2717");
					JOptionPane.showMessageDialog(VentanaCrearUsuario.this,
							"Ingresó mal algun campo","Error",0);
				}
				txtNombre.setEditable(false);
				txtEdad.setEditable(false);
				txtCorreo.setEditable(false);
				txtTelefono.setEditable(false);
				txtDireccion.setEditable(false);
				txtDigVer.setEditable(false);
				txtRUT.setEditable(false);
			}
			else
				JOptionPane.showMessageDialog(VentanaCrearUsuario.this,
						"faltó llenar algun campo","Error",0);
			}
		});
		btnRegistrarse.setBounds(10, 277, 179, 37);
		contentPane.add(btnRegistrarse);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton atras
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAtras.setBounds(199, 277, 100, 37);
		contentPane.add(btnAtras);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnSalir = new JButton("Cerrar Sesión");
		btnSalir.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(178, 14, 125, 29);
		contentPane.add(btnSalir);
	
		
		
		
		
		
		
	}//FIN DEL CONTRUCTOR

}
