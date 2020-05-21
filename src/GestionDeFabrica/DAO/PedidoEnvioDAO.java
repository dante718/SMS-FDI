package GestionDeFabrica.DAO;

public class PedidoEnvioDAO extends PedidosAbstractoDAO {

	public PedidoEnvioDAO() {
		
		this._file = "src/GestionDeFabrica/Almacen/json_envio.json";
		this.type = "pedido_envio";
	}
}
