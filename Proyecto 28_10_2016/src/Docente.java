import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
public class Docente extends Persona
{

	public Docente(){
		this("","","","","",0,0,"");
	}
	
	public Docente(String nombrePersona, String rut, String direccion, String correo, String sexo, int edad,
			int telefono) {
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		}

	public Docente(String nombrePersona, String rut, String direccion, String correo, String sexo, int edad,
			int telefono,String contrasena) {
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono,contrasena);
		}
	
	
	
	//se genera una contraseña al azar con la clase Random
	public String generarContrasena() 
	{
		int pass,i,digito= 0, aux=0;
		String contrasena;
		Random  rnd = new Random();
		contrasena = String.valueOf(rnd.nextInt());
		super.setContrasena(contrasena);
		return contrasena;
	}
	
	//valida que los datos del docente sean correctos
	public boolean validarDocente(String rut, String password) 
	{						
		if(rut.equals(super.getRut()) && password.equals(getContrasena()))
		{
			return true;
		}
		return false;
	}
	
}
