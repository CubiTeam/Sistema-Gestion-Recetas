import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	
	
	//se obtienen los ultimos digitos del rut y se convierte en la contraseña
	public String generarContraseña(String rut) 
	{
		int pass,i,digito= 0, aux=0;
		String contrasena;
		pass = Integer.parseInt(rut);
		
		for(i=0;i<6;i++)				
		{								
			digito = pass%10;
			pass = pass/10;
			aux = aux*10 + digito;
		}
		this.contrasena = String.valueOf(aux);
		contrasena = String.valueOf(aux);
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
