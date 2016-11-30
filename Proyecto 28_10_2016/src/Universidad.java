import java.util.*;


public class Universidad 
{
	private String nombre;
	private Archivos archivos;
	private ListaAlumnos listaAlumnos;
	private ListaDocentes listaDocentes;
	
	public Universidad(String nombre, Archivos archivo) {
		this.nombre = nombre;
		this.archivos = archivo;
	}
	
	public Universidad() 
	{
		ArrayList<Receta> todasLasRecetas;
		this.nombre = "";
		archivos = new Archivos();
		listaDocentes = new ListaDocentes(archivos);
		listaAlumnos = new ListaAlumnos(archivos);
		todasLasRecetas = listaAlumnos.TodasLasRecetas();
		cargarComentarios(todasLasRecetas);
		cargarVentanasRecetas(todasLasRecetas);
	}
	
	
	
	
	

	
	
	//retorna todas las recetas de todos los alumnos
	public ArrayList<Receta> TodasLasRecetas()
	{
		if(listaAlumnos != null)
			return listaAlumnos.TodasLasRecetas();
		return null;
	}	
	
	
	

	
	
	
	
	
	
	//se cargan los comentarios de todas las recetas
	public void  cargarComentarios(ArrayList<Receta> recetas)
	{						
		for(int i=0;i<recetas.size();i++)
		{
			recetas.get(i).cargarComentarios(Universidad.this);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void cargarVentanasRecetas(ArrayList<Receta> arrayRecetas)
	{														//se crean las ventanasPrincipales de todas las recetas
		for(int i=0;i<arrayRecetas.size();i++)
		{
			arrayRecetas.get(i).setVentanaPrincipal(new VentanaReceta(arrayRecetas.get(i)));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Archivos getArchivo() {
		return archivos;
	}

	public void setArchivo(Archivos archivo) {
		this.archivos = archivo;
	}

	public ListaAlumnos getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ListaAlumnos listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public ListaDocentes getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(ListaDocentes listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
