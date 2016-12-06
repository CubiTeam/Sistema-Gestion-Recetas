import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListaReceta 
{
	
	private ArrayList<Receta> arrayRecetas;
	
	
	
	public ListaReceta()
	{
		arrayRecetas= new ArrayList<Receta>();
		
	}
	
	
	
	
	
	
	//elimina una receta del txt y del ArrayList de recetas
		public boolean eliminarReceta(Receta receta,String rut)
		{					
			File raiz = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+rut+"\\Recetas");
			if(raiz.exists()){
				File archivoReceta = new File(raiz,receta.getNombreReceta()+".txt");
					if(archivoReceta.delete()){
						if(arrayRecetas.remove((Receta)receta))
							return true;
					}
			}
			return false;
		}
		
		
		
	
		
		
		
		
		
		//verifica que la receta existe
		public boolean existe(Receta receta)
		{
			for(int i=0;i<arrayRecetas.size();i++)
			{
				if(arrayRecetas.get(i)==receta)
					return true;
			}
			return false;
		}

		
		
		
		
		
		
		
		
		
		
		
		
	
		
		public ArrayList<Receta> getArrayRecetas() {
			return arrayRecetas;
		}



		
		
		
		
		
		
		
		
		



		public void setArrayRecetas(ArrayList<Receta> arrayRecetas) {
			this.arrayRecetas = arrayRecetas;
		}





		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//agrega una receta al ArrayList de recetas
		public void agregarReceta(Receta receta)
		{		
			
			if(!existe(receta))
			{
				arrayRecetas.add(receta);
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
		//llama al metodo actualizarDatosRecetas de cada receta del alumno
		public void guardarDatosReceta(Alumno alumno) throws IOException
		{			
			Archivos archivo = new Archivos();
			if(!arrayRecetas.isEmpty())
			{		
				for(int i = 0;i < arrayRecetas.size();i++)
				{
					archivo.actualizarDatosReceta(alumno,arrayRecetas.get(i));	//este metodo guarda los datos de una receta
				}
			}
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//modifica la receta recibida
	public boolean modificarReceta(Receta recetaClon)
	{
		Archivos archivo = new Archivos();
		
		//se busca la receta original
		Receta receta= (Receta)busqueda(recetaClon.getAutor().getRut());
		
		receta.setCategorias(recetaClon.getCategorias());
		receta.setNombreReceta(recetaClon.getNombreReceta());
		receta.setInstrucciones(recetaClon.getInstrucciones());
		receta.setTiempoEstimadoPreparacion(recetaClon.getTiempoEstimadoPreparacion());
		
		if(archivo.eliminarRecetaTxt(receta,receta.getAutor().getRut()))	
    	{
	    	//vuelve a crear el txt con los datos nuevos
	    	try {						
	    		archivo.actualizarDatosReceta(receta.getAutor(),receta); 
	    		return true;
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	    	
    	}
		
		return false;
	}
	
}
