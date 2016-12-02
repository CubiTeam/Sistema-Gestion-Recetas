import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaAlumnos extends ListaPersonas implements Arreglo 
{
	private ArrayList <Alumno> arrayAlumnos;
	
	

	
	
	
	
	
	
	
	
	
	public ListaAlumnos(Archivos archivo)
	{
		arrayAlumnos = archivo.cargarArchivoTextoAlumno(arrayAlumnos);

	}
	
	
	
	
	
	
	
	
	
	
	
	//agrega a un nuevo alumno
	public boolean agregar (Object alumnoNuevo)
	{
		if(validar((Alumno)alumnoNuevo))
		{
			arrayAlumnos.add((Alumno)alumnoNuevo);
			Archivos archivo= new Archivos();
			try {
				archivo.actualizarTxtAlumno((Alumno)alumnoNuevo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		return false;
	}
	
	
	
	//retorna el largo del array de alumnos
	public int size()
	{
		return arrayAlumnos.size();
	}
	
	
	
	
	
	
	
	//valida que los datos del alumno son correctos
	public boolean validar(Alumno alumno)
	{
		if(!super.esNumerico(alumno.getRut()))
			return false;
		if(!super.esNumerico(String.valueOf(alumno.getTelefono())))
			return false;
		try{
			verificarEmail(alumno.getCorreo());
		}catch(CorreoException e){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el nombre de un alumno
	public boolean modificar(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			((Alumno)alumno).setNombrePersona(cambiar);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica la direccion de un alumno
	public boolean modificarDireccion(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			((Alumno)alumno).setDireccion(cambiar);;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el rut de un alumno
	public boolean modificarRut(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			((Alumno)alumno).setRut(cambiar);;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica la edad de un alumno
	public boolean modificarEdad(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			if(super.esNumerico(cambiar))
			{
				if(Integer.parseInt(cambiar)>0)
				{
					((Alumno)alumno).setEdad(Integer.parseInt(cambiar));
					return true;
				}
			}
			else
				return false;
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el telefono de un alumno
	public boolean modificarTelefono(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			if(super.esNumerico(cambiar))
			{
				if(verificarTelefono(Integer.parseInt(cambiar)))
				{
					((Alumno)alumno).setTelefono(Integer.parseInt(cambiar));
					return true;
				}
			}
			else
				return false;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el correo de un alumno
	public boolean modificarCorreo(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			try{
				if(!verificarEmail(cambiar))
				{
					((Alumno)alumno).setCorreo(cambiar);
					return true;
			}}catch(CorreoException e){
				
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Recibe el alumno y contraseña y si existe devuelve true ()
	public boolean existeAlumno(String alumno, JPasswordField contrasena)
	{
		String valor = new String(contrasena.getPassword()); 	
	    if(arrayAlumnos!=null){
	    	for(int i = 0; i < arrayAlumnos.size(); i++){
				if(alumno.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
					return true;
				}
			}
	    }
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//busqueda del alumno por el correo en el array de alumnos 
	public boolean existeAlumnoCorreo(String correoBuscado)
	{													
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++)
			{
				if(correoBuscado.equals(arrayAlumnos.get(i).getCorreo())){
					return true;				
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//elimina un alumno del arreglo de alumnos
	public boolean eliminar(Object alumno)
	{    	
		if(existe(((Alumno)alumno).getRut()))
		{
			Archivos archivos= new Archivos();
			archivos.eliminarTxtAlumno((Alumno)alumno);
			return true;
		}
		return false;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//busqueda del alumno por el rut en el array de alumnos
	public boolean existe(String buscado)
	{										
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++)
			{
				if(buscado.equals(arrayAlumnos.get(i).getRut())){
					return true;			
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//retorna la posicion del alumno en el arreglo de alumnos
	public int posicionAlumno(String nombreAlumno)
	{										//recibe el nombre de un alumno
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(nombreAlumno.equals(arrayAlumnos.get(i).getNombrePersona())){	
					return i;			
				}
			}
		}
		return -1;//si no está retorna -1
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//busqueda del alumno segun el rut y contraseña en el array de alumnos
	public Alumno getAlumno(String alumno, JPasswordField contrasena)
	{																									    	
		String valor = new String(contrasena.getPassword()); 
		if(arrayAlumnos!=null){	
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(alumno.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
					return arrayAlumnos.get(i);		
				}
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//busca un alumno por el rut en el array de alumnos
	public Alumno busqueda(String buscado)
	{									   	
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(buscado.equals(arrayAlumnos.get(i).getRut()))
				{
					return arrayAlumnos.get(i);
					
				}
			}
		}
		return null;	
	}

	
	
	//retorna la posicion del alumno en el array
	public Alumno getPosAlumno(int buscado)
	{									   	
		if(buscado<arrayAlumnos.size())
			return arrayAlumnos.get(buscado);
		return null;	
	}
	
	
	
	
	
	

	
	//retorna todas las recetas de todos los alumnos
	public ArrayList<Receta> TodasLasRecetas()
	{
		ArrayList<Receta> todasRecetas= new ArrayList<Receta>();
		for(int i=0;i<arrayAlumnos.size();i++)
		{
			for(int j=0;j<arrayAlumnos.get(i).getListaRecetas().getArrayRecetas().size();j++)
			{
				if(!arrayAlumnos.get(i).getListaRecetas().getArrayRecetas().isEmpty())
					todasRecetas.add(arrayAlumnos.get(i).getListaRecetas().getArrayRecetas().get(j));
			}
		}
		return todasRecetas;
	}	
	
	
	
	
	
	


}
