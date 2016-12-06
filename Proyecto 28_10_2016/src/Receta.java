import java.util.ArrayList;

public class Receta 
{
	private String nombreReceta;
	private String[] ingredientes;
	private String[] utensilios;
	private String[] categorias; 
	private Alumno autor;
	private String Instrucciones;
	private int tiempoEstimadoPreparacion;
	private VentanaReceta ventanaPrincipal;
	private ListaComentarios ListaComentarios;
	
	
	
	
	
	
	
	
	
	
	
	public ListaComentarios getListaComentarios() {
		return ListaComentarios;
	}









	public void setListaComentarios(ListaComentarios listaComentarios) {
		ListaComentarios = listaComentarios;
	}















	//se cargan los comentarios de todas las recetas
	public void  cargarComentarios(Universidad universidad)
	{						
		if(ListaComentarios!=null)
			ListaComentarios.cargarArrayComentarios(universidad);
	}





	
	
	







	public void setComentarios(ListaComentarios comentarios) {
		this.ListaComentarios = comentarios;
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









	public Alumno getAutor() {
		return autor;
	}









	public void setAutor(Alumno autor) {
		this.autor = autor;
	}


















	public String getInstrucciones() {
		return Instrucciones;
	}









	public void setInstrucciones(String instrucciones) {
		Instrucciones = instrucciones;
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
		Instrucciones = null;
		this.tiempoEstimadoPreparacion = 0;
		this.categorias = null;
		this.ventanaPrincipal=null;
		this.ListaComentarios= new ListaComentarios();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Receta(String nombreReceta, String[] ingredientes,
			String[] utensilios,String intrucciones,
			int tiempoEstimadoPreparacion, String[] categorias,
			 ArrayList<Comentario> comentarios,Alumno alumno) 
	{
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.utensilios = utensilios;
		Instrucciones = intrucciones;
		this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
		this.categorias = categorias;
		this.ListaComentarios = new ListaComentarios(comentarios);
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
