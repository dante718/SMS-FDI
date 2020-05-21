package GestionDeFabrica.Vista;

import java.awt.EventQueue;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.Fabrica;

public class MainFabrica {

	public MainFabrica() {
		
	}
	
	public void initGUI() {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					Fabrica fac = new Fabrica();
					ControladorDeFabrica ctrl = new ControladorDeFabrica(fac);
					ctrl.initGUI();
					//new VistaFabrica(ctrl);
					//new VistaFabrica(ctrl);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});

	}
}