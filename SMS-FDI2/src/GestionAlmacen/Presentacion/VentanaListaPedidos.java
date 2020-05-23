package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import GestionAlmacen.Negocio.TPedido;

public class VentanaListaPedidos extends JFrame implements InterfazVista{
	
	JFrame _ventana;
	ArrayList<TPedido> _pedidos;
	
	public VentanaListaPedidos(Controlador c) {
		_pedidos = c.getPedidos();
		_ventana = new JFrame("LISTA DE PEDIDOS");
		_ventana.setSize(500, 500);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 50));
		
		_ventana.setTitle("Lista de Pedidos");
		_ventana.setLocationRelativeTo(null);
		
		JPanel panelAux = new JPanel();
		JList<String> lista = new JList<String>();
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		for (int i = 0; i < _pedidos.size(); ++i) {
			modelo.addElement("Pedido " + (i + 1));
			modelo.addElement(_pedidos.get(i).getIdPedido());
			modelo.addElement(_pedidos.get(i).getIdSolicitante());
			modelo.addElement(_pedidos.get(i).getNombreSolicitante());
			ArrayList<String>productos = _pedidos.get(i).getProductos();
			for(int j = 0; j < productos.size(); ++j) {
				modelo.addElement(productos.get(j));
			}
		}
		
		lista.setModel(modelo);
		panelAux.add(lista);
		
		_ventana.getContentPane().add(panelPrincipal);
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		_ventana.pack();
		_ventana.setLocationRelativeTo(null);
		_ventana.setVisible(true);
	}
}
