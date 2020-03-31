package GestionMedicos.FactoriaServAplicacion;

public class TransDatosClinicos {
	private String Id;
	private  String Sexo;
	private int Edad;
	private int Cantidad;
	private String Fecha;
	public TransDatosClinicos(String id,String sexo,int edad,int cantidad,String fecha) {
		this.Id=id;
		this.Sexo=sexo;
		this.Edad=edad;
		this.Cantidad=cantidad;
		this.Fecha=fecha;
		
		
	}
public String getId() {
	return this.Id;	
}
public String getFecha() {
	return this.Fecha;	
}
public String getSexo() {
	return this.Sexo;	
}
public int getEdad() {
	return this.Edad;	
}
public int getCantidad() {
	return this.Cantidad;	
}
public void setCantidad(int c){
	this.Cantidad=c;
}
public void setEdad(int c){
	this.Edad=c;
}
public void setFecha(String s){
	this.Fecha=s;
}
public void setId(String s){
	this.Id=s;
}
public void setSexo(String s){
	this.Sexo=s;
}

}
