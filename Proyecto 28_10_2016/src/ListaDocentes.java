import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaDocentes implements Arreglo
{
	
	private ArrayList <Docente> arrayDocentes;
	
	
	
	
	
	public ListaDocentes(Archivos archivo)
	{
		arrayDocentes = new ArrayList<Docente>();
		archivo.cargarArchivoTextoDocente(ListaDocentes.this);
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//verifica que el docente tenga la misma contraseña que se ingresó
	public boolean verificacion(Docente docente,JPasswordField contrasena)
	{														
		if(contrasena.getText().equals(docente.getContrasena())){
				return true;		
		}else{
			return false;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Docente> getArrayDocentes() {
		return arrayDocentes;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setArrayDocentes(ArrayList<Docente> arrayDocentes) 
	{
		this.arrayDocentes = arrayDocentes;
	}













	
	


	//agrega un docente al arreglo de docentes
	public boolean agregar(Object docenteAgregar) 
	{
		if(docenteAgregar!=null)
		{
			arrayDocentes.add((Docente)docenteAgregar);
			return true;
		}
		return false;
	}
















	
	

	
	
	//modifica el nombre de un docente
	public boolean modificar(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			((Docente)docente).setNombrePersona(cambiar);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica la direccion de un docente
	public boolean modificarDireccion(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			((Docente)docente).setDireccion(cambiar);;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el rut de un docente
	public boolean modificarRut(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			((Docente)docente).setRut(cambiar);;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica la edad de un docente
	public boolean modificarEdad(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			if(esNumerico(cambiar))
			{
				if(Integer.parseInt(cambiar)>0)
				{
					((Docente)docente).setEdad(Integer.parseInt(cambiar));
					return true;
				}
			}
			else
				return false;
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//verifica que el string se pueda cambiara numerico
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el telefono de un docente
	public boolean modificarTelefono(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			if(esNumerico(cambiar))
			{
				if(verificarTelefono(Integer.parseInt(cambiar)))
				{
					((Docente)docente).setTelefono(Integer.parseInt(cambiar));
					return true;
				}
			}
			else
				return false;
		}
		return false;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el correo de un docente
	public boolean modificarCorreo(Object docente,String cambiar)
	{
		if(existe(((Docente)docente).getRut()))
		{
			if(verificarEmail(cambiar))
			{
				((Docente)docente).setCorreo(cambiar);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//verifica que el correo tenga el @ y el .
	public boolean verificarEmail(String email){
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
	
	
	
	
	
	










	//elimina un docente del array de docentes
	public boolean eliminar(Object docenteEliminar) 
	{
		if(existe(((Docente)docenteEliminar).getRut()))
		{
			arrayDocentes.remove(docenteEliminar);
			return true;
		}
		return false;
	}
















	//busca un docente por su rut y retorna true si es que existe 
	public boolean existe(String buscado) 
	{
		for(int i=0;i<arrayDocentes.size();i++)
		{
			if(arrayDocentes.get(i).getRut().equals(buscado))
				return true;
		}
		return false;
	}



	//busca un docente por su rut y lo retorna 
	public Object busqueda(String rutDocente)
	{															
		if(arrayDocentes!=null){
			for(int i = 0; i < arrayDocentes.size(); i++){
				if(arrayDocentes.get(i).getRut().equals(rutDocente))
				{
					return arrayDocentes.get(i);				
				}
			}
		}
		return null;			//si no existe retorna null
	}



	
}
