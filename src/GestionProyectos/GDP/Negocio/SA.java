package GestionProyectos.GDP.Negocio;



import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;

public interface SA {
     public void leerdatos();
     public ModeloTablaPersona creartablaPersonas(String RolPersona);
	 public TProyecto BuscarProyecto(String nombreProy);
	 public boolean liberar(String DNI);
	 public boolean cambiarproyecto(String DNI, String NombreProy);
	 public void AddProyecto(TProyecto proyecto);
	 public ModeloTablaProyectos creartablaProyectos();
	 public void añadiraproyecto(String DNI, String NombreProy);
	 public boolean compararfechas(String fechaAntigua);
	 public void GenerarNuevaVersion(String NombreProy);
	 public boolean pasarafabricacion(String NombreProy);
	 public ModeloTablaPersona tablapersonaldeproyecto(String NombreProy);
	 public void ponerenfabricacion(String nombreProy);
	 public boolean addProducto(Producto producto); 
	 public Producto[] getProductos();
	 public void reiniciarpedido();
	 public int getTamProductos();
}
