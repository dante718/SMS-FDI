package GestionProyectos.GDP.Presentacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionDeAlmacen.GDA.Modelo.Producto;


public class VistaAnnadirProducto extends JFrame implements IVista{
	private static VistaAnnadirProducto instancia=null;
     private JPanel centerpanel, southpanel;
     private JButton añadir, cancelar;
     private JLabel id, cantidad, nombre, precio;
     private JTextField idtexto, cantexto, nametexto, preciotexto;
     private VistaAnnadirProducto() {	  
    	  initVista();
     }
     public static VistaAnnadirProducto getInstancia() {
    	 if(instancia==null) {
    		 instancia= new VistaAnnadirProducto();
    	 }
    	 return instancia;
     }
	public void initVista() {
		setSize(500,400);
		getContentPane().setLayout(new BorderLayout());
		centerpanel= new JPanel();
		centerpanel.setLayout(null);
		id= new JLabel("Id: ");
		id.setBounds(50, 10, 50, 30);
		idtexto= new JTextField();
		idtexto.setBounds(160, 10, 150, 30);
		centerpanel.add(id);
		centerpanel.add(idtexto);
		nombre= new JLabel("Nombre: ");
		nombre.setBounds(50, 90, 100, 30);
		nametexto= new JTextField();
		nametexto.setBounds(160, 90, 150, 30);
		centerpanel.add(nombre);
		centerpanel.add(nametexto);
		cantidad= new JLabel("Cantidad: ");
		cantidad.setBounds(50, 170, 100, 30);
		cantexto= new JTextField();
		cantexto.setBounds(160, 170, 150, 30);
		centerpanel.add(cantidad);
		centerpanel.add(cantexto);
		precio= new JLabel("Precio: ");
		precio.setBounds(50, 250, 100, 30);
		preciotexto= new JTextField();
		preciotexto.setBounds(160, 250, 150, 30);
		centerpanel.add(precio);
		centerpanel.add(preciotexto);
		getContentPane().add(centerpanel, BorderLayout.CENTER);
		
		southpanel= new JPanel();
		añadir= new JButton("Añadir");
		
		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!idtexto.getText().equals("") && !nametexto.getText().equals("") && !cantexto.getText().equals("") && !preciotexto.getText().equals("")) {
					try {
						Producto producto= new Producto(Integer.parseInt(idtexto.getText()),nametexto.getText(),Integer.parseInt(cantexto.getText()), Double.parseDouble(preciotexto.getText()));
						if(Controlador.getInstancia().Addproducto(producto)) {
							idtexto.setText("");
							nametexto.setText("");
							cantexto.setText("");
							preciotexto.setText("");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Ya existe un producto con ese id en este pedido. ");
						}
					}catch(NumberFormatException e1) {
						throw new IllegalArgumentException("El id debe ser un numero entero, al igual que la cantidad. Y el precio un double. ");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar los 4 campos, para añadir el producto");
				}
				
			}
			
		});
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		southpanel.add(añadir);
		southpanel.add(cancelar);
		
		getContentPane().add(southpanel, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	@Override
	public void Visibilizar() {
		setVisible(true);	
	}
	   
}
