package GestionProyectos.GDP.Negocio;



import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;

public interface SA {
     public void leerdatos();
     public TProyecto getProyecto(TProyecto Proyecto);
     public TPersona getPersona(TPersona Persona);
     public ModeloTablaPersona creartablaPersonas(String RolPersona);
	 public boolean liberar(TPersona Persona);
	 public boolean cambiarproyecto(TPersona Persona, TProyecto proyecto);
	 public void AddProyecto(TProyecto proyecto);
	 public ModeloTablaProyectos creartablaProyectos();
	 public void annadiraproyecto(TPersona Persona, TProyecto proyecto);
	 public boolean compararfechas(String fechaAntigua);
	 public void GenerarNuevaVersion(TProyecto proyecto);
	 public boolean pasarafabricacion(TProyecto proyecto);
	 public ModeloTablaPersona tablapersonaldeproyecto(TProyecto proyecto);
	 public void ponerenfabricacion(TProyecto proyecto);
	 public void EnviarPedido(PedidosTransfer pedido);
	 public int getTamPersonas();
	 public int getTamProyectos();
}
