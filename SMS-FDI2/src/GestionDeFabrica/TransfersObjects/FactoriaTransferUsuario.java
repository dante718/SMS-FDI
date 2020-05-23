package GestionDeFabrica.TransfersObjects;

public abstract class FactoriaTransferUsuario {

private static FactoriaTransferUsuario factoria;
	
	public static FactoriaTransferUsuario dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaTransferUsuarioImp();
		}
		
		return factoria;
	}
	
	public abstract UsuarioTransfer generaObjetoUsuarioTransfer();
}
