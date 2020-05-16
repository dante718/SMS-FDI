package GestionDeFabrica.DAO;

import org.json.JSONObject;

import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public interface UsuarioDAO {

	public boolean insertarUsuario();
	public boolean eliminaUsuario();
	public UsuarioTransfer buscarUsuario(String id);
	public boolean modificarUsuario(UsuarioTransfer usuario);
}
