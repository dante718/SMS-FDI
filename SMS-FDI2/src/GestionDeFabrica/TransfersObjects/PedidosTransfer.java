package GestionDeFabrica.TransfersObjects;

import GestionDeFabrica.Modelo.EstadoPedido;

public interface PedidosTransfer {

	public String getType();
	public void setType(String type);
	public String getIdPedido();
	public void setIdPedido(String id);
	public String getUsuario();
	public void setUsuario(String usuario);
	public String getNombre();
	public void setNombre(String nombre);
	public String getCompuesto();
	public void setCompuesto(String compuesto);
	public String getProducto();
	public void setProducto(String producto);
	public int getCantidad();
	public void setCantidad(int cantidad);
	public EstadoPedido getEstadoPedido();
	public void setEstadoPedido(String estado);
}
