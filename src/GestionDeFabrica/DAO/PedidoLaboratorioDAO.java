package GestionDeFabrica.DAO;

public class PedidoLaboratorioDAO extends PedidosAbstractoDAO {

	public PedidoLaboratorioDAO() {
		
		this._file = "src/GestionDeFabrica/Almacen/json_laboratorio.json";
		this.type = "pedido_laboratorio";
	}
}
