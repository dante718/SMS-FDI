package General;

import GestionDeInformatica.GDI.Modelo.TransferEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferError;
import GestionDeInformatica.GDI.Modelo.TransferPlantilla;
import GestionDeInformatica.GDI.Modelo.FactoriaTransfer_Inf_imp;

//Autor Michal Fital
public abstract class Factoria_Transfers {

	private static Factoria_Transfers instancia_Inf=null;
	static public Factoria_Transfers getInstanicaInf() {
		
			if (instancia_Inf == null) instancia_Inf= new FactoriaTransfer_Inf_imp();
		
			return instancia_Inf;
		}
		public abstract TransferEmpleados crearTEmpleados(String dni, String nom,String ap1,String ap2,String prof,String est,String ro);
		public abstract TransferPlantilla crearTPlantilla(String ids, String names, String vers);
		public abstract TransferError crearTError(String err);
	
	
}
