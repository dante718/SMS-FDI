package GestionProyectos.GDP.Presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import GestionDeFabrica.TransfersObjects.PedidoTransferProyecto;


public class VistaAnnadirPedido extends JFrame implements IVista{
	 private static VistaAnnadirPedido instancia=null;
     private JPanel centerpanel, southpanel;
     private JButton añadir, cancelar;
     private JLabel id, cantidad, nombre, producto;
     private JTextField idtexto, cantexto, nametexto, productotexto;
     private VistaAnnadirPedido() {	  
    	  initVista();
     }
     public static VistaAnnadirPedido getInstancia() {
    	 if(instancia==null) {
    		 instancia= new VistaAnnadirPedido();
    	 }
    	 return instancia;
     }
	public void initVista() {
		setTitle("Añadir Pedido");
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
		producto= new JLabel("Producto: ");
		producto.setBounds(50, 250, 100, 30);
		productotexto= new JTextField();
		productotexto.setBounds(160, 250, 150, 30);
		centerpanel.add(producto);
		centerpanel.add(productotexto);
		getContentPane().add(centerpanel, BorderLayout.CENTER);	
		southpanel= new JPanel();
		añadir= new JButton("Enviar");	
		añadir.setForeground(Color.WHITE);
		añadir.setBackground(Color.GREEN);
		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!idtexto.getText().equals("") && !nametexto.getText().equals("") && !cantexto.getText().equals("") && !productotexto.getText().equals("")) {
					try {
						PedidoTransferProyecto ped= new PedidoTransferProyecto();
						ped.setType("pedido_proyecto");
						ped.setEstadoPedido("ACCEPTADO");
						ped.setCantidad(Integer.parseInt(cantexto.getText()));
						ped.setIdPedido(idtexto.getText());
						ped.setNombre(nametexto.getText());
						ped.setProducto(producto.getText());
						Controlador.getInstancia().EnviarPedido(ped);
						idtexto.setText("");
						nametexto.setText("");
						cantexto.setText("");
						productotexto.setText("");
						JOptionPane.showMessageDialog(null, "Pedido y facturas, enviados correctamente a sus correspondientes subsistemas. ");
						dispose();
                        
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
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.RED);
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
