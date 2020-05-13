package GestionDeFabrica.Modelo;

public interface FabricaObservadora {

	void agregaPedidoLaboratorio();
	void modificaPedidoLaboratorio(Pedidos ped);
	void rechazaPedidoLaboratorio();
	void agregaPedidoAlmacen();
	void modificaPedidoAlmacen();
	void cancelaPedidoAlmacen();
	void agregaInventario();
	void modificaInventario();
	void eliminaInventario();
	void agregaProyecto();
	void modificaProyecto();
	void eliminaProyecto();
	void error();
}
