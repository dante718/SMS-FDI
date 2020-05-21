package GestionDeFabrica.DAO;

public class PedidoAlmacenDAO extends PedidosAbstractoDAO {

	public PedidoAlmacenDAO() {
		
		this._file = "src/GestionDeFabrica/Almacen/json_almacen.json";
		this.type = "pedido_almacen";
	}
}
