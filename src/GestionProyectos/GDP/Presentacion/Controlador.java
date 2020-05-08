package GestionProyectos.GDP.Presentacion;



import javax.swing.JOptionPane;


import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;
import GestionProyectos.GDP.Negocio.SAImp;
import GestionProyectos.GDP.Negocio.TProyecto;



public class Controlador {
	private static Controlador instancia=null;
	private Controlador() {
		
		leerdatos();
	}
	
	public static Controlador getInstancia() {
		if(instancia==null) {
			instancia= new Controlador();
		}
		return instancia;
	}
	
	public ModeloTablaPersona creartablaPersonas(String tipo) {
	 if(!tipo.toLowerCase().contentEquals("investigador") && !tipo.toLowerCase().contentEquals("trabajador") && !tipo.toLowerCase().contentEquals("participantes")) {
		 JOptionPane.showMessageDialog(null, "El rol de persona no es valido");
		 return null;
	 }
	 else {
		 ModeloTablaPersona Ta= SAImp.getInstancia().creartablaPersonas(tipo);
		  if(Ta!=null) {
			  return Ta;
		  }
		  return null;		
		}
	 }
	public ModeloTablaProyectos crearTablaProyectos() {
		ModeloTablaProyectos Tp= SAImp.getInstancia().creartablaProyectos();
		return Tp;
	}
	public boolean AddProyecto(TProyecto proyecto) {
		
		if(BuscarProyecto(proyecto.getNombre())!=null) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else {
			SAImp.getInstancia().AddProyecto(proyecto); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
	}
	public TProyecto BuscarProyecto(String NombreProy) {
		return SAImp.getInstancia().BuscarProyecto(NombreProy);
	}
	public void leerdatos() {
		SAImp.getInstancia().leerdatos();
	}
	public boolean liberar(String DNI) {
		return SAImp.getInstancia().liberar(DNI);
	}
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		return SAImp.getInstancia().cambiarproyecto(DNI, NombreProy);
	}
	public void añadiraproyecto(String DNI, String NombreProy) {
		SAImp.getInstancia().añadiraproyecto(DNI, NombreProy);
	}
	public boolean compararfechas(String fechaAntigua) {
		return SAImp.getInstancia().compararfechas(fechaAntigua);
	}
	public void GenerarNuevaVersion(String NombreProy) {
		SAImp.getInstancia().GenerarNuevaVersion(NombreProy);
	}
	public boolean pasarafabricacion(String NombreProy) {
		return SAImp.getInstancia().pasarafabricacion(NombreProy);
	}
	public ModeloTablaPersona tablapersonaldeproyecto(String NombreProy) {
		return SAImp.getInstancia().tablapersonaldeproyecto(NombreProy);
	}
	public void ponerenfabricacion(String nombreProy) {
		SAImp.getInstancia().ponerenfabricacion(nombreProy);
	}
	public boolean Addproducto(Producto producto) {
		return SAImp.getInstancia().addProducto(producto);
	}
	public Producto[] getProductos() {
		return SAImp.getInstancia().getProductos();
	}
	public int getTamProductos() {
		return SAImp.getInstancia().getTamProductos();
	}
	public void reinicarpedido() {
		SAImp.getInstancia().reiniciarpedido();
	}
}
