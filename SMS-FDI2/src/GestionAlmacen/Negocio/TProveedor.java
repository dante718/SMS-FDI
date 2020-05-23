package GestionAlmacen.Negocio;

public class TProveedor {
	
	private String _nombre, _empresa, _gmail;
	
	//Nombre del proveedor
	public String getNombreProveedor() { return _nombre; }
	public void setNombreProveedor(String nombre) { _nombre = nombre; }
	
	//Empresa
	public String getEmpresaProveedor() { return _empresa; }
	public void setEmpresaProveedor(String empresa) { _empresa = empresa; }
	
	//Gmail
	public String getGmailProveedor() { return _gmail; }
	public void setGmailProveedor(String gmail) { _gmail = gmail; }
}
