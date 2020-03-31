package GestionDeAlmacen.GDA.Vista;

import GestionDeAlmacen.GDA.Controlador.Controlador;

public interface InterfazVista {
	
	static final String I = "INVENTARIO";
	static final String AP = "AÑADIR PRODUCTO";
	static final String LP = "LISTA DE PEDIDOS";
	static final String P = "REALIZAR PEDIDO";
	
	void setControlador(Controlador c);
	void arranca();
	void ventanaInventario();
	void ventanaAddProducto();
	void ventanaListaPedidos();

}
