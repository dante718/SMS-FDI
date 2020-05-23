package GestionDeFabrica.ServicioDeAplicacion;

import java.util.List;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.DAO.PedidosDAO;
import GestionDeFabrica.Factoria.FactoriaAbstractaDAO;
import GestionDeFabrica.Factoria.FactoriaDAOPedidos;
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
