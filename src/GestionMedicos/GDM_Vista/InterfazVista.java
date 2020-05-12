package GestionMedicos.GDM_Vista;

import javax.swing.JFrame;

import GestionMedicos.GDM.Controlador.ControladorMed;

public class InterfazVista extends JFrame{
	private ControladorMed ctrl;
	public InterfazVista(ControladorMed c) {
		this.ctrl=c;
		MainMedicos();
	}
	private  void MainMedicos() {
	
		this.ctrl.CrearPantallaPrincipal();
	
	}
	
}
