package GestionDeEnvios.GDE.Modelo;



public class Envios {
	
	protected int ID_Envio;  
    protected String  Destinatario;  
    protected StatusEnvio Estado; 
    protected int pedido;
    
    
    public Envios(int ID_Envio, String Destinatario, StatusEnvio Estado){
    	
    	this.ID_Envio = ID_Envio;
    	this.Destinatario = Destinatario;
    	this.Estado = Estado;
    
    }
    
    
	public int getID() {
		return ID_Envio;
	}
	public void setID(int iD) {
		ID_Envio = iD;
	}
	public String getPara() {
		return Destinatario;
	}
	public void setPara(String Destinatario) {
		this.Destinatario = Destinatario;
	}
	public StatusEnvio getEstado() {
		return Estado;
	}
	public void setEstado(StatusEnvio estado) {
		Estado = estado;
	}

}
