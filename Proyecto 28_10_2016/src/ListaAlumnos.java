import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaAlumnos implements Arreglo 
{
	private ArrayList <Alumno> arrayAlumnos;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListaAlumnos(Archivos archivo)
	{
		arrayAlumnos = archivo.cargarArchivoTextoUsuario(arrayAlumnos);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	//agrega a un nuevo alumno
	public boolean agregar (Object a)
	{
		if(arrayAlumnos.add((Alumno)a))
			return true;
		return false;
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
			if(Integer.parseInt(cambiar)>0)
			{
				((Alumno)alumno).setEdad(Integer.parseInt(cambiar));
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el telefono de un alumno
	public boolean modificarTelefono(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			if(verificarTelefono(Integer.parseInt(cambiar)))
			{
				((Alumno)alumno).setTelefono(Integer.parseInt(cambiar));
				return true;
			}
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica el correo de un alumno
	public boolean modificarCorreo(Object alumno,String cambiar)
	{
		if(existe(((Alumno)alumno).getRut()))
		{
			if(verificarEmail(cambiar))
			{
				((Alumno)alumno).setCorreo(cambiar);
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
			return true;
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	//retorna la posicion del alumno en el arreglo de alumnos
	public int posicionUsuario(String nombreUsuario)
	{										//recibe el nombre de un usuario
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(nombreUsuario.equals(arrayAlumnos.get(i).getNombrePersona())){	
					return i;			
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
