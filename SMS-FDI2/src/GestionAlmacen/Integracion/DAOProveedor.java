package GestionAlmacen.Integracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import GestionAlmacen.Negocio.TProveedor;

public class DAOProveedor {
	
	String _bdProveedores = "src/BaseDatos/proveedores.txt";
	
	private ArrayList<TProveedor> _proveedores = new ArrayList<TProveedor>();
	
	public DAOProveedor() {
		leerBD();
	}
	
	public void leerBD() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(_bdProveedores);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			while(linea != null) {
				TProveedor proveedor = new TProveedor();
				proveedor.setNombreProveedor(linea);
				linea = br.readLine();
				proveedor.setEmpresaProveedor(linea);
				linea = br.readLine();
				proveedor.setGmailProveedor(linea);
				_proveedores.add(proveedor);
				linea = br.readLine();
			}
		}catch(IOException | IllegalArgumentException ex) {
			System.out.println(ex.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public ArrayList<TProveedor> getProveedores(){
		return _proveedores;
	}
	
	public void writeBD(ArrayList<TProveedor> proveedores) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(_bdProveedores);
			pw = new PrintWriter(fichero);
			
			for(int i = 0; i < proveedores.size(); ++i) {
				pw.println(proveedores.get(i).getNombreProveedor());
				pw.println(proveedores.get(i).getEmpresaProveedor());
				pw.println(proveedores.get(i).getGmailProveedor());
			}
			
			_proveedores = proveedores;
			
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
	
	public ArrayList<TProveedor> addProveedor(TProveedor proveedor){
		_proveedores.add(proveedor);
		return _proveedores;
	}

}