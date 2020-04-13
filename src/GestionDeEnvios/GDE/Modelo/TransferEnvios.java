package GestionDeEnvios.GDE.Modelo;

import java.util.ArrayList;
import java.util.List;

public class TransferEnvios {
	
	static int numeroPedido=100;
	
	protected int ID_Envio;  
    protected String  Destinatario;  
    protected StatusEnvio Estado; 
    protected int ID_pedido;
    protected List<TransferEnvios> _Envio;    
    
    public TransferEnvios(){
    	_Envio = new ArrayList<>();
    	ID_pedido = numeroPedido;
    	numeroPedido+=2;
    
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
	public List<TransferEnvios> get_Envio() {
		return _Envio;
	}


	public void set_Envio(List<TransferEnvios> _Envio) {
		this._Envio = _Envio;
	}


}



