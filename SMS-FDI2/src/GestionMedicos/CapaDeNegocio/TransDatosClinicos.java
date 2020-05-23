package GestionMedicos.CapaDeNegocio;

public class TransDatosClinicos {
	private String Id;
	private  String Sexo;
	private int Edad, Cantidad;
	private String Fecha;
	
	public TransDatosClinicos(String id,String sexo,int edad,String fecha,int cantidad) {
		this.Id=id;
		this.Sexo=sexo;
		this.Edad=edad;
		this.Fecha=fecha;
		this.Cantidad=cantidad;
		
		
	}
	public int GetCantidad() {
		return this.Cantidad;
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
public void setCantidad(int c){
	this.Cantidad=c;
}
@Override
public String toString() {
	return this.Id+" "+this.Sexo+" "+this.Edad+" "+this.Fecha+" "+this.Cantidad;
}

}
