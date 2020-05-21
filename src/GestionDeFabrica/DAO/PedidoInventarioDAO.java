package GestionDeFabrica.DAO;

public class PedidoInventarioDAO extends PedidosAbstractoDAO {

	public PedidoInventarioDAO() {
		
		this._file = "src/GestionDeFabrica/Almacen/json_inventario.json";
		this.type = "pedido_inventario";
	}
}
