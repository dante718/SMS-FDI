package GestionDeEnvios.GDE.Modelo;

public class Envios_Externos extends Envios {

	
	protected int factura;
	
	public Envios_Externos(int ID_Envio, String Destinatario, StatusEnvio Estado, int factura) {
				
		this.factura = factura;
	
		// TODO Auto-generated constructor stub
	}

	
	
	void GenerarFactura() {
		
	}
	
	
		
}
