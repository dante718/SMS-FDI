package GestionDeFabrica.ServicioDeAplicacion;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import GestionDeFabrica.DAO.PedidosDAO;
//import GestionDeFabrica.DAOFactoria.FactoriaAbstractaDAO;
import GestionDeFabrica.DAOFactoria.FactoriaDAOPedidos;
import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class SAPedido implements SAPedidos {

	private ControladorDeFabrica controlador;
	private FactoriaDAOPedidos factoriaDAO;
	private PedidosDAO pedidoDAO;
	
	@Override
	public void setControlador(ControladorDeFabrica controlador) {
		
		this.controlador = controlador;
		
		this.factoriaDAO = FactoriaDAOPedidos.dameInstancia();
	}
	
	
	@Override
	public void insertaPedido(PedidosTransfer pedido) {
		// TODO Auto-generated method stub
		
		try {
			
			determinaFactoria(pedido.getType()).insertarPedido(pedido);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminaPedido(PedidosTransfer pedido) {
		// TODO Auto-generated method stub
		
		try {
			
			determinaFactoria(pedido.getType()).eliminaPedido(pedido);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificaPedido(PedidosTransfer pedido) {
		// TODO Auto-generated method stub
		try {
			
			determinaFactoria(pedido.getType()).modificaPedido(pedido);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PedidosTransfer buscaPedido(PedidosTransfer pedido) {
		// TODO Auto-generated method stub
		
		try {
			
			return determinaFactoria(pedido.getType()).buscaPedido(pedido.getIdPedido());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public PedidosDAO determinaFactoria(String type) {
		// TODO Auto-generated method stub
		
		if (type.equals("pedido_proyecto")) {
			
			return this.factoriaDAO.dameInstancia().generaPedidoProyectoDAO();
		}
		else if (type.equals("pedido_laboratorio")) {
			
			return this.factoriaDAO.dameInstancia().generaPedidoLaboratorioDAO();
		}
		else if (type.equals("pedido_almacen")) {
			
			return this.factoriaDAO.dameInstancia().generaPedidoAlmacenDAO();
		}
		else if (type.equals("pedido_inventario")) {
			
			return this.factoriaDAO.dameInstancia().generaPedidoInventarioDAO();
		}
		else if (type.equals("pedido_envio")) {
			
			return this.factoriaDAO.dameInstancia().generaPedidoEnvioDAO();
		}
		return null;
	}


	@Override
	public List<PedidosTransfer> solicitaPedidos(PedidosTransfer pedido) {
		// TODO Auto-generated method stub
		
		try {
			
			List<PedidosTransfer> pedidos = new ArrayList<PedidosTransfer>();
			
			pedidos = determinaFactoria(pedido.getType()).buscaListaPedidos();
			
			return pedidos;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
