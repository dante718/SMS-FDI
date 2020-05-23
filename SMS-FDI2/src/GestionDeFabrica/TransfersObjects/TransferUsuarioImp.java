package GestionDeFabrica.TransfersObjects;

public class TransferUsuarioImp implements UsuarioTransfer{

	protected String dni;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected boolean disponibilidad;
	protected String proyecto;
	protected String telefono;
	
	@Override
	public String getDNI() {
		// TODO Auto-generated method stub
		return this.dni;
	}
	@Override
	public void setDNI(String dni) {
		// TODO Auto-generated method stub
		this.dni = dni;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
	}
	@Override
	public String getApellido1() {
		// TODO Auto-generated method stub
		return this.apellido1;
	}
	@Override
	public void setApellido1(String apellido1) {
		// TODO Auto-generated method stub
		this.apellido1 = apellido1;
	}
	@Override
	public String getApellido2() {
		// TODO Auto-generated method stub
		return this.apellido2;
	}
	@Override
	public void setApellido2(String apellido2) {
		// TODO Auto-generated method stub
		this.apellido2 = apellido2;
	}
	@Override
	public boolean getDisponibilidad() {
		// TODO Auto-generated method stub
		return this.disponibilidad;
	}
	@Override
	public void setDisponibilidad(boolean disp) {
		// TODO Auto-generated method stub
		this.disponibilidad = disp;
	}
	@Override
	public String getProyecto() {
		// TODO Auto-generated method stub
		return this.proyecto;
	}
	@Override
	public void setProyecto(String proyecto) {
		// TODO Auto-generated method stub
		this.proyecto = proyecto;
	}
	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return this.telefono;
	}
	@Override
	public void setTelefono(String tel) {
		// TODO Auto-generated method stub
		this.telefono = tel;
	}
	
	
}
