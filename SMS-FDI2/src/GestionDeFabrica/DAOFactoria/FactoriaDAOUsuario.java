package GestionDeFabrica.DAOFactoria;

import GestionDeFabrica.DAO.UsuarioDAO;
import GestionDeFabrica.TransfersObjects.FactoriaTransferUsuario;
import GestionDeFabrica.TransfersObjects.FactoriaTransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public abstract class FactoriaDAOUsuario {

private static FactoriaDAOUsuario factoria;
	
	public static FactoriaDAOUsuario dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaDAOUsuarioImp();
		}
		
		return factoria;
	}
	
	public abstract UsuarioDAO generaObjetoUsuarioDAO();
}

