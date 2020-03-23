package integracion_Laboratorio;

import java.util.List;

import negocio_Laboratorio.TransferPedido_Lab;
import negocio_Laboratorio.TransferProducto_Lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DAOPedido_Lab {
	String sis_pedidos = "src/integracion/sis_pedidos.txt";
	
	File _filePed= new File(sis_pedidos);
	
	
	public TransferPedido_Lab crearPedido() {
		
		return new TransferPedido_Lab();
		
	}
	
	public void ModificaPedido(TransferPedido_Lab ped,String idSolicitante, String NombreSolicitante,List<TransferProducto_Lab> productos) {
		if(ped!=null) {
			if(idSolicitante!=null) ped.set_idSolicitante(idSolicitante);
			if(NombreSolicitante!=null) ped.set_NombreSolicitante(NombreSolicitante);
			if(productos!=null) ped.set_productos(productos);
		}
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
	
}
