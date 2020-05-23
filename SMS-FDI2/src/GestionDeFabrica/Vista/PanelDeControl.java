package GestionDeFabrica.Vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.Fabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;

public class PanelDeControl extends JPanel {
	
	private JToolBar toolBar;
	
	public PanelDeControl(ControladorDeFabrica ctrl) {
		
		this.setLayout(new BorderLayout());
		
		this.toolBar = new JToolBar();
		this.add(this.toolBar, BorderLayout.PAGE_START);
		
	}
	
	
}
