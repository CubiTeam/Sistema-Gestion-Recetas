import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VentanaMisRecetas extends JFrame 
{

	private JPanel contentPane;
	private VentanaCrearReceta recetaVentanaNueva;
	private DefaultListModel<Receta> recetas;
	public VentanaMisRecetas(final Alumno alumno,final VentanaAlumno ventanaUsuario) 
	{
		setTitle("VentanaMisRecetas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 288);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		recetas=new DefaultListModel<Receta>();
		
		convertir(recetas,alumno.getListaRecetas().getArrayRecetas());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		//LISTA RECETAS
		JPanel panel_recetas = new JPanel();										
		panel_recetas.setBackground(new Color(0, 153, 255));
		panel_recetas.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MIS RECETAS", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panel_recetas.setBounds(10, 20, 260, 230);
		contentPane.add(panel_recetas);
		panel_recetas.setLayout(new GridLayout());
		
		final JList<Receta> lista_recetas = new JList<Receta>();
		lista_recetas.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_recetas.add(lista_recetas);
		lista_recetas.setModel(recetas);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		//BOTON MOSTRAR RECETA
		JButton btnMostrarReceta = new JButton("Mostrar Receta");					
		btnMostrarReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnMostrarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(lista_recetas.getSelectedIndex()!=-1)
				{
					Receta recetaMostrar= ((Receta)recetas.getElementAt(lista_recetas.getSelectedIndex()));
					if(recetaMostrar!=null)
						recetaMostrar.getVentanaPrincipal().mostrarVentana(VentanaMisRecetas.this,alumno);
					setVisible(false);
				}
			}
		});
		btnMostrarReceta.setBounds(280, 95, 133, 44);
				contentPane.add(btnMostrarReceta);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//------------------------------------------------------------------------------------------------------------------------		
		
		//BOTON CREAR RECETA	
		JButton btnCrearReceta = new JButton("Crear Receta");						
		btnCrearReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCrearReceta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				recetaVentanaNueva = new VentanaCrearReceta(alumno,VentanaMisRecetas.this);
				recetaVentanaNueva.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		btnCrearReceta.setBounds(280, 40, 133, 44);
		contentPane.add(btnCrearReceta);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		//BOTON MODIFICAR RECETA
		final JButton btnModificarReceta = new JButton("Modificar Receta");				
		btnModificarReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnModificarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(lista_recetas.getSelectedIndex()!=-1)
				{
					setVisible(false);
					recetaVentanaNueva = new VentanaCrearReceta(((Receta)recetas.getElementAt(lista_recetas.getSelectedIndex())),alumno,VentanaMisRecetas.this);
					recetaVentanaNueva.setVisible(true);
				}
				
			}
		});
		btnModificarReceta.setBounds(423, 40, 133, 44);
		contentPane.add(btnModificarReceta);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		//BOTON ELIMINAR RECETA
		JButton btnEliminarReceta = new JButton("Eliminar Receta");					
		btnEliminarReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEliminarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(lista_recetas.getSelectedIndex()!=-1)
				{
					int reply = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar de forma permanente esta receta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
				    if (reply == JOptionPane.YES_OPTION)
				    {
				    	if(alumno.getListaRecetas().eliminarReceta((Receta)(recetas.getElementAt(lista_recetas.getSelectedIndex())),alumno.getRut()))
				    	{
				    		recetas.remove(lista_recetas.getSelectedIndex());
				    	}
				    }
				}
			}
		});
		btnEliminarReceta.setBounds(423, 95, 133, 44);
		contentPane.add(btnEliminarReceta);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON ATRAS
		JButton btnAtras = new JButton("Atras");									
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(351, 205, 122, 39);
		contentPane.add(btnAtras);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON GUARDAR RECETAS																	
		JButton btnDescargarReceta = new JButton("Guardar Recetas");
		btnDescargarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CrearPDF(alumno.getListaRecetas().getArrayRecetas(),1);
			}
		});
		btnDescargarReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnDescargarReceta.setBounds(280, 150, 133, 44);
		contentPane.add(btnDescargarReceta);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON ENVIAR A CORREO																			
		JButton btnEnviarACorreo = new JButton("Enviar a correo");
		btnEnviarACorreo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEnviarACorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CrearPDF(alumno.getListaRecetas().getArrayRecetas(),2);
			}
		});
		btnEnviarACorreo.setBounds(423, 150, 133, 44);
		contentPane.add(btnEnviarACorreo);
		
	}//FIN CONTRUCTOR
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// cambia de arrayList a DefaultListModel
	public void convertir(DefaultListModel<Receta> recetasList,ArrayList<Receta> recetasArray) 
	{
		int cont;
		for(int i=0;i<recetasArray.size();i++)
		{
			cont=0;
			for(int j=0;j<recetasList.size();j++)
			{
				if(recetasArray.get(i)==((Receta)recetasList.getElementAt(j)))
					cont++;
			}
			if(cont==0)
				recetasList.addElement(recetasArray.get(i));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//vuelve a cargar las recetas
	public void actualizar(ArrayList<Receta> recetas)
	{
		convertir(this.recetas,recetas);
	}
	
}
