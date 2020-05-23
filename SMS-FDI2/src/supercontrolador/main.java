package supercontrolador;

import GestionLaboratorio.presentacion_Laboratorio.CrearPedido;
import GestionMedicos.CapaPresentacion.InterfazVista;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		System.out.println("Menu de Subsistemas");
		System.out.println("1)GDEM");
		System.out.println("2)GDMe Implementado");
		System.out.println("3)GDI");
		System.out.println("4)GDProy Implementado");
		System.out.println("5)GDP");
		System.out.println("6)GDF Implementado");
		System.out.println("7)GDL Implementado");
		System.out.println("8)GDA Implementado");
		System.out.println("9)GDE Implementado");
		System.out.println("10)GDP");
		
		System.out.println("Opcion--->");
		try {
			opcion = Integer.parseInt(br.readLine());
		}catch (Exception e) {
			opcion = -1;
		}
		
		switch(opcion){
		case 1:
			
			break;
		case 2:
			InterfazVista medicos=new InterfazVista();
			medicos.mainMedicos();
			break;
		case 3:
			break;
		case 4:
			GDP_initGUI.mainProyectos(null);
			break;
		case 5:
			break;
		case 6:
			VistaFabrica vistaFabrica = new VistaFabrica();
			vistaFabrica.start();
			break;
		case 7:
			new Vista_Lab();
			break;
		case 8:
			break;
		case 9:	
				ControladorEnvio envio = new ControladorEnvio();
				envio.iniciar();
			break;
		case 10:
			break;
		default: System.out.println("no es una opcion");
			break;
		}
		
			
		}
	}*/
     public static void main(String [] args) {
    	 VentanaPrincipal vp= new VentanaPrincipal();
     }

}
