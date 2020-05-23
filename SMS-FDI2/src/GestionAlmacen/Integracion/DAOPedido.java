package GestionAlmacen.Integracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

import GestionAlmacen.Negocio.TPedido;

public class DAOPedido {
	
	String _bdPedidos = "src/BaseDatos/sis_pedidos.txt";
	private ArrayList<TPedido> _pedidos = new  ArrayList<TPedido>();
	
	public DAOPedido() {
		leerBD();
	}
	
	public void leerBD() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> productos = new ArrayList<String>();
		
		try {
			archivo = new File(_bdPedidos);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			while(linea != null && !linea.isEmpty()) {
				TPedido pedido = new TPedido();
				pedido.setIdPedido(linea);
				linea = br.readLine();
				pedido.setIdSolicitante(linea);
				linea = br.readLine();
				pedido.setNombreSolicitante(linea);
				linea = br.readLine();
				while(!linea.isEmpty() && linea != null) {
					productos.add(linea);
					linea = br.readLine();
				}
				pedido.setProductos(productos);
				_pedidos.add(pedido);
				linea = br.readLine();
			}
		}catch(IOException | IllegalArgumentException ex) {
			System.out.println(ex.getLocalizedMessage());
			System.exit(1);;
		}
	}
	
	public ArrayList<TPedido> getPedidos(){
		return _pedidos;
	}
	
	
}