package GestionProyectos.GDP.Presentacion;



import javax.swing.JOptionPane;


import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;
import GestionProyectos.GDP.Negocio.SAImp;
import GestionProyectos.GDP.Negocio.TPersona;
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
		
		if(BuscarProyecto(proyecto)!=null) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else {
			SAImp.getInstancia().AddProyecto(proyecto); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
	}
	public TProyecto BuscarProyecto(TProyecto proyecto) {
		return SAImp.getInstancia().BuscarProyecto(proyecto);
	}
	public void leerdatos() {
		SAImp.getInstancia().leerdatos();
	}
	public boolean liberar(TPersona Persona) {
		return SAImp.getInstancia().liberar(Persona);
	}
	public boolean cambiarproyecto(TPersona Persona, TProyecto proyecto) {
		return SAImp.getInstancia().cambiarproyecto(Persona, proyecto);
	}
	public void annadiraproyecto(TPersona Persona, TProyecto proyecto) {
		SAImp.getInstancia().annadiraproyecto(Persona, proyecto);
	}
	public boolean compararfechas(String fechaAntigua) {
		return SAImp.getInstancia().compararfechas(fechaAntigua);
	}
	public void GenerarNuevaVersion(TProyecto proyecto) {
		SAImp.getInstancia().GenerarNuevaVersion(proyecto);
	}
	public boolean pasarafabricacion(TProyecto proyecto) {
		return SAImp.getInstancia().pasarafabricacion(proyecto);
	}
	public ModeloTablaPersona tablapersonaldeproyecto(TProyecto proyecto) {
		return SAImp.getInstancia().tablapersonaldeproyecto(proyecto);
	}
	public void ponerenfabricacion(TProyecto proyecto) {
		SAImp.getInstancia().ponerenfabricacion(proyecto);
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
