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
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaMisRecetas extends JFrame 
{

	private JPanel contentPane;
	private VentanaCrearReceta recetaVentanaNueva;
	private DefaultListModel recetas;
	public VentanaMisRecetas(final Alumno alumno,final VentanaAlumno ventanaUsuario) 
	{
		setTitle("VentanaMisRecetas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		recetas=new DefaultListModel();
		
		convertir(recetas,alumno.getListaRecetas().getArrayRecetas());
//------------------------------------------------------------------------------------------------------------------------		
		JPanel panel_recetas = new JPanel();										//LISTA RECETAS
		panel_recetas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "MIS RECETAS", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_recetas.setBounds(10, 20, 260, 230);
		contentPane.add(panel_recetas);
		panel_recetas.setLayout(new GridLayout());
		
		final JList lista_recetas = new JList();
		panel_recetas.add(lista_recetas);
		lista_recetas.setModel(recetas);
//------------------------------------------------------------------------------------------------------------------------		
		JButton btnMostrarReceta = new JButton("Mostrar Receta");					//BOTON MOSTRAR RECETA
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
		JButton btnCrearReceta = new JButton("Crear Receta");						//BOTON CREAR RECETA
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
		final JButton btnModificarReceta = new JButton("Modificar Receta");				//BOTON MODIFICAR RECETA
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
		JButton btnEliminarReceta = new JButton("Eliminar Receta");					//BOTON ELIMINAR RECETA
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
		JButton btnAtras = new JButton("Atras");									//BOTON ATRAS
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
				CrearPDF crearPDF = new CrearPDF(alumno.getListaRecetas().getArrayRecetas(),1);
			}
		});
		btnDescargarReceta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDescargarReceta.setBounds(280, 150, 133, 44);
		contentPane.add(btnDescargarReceta);
		
//------------------------------------------------------------------------------------------------------------------------
																			//BOTON ENVIAR A CORREO		
		JButton btnEnviarACorreo = new JButton("Enviar a correo");
		btnEnviarACorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearPDF crearPDF = new CrearPDF(alumno.getListaRecetas().getArrayRecetas(),2);
			}
		});
		btnEnviarACorreo.setBounds(423, 150, 133, 44);
		contentPane.add(btnEnviarACorreo);
		
	}//FIN CONTRUCTOR
	
	// cambia de arrayList a DefaultListModel
	public void convertir(DefaultListModel recetasList,ArrayList<Receta> recetasArray) 
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
	
	
	public void actualizar(ArrayList<Receta> recetas)
	{
		convertir(this.recetas,recetas);
	}
}
