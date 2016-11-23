

public class Alumno extends Persona{
	private ListaReceta listaRecetas;
	
	
	
	public Alumno()
	{
		this ("","","","","",0,0,"");
	}
	
	
	public Alumno(String nombrePersona)
	{
		super(nombrePersona);
	}
	
	
	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono, String contrasena)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono,contrasena);
		listaRecetas= new ListaReceta();
	}

	
	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		listaRecetas= new ListaReceta();
	}

	public ListaReceta getListaRecetas() {
		return listaRecetas;
	}

	public void setListaRecetas(ListaReceta listaRecetas) 
	{
		this.listaRecetas = listaRecetas;
	}

	@Override
	public String toString()
	{

		return getNombrePersona()+" \n";
	}
}

