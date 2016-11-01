import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class VentanaReceta extends JFrame {

	private JPanel contentPane;
	private boolean ventanaAnteriorBuscarReceta;
	private VentanaBuscarReceta ventanaBuscarReceta;
	private VentanaMisRecetas ventanaMisRecetas;
	Alumno alumno;
	public VentanaReceta(final Receta receta) 
	{
		setTitle("VentanaReceta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel(receta.getNombreReceta());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 11, 230, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblTiempoEstimadoDe = new JLabel("Tiempo Estimado De Preparacion "+ receta.getTiempoEstimadoPreparacion() + " minutos");
		lblTiempoEstimadoDe.setForeground(new Color(255, 255, 255));
		lblTiempoEstimadoDe.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTiempoEstimadoDe.setBounds(10, 221, 354, 26);
		contentPane.add(lblTiempoEstimadoDe);
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(424, 0, 2, 571);		
		contentPane.add(separator);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		//INGREDIENTES
		JPanel panel_ingredientes = new JPanel();							
		panel_ingredientes.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_ingredientes.setBackground(new Color(0, 153, 255));
		panel_ingredientes.setBounds(10, 60, 100, 150);
		panel_ingredientes.setLayout(new GridLayout());
		contentPane.add(panel_ingredientes);
		
		JList<?> lista_ingredientes = new JList<Object>(receta.getIngredientes());
		lista_ingredientes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_ingredientes.add(lista_ingredientes);
		
		JScrollPane scroll_ingredientes = new JScrollPane(lista_ingredientes);
		panel_ingredientes.add(scroll_ingredientes);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setForeground(new Color(255, 255, 255));
		lblIngredientes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredientes.setBounds(10, 45, 100, 14);
		contentPane.add(lblIngredientes);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//UTENSILIOS
		JPanel panel_utensilios = new JPanel();								
		panel_utensilios.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_utensilios.setBackground(new Color(0, 153, 255));
		panel_utensilios.setBounds(160, 60, 100, 150);
		panel_utensilios.setLayout(new GridLayout());
		contentPane.add(panel_utensilios);
		
		JList<?> lista_utensilios = new JList<Object>(receta.getUtensilios());
		lista_utensilios.setBorder(new LineBorder(new Color(255, 255, 255)));
		lista_utensilios.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_utensilios.add(lista_utensilios);
		
		JScrollPane scroll_utensilios = new JScrollPane(lista_utensilios);
		panel_utensilios.add(scroll_utensilios);
		
		JLabel lblUtensilios = new JLabel("Utensilios");
		lblUtensilios.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUtensilios.setForeground(new Color(255, 255, 255));
		lblUtensilios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtensilios.setBounds(160, 45, 100, 14);
		contentPane.add(lblUtensilios);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//CATEGORIAS
		JPanel panel_categorias = new JPanel();								
		panel_categorias.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_categorias.setBackground(new Color(0, 153, 255));
		panel_categorias.setBounds(310, 60, 100, 150);
		panel_categorias.setLayout(new GridLayout());
		contentPane.add(panel_categorias);
		
		JList<?> lista_categorias = new JList<Object>(receta.getCategorias());
		lista_categorias.setBorder(new LineBorder(new Color(0, 153, 255)));
		lista_categorias.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_categorias.add(lista_categorias);
		
		JScrollPane scroll_categorias = new JScrollPane(lista_categorias);
		panel_categorias.add(scroll_categorias);

		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCategorias.setForeground(new Color(255, 255, 255));
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setBounds(310, 45, 100, 14);
		contentPane.add(lblCategorias);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
	
		//INSTRUCCIONES
		JPanel panel_instrucciones = new JPanel();						
		panel_instrucciones.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_instrucciones.setBackground(new Color(0, 153, 255));
		panel_instrucciones.setBounds(10, 279, 400, 220);
		contentPane.add(panel_instrucciones);
		panel_instrucciones.setLayout(new GridLayout());
		
		JTextArea txtInstrucciones = new JTextArea(receta.getInstrucciones());
		txtInstrucciones.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_instrucciones.add(txtInstrucciones);
		txtInstrucciones.setEditable(false);
		txtInstrucciones.setLineWrap(true);   		
		txtInstrucciones.setWrapStyleWord(true);

		JScrollPane scroll_instrucciones = new JScrollPane(txtInstrucciones);
		panel_instrucciones.add(scroll_instrucciones);
		
		JLabel lblInstrucciones = new JLabel("INSTRUCCIONES");
		lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucciones.setForeground(new Color(255, 255, 255));
		lblInstrucciones.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblInstrucciones.setBounds(10, 264, 400, 14);
		contentPane.add(lblInstrucciones);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//--------------------------------------------------------------------------------------------------------------------------
		
		//BOTON ATRAS
		JButton btnAtras = new JButton("Atras");						
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(receta.getAutor().getListaRecetas().modificarReceta(receta))
				{
					
					if(ventanaAnteriorBuscarReceta)
							ventanaBuscarReceta.setVisible(true);
					else
							ventanaMisRecetas.setVisible(true);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(VentanaReceta.this,"Error","Error",0);
			}
		});
		btnAtras.setBounds(321, 527, 89, 23);
		contentPane.add(btnAtras);


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------

		//LISTA COMENTARIOS
		JPanel panelComentarios = new JPanel();							
		panelComentarios.setBackground(new Color(0, 153, 255));
		panelComentarios.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelComentarios.setBounds(444, 27, 330, 310);
		panelComentarios.setLayout(new GridLayout());
		contentPane.add(panelComentarios);
		

		final JTextArea textComentarios = new JTextArea();
		textComentarios.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panelComentarios.add(textComentarios);
		textComentarios.setEditable(false);
		if(receta.getListaComentarios()!=null)
			textComentarios.setText(actualizarLista(receta.getListaComentarios().getArrayComentarios()));
		
		JScrollPane scrollComentarios = new JScrollPane(textComentarios);
		panelComentarios.add(scrollComentarios);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//AGREGAR COMENTARIO
		JPanel panelAgregarComent = new JPanel();					
		panelAgregarComent.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelAgregarComent.setBackground(new Color(0, 153, 255));
		panelAgregarComent.setBounds(444, 368, 330, 150);
		panelAgregarComent.setLayout(new GridLayout());
		contentPane.add(panelAgregarComent);
		
		final JTextArea txtComentarioNuevo = new JTextArea();
		txtComentarioNuevo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panelAgregarComent.add(txtComentarioNuevo);
		txtComentarioNuevo.setLineWrap(true);
			
		JScrollPane scrollAgregarComent = new JScrollPane(txtComentarioNuevo);
		panelAgregarComent.add(scrollAgregarComent);
		
		JLabel lblComentarios = new JLabel("COMENTARIOS");
		lblComentarios.setForeground(new Color(255, 255, 255));
		lblComentarios.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarios.setBounds(444, 11, 330, 14);
		contentPane.add(lblComentarios);
		
		JButton btnComentar = new JButton("Comentar");
		btnComentar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnComentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Comentario comentarioNuevo = new Comentario(alumno,txtComentarioNuevo.getText(),receta.getListaComentarios().identificadorComentario());
				receta.getListaComentarios().agregar(comentarioNuevo);
				textComentarios.setText(actualizarLista(receta.getListaComentarios().getArrayComentarios()));
				txtComentarioNuevo.setText("");
			}
		});
		btnComentar.setBounds(572, 529, 188, 23);
		contentPane.add(btnComentar);
		
		JLabel lblAgregarComentario = new JLabel("Agregar Comentario");
		lblAgregarComentario.setForeground(new Color(255, 255, 255));
		lblAgregarComentario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblAgregarComentario.setBounds(445, 533, 140, 14);
		contentPane.add(lblAgregarComentario);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------------------------------
		
		//ELIMINAR COMENTARIO
		JButton btnEliminarComentario = new JButton("Eliminar Comentario");	
		btnEliminarComentario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnEliminarComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(receta.getAutor()==alumno) //entra aca si es el creador de la receta
				{
					String code= JOptionPane.showInputDialog(null, "Ingrese numero de comentario: ", "Eliminar comentario: ", JOptionPane.QUESTION_MESSAGE);
					if(code!=null && !code.equals(""))
					{
						if(code.matches("[0-9]"))
						{
							Comentario comentarioEliminar = receta.getListaComentarios().busqueda(code);
							if(comentarioEliminar!=null)
							{
								receta.getListaComentarios().eliminar(comentarioEliminar);
								textComentarios.setText(actualizarLista(receta.getListaComentarios().getArrayComentarios()));
								JOptionPane.showMessageDialog(VentanaReceta.this, "Se elimino con exito");
							}
							else
							{
								JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(VentanaReceta.this, "Debe ingresar un numero");
						}
							
					}
				}
				else
				{		
					String code= JOptionPane.showInputDialog(null, "Ingrese numero de comentario: ", "Eliminar comentario: ", JOptionPane.QUESTION_MESSAGE);
					if(code!=null && !code.equals(""))
					{
						Comentario comentarioEliminar= receta.getListaComentarios().busqueda(code);
						if(comentarioEliminar!=null)
						{
							if(comentarioEliminar.getAutor()==alumno)
							{
								if(receta.getListaComentarios().eliminar(comentarioEliminar))
								{
									textComentarios.setText(actualizarLista(receta.getListaComentarios().getArrayComentarios()));
									JOptionPane.showMessageDialog(VentanaReceta.this, "Se elimino con exito");
								}
								else
								{
									JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
					}
				}
			}
		});
		btnEliminarComentario.setBounds(609, 342, 165, 23);
		contentPane.add(btnEliminarComentario);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//--------------------------------------------------------------------------------------------------------------------------
		
		//MODIFICAR COMENTARIO
		JButton btnModificarComentario = new JButton("Modificar Comentario");	
		btnModificarComentario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnModificarComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String code= JOptionPane.showInputDialog(null, "Ingrese numero de comentario: ", "Modificar comentario: ", JOptionPane.QUESTION_MESSAGE);
				if(code!=null && !code.equals(""))
				{
					Comentario comentarioModificar= receta.getListaComentarios().busqueda(code);
					if(comentarioModificar!=null)
					{
						if(comentarioModificar.getAutor()==alumno)
						{
							String nuevoComent = JOptionPane.showInputDialog(comentarioModificar.getTexto());
							
							if(receta.getListaComentarios().modificar(comentarioModificar,nuevoComent))
							{
								textComentarios.setText(actualizarLista(receta.getListaComentarios().getArrayComentarios()));
								JOptionPane.showMessageDialog(VentanaReceta.this, "Se modificó con exito");
							}
							else
							{
								JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(VentanaReceta.this, "El numero ingresado no es valido");
				}
			}
		});
		btnModificarComentario.setBounds(442, 342, 165, 23);
		contentPane.add(btnModificarComentario);
		
		JLabel lblSubidoPor = new JLabel("Subido por: "+receta.getAutor());
		lblSubidoPor.setForeground(new Color(255, 255, 255));
		lblSubidoPor.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblSubidoPor.setBounds(10, 504, 404, 14);
		contentPane.add(lblSubidoPor);
		

	}//FIN CONTRUCTOR
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String actualizarLista(ArrayList<Comentario> listaComentarios)	//retorna un JtextArea con todos los comentarios en la lista
	{
		JTextArea textNuevo= new JTextArea();
		for(int i=0;i<listaComentarios.size();i++)
		{
			textNuevo.append(listaComentarios.get(i).toString());
			textNuevo.append(System.getProperty("line.separator"));
		}
		return textNuevo.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarVentanaAnteriorMisRecetas()	//muestra la ventana anterior cuando es VentanaMisRecetas
	{
		ventanaMisRecetas.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarVentanaAnteriorBuscarReceta() //muestra la ventana anterior cuando es VentanaBuscarReceta
	{
		ventanaBuscarReceta.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarVentana(VentanaBuscarReceta ventanaAnterior,Alumno alumno)
	{																			//muestra la ventana actual
		ventanaAnteriorBuscarReceta=true;								
		this.alumno=alumno;											//y le da valor a la ventanaBuscarReceta
		ventanaBuscarReceta=ventanaAnterior;
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarVentana(VentanaMisRecetas ventanaAnterior,Alumno alumno)
	{															//muestra la ventana actual
		this.alumno=alumno;							
		ventanaMisRecetas= ventanaAnterior;			//y le da valor a la ventanaMisRecetas
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

