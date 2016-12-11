import java.util.ArrayList;

public class Receta 
{
	private String nombreReceta;
	private String[] ingredientes;
	private String[] utensilios;
	private String[] categorias; 
	private Alumno autor;
	private String instrucciones;
	private int tiempoEstimadoPreparacion;
	private VentanaReceta ventanaPrincipal;
	private ListaComentarios listaComentarios;
	
	
	
	
	
	
	
	
	
	
	
	public ListaComentarios getListaComentarios() {
		return listaComentarios;
	}









	public void setListaComentarios(ListaComentarios listaComentarios) 
	{
		this.listaComentarios = listaComentarios;
	}









	//se cargan los comentarios de todas las recetas
	public void  cargarComentarios(Universidad universidad)
	{						
		if(listaComentarios!=null)
			listaComentarios.cargarArrayComentarios(universidad);
	}

	





	public void setComentarios(ListaComentarios comentarios) {
		this.listaComentarios = comentarios;
	}






	public String getNombreReceta() {
		return nombreReceta;
	}









	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}









	public String[] getIngredientes() {
		return ingredientes;
	}









	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}









	public String[] getUtensilios() {
		return utensilios;
	}









	public void setUtensilios(String[] utensilios) {
		this.utensilios = utensilios;
	}

	
	



	//retorna un clon de la receta
	public Receta getClonReceta()
	{
		Receta clon = new Receta();
		
		
		clon.setNombreReceta(nombreReceta);
		clon.setTiempoEstimadoPreparacion(tiempoEstimadoPreparacion);
		clon.setCategorias(clonarArray(categorias));
		clon.setIngredientes(clonarArray(ingredientes));
		clon.setUtensilios(clonarArray(utensilios));
		clon.setInstrucciones(instrucciones);
		
		//no se clonan estos atributos porque no son necesarios para el programa
		clon.setAutor(autor);
		clon.setListaComentarios(listaComentarios);
		clon.setVentanaPrincipal(ventanaPrincipal);
		
		return clon;
	}

	
	//clona un arreglo
	public String[] clonarArray(String[] lista)
	{
		String[] listaClon = new String[lista.length];
		for(int i=0;i<lista.length;i++)
		{
			listaClon[i] = lista[i];
		}
		return listaClon;
	}


	public Alumno getAutor() {
		return autor;
	}







	public void setAutor(Alumno autor) {
		this.autor = autor;
	}









	public String getInstrucciones() {
		return instrucciones;
	}









	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}









	public int getTiempoEstimadoPreparacion() {
		return tiempoEstimadoPreparacion;
	}









	public void setTiempoEstimadoPreparacion(int tiempoEstimadoPreparacion) {
		this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
	}









	public String[] getCategorias() {
		return categorias;
	}









	public void setCategorias(String[] categorias) {
		this.categorias = categorias;
	}








	public VentanaReceta getVentanaPrincipal() {
		return ventanaPrincipal;
	}








	public void setVentanaPrincipal(VentanaReceta ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}






	public Receta()	
	{
		this.nombreReceta = null;
		this.ingredientes = null;
		this.utensilios = null;
		this.instrucciones = null;
		this.tiempoEstimadoPreparacion = 0;
		this.categorias = null;
		this.ventanaPrincipal=null;
		this.listaComentarios= new ListaComentarios();
	}
	
	
	
	public void crearVentana()
	{
		ventanaPrincipal = new VentanaReceta(Receta.this);
	}
	
	
	
	public Receta(String nombreReceta, String[] ingredientes,
			String[] utensilios,String intrucciones,
			int tiempoEstimadoPreparacion, String[] categorias,
			 ArrayList<Comentario> comentarios,Alumno alumno) 
	{
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.utensilios = utensilios;
		this.instrucciones = intrucciones;
		this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
		this.categorias = categorias;
		this.listaComentarios = new ListaComentarios(comentarios);
		this.autor= alumno;
	}
	


	

	
	public void mostrarReceta()
	{
		ventanaPrincipal.setVisible(true);
	}

	
	
	@Override
	public String toString()
	{
		return nombreReceta;
	}
	
	}
