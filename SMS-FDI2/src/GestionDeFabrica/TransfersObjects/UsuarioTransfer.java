package GestionDeFabrica.TransfersObjects;

import org.json.JSONObject;

public interface UsuarioTransfer {

	public String getDNI();
	public void setDNI(String dni);
	public String getNombre();
	public void setNombre(String nombre);
	public String getApellido1();
	public void setApellido1(String apellido1);
	public String getApellido2();
	public void setApellido2(String apellido2);
	public boolean getDisponibilidad();
	public void setDisponibilidad(boolean disp);
	public String getProyecto();
	public void setProyecto(String proyecto);
	public String getTelefono();
	public void setTelefono(String tel);
}
