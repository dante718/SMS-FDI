package GestionDeFabrica.DAOFactoria;

import GestionDeFabrica.DAO.UsuarioDAO;
import GestionDeFabrica.DAO.UsuarioDAOImp;

public class FactoriaDAOUsuarioImp extends FactoriaDAOUsuario {

	@Override
	public UsuarioDAO generaObjetoUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOImp();
	}


}
