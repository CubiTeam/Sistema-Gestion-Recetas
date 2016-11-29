import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class VentanaReporteAlumnos extends JFrame {

	private JPanel contentPane;

	public VentanaReporteAlumnos(final ListaAlumnos alumno, final VentanaDocente ventanaAnterior) {
		setTitle("Ventana de reporte");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelAlumnos = new JPanel();
		panelAlumnos.setBackground(new Color(0, 153, 255));
		panelAlumnos.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información alumnos registrados :", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelAlumnos.setBounds(8, 10, 350, 360);
		contentPane.add(panelAlumnos);
		panelAlumnos.setLayout(new GridLayout());
		
		final JTextArea datosAlumnos = new JTextArea();
		panelAlumnos.add(datosAlumnos);
		datosAlumnos.setLineWrap(true); 
		datosAlumnos.setWrapStyleWord(true);
		
		JScrollPane scrollLateral = new JScrollPane(datosAlumnos);
		panelAlumnos.add(scrollLateral);
		
		
		
		
		
		
		
		
		
		
		
//---------------------------------------------------------------------------------------------------
		
		//Generar reporte
		mostrarEnJTextArea(datosAlumnos,alumno);
		
		//Regresa a la ventana anterior
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 11));
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
		btnCrearArchivoXls.setFont(new Font("Century Gothic", Font.PLAIN, 11));
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
	private void mostrarEnJTextArea(JTextArea datosAlumnos, ListaAlumnos alumno)
	{
		int j = 1;
		for (int i = 0; i < alumno.size(); i++)
		{
			datosAlumnos.append("["+j+"] Alumno \r\nNombre : "+alumno.getPosAlumno(i).getNombrePersona()+
			"\r\nRUT : "+alumno.getPosAlumno(i).getRut()+"\r\nCorreo : "+alumno.getPosAlumno(i).getCorreo()+
			"\r\nEdad : "+alumno.getPosAlumno(i).getEdad()+"\r\nSexo : "+alumno.getPosAlumno(i).getSexo()+ 
			"\r\nDireccion : "+alumno.getPosAlumno(i).getDireccion()+"\r\nTelefono : "+alumno.getPosAlumno(i).getTelefono()+"\r\n\r\n");
			j++;
		}
	}
}
