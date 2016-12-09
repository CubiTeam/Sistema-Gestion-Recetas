import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class FacadeUsuario{
	
	private String nombre;
	private String rut;
	private String direccion;
	private String correo;
	private String sexo;
	private int edad;
	private int telefono;
	private boolean tipoUsuario;
	
	private Docente docente;
	private Alumno alumno;
	
	
	public FacadeUsuario(String nombre, String rut, String direccion, String correo, String sexo,
			String edad, String telefono, boolean tipoUsuario){
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.sexo = sexo;
		this.edad = Integer.parseInt(edad);
		this.telefono = Integer.parseInt(telefono);
		this.tipoUsuario = tipoUsuario;
	}

	public void agregarUsuario(Universidad universidad, JLabel lblVerifCorreo, JTextField txtCorreo) {
		if(tipoUsuario){
			docente = new Docente(nombre,rut,direccion,correo,sexo,edad,telefono);
			docente.generarContrasena();
			if(universidad.getListaDocentes().agregar(docente))
			{
				lblVerifCorreo.setText("\u2713");
				txtCorreo.setBackground(Color.GREEN);
			}
		}else{
			alumno = new Alumno(nombre,rut,direccion,correo,sexo,edad,telefono);
			alumno.generarContrasena();
			if(universidad.getListaAlumnos().agregar(alumno))
			{
				lblVerifCorreo.setText("\u2713");
				txtCorreo.setBackground(Color.GREEN);
			}
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		if(tipoUsuario)
			return docente.getContrasena();
		return alumno.getContrasena();
	}

	public boolean isTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
