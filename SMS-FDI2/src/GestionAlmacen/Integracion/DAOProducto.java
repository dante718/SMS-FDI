package GestionAlmacen.Integracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import GestionAlmacen.Negocio.TProducto;

public class DAOProducto {
	
	String _bdAlmacen = "src/BaseDatos/bdAlmacen.txt";
	
	private ArrayList<TProducto> _productos = new ArrayList<TProducto>();
	
	public DAOProducto() {
		leerBD();
	}
	
	public void leerBD() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(_bdAlmacen);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			while(linea != null) {
				TProducto producto = new TProducto();
				producto.setIdProducto(Integer.parseInt(linea));
				linea = br.readLine();
				producto.setNombreProducto(linea);
				linea = br.readLine();
				producto.setDescripcionProducto(linea);
				linea = br.readLine();
				producto.setCantidadProducto(Integer.parseInt(linea));
				_productos.add(producto);
				linea = br.readLine();
			}
		}catch(IOException | IllegalArgumentException ex) {
			System.out.println(ex.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public ArrayList<TProducto> getProductos() {
		return _productos;
	}
	
	public void writeBD(ArrayList<TProducto> productos) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(_bdAlmacen);
			pw = new PrintWriter(fichero);
			
			for(int i = 0; i < productos.size(); ++i) {
				pw.println(productos.get(i).getIdProducto());
				pw.println(productos.get(i).getNombreProducto());
				pw.println(productos.get(i).getDescripcionProducto());
				pw.println(productos.get(i).getCantidadProducto());
			}
			
			_productos = productos;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fichero != null) fichero.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<TProducto> addProducto(TProducto producto){
		_productos.add(producto);
		return _productos;
	}
	
	public ArrayList<TProducto> eliminarProducto(int id) {
		_productos.remove(id);
		return _productos;
	}
}
