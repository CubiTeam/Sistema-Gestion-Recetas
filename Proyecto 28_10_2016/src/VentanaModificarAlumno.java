import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class VentanaModificarAlumno extends JFrame {

	private JPanel contentPane;
	
	public VentanaModificarAlumno(final Alumno usuario,final Universidad universidad, final VentanaDocente ventanaAnterior){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		final JLabel lblNombre = new JLabel("Nombre : "+usuario.getNombrePersona());
		lblNombre.setBounds(10, 30, 280, 14);
		contentPane.add(lblNombre);
		
		final JLabel lblDireccion = new JLabel("Direccion : "+usuario.getDireccion());
		lblDireccion.setBounds(10, 60, 280, 14);
		contentPane.add(lblDireccion);
		
		final JLabel lblRut = new JLabel("Rut : "+usuario.getRut());
		lblRut.setBounds(10, 90, 280, 14);
		contentPane.add(lblRut);
		
		final JLabel lblTelefono = new JLabel("Telefono : "+usuario.getTelefono());
		lblTelefono.setBounds(10, 150, 280, 14);
		contentPane.add(lblTelefono);
		
		final JLabel lblEdad = new JLabel("Edad : "+usuario.getEdad());
		lblEdad.setBounds(10, 120, 201, 14);
		contentPane.add(lblEdad);
		
		final JLabel lblCorreo = new JLabel("Correo : "+usuario.getCorreo());
		lblCorreo.setBounds(10, 180, 280, 14);
		contentPane.add(lblCorreo);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventanaInicial = new VentanaPrincipal(universidad);
				dispose();
				ventanaInicial.setVisible(true);
			}
		});
		btnCerrarSesion.setBounds(239, 219, 110, 31);
		contentPane.add(btnCerrarSesion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAtras.setBounds(10, 219, 110, 31);
		contentPane.add(btnAtras);
		
//------------------------------------------------------------------------------------------------------------------------	
		
		//MODIFICAR NOMBRE
		
		final JLabel lblmodificarNombre = new JLabel("[Modificar]");
		lblmodificarNombre.setForeground(Color.BLUE);
		lblmodificarNombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarNombre.setBounds(300, 30, 49, 14);
		contentPane.add(lblmodificarNombre);
		
		//Modifica el nombre al presionar en el label [Modificar]
		
		lblmodificarNombre.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 	{
				String editarNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre : ", "Edite nombre : ", JOptionPane.QUESTION_MESSAGE);
				if(universidad.getListaAlumnos().modificar(usuario, editarNombre))
					{
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
						lblNombre.setText("Nombre : "+usuario.getNombrePersona());
					}
				else
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
				
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarNombre.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarNombre.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});

//------------------------------------------------------------------------------------------------------------------------	
		
		//MODIFICAR DIRECCION
		
		final JLabel lblmodificarDireccion = new JLabel("[Modificar]");
		lblmodificarDireccion.setForeground(Color.BLUE);
		lblmodificarDireccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarDireccion.setBounds(300, 60, 49, 14);
		contentPane.add(lblmodificarDireccion);
		
		lblmodificarDireccion.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 	{
				String editarDireccion = JOptionPane.showInputDialog(null, "Ingrese su nueva dirección: ", "Edite dirección : ", JOptionPane.QUESTION_MESSAGE);
				if(universidad.getListaAlumnos().modificarDireccion(usuario, editarDireccion))
					{
						lblDireccion.setText("Direccion : "+usuario.getDireccion());
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
					}
				else
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
				
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
//------------------------------------------------------------------------------------------------------------------------	
		
		//MODIFICAR RUT
		
		final JLabel lblmodificarRut = new JLabel("[Modificar]");
		lblmodificarRut.setForeground(Color.BLUE);
		lblmodificarRut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarRut.setBounds(300, 90, 49, 14);
		contentPane.add(lblmodificarRut);
		
		lblmodificarRut.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 	{
				String editarRut = JOptionPane.showInputDialog(null, "Ingrese el nuevo rut : ", "Edite rut : ", JOptionPane.QUESTION_MESSAGE);
				if(universidad.getListaAlumnos().modificarRut(usuario, editarRut))
				{
					lblRut.setText("Rut : "+usuario.getRut());
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
				}
			else
				JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
				
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarRut.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarRut.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});		
//----------------------------------------------------------------------------------------------------------------------		
		
		//MODIFICAR EDAD
		
		final JLabel lblmodificarEdad = new JLabel("[Modificar]");
		lblmodificarEdad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarEdad.setForeground(Color.BLUE);
		lblmodificarEdad.setBounds(300, 120, 49, 14);
		contentPane.add(lblmodificarEdad);

		lblmodificarEdad.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) 
			{
				String editarEdad = JOptionPane.showInputDialog(null, "Ingrese la nueva edad: ", "Edite edad : ", JOptionPane.QUESTION_MESSAGE);
							
				if(universidad.getListaAlumnos().modificarEdad(usuario, editarEdad))
				{
					lblEdad.setText("Edad : "+usuario.getEdad());
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
				
					
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarEdad.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarEdad.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
//----------------------------------------------------------------------------------------------------------------------		
		
		//MODIFICAR TELEFONO
		
		final JLabel lblmodificarTelefono = new JLabel("[Modificar]");
		lblmodificarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarTelefono.setForeground(Color.BLUE);
		lblmodificarTelefono.setBounds(300, 150, 49, 14);
		contentPane.add(lblmodificarTelefono);

		lblmodificarTelefono.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) 
			{
				String editarTelefono = JOptionPane.showInputDialog(null, "Ingrese su nuevo teléfono: ", "Edite teléfono : ", JOptionPane.QUESTION_MESSAGE);
				if(universidad.getListaAlumnos().modificarTelefono(usuario, editarTelefono))
				{
					lblTelefono.setText("Telefono : "+usuario.getTelefono());
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
				
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});				
		
//----------------------------------------------------------------------------------------------------------------------		
		
		//MODIFICAR CORREO
		
		final JLabel lblmodificarCorreo = new JLabel("[Modificar]");					
		lblmodificarCorreo.setForeground(Color.BLUE);
		lblmodificarCorreo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarCorreo.setBounds(300, 180, 49, 14);
		contentPane.add(lblmodificarCorreo);
		
		lblmodificarCorreo.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{				
				String editarCorreo = JOptionPane.showInputDialog(null, "Ingrese su nuevo correo: ", "Edite correo : ", JOptionPane.QUESTION_MESSAGE);
				if(universidad.getListaAlumnos().modificarCorreo(usuario, editarCorreo))
				{
					lblCorreo.setText("Correo : "+usuario.getCorreo());
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Exito","Se modifico sin problemas",0);
				}
				else
					JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
			
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
	}

	
	
}
