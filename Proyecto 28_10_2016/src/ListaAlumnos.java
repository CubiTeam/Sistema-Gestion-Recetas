import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaAlumnos implements Arreglo 
{

	
	
	
	
	
	
	
	
	

	
	
	
	private ArrayList <Alumno> arrayAlumnos;
	
	public ListaAlumnos(Archivos archivo)
	{
		arrayAlumnos = archivo.cargarArchivoTextoUsuario(arrayAlumnos);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Este metodo agrega a un nuevo alumno
	public boolean agregar (Object a)
	{
		if(arrayAlumnos.add((Alumno)a))
			return true;
		return false;
	}
	
	
	
	
	
	public boolean modificar(Object alumno,String cambiar)
	{
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	//Recibe el usuario y contraseña y si existe devuelve true ()
	public boolean existeAlumno(String usuario, JPasswordField contrasena)
	{
		String valor = new String(contrasena.getPassword()); 	
	    if(arrayAlumnos!=null){
	    	for(int i = 0; i < arrayAlumnos.size(); i++){
				if(usuario.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int posicionUsuario(String nombreUsuario)
	{										//recibe el nombre de un usuario
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(nombreUsuario.equals(arrayAlumnos.get(i).getNombrePersona())){	
					return i;			//retorna la posicion en que se encuentra del ArrayList de usuarios
				}
			}
		}
		return -1;//si no está retorna -1
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//busqueda del alumno segun el rut y contraseña en el array de alumnos
	public Alumno getAlumno(String usuario, JPasswordField contrasena)
	{																									    	
		String valor = new String(contrasena.getPassword()); 
		if(arrayAlumnos!=null){	
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(usuario.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
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


	public ArrayList<Alumno> getArrayAlumnos() {
		return arrayAlumnos;
	}
	
	
	
	
	
	
	
	
	
	public void setArrayAlumnos(ArrayList<Alumno> arrayAlumnos) {
		this.arrayAlumnos = arrayAlumnos;
	}

}
