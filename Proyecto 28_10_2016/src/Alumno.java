

public class Alumno extends Persona{
	private String contrasena;
	private ListaReceta listaRecetas;
	
	
	
	
	
	
	
	//ASDASDASDASDSA
	
	//dsdfwefwef
	
	public Alumno()
	{
		this ("","","","","",0,0);
		this.contrasena = "";
	}

	
	
	
	
	
	
	
	

	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono, String contrasena)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		this.setContrasena(contrasena);
		listaRecetas= new ListaReceta();
	}

	
	
	
	
	
	
	
	
	
	
	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		listaRecetas= new ListaReceta();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
















	public String getContrasena() {
		return contrasena;
	}










	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}






	

















	public ListaReceta getListaRecetas() {
		return listaRecetas;
	}










	public void setListaRecetas(ListaReceta listaRecetas) {
		this.listaRecetas = listaRecetas;
	}










	public Alumno(String nombrePersona)
	{
		super(nombrePersona);
	}
	
	
	
	
	
	
	
	
	//se genera una contrase�a estadar para el alumno
		public String generarContrase�a(String rut) 
		{
			int pass, i, digito = 0, aux = 0;
			String contrasena;
			pass = Integer.parseInt(rut);

			for(i=0;i<5;i++)				//se obtienen los ultimos digitos del rut
			{								//y se convierte en la contrase�a
				digito = pass%10;
				pass = pass/10;
				aux = aux*10 + digito;
			}
			this.contrasena = String.valueOf(aux);
			contrasena = String.valueOf(aux);
			return contrasena;
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString()
	{

		return getNombrePersona()+" \n";
	}
}

