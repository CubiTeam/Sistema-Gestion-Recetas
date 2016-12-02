import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;

public class ListaDocentes extends ListaPersonas implements Arreglo
{
	
	private ArrayList <Docente> arrayDocentes;
	
	
	
	
	
	public ListaDocentes(Archivos archivo)
	{
		arrayDocentes = new ArrayList<Docente>();
		archivo.cargarArchivoTextoDocente(ListaDocentes.this);
	}
	
	
	
	
	//verifica si el correo corresponde a la universidad pucv
	public boolean verificarEmail(String email) throws CorreoException{
		Pattern pat;
		Matcher mat;
		
		pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@mail.pucv.cl");
		mat = pat.matcher(email);

		try{
			if(!(mat.find()))
				throw new CorreoException();
		}catch(CorreoException e){
			return false;
		}
   
		pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@pucv.cl");
		mat = pat.matcher(email);
		try{
			if(!(mat.find()))
				throw new CorreoException();
		}catch(CorreoException e){
			return false;
		}
   
		pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@ucv.cl");
		mat = pat.matcher(email);
		try{
			if(!(mat.find()))
				throw new CorreoException();
		}catch(CorreoException e){
			return false;
		}
		
		return true;
	}


	
	

	
	
	
	
	
	



	


	//agrega un docente al arreglo de docentes
	public boolean agregar(Object docenteAgregar) 
	{
		if(docenteAgregar!=null)
		{
			arrayDocentes.add((Docente)docenteAgregar);
			Archivos archivo = new Archivos();	
			try {
				archivo.actualizarTxtDocente((Docente)docenteAgregar);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
	
	




	
	
	//modifica el correo de un docente
	public boolean modificarCorreo(Object docente,String cambiar)
	{
		if(!(existe(((Docente)docente).getRut())))
		{
			try {
				if(verificarEmail(cambiar)){
					((Docente)docente).setCorreo(cambiar);
				}
			} catch(CorreoException e) {
				return false;
			}
		}
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
