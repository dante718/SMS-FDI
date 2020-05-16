package GestionDeFabrica.TransfersObjects;

import org.json.JSONObject;

public interface UsuarioTransfer {

	public String getType();
	public void setType(String type);
	public String getIdUsuario();
	public void setIdUsuario(String usuario);
	public String getNombreUsuario();
	public void setNombreUsuario(String usuario);
	public int getTelefonoUsuario();
	public void setTelefonoPersona(int telefono);
}
