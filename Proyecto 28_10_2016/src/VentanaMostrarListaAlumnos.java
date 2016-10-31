import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaMostrarListaAlumnos extends JFrame {

	private JPanel contentPane;

	public VentanaMostrarListaAlumnos(final ArrayList<Alumno> alumno, final VentanaDocente ventanaAnterior) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelAlumnos = new JPanel();
		panelAlumnos.setBounds(8, 25, 350, 340);
		contentPane.add(panelAlumnos);
		panelAlumnos.setLayout(new GridLayout());
		
		final JTextArea datosAlumnos = new JTextArea();
		panelAlumnos.add(datosAlumnos);
		datosAlumnos.setLineWrap(true); 
		datosAlumnos.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosAlumnos);
		panelAlumnos.add(scrollLateral);
		
		JLabel lblInformacionUsuarioRegistrados = new JLabel("Informacion usuario registrados :");
		lblInformacionUsuarioRegistrados.setBounds(10, 11, 199, 14);
		contentPane.add(lblInformacionUsuarioRegistrados);
		
		
		
		
		
		
		
		
		
		
		
//---------------------------------------------------------------------------------------------------
		
		//Generar reporte
		mostrarEnJTextArea(datosAlumnos,alumno);
		
		//Regresa a la ventana anterior
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAtras.setBounds(268, 376, 90, 23);
		contentPane.add(btnAtras);
		
		
		
		
		
		
		
		
		
		
		
		
//-----------------------------------------------------------------------------------------------------

		//Se crea un .xls con los datos de los alumnos
		JButton btnCrearArchivoXls = new JButton("Crear archivo XLS");
		btnCrearArchivoXls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//implementar despues un JFileChooser para elegir ruta y nombre archivo
				try {
					CrearReporteEnExcel archivoXLS = new CrearReporteEnExcel(alumno);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnCrearArchivoXls.setBounds(8, 376, 137, 23);
		contentPane.add(btnCrearArchivoXls);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/**********************************************************************************************
 * 
 * 											METODOS
 * 
 * *******************************************************************************************/
	
	
	//muestra los datos por pantalla
	private void mostrarEnJTextArea(JTextArea datosAlumnos, ArrayList<Alumno> alumno){
		int j = 1;
		for (int i = 0; i < alumno.size(); i++){
			datosAlumnos.append("["+j+"] Alumno \r\nNombre : "+alumno.get(i).getNombrePersona()+
			"\r\nRUT : "+alumno.get(i).getRut()+"\r\nCorreo : "+alumno.get(i).getCorreo()+
			"\r\nEdad : "+alumno.get(i).getEdad()+"\r\nSexo : "+alumno.get(i).getSexo()+ 
			"\r\nDireccion : "+alumno.get(i).getDireccion()+"\r\nTelefono : "+alumno.get(i).getTelefono()+"\r\n\r\n");
			j++;
		}
	}
}
