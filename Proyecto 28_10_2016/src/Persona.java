
public abstract class Persona {
	private String nombrePersona;
	private String rut;
	private String direccion;
	private String sexo;
	private String correo;
	private int edad;
	private int telefono;
	private String contrasena;
	private boolean tipoUsuario;
	

	public Persona(String nombrePersona, String rut, String direccion, String correo,
			String sexo, int edad, int telefono, String contrasena) 
	{
		this.nombrePersona = nombrePersona;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
		this.contrasena= contrasena;
	}
	
	public Persona(String nombrePersona, String rut, String direccion, String correo,
			String sexo, int edad, int telefono) 
	{
		this.nombrePersona = nombrePersona;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
	}
	
	public Persona(String nombrePersona, String rut, String direccion, String correo,
			String sexo, String edad, String telefono, boolean tipoUsuario) 
	{
		this.nombrePersona = nombrePersona;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.sexo = sexo;
		this.edad = Integer.parseInt(edad);
		this.telefono = Integer.parseInt(telefono);
		this.tipoUsuario = tipoUsuario;
	}
	
	//se obtienen los ultimos digitos del rut y se convierte en la contraseña
	public String generarContrasena() 
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
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Persona(String nombrePersona) 
	{
		this.nombrePersona=nombrePersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
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

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCorreo() {
		return correo;
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
	
	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
