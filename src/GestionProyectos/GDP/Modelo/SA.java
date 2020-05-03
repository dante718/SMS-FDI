package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

import GestionDeAlmacen.GDA.Modelo.Producto;

public interface SA {
     public void leerdatos();
     public ModeloTablaPersona creartablaPersonas(String tipo);
	 public boolean BuscarProyecto(String nombreProy);
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
