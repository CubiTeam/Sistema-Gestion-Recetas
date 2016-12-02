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

public class VentanaEliminarUsuario extends JFrame {

	private JPanel contentPane;


	public VentanaEliminarUsuario(final Universidad universidad,final Persona persona, final VentanaDocente ventanaAnterior,final boolean esDocente)
	{
		
		
		setTitle("Ventana Eliminar Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 261);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBackground(new Color(51, 153, 255));
		panelDatosPersona.setBorder(new TitledBorder(new MatteBorder(1, 5, 1, 1, (Color) new Color(255, 255, 255)), "Datos Persona", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelDatosPersona.setBounds(10, 13, 357, 168);
		contentPane.add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
	
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton eliminar
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnEliminarPersona.setBounds(196, 127, 151, 30);
		panelDatosPersona.add(btnEliminarPersona);
		btnEliminarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if(esDocente)
				{
					if(universidad.getListaDocentes().eliminar(persona))
					{
						JOptionPane.showMessageDialog(null,"Datos eliminados exitosamente","Eliminar Persona",JOptionPane.INFORMATION_MESSAGE);
						ventanaAnterior.setVisible(true);
						setVisible(false);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"Ha ocurrido un error al eliminar","Eliminar Persona",JOptionPane.ERROR_MESSAGE);
					
				}else{
					if(universidad.getListaAlumnos().eliminar(persona))
					{
						JOptionPane.showMessageDialog(null,"Datos eliminados exitosamente","Eliminar Alumno",JOptionPane.INFORMATION_MESSAGE);
						ventanaAnterior.setVisible(true);
						setVisible(false);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"Ha ocurrido un error al eliminar","Eliminar Alumno",JOptionPane.ERROR_MESSAGE);
					
				}
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
	
		JLabel lblInformacionPersona = new JLabel("Nombre :");
		lblInformacionPersona.setForeground(new Color(255, 255, 255));
		lblInformacionPersona.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblInformacionPersona.setBounds(21, 21, 232, 14);
		panelDatosPersona.add(lblInformacionPersona);
		lblInformacionPersona.setText("Nombre: "+persona.getNombrePersona());
		
		JLabel lblRut = new JLabel("RUT: ");
		lblRut.setForeground(new Color(255, 255, 255));
		lblRut.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblRut.setBounds(256, 21, 101, 14);
		panelDatosPersona.add(lblRut);
		lblRut.setText("RUT: "+persona.getRut());
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(21, 46, 326, 14);
		panelDatosPersona.add(lblCorreo);
		lblCorreo.setText("Correo: "+persona.getCorreo());
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setBounds(21, 71, 326, 14);
		panelDatosPersona.add(lblDireccion);
		lblDireccion.setText("Dirección: "+persona.getDireccion());
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setBounds(21, 95, 151, 14);
		panelDatosPersona.add(lblEdad);
		lblEdad.setText("Edad: "+persona.getEdad());
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setBounds(21, 120, 175, 14);
		panelDatosPersona.add(lblTelefono);
		lblTelefono.setText("Teléfono: "+persona.getTelefono());
		
		

	}
}
