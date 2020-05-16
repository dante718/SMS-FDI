package GestionDeFabrica.TransfersObjects;

import GestionDeFabrica.Modelo.EstadoPedido;

public class PedidoTransferProyecto extends PedidosTransfer {

	private String nombreFarmaco;
	
	public String getNombreFarmaco() {
		
		return this.nombreFarmaco;
	}
	
	public void setNombreFarmaco(String nombre) {
		
		this.nombreFarmaco = nombre;
	}
}
