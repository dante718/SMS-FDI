package GestionMedicos.CapaPresentacion;

import javax.swing.JFrame;

public class InterfazVista extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControladorMed ctrl;
	public InterfazVista() {
		this.ctrl=ControladorMed.getInstancia();
		MainMedicos();
	}
	private  void MainMedicos() {
	
		this.ctrl.CrearPantallaPrincipal();
	
	}
	
}
