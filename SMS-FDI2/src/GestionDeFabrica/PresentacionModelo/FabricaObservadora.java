package GestionDeFabrica.PresentacionModelo;

import java.util.List;

import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public interface FabricaObservadora {

	//void agregaPedidoLaboratorio();
	//void modificaPedidoLaboratorio(Pedidos ped);
	//void rechazaPedidoLaboratorio();
	//void agregaPedidoAlmacen();
	//void modificaPedidoAlmacen();
	//void cancelaPedidoAlmacen();
	//void agregaInventario();
	//void modificaInventario();
	//void eliminaInventario();
	//void agregaProyecto();
	//void modificaProyecto();
	//void eliminaProyecto();
	//void error();
	
	void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e);
	void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e);
	void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e);
	void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos);
	void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos);
}
