package GestionDeFabrica.DAO;

import java.io.FileNotFoundException;
import java.util.List;

import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public interface PedidosDAO {

	public boolean insertarPedido(PedidosTransfer nuevoPedido) throws FileNotFoundException;
	public boolean eliminaPedido(PedidosTransfer pedido) throws FileNotFoundException;
	public boolean modificaPedido(PedidosTransfer pedido) throws FileNotFoundException;
	public PedidosTransfer buscaPedido(String id) throws FileNotFoundException;
	public List<PedidosTransfer> buscaListaPedidos();
	
}
