import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaDocentes implements Arreglo
{
	
	private ArrayList <Docente> arrayDocentes;
	
	
	
	
	
	public ListaDocentes(Archivos archivo)
	{
		archivo.cargarArchivoTextoDocente(ListaDocentes.this);
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//verifica que el docente tenga la misma contraseña que se ingresó
	public boolean verificacion(Docente docente,JPasswordField contrasena)
	{														
		if(contrasena.equals(docente.getContrasena())){
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
		}
		return false;
	}
















	
	public boolean modificar(Object objeto, String cambiar) 
	{
		// TODO Auto-generated method stub
		return false;
	}
















	@Override
	public boolean eliminar(Object e) 
	{
		// TODO Auto-generated method stub
		return false;
	}
















	@Override
	public boolean existe(String buscado) 
	{
		for(int i=0;i<arrayDocentes.size();i++)
		{
			if(arrayDocentes.get(i).getRut().equals(buscado))
				return true;
		}
		return false;
	}




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
