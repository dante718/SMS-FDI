package GestionDeInformatica.GDI.Modelo;

import General.Factoria_Transfers;

public class FactoriaTransfer_Inf_imp extends Factoria_Transfers{

	@Override
	public TransferEmpleados crearTEmpleados(String dni, String nom,String ap1,String ap2,String prof,String est,String ro) {
		// TODO Auto-generated method stub
		return new TransferEmpleados(dni, nom, ap1, ap2, prof, est, ro);
	}

	@Override
	public TransferPlantilla crearTPlantilla(String ids, String names, String vers) {
		// TODO Auto-generated method stub
		return new TransferPlantilla(ids,  names,  vers);
	}

	@Override
	public TransferError crearTError(String err) {
		// TODO Auto-generated method stub
		return new TransferError(err);
	}

}
