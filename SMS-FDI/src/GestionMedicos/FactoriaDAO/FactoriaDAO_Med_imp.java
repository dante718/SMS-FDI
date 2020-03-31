package GestionMedicos.FactoriaDAO;

public class FactoriaDAO_Med_imp extends FactoriaDAO_Med {
	
	
	public DAODatosPlantilla crearDAOPlantilla() {
		return new DAODatosPlantilla();
		
	}
	public DAODatosClinicos  CrearTablaDatosClinicos() {
		return new DAODatosClinicos();
	}
	
}

