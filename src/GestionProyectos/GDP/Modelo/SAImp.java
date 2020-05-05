package GestionProyectos.GDP.Modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import GestionDeAlmacen.GDA.Modelo.Producto;



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
	public ModeloTablaPersona creartablaPersonas(String tipo)  {

		ModeloTablaPersona TA= null;
		
	    TA = DAOPersonaImp.getInstancia().creartablaPersonas(tipo);
			
		if(TA!=null) {
			return TA;
		}
		else return null;
	}

	@Override
	public TProyecto BuscarProyecto(String nombreProy) {		
		return DAOProyectoImp.getInstancia().getProyecto(nombreProy);
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		DAOPersonaImp.getInstancia().AddProyecto(proyecto);
		DAOProyectoImp.getInstancia().AddProyecto(proyecto);
	}
	@Override
	public void leerdatos() {
		DAOPersonaImp.getInstancia().leerPersonas();	
		DAOProyectoImp.getInstancia().leerProyectos();
	}
	@Override
	public boolean liberar(String DNI) {
		if(DAOProyectoImp.getInstancia().LiberarPersonadeProyecto(DNI)) {
			DAOPersonaImp.getInstancia().LiberarPersonadeProyecto(DNI);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public ModeloTablaProyectos creartablaProyectos() {
		ModeloTablaProyectos Tp= DAOProyectoImp.getInstancia().creartablaProyectos();
		return Tp;
	}
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		return DAOProyectoImp.getInstancia().cambiarproyecto(DNI, NombreProy);
	}
	public void añadiraproyecto(String DNI, String NombreProy) {
		DAOProyectoImp.getInstancia().añadirpersona(DNI, NombreProy);
		DAOPersonaImp.getInstancia().AddProyecto(DAOProyectoImp.getInstancia().getProyecto(NombreProy));
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
		DAOProyectoImp.getInstancia().GenerarNuevaVersion(NombreProy);
		
	}
	@Override
	public boolean pasarafabricacion(String NombreProy) {
		
		return DAOProyectoImp.getInstancia().pasarafabricacion(NombreProy);
	}
	@Override
	public ModeloTablaPersona tablapersonaldeproyecto(String NombreProy) {
		List<String> DNIs= DAOProyectoImp.getInstancia().getParticipantesProyecto(NombreProy);
		return DAOPersonaImp.getInstancia().creartablapersonaldeproyecto(DNIs);
	}
	@Override
	public void ponerenfabricacion(String nombreProy) {
		DAOProyectoImp.getInstancia().ponerenfabricacion(nombreProy);
	
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
