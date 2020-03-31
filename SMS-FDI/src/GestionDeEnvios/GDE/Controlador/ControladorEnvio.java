package GestionDeEnvios.GDE.Controlador;

import java.awt.EventQueue;

import GestionDeEnvios.GDE.Vista.*;

public class ControladorEnvio {

	public ControladorEnvio(){
		
	}
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frmEnvios frame = new frmEnvios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}
