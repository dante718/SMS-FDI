package GestionDeFabrica.Factoria;

import org.json.JSONObject;

import GestionDeFabrica.DAO.PedidosDAO;
import GestionDeFabrica.DAO.UsuarioDAO;

public abstract class FactoriaAbstractaDAO {

	public static final int PROYECTO = 1;
	public static final int LABORATORIO = 2;
	public static final int ALMACEN = 3;
	public static final int INVENTARIO = 4;
	public static final int ENVIO = 5;
	
	public abstract UsuarioDAO generaUsuarioDAO();
	//public abstract boolean setUsuario(UsuarioDAO usuario);
	//public abstract void crearNuevoUsuario(UsuarioDAO nuevoUsuario);
	public abstract PedidosDAO generaPedidoDAO();
	//public abstract boolean setPedido(PedidosDAO pedido);
	//public abstract void crearNuevoPedido(PedidosDAO nuevoPedido);
	
	public FactoriaAbstractaDAO getFactoriaAbstractaDAO(int numeroFactoria) {
		
		switch (numeroFactoria) {
		//TODO
			case PROYECTO :
				return new ProyectoDAOFactory();
			case LABORATORIO :
				return new LaboratorioDAOFactory();
			case ALMACEN :
				return new AlmacenDAOFactory();
			case INVENTARIO :
				return new InventarioDAOFactory();
			case ENVIO :
				return new EnvioDAOFactory();
			default :
				return null;
		}
	}
}
