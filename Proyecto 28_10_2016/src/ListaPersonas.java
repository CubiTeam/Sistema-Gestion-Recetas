import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ListaPersonas 
{

	

	//verifica que tenga la composicion correcta de un correo valido
	public boolean verificarEmail(String email) throws CorreoException
	{
		Pattern patron;
		Matcher mat;
		
		patron = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]*(\\.[A-Za-z]{2,})$");
		mat = patron.matcher(email);
		try{
		if(!(mat.find()))
		   
			throw new CorreoException();
		}catch(CorreoException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	
	
	//valida que la contraseña es correcta
	public boolean verificacion(String contraseñaReal, String contraseñaIngresada) throws CorreoException 
	{ 
		try{
			if(!(contraseñaReal.equals(contraseñaIngresada))){
				throw new ContrasenaException("Contraseña no valida");
			}
		}catch(ContrasenaException e){
			e.printStackTrace();
			return false;
		}
			
		return true;
	}
			
	
		
		
		
		
	
	//verifica que el telefono tenga 8 digitos
	public boolean verificarTelefono(int nuevoTelefono)	
	{
		int cont = 0;
		while(nuevoTelefono>0){
			nuevoTelefono = nuevoTelefono/10;
			cont++;
		}
		if(cont>=8)
			return true;
		else
			return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	//verifica que el string se pueda cambiar a numerico
	public boolean esNumerico(String string)
	{
	    boolean numerico = true;
	    try{
	        Integer.parseInt(string);
	    }catch(NumberFormatException e){
	    	numerico = false;
	    }
	    return numerico;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public abstract boolean modificarRut(Object persona,String cambiar);

	public abstract boolean modificarEdad(Object persona,String cambiar);

	public abstract boolean modificarDireccion(Object persona,String cambiar);

	public abstract boolean modificarTelefono(Object persona,String cambiar);

	public abstract boolean modificarCorreo(Object persona,String cambiar);
	


}
