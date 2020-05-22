package GestionMedicos.GDM_Vista;

import javax.swing.JFrame;

import GestionMedicos.GDM.Controlador.ControladorMed;

public class InterfazVista extends JFrame{
	private ControladorMed ctrl;
	public InterfazVista() {
		this.ctrl=ControladorMed.getInstancia();
		MainMedicos();
	}
	private  void MainMedicos() {
	
		this.ctrl.CrearPantallaPrincipal();
	
	}
	
}
