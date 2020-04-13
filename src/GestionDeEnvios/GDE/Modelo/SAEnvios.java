package GestionDeEnvios.GDE.Modelo;

public class SAEnvios {
	
	protected  TransferEnvios envio;
	
	public SAEnvios(){
		crearEnvio();
	}
	
	public void crearEnvio() {
		envio = FactoriaEnvios.getInstancia().crearDAOEnvios().crearEnvio();	
		}
	public void eliminarEnvio() {
		
	}
	public void modificarEnvio() {
		
	}
	public void listarEnvio() {
		
	}
	public void statusEnvio() {
		
	}
	public void disponibilidadRepartidor() {
		
	}
	public void aceptarPedido() {
		
	}
	public void rechazarPedido() {
		
	}
}
