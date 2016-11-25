import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaDocentes extends ListaPersonas implements Arreglo
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
