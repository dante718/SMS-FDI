package GestionDeInformatica.GDI.Vista;

import java.awt.EventQueue;

public class mainInformatico {
	public mainInformatico(){
	}
	
public static void iniciar() {
	
	
	

	
	EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
			try {
				GDI_VistaPrincipal frame = new GDI_VistaPrincipal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	
	
	
}
}
