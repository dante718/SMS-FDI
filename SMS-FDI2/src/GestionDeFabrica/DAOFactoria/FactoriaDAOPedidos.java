package GestionDeFabrica.DAOFactoria;

import GestionDeFabrica.DAO.PedidosDAO;

public abstract class FactoriaDAOPedidos {

	private static FactoriaDAOPedidos factoria;
	
	public static FactoriaDAOPedidos dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaDAOPedidosImp();
		}
		
		return factoria;
	}
	
	public abstract PedidosDAO generaPedidoProyectoDAO();
	public abstract PedidosDAO generaPedidoLaboratorioDAO();
	public abstract PedidosDAO generaPedidoAlmacenDAO();
	public abstract PedidosDAO generaPedidoInventarioDAO();
	public abstract PedidosDAO generaPedidoEnvioDAO();
}
