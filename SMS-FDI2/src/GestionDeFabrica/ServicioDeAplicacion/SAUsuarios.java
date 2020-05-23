package GestionDeFabrica.ServicioDeAplicacion;

import java.util.List;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public interface SAUsuarios {

	public void setControlador(ControladorDeFabrica controlador);
	public void insertarUsuario(UsuarioTransfer usuario);
	public void eliminaUsuario(UsuarioTransfer usuario);
	public void modificaUsuario(UsuarioTransfer usuario);
	public UsuarioTransfer buscaUsuario(UsuarioTransfer usuario);
	public List<UsuarioTransfer> solicitaUsuarios();
}
