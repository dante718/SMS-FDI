package GestionDeFabrica.TransfersObjects;

public class FactoriaTransferPedidoImp extends FactoriaTransferPedidos {

	@Override
	public PedidosTransfer generaObjetoPedidoTransfer() {
		// TODO Auto-generated method stub
		return new TransferPedidoImp();
	}

}
