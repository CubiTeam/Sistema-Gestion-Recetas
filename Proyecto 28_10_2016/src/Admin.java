public class Admin 
{
	private String contrasena;
	
	public Admin(String contrasena)
	{
		this.contrasena=contrasena;
	}
	
	//valida que se ingres� la contrase�a correcta
	public boolean validacion(String contrasenaIngresada)
	{
		if(contrasenaIngresada.equals(contrasena))
			return true;
		return false;
	}
}
