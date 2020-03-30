package GDA.Vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GDA.Controlador.Controlador;

public class VentanaInventario extends JFrame implements InterfazVista{
	
	static final String MENSAJE = "Te encuentras en el inventario";
	
	private JLabel _mensaje;
	
	public VentanaInventario(){
		super("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50,50));
		
		_mensaje = new JLabel(MENSAJE);
		JPanel panelAux = new JPanel();
		panelAux.add(_mensaje);
		panelPrincipal.add(panelAux, BorderLayout.NORTH);
	}
	
	@Override
	public void setControlador(Controlador c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void ventanaInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaAddProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaListaPedidos() {
		// TODO Auto-generated method stub
		
	}

}
