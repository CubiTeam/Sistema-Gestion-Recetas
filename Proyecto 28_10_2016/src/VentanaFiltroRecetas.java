import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class VentanaFiltroRecetas extends JFrame {

	private JPanel contentPane;
	private JTextField txtTiempoEstimado;
	private JTextField txtCalificacion;
	private JTextField txtCreador;
	private DefaultListModel ingredientes, utensilios, categorias;
	private JTextField txtAgregarI;
	private JTextField textAgregarC;
	private JTextField txtAgregarU;
	
	public VentanaFiltroRecetas(final VentanaBuscarReceta ventanaBuscarReceta, final Receta receta) 
	{
		
		ingredientes = new DefaultListModel();
		utensilios = new DefaultListModel();
		categorias = new DefaultListModel();
		setResizable(false);
		
		setTitle("Ventana Filtro Receta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//-----------------------------------------------------------------------------------------------------------------------------
		JLabel lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO MAX");				//TIEMPO ESTIMADO
		lblTiempoEstimado.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTiempoEstimado.setForeground(new Color(255, 255, 255));
		lblTiempoEstimado.setBounds(88, 39, 167, 14);
		contentPane.add(lblTiempoEstimado);
		
		txtTiempoEstimado = new JTextField();
		txtTiempoEstimado.setBounds(230, 33, 45, 25);
		contentPane.add(txtTiempoEstimado);
		txtTiempoEstimado.setColumns(10);
		
//-----------------------------------------------------------------------------------------------------------------------------
		/*JLabel lblCalificacion = new JLabel("Calificaci\u00F3n");				//CALIFICACION
		lblCalificacion.setBounds(315, 24, 69, 14);				//todavia no esta implementado
		contentPane.add(lblCalificacion);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(394, 21, 45, 20);
		contentPane.add(txtCalificacion);
		txtCalificacion.setColumns(10);
		
		JRadioButton radioButtonCalificacion = new JRadioButton("");
		radioButtonCalificacion.setBounds(445, 21, 21, 23);
		contentPane.add(radioButtonCalificacion); */
//-----------------------------------------------------------------------------------------------------------------------------
		JLabel lblCreador = new JLabel("CREADOR");								//CREADOR
		lblCreador.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCreador.setForeground(new Color(255, 255, 255));
		lblCreador.setBounds(311, 39, 69, 14);
		contentPane.add(lblCreador);
		
		txtCreador = new JTextField();
		txtCreador.setBounds(376, 33, 103, 25);
		contentPane.add(txtCreador);
		txtCreador.setColumns(10);
		
//-----------------------------------------------------------------------------------------------------------------------------
		JPanel panelIngredientes = new JPanel();							//INGREDIENTES
		panelIngredientes.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelIngredientes.setBackground(new Color(0, 153, 255));
		panelIngredientes.setBounds(10, 173, 110, 152);
		panelIngredientes.setLayout(new GridLayout());
		contentPane.add(panelIngredientes);
		
		JList listIngredientes = new JList();
		listIngredientes.setModel(ingredientes);
		panelIngredientes.add(listIngredientes);
		
		JButton btnAgregarI = new JButton("Agregar");						
		btnAgregarI.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAgregarI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtAgregarI.getText().isEmpty())
				{
				
					ingredientes.addElement(txtAgregarI.getText());
					txtAgregarI.setText("");
				}
			}
		});
		
		JLabel lblIngredientes = new JLabel("INGREDIENTES");
		lblIngredientes.setForeground(new Color(255, 255, 255));
		lblIngredientes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredientes.setBounds(10, 144, 110, 25);
		contentPane.add(lblIngredientes);
		
		txtAgregarI = new JTextField();
		txtAgregarI.setBounds(132, 187, 86, 25);
		contentPane.add(txtAgregarI);
		txtAgregarI.setColumns(10);
		btnAgregarI.setBounds(130, 218, 89, 23);
		contentPane.add(btnAgregarI);
		
		JButton btnBorrarI = new JButton("Borrar");
		btnBorrarI.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnBorrarI.setBounds(130, 241, 89, 23);
		contentPane.add(btnBorrarI);
		
