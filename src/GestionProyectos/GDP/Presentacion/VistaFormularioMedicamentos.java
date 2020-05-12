package GestionProyectos.GDP.Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionDeAlmacen.GDA.Modelo.Pedido;


public class VistaFormularioMedicamentos extends JFrame{
	  private static VistaFormularioMedicamentos instancia=null;
      private JPanel panel = new JPanel();
      private JButton addproducto, enviarpedido, cancelar;
      private JLabel idpedido;
      private JTextField fieldpedido;
      private VistaFormularioMedicamentos() {    	  
    	  initVista();
      }
      public static VistaFormularioMedicamentos getInstancia() {
  		if(instancia==null) {
  			instancia= new VistaFormularioMedicamentos();
  		}
  		return instancia;
  	}
      
	  private void initVista() {
		setSize(500, 250);
		panel.setLayout(null);
		idpedido= new JLabel("Introduce id de pedido: ");
		idpedido.setBounds(50,50, 150, 30);
		panel.add(idpedido);
		fieldpedido= new JTextField();
		fieldpedido.setBounds(210, 50, 150, 30);
		panel.add(fieldpedido);
		addproducto= new JButton("Añadir Producto");
		addproducto.setBounds(210, 100, 150, 40);
		addproducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaAñadirProducto.getInstancia().setVisible(true);	
			}
			
		});
		
		panel.add(addproducto);
		enviarpedido= new JButton("Enviar Pedido");
		enviarpedido.setBounds(60, 160, 120, 40);
		enviarpedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!fieldpedido.getText().equals("")) {
					if(Controlador.getInstancia().getTamProductos()==0) {
						JOptionPane.showMessageDialog(null, "El pedido debe tener al menos un producto añadido. ");
					}
					else{
						try {
							Pedido pedido= new Pedido(Integer.parseInt(fieldpedido.getText()), Controlador.getInstancia().getProductos());
							Controlador.getInstancia().reinicarpedido();
							JOptionPane.showMessageDialog(null, "Pedido realizado con éxito. ");
						}catch(NumberFormatException e1) {
							throw new IllegalArgumentException("El id ha de ser un valor entero. ");
						}
						dispose();
					}					
				}
				else {
					JOptionPane.showMessageDialog(null, "Debes añadir un id al pedido para poder solicitar la partida de medicamentos. ");
				}
			}
			
		});
		panel.add(enviarpedido);
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
			
			
		});
		cancelar.setBounds(270, 160, 120, 40);
		panel.add(cancelar);
		getContentPane().add(panel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
