package GestionLaboratorio.integracion_Laboratorio;

import GestionLaboratorio.negocio_Laboratorio.TransferPedido_Lab;
import GestionLaboratorio.negocio_Laboratorio.TransferProducto_Lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class DAOPedido_Lab {
	String sis_pedidos = "src/BaseDatos/sis_pedidos.txt";
	
	File _filePed= new File(sis_pedidos);
	
	
	public TransferPedido_Lab crearPedido() {
		
		return new TransferPedido_Lab();
		
	}

	public TransferPedido_Lab BuscarPedidoEnsisPedidos(String id_ped) {
		TransferPedido_Lab ped= crearPedido();
		String str;
		try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(sis_pedidos)))){
			str = r.readLine();
			boolean encontrado =false;
			while(str != null&&!encontrado ) {
				if(str.equals("Id_Pedido: "+ id_ped)) {
					ped.set_idPedido(Integer.parseInt(id_ped));
					encontrado=true;
				}
				else {
					str = r.readLine();
				}
				
			}
			if(!encontrado) {
				throw new IllegalArgumentException("El pedido no esta en BBDD");
			}
			
		} catch (IOException | IllegalArgumentException ex) {
			throw new IllegalArgumentException(ex.getLocalizedMessage());
		}
		
		
		
		return ped;
	}
	
	
	public void guardarPedidoEnSisPedidos(TransferPedido_Lab ped) {   
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(_filePed.getAbsoluteFile(), true))){
			wr.write("Id_Pedido: " + ped.get_idPedido()+"\n");
			wr.write("Id_Solicitante: " + ped.get_idSolicitante()+"\n");
			wr.write("Nombre_Solicitante: " + ped.get_NombreSolicitante() + "\n");
			wr.write("Productos: " + "\n");
			for(TransferProducto_Lab p: ped.get_productos()) {
				wr.write("  ID_Producto: " + p.get_idProducto() + "\n");
				wr.write("  Nombre_Producto: " + p.get_nombre() + "\n");
				wr.write("  Cantidad_Por_Producto: " + p.get_cantidad() + "\n");	
				}
			wr.write("\n");
		} catch (IOException | IllegalArgumentException ex) {
			System.err.println(ex.getLocalizedMessage());
			System.exit(1);
		}
	}

	public void EliminarPedido(String id_ped) {
		String str;
		try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(sis_pedidos)))){
			str = r.readLine();
			boolean encontrado =false;
			while(str != null&&!encontrado ) {
				if(str.equals("Id_Pedido: "+ id_ped)) {
					encontrado=true;
				}
				else {
					str = r.readLine();
				}
				
			}
			if(!encontrado) {
				throw new IllegalArgumentException("El pedido no esta en BBDD");
			}
			
		} catch (IOException | IllegalArgumentException ex) {
			throw new IllegalArgumentException(ex.getLocalizedMessage());
		}
		
	}
	
}
