package GestionDeFabrica.Factoria;

import GestionDeFabrica.DAO.PedidoProyectoDAO;
import GestionDeFabrica.DAO.PedidosDAO;
import GestionDeFabrica.DAO.UsuarioDAO;
import GestionDeFabrica.DAO.UsuarioProyectoDAO;

public class ProyectoDAOFactory extends FactoriaAbstractaDAO {

	@Override
	public UsuarioDAO generaUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioProyectoDAO();
	}

	@Override
	public PedidosDAO generaPedidoDAO() {
		// TODO Auto-generated method stub
		return new PedidoProyectoDAO();
	}

}
