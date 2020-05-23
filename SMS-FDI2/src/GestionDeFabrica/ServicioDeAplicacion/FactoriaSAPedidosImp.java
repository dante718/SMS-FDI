package GestionDeFabrica.ServicioDeAplicacion;

public class FactoriaSAPedidosImp extends FactoriaSAPedidos {

	@Override
	public SAPedidos generaSAPedidos() {
		// TODO Auto-generated method stub
		return new SAPedido();
	}

}
