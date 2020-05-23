package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import GestionAlmacen.Negocio.TProveedor;

public class VentanaProveedores extends JFrame implements InterfazVista{
	
	ArrayList<TProveedor> _proveedores;
	JFrame _ventana;
	
	public VentanaProveedores(Controlador c) {
		_proveedores = c.getProveedores();
		_ventana = new JFrame();
		_ventana.setSize(500, 500);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 50));
		
		_ventana.setTitle("Lista de Proveedores");
		_ventana.setLocationRelativeTo(null);
		
		/*String[] columnNames = {"Nombre", "Empresa", "Gmail"};
		Object data[][];
		data = new Object[_proveedores.size()][3];
		
		for(int i = 0; i < _proveedores.size(); ++i) {
			data[i][0] = _proveedores.get(i).getNombreProveedor();
			data[i][1] = _proveedores.get(i).getEmpresaProveedor();
			data[i][2] = _proveedores.get(i).getGmailProveedor();
		}
		
		JTable table = new JTable(data, columnNames);*/
		
		JPanel panelAux = new JPanel();
		JList<String> lista = new JList<String>();
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		for(int i = 0; i < _proveedores.size(); ++i) {
			modelo.addElement("Proveedor " + (i + 1));
			modelo.addElement(_proveedores.get(i).getNombreProveedor());
			modelo.addElement(_proveedores.get(i).getEmpresaProveedor());
			modelo.addElement(_proveedores.get(i).getGmailProveedor());
			modelo.addElement("\n");
		}
		//panelAux.add(table);
		lista.setModel(modelo);
		panelAux.add(lista);
		
		panelPrincipal.add(panelAux);
		
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
