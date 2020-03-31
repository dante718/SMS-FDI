package GDA.Modelo;

import java.io.File;
import java.util.Scanner;

public class ModeloGestionProducto {
	
	private String _file;
	private Producto[] _producto;
	
	public ModeloGestionProducto(String file){
		_file = file;
		_producto = null;
	}
	
	public void addProducto(Producto p){
		
	}
	
	public void modificarProducto(String id){
		
	}
	
	public void eliminarProducto(String id){
		
	}
	
	@SuppressWarnings("null")
	public Producto[] leerProductos(){
		String datos[] = null;
		Producto productos[] = null;
		File fichero = new File(_file);
		Scanner s = null;
		
		try{
			s = new Scanner(fichero);
			int i = 0;
			while(s.hasNextLine()){
				String linea = s.nextLine();
				datos = linea.split(" ");
				productos[i].set_id(Integer.parseInt(datos[0]));
				productos[i].set_nombre(datos[1]);
				productos[i].set_cantidad(Integer.parseInt(datos[2]));
				productos[i].set_precio(Integer.parseInt(datos[3]));
				i++;
			}
		}catch(Exception ex){
			System.out.println("Mensaje: " + ex.getMessage());
		}finally{
			try{
				if(s != null) s.close();
			}catch(Exception ex2){
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		return productos;
	}
	
	public void mostrarProductos(Producto[] productos){
		System.out.println(productos);
	}
}
