package GestionProyectos.GDP.Negocio;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionDeFabrica.Factoria.FactoriaAbstractaDAO;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionProyectos.GDP.Integracion.DAOPersonaImp;
import GestionProyectos.GDP.Integracion.DAOProyectoImp;
import GestionProyectos.GDP.Integracion.FactoriaDAO;
import GestionProyectos.GDP.Integracion.FactoriaTabla;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;



public class SAImp implements SA{
	private static SA instancia= null;
    private SAImp() {}
    public static SA getInstancia() {
    	if(instancia==null) {
    		instancia= new SAImp();
    	}
    	return instancia;
    }
    
    public TProyecto getProyecto(TProyecto Proyecto) {	  	  
    	return FactoriaDAO.getInstancia().CrearObjetoProyecto(null).getProyecto(Proyecto);		 
	}
    public TPersona getPersona(TPersona Persona) {
    	return FactoriaDAO.getInstancia().CrearObjetoPersona(null).getPersona(Persona);
	}
    
	@Override
	public ModeloTablaPersona creartablaPersonas(String RolPersona)  {	
		return FactoriaDAO.getInstancia().CrearObjetoPersona(null).creartablaPersonas(RolPersona);
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).AddProyecto(proyecto);
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).AddProyecto(proyecto);
	}
	
	@Override
	public void leerdatos() {
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).leerPersonas();	
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).leerProyectos();
	}
	@Override
	public boolean liberar(TPersona persona) {
		if(FactoriaDAO.getInstancia().CrearObjetoProyecto(null).LiberarPersonaDeProyecto(persona)) {
			FactoriaDAO.getInstancia().CrearObjetoPersona(null).liberar(persona);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public ModeloTablaProyectos creartablaProyectos() {		
		return FactoriaDAO.getInstancia().CrearObjetoProyecto(null).creartablaProyectos();
	}
	public boolean cambiarproyecto(TPersona persona, TProyecto proyecto) {
		return FactoriaDAO.getInstancia().CrearObjetoProyecto(null).cambiarproyecto(persona, proyecto);
	}
	
	public void annadiraproyecto(TPersona persona, TProyecto proyecto) {
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).annadiraproyecto(persona, proyecto);
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).annadiraproyecto(persona);
	}
	@Override
	public boolean compararfechas(String fechaAntigua) {
		Date NuevaDate = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");		
		try {
			Date AntiguaDate= sdf.parse(fechaAntigua);
			if(NuevaDate.getYear()==AntiguaDate.getYear()) {
				if(NuevaDate.getMonth()==AntiguaDate.getMonth()) {
					if((NuevaDate.getDate()-AntiguaDate.getDate())>=1) {
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
	public void GenerarNuevaVersion(TProyecto proyecto) {
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).GenerarNuevaVersion(proyecto);
	}
	
	@Override
	public boolean pasarafabricacion(TProyecto proyecto) {	
		return FactoriaDAO.getInstancia().CrearObjetoProyecto(null).pasarafabricacion(proyecto);
	}
	@Override
	public ModeloTablaPersona tablapersonaldeproyecto(TProyecto proyecto) {
		return FactoriaDAO.getInstancia().CrearObjetoPersona(null).tablapersonaldeproyecto(proyecto);
	}
	@Override
	public void ponerenfabricacion(TProyecto proyecto) {	
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).ponerenfabricacion(proyecto);
	}
	public int getTamProyectos() {
		return FactoriaDAO.getInstancia().CrearObjetoProyecto(null).getTamProyectos();
	}
	public int getTamPersonas() {
		return FactoriaDAO.getInstancia().CrearObjetoPersona(null).getTamPersonas();
	}
	@Override
	public void EnviarPedido(PedidosTransfer pedido) {
		try {
			FactoriaAbstractaDAO.getFactoriaAbstractaDAO(1).getPedidoDAO().insertarPedido(pedido);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
