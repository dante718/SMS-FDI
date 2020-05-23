package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionAlmacen.Negocio.TProveedor;

public class VentanaAddProveedor extends JFrame implements InterfazVista{

	JFrame _ventana;
	ArrayList<TProveedor> _proveedores;
	
	public VentanaAddProveedor(Controlador c) {
		_proveedores = c.getProveedores();
		_ventana = new JFrame("ADDPROVEEDOR");
		_ventana.setSize(500, 500);
		
		_ventana.setTitle("Añadir Proveedor");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 50));
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new BorderLayout(50, 50));
		
		JLabel nombre = new JLabel("Nombre");
		JTextField tNombre = new JTextField(5);
		
		JLabel empresa = new JLabel("Empresa");
		JTextField tEmpresa = new JTextField(5);
		
		JLabel email = new JLabel("Email");
		JTextField tEmail = new JTextField(5);
		
		JPanel f = new JPanel();
		f.add(nombre);
		f.add(tNombre);
		f.add(empresa);
		f.add(tEmpresa);
		f.add(email);
		f.add(tEmail);
		
		formulario.add(f);
		panelPrincipal.add(formulario, BorderLayout.CENTER);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BorderLayout(50, 50));
		
		JButton add = new JButton("AÑADIR");
		
		TProveedor proveedor = new TProveedor();
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				proveedor.setNombreProveedor(tNombre.getText());
				proveedor.setEmpresaProveedor(tEmpresa.getText());
				proveedor.setGmailProveedor(tEmail.getText());
				
				_proveedores = c.addProveedor(proveedor);
				c.escribirBDProveedores(_proveedores);
			}
		});
		
		JPanel botones = new JPanel();
		botones.add(add);
		panelBoton.add(botones);
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		
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