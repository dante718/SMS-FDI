package GestionDeInformatica.GDI.Modelo;

public class TransferError {
	private String error;
	
			//constructor
			public TransferError(String err) {
				
				error = err;			
			}
			
			//Metodos - getters&setters
			
			
			public void setE(String err) {
				error = err;
			}
			public String getE(){
				return error;
			}
}
