package GestionDeFabrica.TransfersObjects;

public abstract class FactoriaTransferPedidos {

	private static FactoriaTransferPedidos factoria;
	
	public static FactoriaTransferPedidos dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaTransferPedidoImp();
		}
		
		return factoria;
	}
	
	public abstract PedidosTransfer generaObjetoPedidoTransfer();
}
