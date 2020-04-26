package GestionLaboratorio.integracion_Laboratorio;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import GestionLaboratorio.negocio_Laboratorio.TransferProducto_Lab;


public class DAOProducto_Lab {

	
	String bbdd_almacen = "src/GestionLaboratorio/integracion_Laboratorio/bbdd_almacen.txt";
	
	private String[][]productos;
	
	public DAOProducto_Lab() {
		LeerBBDDProducto(); //tener actualizado la lista de productos que hay en almacen
	}
	
	public void LeerBBDDProducto()        //guarda los productos en "productos"
	{
		String str;
		try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(bbdd_almacen)))){
			productos = new String[Integer.parseInt(r.readLine())][2];
			int i = 0;
			str = r.readLine();
			while(str != null) {
				productos[i][0] = str;
				str = r.readLine();
				productos[i][1] = str;
				i++;
				str = r.readLine();
			}
			
		} catch (IOException | IllegalArgumentException ex) {
			System.err.println(ex.getLocalizedMessage());
			System.exit(1);
		}
		
	}
	
	public TransferProducto_Lab ConsultaStock(int id_Producto,int cantidad) {
		TransferProducto_Lab ProductoBuscado=null;
		boolean encontrado=false;
		for(int i=0;i<productos.length&&!encontrado;i++) {
			if(id_Producto==Integer.parseInt(productos[i][0])) {
				if(Integer.parseInt(productos[i][1])>=cantidad) {
					ProductoBuscado= new TransferProducto_Lab();
					ProductoBuscado.set_idProducto(id_Producto);
					ProductoBuscado.set_cantidad(cantidad);
					productos[i][0]=Integer.toString(Integer.parseInt(productos[i][0])-cantidad);
					encontrado=true;
				}
				else {
					throw new IllegalArgumentException("La cantidad es superior al stock");
				}
			}
		}
		
		return ProductoBuscado;
	}
	
	
}
	
	
	