//-----------------------------------------------------------------------------------------------------------------------------		
		JPanel panelCategorias = new JPanel();								//CATEGORIAS
		panelCategorias.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelCategorias.setBackground(new Color(0, 153, 255));
		panelCategorias.setBounds(232, 173, 106, 152);
		panelCategorias.setLayout(new GridLayout());
		contentPane.add(panelCategorias);
		
		JList listCategorias = new JList();
		panelCategorias.add(listCategorias);
		listCategorias.setModel(categorias);
		
		JButton btnAgregarC = new JButton("Agregar");
		btnAgregarC.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAgregarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textAgregarC.getText().isEmpty())
				{		
					categorias.addElement(textAgregarC.getText());
					textAgregarC.setText("");
				}
			}
		});
		
		btnAgregarC.setBounds(348, 218, 89, 23);
		contentPane.add(btnAgregarC);
		
		JLabel lblCategorias = new JLabel("CATEGORIAS");
		lblCategorias.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCategorias.setForeground(new Color(255, 255, 255));
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setBounds(232, 144, 106, 25);
		contentPane.add(lblCategorias);
		
		textAgregarC = new JTextField();
		textAgregarC.setColumns(10);
		textAgregarC.setBounds(350, 187, 86, 25);
		contentPane.add(textAgregarC);
		
		JButton btnBorrarC = new JButton("Borrar");
		btnBorrarC.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnBorrarC.setBounds(348, 241, 89, 23);
		contentPane.add(btnBorrarC);
		
//-----------------------------------------------------------------------------------------------------------------------------		
		JPanel panelUtensilios = new JPanel();								//UTENSILIOS
		panelUtensilios.setBackground(new Color(0, 153, 255));
		panelUtensilios.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelUtensilios.setBounds(447, 173, 103, 152);
		panelUtensilios.setLayout(new GridLayout());
		contentPane.add(panelUtensilios);
		
		JList listUtensilios = new JList();
		panelUtensilios.add(listUtensilios);
		listUtensilios.setModel(utensilios);
		
		txtAgregarU = new JTextField();
		txtAgregarU.setBounds(562, 187, 86, 25);
		contentPane.add(txtAgregarU);
		txtAgregarU.setColumns(10);
		
		JButton btnAgregarU = new JButton("Agregar");
		btnAgregarU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAgregarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtAgregarU.getText().isEmpty())
				{		
					utensilios.addElement(txtAgregarU.getText());
					txtAgregarU.setText("");
				}
			}
		});
		btnAgregarU.setBounds(560, 218, 89, 23);
		contentPane.add(btnAgregarU);
		
		JLabel lblUtensilios = new JLabel("UTENSILIOS");
		lblUtensilios.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUtensilios.setForeground(new Color(255, 255, 255));
		lblUtensilios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtensilios.setBounds(447, 144, 103, 25);
		contentPane.add(lblUtensilios);
		
		JButton btnBorrarU = new JButton("Borrar");
		btnBorrarU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnBorrarU.setBounds(560, 241, 89, 23);
		contentPane.add(btnBorrarU);
		
//-----------------------------------------------------------------------------------------------------------------------------		
		JButton btnAtras = new JButton("Ok");								//BOTON OK
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!txtTiempoEstimado.getText().isEmpty() && !txtTiempoEstimado.getText().equals(""))
							receta.setTiempoEstimadoPreparacion(Integer.parseInt(txtTiempoEstimado.getText()));
				if(!txtCreador.getText().isEmpty() && !txtCreador.getText().equals(""))
				{
					Alumno usuarioAux= new Alumno(txtCreador.getText());
				}
				if(!ingredientes.isEmpty())
					receta.setIngredientes(casteo(ingredientes));
				if(!utensilios.isEmpty())
					receta.setUtensilios(casteo(utensilios));
				if(!categorias.isEmpty())
					receta.setCategorias(casteo(categorias));
				
				ventanaBuscarReceta.setVisible(true);	//cierra la ventana actual y abre la anterior
				dispose();
			}
		});
		btnAtras.setBounds(557, 16, 91, 37);
		contentPane.add(btnAtras);
	}
	public String[] casteo(DefaultListModel listaEntrada) //convierte de DefaultListModel a String[]
	{
		String[] listaFinal= new String[listaEntrada.getSize()];
		int i;
		for(i=0;i<listaEntrada.getSize();i++)
		{
			listaFinal[i]=((String)listaEntrada.getElementAt(i));
		}
		return listaFinal;
	}
}
