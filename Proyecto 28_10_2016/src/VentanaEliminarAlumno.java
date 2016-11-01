import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class VentanaEliminarAlumno extends JFrame {

	private JPanel contentPane;


	public VentanaEliminarAlumno(final Universidad universidad,final Alumno alumno, final VentanaDocente ventanaAnterior) 
	{
		
		
		setTitle("Ventana Eliminar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 261);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelDatosAlumno = new JPanel();
		panelDatosAlumno.setBackground(new Color(51, 153, 255));
		panelDatosAlumno.setBorder(new TitledBorder(new MatteBorder(1, 5, 1, 1, (Color) new Color(255, 255, 255)), "Datos alumno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelDatosAlumno.setBounds(10, 13, 357, 168);
		contentPane.add(panelDatosAlumno);
		panelDatosAlumno.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
	
//------------------------------------------------------------------------------------------------------------------------
		//BOTONES
		
		
		
		
		
		
		
		
		
		
		//boton atras
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaAnterior.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnAtras.setBounds(33, 192, 113, 30);
		contentPane.add(btnAtras);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton eliminar alumno
		JButton btnEliminarAlumno = new JButton("Eliminar Alumno");
		btnEliminarAlumno.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnEliminarAlumno.setBounds(196, 127, 151, 30);
		panelDatosAlumno.add(btnEliminarAlumno);
		btnEliminarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if(universidad.getListaAlumnos().eliminar(alumno))
				{
					JOptionPane.showMessageDialog(null,"Datos eliminados exitosamente","Eliminar Alumno",JOptionPane.INFORMATION_MESSAGE);
					ventanaAnterior.setVisible(true);
					setVisible(false);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null,"Ha ocurrido un error al eliminar","Eliminar Alumno",JOptionPane.ERROR_MESSAGE);
				}
		});
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(230, 192, 113, 30);
		contentPane.add(btnSalir);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//---------------------------------------------------------------------------------------------------------------------------
		
		//JLabel
	
		JLabel lblInformacionAlumno = new JLabel("Nombre :");
		lblInformacionAlumno.setForeground(new Color(255, 255, 255));
		lblInformacionAlumno.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblInformacionAlumno.setBounds(21, 21, 232, 14);
		panelDatosAlumno.add(lblInformacionAlumno);
		lblInformacionAlumno.setText("Nombre: "+alumno.getNombrePersona());
		
		JLabel lblRut = new JLabel("RUT: ");
		lblRut.setForeground(new Color(255, 255, 255));
		lblRut.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblRut.setBounds(256, 21, 101, 14);
		panelDatosAlumno.add(lblRut);
		lblRut.setText("RUT: "+alumno.getRut());
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(21, 46, 326, 14);
		panelDatosAlumno.add(lblCorreo);
		lblCorreo.setText("Correo: "+alumno.getCorreo());
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setBounds(21, 71, 326, 14);
		panelDatosAlumno.add(lblDireccion);
		lblDireccion.setText("Dirección: "+alumno.getDireccion());
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setBounds(21, 95, 151, 14);
		panelDatosAlumno.add(lblEdad);
		lblEdad.setText("Edad: "+alumno.getEdad());
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setBounds(21, 120, 175, 14);
		panelDatosAlumno.add(lblTelefono);
		lblTelefono.setText("Teléfono: "+alumno.getTelefono());
		
		

	}
}
