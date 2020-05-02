package GestionProyectos.GDP.Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionProyectos.GDP.Controlador.Controlador;

public class VistaFormularioMedicamentos extends JFrame{
      private Controlador controlador;
      private JPanel panel = new JPanel();
      private JButton addproducto, enviarpedido, cancelar;
      private JLabel idpedido;
      private JTextField fieldpedido;
      public VistaFormularioMedicamentos(Controlador controlador) {
    	  this.controlador= controlador;
    	  initVista();
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
		panel.add(addproducto);
		enviarpedido= new JButton("Enviar Pedido");
		enviarpedido.setBounds(60, 160, 120, 40);
		panel.add(enviarpedido);
		cancelar= new JButton("Cancelar");
		cancelar.setBounds(270, 160, 120, 40);
		panel.add(cancelar);
		getContentPane().add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
