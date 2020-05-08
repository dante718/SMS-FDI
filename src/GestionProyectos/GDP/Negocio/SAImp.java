package GestionProyectos.GDP.Negocio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionProyectos.GDP.Integracion.DAOProyectoImp;
import GestionProyectos.GDP.Integracion.FactoriaDAO;
import GestionProyectos.GDP.Integracion.FactoriaTabla;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;



public class SAImp implements SA{
	private static SA instancia= null;
    private Producto[] productos;
    private int contadordeproductos=0;  
    private SAImp() {   	
    	productos= new Producto[1000];
    }
    
    public static SA getInstancia() {
    	if(instancia==null) {
    		instancia= new SAImp();
    	}
    	return instancia;
    }
    
	@Override
	public ModeloTablaPersona creartablaPersonas(String RolPersona)  {

		ModeloTablaPersona TA= FactoriaTabla.getInstancia().CrearObjetoPersona();
		
		for(int i=0;i<TA.getRowCount();i++) {
			if(!RolPersona.equals((String) TA.getValueAt(i, 6))) {
				TA.removeFila(i);
				TA.fireTableDataChanged();
				i--;
			}
		}	
		return TA;
	}

	@Override
	public TProyecto BuscarProyecto(String nombreProy) {		
		return FactoriaDAO.getInstancia().CrearObjetoProyecto().getProyecto(nombreProy);
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		FactoriaDAO.getInstancia().CrearObjetoPersona().AddProyecto(proyecto);
		FactoriaDAO.getInstancia().CrearObjetoProyecto().AddProyecto(proyecto);
	}
	@Override
	public void leerdatos() {
		FactoriaDAO.getInstancia().CrearObjetoPersona().leerPersonas();	
		FactoriaDAO.getInstancia().CrearObjetoProyecto().leerProyectos();
	}
	@Override
	public boolean liberar(String DNI) {
		if(FactoriaDAO.getInstancia().CrearObjetoProyecto().LiberarPersonadeProyecto(DNI)) {
			FactoriaDAO.getInstancia().CrearObjetoPersona().LiberarPersonadeProyecto(DNI);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public ModeloTablaProyectos creartablaProyectos() {		
		return FactoriaTabla.getInstancia().CrearObjetoProyecto();
	}
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		return FactoriaDAO.getInstancia().CrearObjetoProyecto().cambiarproyecto(DNI, NombreProy);
	}
	public void añadiraproyecto(String DNI, String NombreProy) {
		FactoriaDAO.getInstancia().CrearObjetoProyecto().añadirpersona(DNI, NombreProy);
		FactoriaDAO.getInstancia().CrearObjetoPersona().AddProyecto(DAOProyectoImp.getInstancia().getProyecto(NombreProy));
	}
	@Override
	public boolean compararfechas(String fechaAntigua) {
		Date NuevaDate = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");		
		try {
			Date AntiguaDate= sdf.parse(fechaAntigua);
			if(NuevaDate.getYear()==AntiguaDate.getYear()) {
				if(NuevaDate.getMonth()==AntiguaDate.getMonth()) {
					if(NuevaDate.getDay()-AntiguaDate.getDay()>=1) {
						return true;
					}
					else {
						return false;
					}
				}
				else if(NuevaDate.getMonth()>AntiguaDate.getMonth()) {
					return true;
				}
		  }
			else if(NuevaDate.getYear()>AntiguaDate.getYear()) {
				return true;
			}
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		return false;	
	}
	@Override
	public void GenerarNuevaVersion(String NombreProy) {
		FactoriaDAO.getInstancia().CrearObjetoProyecto().GenerarNuevaVersion(NombreProy);
		
	}
	@Override
	public boolean pasarafabricacion(String NombreProy) {	
		return FactoriaDAO.getInstancia().CrearObjetoProyecto().pasarafabricacion(NombreProy);
	}
	@Override
	public ModeloTablaPersona tablapersonaldeproyecto(String NombreProy) {
		List<String> DNIs= FactoriaDAO.getInstancia().CrearObjetoProyecto().getParticipantesProyecto(NombreProy);
		return FactoriaDAO.getInstancia().CrearObjetoPersona().creartablapersonaldeproyecto(DNIs);
	}
	@Override
	public void ponerenfabricacion(String nombreProy) {
		FactoriaDAO.getInstancia().CrearObjetoProyecto().ponerenfabricacion(nombreProy);
	
	}
	@Override
	public boolean addProducto(Producto producto) {
		if(!estaelproducto(producto)) {
			productos[contadordeproductos]=producto;
			contadordeproductos++;
			return true;
		}
		else return false;
	}
	private boolean estaelproducto(Producto producto) {
		int i=0;
		boolean encontrado=false;		
		while(i<contadordeproductos && !encontrado) {
			if(productos[i].get_id()==producto.get_id()) {
				encontrado=true;
			}	
			i++;
		}	
		return encontrado;
	}
	public Producto[] getProductos() {
		return productos;
	}
	@Override
	public void reiniciarpedido() {
		this.contadordeproductos=0;
		
	}
	@Override
	public int getTamProductos() {		
		return contadordeproductos;
	}
}
