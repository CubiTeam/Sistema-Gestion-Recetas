import java.util.ArrayList;


public class ListaComentarios implements Arreglo
{
	private ArrayList<Comentario> arrayComentarios;
	
	
	
	
	
	
	
	public ListaComentarios(ArrayList<Comentario> arrayComentarios)
	{
		this.arrayComentarios= arrayComentarios;
	}
	
	
	
	
	
	
	
	public ListaComentarios()
	{
		this.arrayComentarios= new ArrayList<Comentario>();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//se cargan los arrayComentarios de todas las recetas
	public void  cargarArrayComentarios(Universidad universidad)
	{						
		for(int i=0;i<arrayComentarios.size();i++)
		{
			Alumno alumnoEncontrado = 
				universidad.getListaAlumnos().busqueda(arrayComentarios.get(i).getRut());
			if(alumnoEncontrado!=null)
				arrayComentarios.get(i).setAutor(alumnoEncontrado);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//agrega un comentario nuevo a la receta
	public boolean agregar(Object comentario)
	{	
		
		if(!existe(String.valueOf(((Comentario)comentario).getNumero())))
		{
			arrayComentarios.add((Comentario)comentario);
			return true;
		}
		return false;
	}
	
	
	
	

	
	
	
	
	
	
	public boolean existe(String buscado)
	{
		
		for(int i=0;i<arrayComentarios.size();i++)
		{
			if(arrayComentarios.get(i).getNumero()==Integer.parseInt(buscado))
				return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	//retorna el largo del arreglo
	public int largo()
	{
		return arrayComentarios.size();
	}
	
	
	
	
	
	
	//retorna el comentario de la posicion 
	public Comentario getPosComentario(int i)
	{
		if(i<arrayComentarios.size())
			return arrayComentarios.get(i);
		return null;
	}






	//crea un numero que identifique al comentario para poder modificarlo o eliminarlo
	public int identificadorComentario()
	{									
		int numero=0,cont;
		int correcto=0;
		while(correcto!=1)
		{
			cont=numero;
			if(arrayComentarios==null)
				arrayComentarios= new ArrayList<Comentario>();
			for(int i=0;i<arrayComentarios.size();i++)
			{
				if(arrayComentarios.get(i).getNumero()==numero)
					numero++;
			}
			if(cont==numero)
				correcto=1;		//se valida que el numero no lo tenga otro comentario
		}
		return numero;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//retorna un comentario segun el numero identificador que tenga
	public Comentario busqueda(String code)
	{					
		for(int i=0;i<arrayComentarios.size();i++)
		{
			if(arrayComentarios.get(i).getNumero()==Integer.parseInt(code))
				return arrayComentarios.get(i);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//elimina un comentario de la receta
	public boolean eliminar(Object comentarioEliminar)
	{												
		for(int i=0;i<arrayComentarios.size();i++)
		{
			if(arrayComentarios.get(i)==(Comentario)comentarioEliminar)
			{
				arrayComentarios.remove(i);
				return true;
			}
		}
	
		return false;
	}
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	

	//modifica un comentario de la receta
	public boolean modificar(int codeNumerico,String nuevoComentario)
	{												
		for(int i=0;i<arrayComentarios.size();i++)
		{
			if(arrayComentarios.get(i).getNumero()==codeNumerico)
			{	
				arrayComentarios.get(i).setTexto(nuevoComentario);
				return true;
			}
		}
		return false;
	}








	



	//recibe un comentario con el nuevo texto y lo cambia
	public boolean modificar(Object comentario,String cambiar) 
	{
		if(existe(String.valueOf(((Comentario)comentario).getNumero())));
		{
			((Comentario)comentario).setTexto(cambiar);
		}
		return false;
	}












	
	
	
	
}

