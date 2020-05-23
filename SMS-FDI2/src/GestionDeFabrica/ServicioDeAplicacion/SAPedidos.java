package GestionDeFabrica.ServicioDeAplicacion;

import java.util.List;

import GestionDeFabrica.DAO.PedidosDAO;
//import GestionDeFabrica.DAOFactoria.FactoriaAbstractaDAO;
import GestionDeFabrica.DAOFactoria.FactoriaDAOPedidos;
import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public interface SAPedidos {

	public void setControlador(ControladorDeFabrica controlador);
	public void insertaPedido(PedidosTransfer pedido);
	public void eliminaPedido(PedidosTransfer pedido);
	public void modificaPedido(PedidosTransfer pedido);
	public PedidosTransfer buscaPedido(PedidosTransfer pedido);
	public PedidosDAO determinaFactoria(String type);
	public List<PedidosTransfer> solicitaPedidos(PedidosTransfer pedido);
}
