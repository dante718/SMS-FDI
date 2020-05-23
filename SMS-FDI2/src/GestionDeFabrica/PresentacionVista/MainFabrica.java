package GestionDeFabrica.PresentacionVista;

import java.awt.EventQueue;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.Fabrica;

public class MainFabrica {

	public MainFabrica() {
		initGUI();
	}
	
	public void initGUI() {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					Fabrica fac = new Fabrica();
					ControladorDeFabrica ctrl = new ControladorDeFabrica(fac);
					//ctrl.iniciaGUI();
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