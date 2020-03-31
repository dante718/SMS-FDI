package GestionMedicos.FactoriaServAplicacion;

public class TransPlantilla {
	private String Estudio;
	private String Farmaco;
	private String Etapa;
	
	public TransPlantilla(String estudio, String farmaco,String etapa){
		this.Estudio=estudio;
		this.Etapa=etapa;
		this.Farmaco=farmaco;
		
		
	}//completar
	public boolean equals(TransPlantilla p) {
		
		if(p.getEstudio().equals(this.getEstudio())){
			/*&&(this.Farmaco.equals(p.getFarmaco()))
			&&(this.Etapa.equals(p.getEtapa()))){
			*/return true;
	
		}
			
		
				
		return false;
	}
	public String getEstudio() {
		return this.Estudio;
	}
	public String getFarmaco() {
		return this.Farmaco;
	}
	public String getEtapa() {
		return this.Etapa;
	}
	
}
