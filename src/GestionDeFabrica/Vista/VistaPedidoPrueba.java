package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.Modelo.Pedidos;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoPrueba extends VistaPedidosAbstracto {

	public VistaPedidoPrueba(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Prueba";
		this.textoBotonAceptar = "heeey aceptame";
		this.textoBotonEliminar = "hey eliminame";
		
		tabla = new TablaPedidosLaboratorio(this.controlador);
		this.initGUI();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void accionAceptar() {
		// TODO Auto-generated method stub

		JOptionPane.showMessageDialog(this, "prueba");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub

		JOptionPane.showMessageDialog(this, "prueba2222");
	}


	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
	}

	
}
