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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class VentanaModificarAlumno extends JFrame 
{

	private JPanel contentPane;
	
	public VentanaModificarAlumno(final Alumno alumno,final Universidad universidad, final VentanaDocente ventanaAnterior){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 278);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Datos Alumno", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelDatos.setBackground(new Color(0, 153, 255));
		panelDatos.setBounds(10, 11, 344, 178);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton cerrar sesión
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventanaInicial = new VentanaPrincipal(universidad);
				dispose();
				ventanaInicial.setVisible(true);
			}
		});
		btnCerrarSesion.setBounds(232, 201, 110, 31);
		contentPane.add(btnCerrarSesion);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton atras
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAtras.setBounds(20, 200, 110, 31);
		contentPane.add(btnAtras);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//----------------------------------------------------------------------------------------------------------------------------
		
		//JLabel
		final JLabel lblNombre = new JLabel("Nombre : "+alumno.getNombrePersona());
		lblNombre.setBounds(20, 22, 280, 14);
		panelDatos.add(lblNombre);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		final JLabel lblDireccion = new JLabel("Direccion : "+alumno.getDireccion());
		lblDireccion.setBounds(20, 47, 280, 14);
		panelDatos.add(lblDireccion);
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		final JLabel lblRut = new JLabel("Rut : "+alumno.getRut());
		lblRut.setBounds(20, 72, 280, 14);
		panelDatos.add(lblRut);
		lblRut.setForeground(new Color(255, 255, 255));
		lblRut.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		final JLabel lblEdad = new JLabel("Edad : "+alumno.getEdad());
		lblEdad.setBounds(20, 97, 201, 14);
		panelDatos.add(lblEdad);
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		final JLabel lblTelefono = new JLabel("Telefono : "+alumno.getTelefono());
		lblTelefono.setBounds(20, 122, 280, 14);
		panelDatos.add(lblTelefono);
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		final JLabel lblCorreo = new JLabel("Correo : "+alumno.getCorreo());
		lblCorreo.setBounds(20, 147, 280, 14);
		panelDatos.add(lblCorreo);
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//----------------------------------------------------------------------------------------------------------------------		
		
		//MODIFICAR DATOS ALUMNO
		
		
										
		
		
		
		
		
		
		
		
		
		//MODIFICAR DIRECCION
		
		final JLabel lblmodificarDireccion = new JLabel("[Modificar]");
		lblmodificarDireccion.setBounds(285, 48, 49, 14);
		panelDatos.add(lblmodificarDireccion);
		lblmodificarDireccion.setForeground(Color.black);
		lblmodificarDireccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
						
		
		lblmodificarDireccion.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 	{
				String editarDireccion = JOptionPane.showInputDialog(null, "Ingrese su nueva dirección: ", "Edite dirección : ", JOptionPane.QUESTION_MESSAGE);
				
				if(editarDireccion != null)
				{
					if(!editarDireccion.equals(""))
					{
						if(universidad.getListaAlumnos().modificarDireccion(alumno, editarDireccion))
						{
							lblDireccion.setText("Direccion : "+alumno.getDireccion());
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Se modifico sin problemas","Exito",0);
						}else
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
					}else
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Debe ingresar el dato","Error",0);
				}
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.black);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//MODIFICAR EDAD
		
		final JLabel lblmodificarEdad = new JLabel("[Modificar]");
		lblmodificarEdad.setBounds(285, 97, 49, 14);
		panelDatos.add(lblmodificarEdad);
		lblmodificarEdad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarEdad.setForeground(Color.black);
		
		
		lblmodificarEdad.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String editarEdad = JOptionPane.showInputDialog(null, "Ingrese la nueva edad: ", "Edite edad : ", JOptionPane.QUESTION_MESSAGE);
				
				if(editarEdad != null)
				{
					if(!editarEdad.equals(""))
					{
						if(universidad.getListaAlumnos().modificarEdad(alumno, editarEdad))
						{
							lblEdad.setText("Edad : "+alumno.getEdad());
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Se modifico sin problemas","Exito",0);
						}else
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
					}else
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Debe ingresar el dato","Error",0);
				}
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarEdad.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarEdad.setForeground(Color.black);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//MODIFICAR TELEFONO
		
		final JLabel lblmodificarTelefono = new JLabel("[Modificar]");
		lblmodificarTelefono.setBounds(285, 123, 49, 14);
		panelDatos.add(lblmodificarTelefono);
		lblmodificarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblmodificarTelefono.setForeground(Color.black);
		
		
		lblmodificarTelefono.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String editarTelefono = JOptionPane.showInputDialog(null, "Ingrese su nuevo teléfono: ", "Edite teléfono : ", JOptionPane.QUESTION_MESSAGE);
				
				if(editarTelefono != null)
				{
					if(!editarTelefono.equals(""))
					{
						if(universidad.getListaAlumnos().modificarTelefono(alumno, editarTelefono))
						{
							lblTelefono.setText("Telefono : "+alumno.getTelefono());
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Se modifico sin problemas","Exito",0);
						}else
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
					}else
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Debe ingresar el dato","Error",0);
				}
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.black);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});				

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//MODIFICAR CORREO	
		
		final JLabel lblmodificarCorreo = new JLabel("[Modificar]");					
		lblmodificarCorreo.setBounds(285, 147, 49, 14);
		panelDatos.add(lblmodificarCorreo);
		lblmodificarCorreo.setForeground(Color.black);
		lblmodificarCorreo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		
		lblmodificarCorreo.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{				
				String editarCorreo = JOptionPane.showInputDialog(null, "Ingrese su nuevo correo: ", "Edite correo : ", JOptionPane.QUESTION_MESSAGE);
				
				if(editarCorreo != null)
				{
					if(!editarCorreo.equals(""))
					{
						if(universidad.getListaAlumnos().modificarCorreo(alumno, editarCorreo))
						{
							lblCorreo.setText("Correo : "+alumno.getCorreo());
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Se modifico sin problemas","Exito",0);
						}else
							JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Error","Error",0);
					}else
						JOptionPane.showMessageDialog(VentanaModificarAlumno.this,"Debe ingresar el dato","Error",0);
				}
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.black);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
	
}
