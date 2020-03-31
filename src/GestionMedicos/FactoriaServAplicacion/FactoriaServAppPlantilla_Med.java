package GestionMedicos.FactoriaServAplicacion;

public abstract  class FactoriaServAppPlantilla_Med {
	private static ServAppMed instancia= null;
	
	
	static public ServAppMed getInstancia(String estudio, String pastilla, String etapa){
		if(instancia ==null) {
			instancia=new ServAppMed(estudio, pastilla,  etapa);
		}
		return instancia;
		
	}
	
}
