package GestionMedicos.GDM_Vista;

import javax.swing.JFrame;

import GestionMedicos.GDM.Controlador.ControladorMed;

public class InterfazVista extends JFrame{
		
	public InterfazVista() {

	}
	public  void mainMedicos() {
		// TODO Auto-generated method stub
		
		//JFrame m=new PantallaPrincipal("subsistema Medicos");
		
		PantallaPrincipal p;
		FabricaPantallasPrincipales FPrincipales=new FabricaPantallasPrincipales();
		p=FPrincipales.crearPantallaPrincipal("subsitema Medicos");
		
		
	}
	
}
