package GestionDeFabrica.TransfersObjects;

public class FactoriaTransferUsuarioImp extends FactoriaTransferUsuario {

	@Override
	public UsuarioTransfer generaObjetoUsuarioTransfer() {
		// TODO Auto-generated method stub
		return new TransferUsuarioImp();
	}

}
