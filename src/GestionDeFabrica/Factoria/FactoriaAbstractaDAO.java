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
	
	public abstract UsuarioDAO getUsuarioDAO();
	//public abstract boolean setUsuario(UsuarioDAO usuario);
	//public abstract void crearNuevoUsuario(UsuarioDAO nuevoUsuario);
	public abstract PedidosDAO getPedidoDAO();
	//public abstract boolean setPedido(PedidosDAO pedido);
	//public abstract void crearNuevoPedido(PedidosDAO nuevoPedido);
	
	public static FactoriaAbstractaDAO getFactoriaAbstractaDAO(int numeroFactoria) {
		
		switch (numeroFactoria) {
		//TODO
			case PROYECTO :
				return new ProyectoDAOFactory();
			default :
				return null;
		}
	}
}
