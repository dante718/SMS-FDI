package GestionDeFabrica.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import GestionDeFabrica.TransfersObjects.TransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class UsuarioDAOImp implements UsuarioDAO {

	private String _file;
	
	public UsuarioDAOImp() {
		
		this._file = "src/GestionDeFabrica/Almacen/json_usuario.json";
	}

	@Override
	public boolean insertarUsuario(UsuarioTransfer usuario) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String usuarioID = ja.getJSONObject(i).getString("dni");
				
				if (usuarioID.equals(usuario.getDNI()) && encontrado != true) {
					
					encontrado = true;
					this.modificarUsuario(usuario);
				}
				else if (usuarioID.equals("null") && encontrado != true) {
					
					ja.getJSONObject(i).put("dni", usuario.getDNI());
					ja.getJSONObject(i).put("nombre", usuario.getNombre());
					ja.getJSONObject(i).put("apellido1", usuario.getApellido1());
					ja.getJSONObject(i).put("apellido2", usuario.getApellido2());
					ja.getJSONObject(i).put("disponibilidad", usuario.getDisponibilidad());
					ja.getJSONObject(i).put("telefono", usuario.getTelefono());
					ja.getJSONObject(i).put("proyecto", usuario.getProyecto());
					
					encontrado = true;
				}
			}
			
			jo.put("array", ja);

			OutputStream out = _outFile == null ? System.out : new FileOutputStream((_outFile));
			PrintStream p = new PrintStream(out);
			
			p.print(jo);
		}
		return encontrado;
	}

	@Override
	public boolean eliminaUsuario(UsuarioTransfer usuario) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String usuarioID = ja.getJSONObject(i).getString("dni");
				
				if (usuarioID.equals(usuario.getDNI())) {
					
					ja.getJSONObject(i).put("dni", "null");
					ja.getJSONObject(i).put("nombre", "null");
					ja.getJSONObject(i).put("apellido1", "null");
					ja.getJSONObject(i).put("apellido2", "null");
					ja.getJSONObject(i).put("disponibilidad", false);
					ja.getJSONObject(i).put("telefono", "null");
					ja.getJSONObject(i).put("proyecto","");
					
					encontrado = true;
				}
			}
			
			jo.put("array", ja);

			OutputStream out = _outFile == null ? System.out : new FileOutputStream((_outFile));
			PrintStream p = new PrintStream(out);
			
			p.print(jo);
		}
		return encontrado;
	}

	@Override
	public UsuarioTransfer buscarUsuario(UsuarioTransfer usuario) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String usuarioID = ja.getJSONObject(i).getString("dni");
				
				if (usuarioID.equals(usuario.getDNI()) && encontrado != true) {
					
					String dni = ja.getJSONObject(i).getString("dni");
					String nombre = ja.getJSONObject(i).getString("nombre");
					String apellido1 = ja.getJSONObject(i).getString("apellido1");
					String apellido2 = ja.getJSONObject(i).getString("apellido2");
					boolean disp = ja.getJSONObject(i).getBoolean("disponibilidad");
					String proyecto = ja.getJSONObject(i).getString("proyecto");
					String telefono = ja.getJSONObject(i).getString("telefono");
					
					TransferUsuarioImp usuarioBuscado = new TransferUsuarioImp();
					
					usuarioBuscado.setDNI(dni);
					usuarioBuscado.setNombre(nombre);
					usuarioBuscado.setApellido1(apellido1);
					usuarioBuscado.setApellido2(apellido2);
					usuarioBuscado.setDisponibilidad(disp);
					usuarioBuscado.setProyecto(proyecto);
					usuarioBuscado.setTelefono(telefono);
					
					encontrado = true;
					
					return usuarioBuscado;
				}
			}
		}
		return null;
	}

	@Override
	public boolean modificarUsuario(UsuarioTransfer usuario) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String usuarioID = ja.getJSONObject(i).getString("dni");
				
				if (usuarioID.equals(usuario.getDNI())) {
					
					ja.getJSONObject(i).put("dni", usuario.getDNI());
					ja.getJSONObject(i).put("nombre", usuario.getNombre());
					ja.getJSONObject(i).put("apellido1", usuario.getApellido1());
					ja.getJSONObject(i).put("apellido2", usuario.getApellido2());
					ja.getJSONObject(i).put("disponibilidad", usuario.getDisponibilidad());
					ja.getJSONObject(i).put("telefono", usuario.getTelefono());
					ja.getJSONObject(i).put("proyecto", usuario.getProyecto());
					
					encontrado = true;
				}
			}
			
			jo.put("array", ja);

			OutputStream out = _outFile == null ? System.out : new FileOutputStream((_outFile));
			PrintStream p = new PrintStream(out);
			
			p.print(jo);
		}
		return encontrado;
	}

	@Override
	public List<UsuarioTransfer> buscaListaUsuarios() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String _inFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		List<UsuarioTransfer> listaUsuarios = new ArrayList<UsuarioTransfer>();
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String usuarioID = ja.getJSONObject(i).getString("dni");
				
				if (!usuarioID.equals("null")) {
					
					String dni = ja.getJSONObject(i).getString("dni");
					String nombre = ja.getJSONObject(i).getString("nombre");
					String apellido1 = ja.getJSONObject(i).getString("apellido1");
					String apellido2 = ja.getJSONObject(i).getString("apellido2");
					boolean disp = ja.getJSONObject(i).getBoolean("disponibilidad");
					String proyecto = ja.getJSONObject(i).getString("proyecto");
					String telefono = ja.getJSONObject(i).getString("telefono");
					
					TransferUsuarioImp usuarioBuscado = new TransferUsuarioImp();
					
					usuarioBuscado.setDNI(dni);
					usuarioBuscado.setNombre(nombre);
					usuarioBuscado.setApellido1(apellido1);
					usuarioBuscado.setApellido2(apellido2);
					usuarioBuscado.setDisponibilidad(disp);
					usuarioBuscado.setProyecto(proyecto);
					usuarioBuscado.setTelefono(telefono);
					
					listaUsuarios.add(usuarioBuscado);
				}
			}
		}
		return listaUsuarios;
	}

}
