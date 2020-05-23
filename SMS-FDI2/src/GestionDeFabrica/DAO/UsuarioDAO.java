package GestionDeFabrica.DAO;

import java.io.FileNotFoundException;
import java.util.List;

import org.json.JSONObject;

import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public interface UsuarioDAO {

	public boolean insertarUsuario(UsuarioTransfer usuario) throws FileNotFoundException;
	public boolean eliminaUsuario(UsuarioTransfer usuario) throws FileNotFoundException;
	public UsuarioTransfer buscarUsuario(UsuarioTransfer usuario) throws FileNotFoundException;
	public boolean modificarUsuario(UsuarioTransfer usuario) throws FileNotFoundException;
	public List<UsuarioTransfer> buscaListaUsuarios() throws FileNotFoundException;
}
