package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import GestionAlmacen.Negocio.TProducto;

public class VentanaInventario extends JFrame implements InterfazVista{
	
	JFrame ventana;
	JLabel mensaje = null;
	ArrayList<TProducto> productos;
	
	public VentanaInventario(Controlador c){
		productos = c.getProductos();
		ventana = new JFrame("INVENTARIO");
		ventana.setSize(500, 500);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 50));
		
		ventana.setTitle("Inventario");
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		String[] columnNames = { "ID", "Nombre", "Descripcion", "Cantidad" };
		Object data[][];
		data = new Object[productos.size()][4];
	
		
		for(int i = 0; i < productos.size(); ++i) {
			data[i][0] = productos.get(i).getIdProducto();
			data[i][1] = productos.get(i).getNombreProducto();
			data[i][2] = productos.get(i).getDescripcionProducto();
			data[i][3] = productos.get(i).getCantidadProducto();
		}
		JTable table = new JTable(data, columnNames);
		
		JPanel panelAux = new JPanel();
		panelAux.add(table);
		
		panelPrincipal.add(panelAux);
		
		ventana.getContentPane().add(panelPrincipal);
	}
	
	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
