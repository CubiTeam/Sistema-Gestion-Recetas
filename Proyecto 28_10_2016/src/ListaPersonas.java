
public abstract class ListaPersonas 
{
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	//verifica que el correo tenga el @ y el .
	public boolean verificarEmail(String email)
	{
		int verificarArroba = 0;
		int verificarPuntos = 0;
		
		for(int i = 0;i < email.length(); i++){
			if(email.charAt(i) == '@')//ExtraerCaracter
			verificarArroba++;
	
		if(email.charAt(i) == '.')
				verificarPuntos++;
		}
		
		if(verificarArroba != 1 && verificarPuntos < 1)
			return false;
		
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
