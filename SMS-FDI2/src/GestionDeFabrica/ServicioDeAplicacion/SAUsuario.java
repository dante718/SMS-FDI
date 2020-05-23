package GestionDeFabrica.ServicioDeAplicacion;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import GestionDeFabrica.DAO.UsuarioDAO;
import GestionDeFabrica.DAOFactoria.FactoriaDAOUsuario;
import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class SAUsuario implements SAUsuarios {

	private ControladorDeFabrica controlador;
	private FactoriaDAOUsuario factoriaDAOu;
	private UsuarioDAO usuarioDAO;
	
	@Override
	public void setControlador(ControladorDeFabrica controlador) {
		// TODO Auto-generated method stub
		
		this.controlador = controlador;
		
		this.factoriaDAOu = FactoriaDAOUsuario.dameInstancia();
		
	}
	@Override
	public void insertarUsuario(UsuarioTransfer usuario) {
		// TODO Auto-generated method stub
		
		try {
			this.factoriaDAOu.dameInstancia().generaObjetoUsuarioDAO().insertarUsuario(usuario);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void eliminaUsuario(UsuarioTransfer usuario) {
		// TODO Auto-generated method stub
		
		try {
			this.factoriaDAOu.dameInstancia().generaObjetoUsuarioDAO().eliminaUsuario(usuario);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void modificaUsuario(UsuarioTransfer usuario) {
		// TODO Auto-generated method stub
		
		try {
			this.factoriaDAOu.dameInstancia().generaObjetoUsuarioDAO().modificarUsuario(usuario);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public UsuarioTransfer buscaUsuario(UsuarioTransfer usuario) {
		// TODO Auto-generated method stub

		try {
			return this.factoriaDAOu.dameInstancia().generaObjetoUsuarioDAO().buscarUsuario(usuario);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public List<UsuarioTransfer> solicitaUsuarios() {
		// TODO Auto-generated method stub
		
		try {
			
			List<UsuarioTransfer> usuarios = new ArrayList<UsuarioTransfer>();
			usuarios = this.factoriaDAOu.dameInstancia().generaObjetoUsuarioDAO().buscaListaUsuarios();
			
			return usuarios;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
