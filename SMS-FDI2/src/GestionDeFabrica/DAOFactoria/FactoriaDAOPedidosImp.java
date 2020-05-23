package GestionDeFabrica.DAOFactoria;

import GestionDeFabrica.DAO.PedidoAlmacenDAO;
import GestionDeFabrica.DAO.PedidoEnvioDAO;
import GestionDeFabrica.DAO.PedidoInventarioDAO;
import GestionDeFabrica.DAO.PedidoLaboratorioDAO;
import GestionDeFabrica.DAO.PedidoProyectoDAO;
import GestionDeFabrica.DAO.PedidosDAO;

public class FactoriaDAOPedidosImp extends FactoriaDAOPedidos {

	@Override
	public PedidosDAO generaPedidoProyectoDAO() {
		// TODO Auto-generated method stub
		return new PedidoProyectoDAO();
	}

	@Override
	public PedidosDAO generaPedidoLaboratorioDAO() {
		// TODO Auto-generated method stub
		return new PedidoLaboratorioDAO();
	}

	@Override
	public PedidosDAO generaPedidoAlmacenDAO() {
		// TODO Auto-generated method stub
		return new PedidoAlmacenDAO();
	}

	@Override
	public PedidosDAO generaPedidoInventarioDAO() {
		// TODO Auto-generated method stub
		return new PedidoInventarioDAO();
	}

	@Override
	public PedidosDAO generaPedidoEnvioDAO() {
		// TODO Auto-generated method stub
		return new PedidoEnvioDAO();
	}

}
