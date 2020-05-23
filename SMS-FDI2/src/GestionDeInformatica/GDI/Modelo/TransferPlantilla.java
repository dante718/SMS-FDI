package GestionDeInformatica.GDI.Modelo;

import java.util.ArrayList;

public class TransferPlantilla {

	
	//Propiedades
		private String identificadores ;
		private String nombres ;
		private String etapas;
		
		//constructor
		public TransferPlantilla(String ids, String names, String vers) {
			
			identificadores = ids;
			nombres = names;
			etapas = vers;
			
		}
		
		
			//Metodos - getters&setters
			
			
			public void setID(String ids) {
				identificadores = ids;
			}
			public String getID(){
				return identificadores;
			}
			
			public void setNOM(String names) {
				nombres = names;
			}
			public String getNOM(){
				return nombres;
			}
			
			public void setETA(String vers) {
				etapas = vers;
			}
			public String getETA(){
				return etapas;
			}
		
		
}
