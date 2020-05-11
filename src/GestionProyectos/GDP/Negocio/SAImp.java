package GestionProyectos.GDP.Negocio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import GestionDeAlmacen.GDA.Modelo.Producto;
import GestionProyectos.GDP.Integracion.DAOProyectoImp;
import GestionProyectos.GDP.Integracion.FactoriaDAO;
import GestionProyectos.GDP.Integracion.FactoriaTabla;
import GestionProyectos.GDP.Integracion.ModeloTablaPersona;
import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;



public class SAImp implements SA{
	private List<TPersona> personas;
	private List<TProyecto> proyectos;
	private static SA instancia= null;
    private Producto[] productos;
    private int contadordeproductos=0;  
    private SAImp() {   	
    	productos= new Producto[1000];
    	personas= new ArrayList<TPersona>();
    	proyectos= new ArrayList<TProyecto>();
    }
    public static SA getInstancia() {
    	if(instancia==null) {
    		instancia= new SAImp();
    	}
    	return instancia;
    }
    
    public TProyecto getProyecto(TProyecto Proyecto) {
	  	  
		  for(TProyecto p: proyectos) {
			  if(p.getNombre().equals(Proyecto.getNombre())) return p;
		  }
		  
		  return null;
		 
	}
    public TPersona getPersona(TPersona Persona) {
    	 for(TPersona p: personas) {
			  if(p.getDNI().equals(Persona.getDNI())) return p;
		  }
		  
		  return null;
	}
    
	@Override
	public ModeloTablaPersona creartablaPersonas(String RolPersona)  {

		ModeloTablaPersona TA= FactoriaTabla.getInstancia().CrearObjetoPersona();
		
		for(int i=0;i<personas.size();i++) {
			if(RolPersona.equals(personas.get(i).getRol())) {
				TA.addPersonas(personas.get(i));
				TA.fireTableDataChanged();			
			}
		}	
		return TA;
	}

	@Override
	public TProyecto BuscarProyecto(TProyecto proyecto) {		
         for(TProyecto p: proyectos) {
        	 if(p.getNombre().equals(proyecto.getNombre())) return p;
         }
         return null;
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		proyectos.add(proyecto);
		FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
		updateEstado(proyecto, "No Disponible");
		FactoriaDAO.getInstancia().CrearObjetoPersona().EscribirPersonas(personas);
	}
	private void updateEstado(TProyecto proyecto, String Estado) {
		for(int i=0, j=0; i<personas.size() && j<proyecto.getparticipantes().size();i++) {
			if(personas.get(i).getDNI().equals(proyecto.getparticipantes().get(j))) {
				personas.get(i).setEstado(Estado);
				j++;
			}
		}
		
	}
	@Override
	public void leerdatos() {
		personas= FactoriaDAO.getInstancia().CrearObjetoPersona().leerPersonas();	
		proyectos= FactoriaDAO.getInstancia().CrearObjetoProyecto().leerProyectos();
	}
	@Override
	public boolean liberar(TPersona persona) {
		if(LiberarPersonadeProyecto(persona)) {
			LiberarPersona("Disponible", persona);
			return true;
		}
		else {
			return false;
		}
	}
	private void LiberarPersona(String Estado, TPersona persona) {
		getPersona(persona).setEstado(Estado);
		FactoriaDAO.getInstancia().CrearObjetoPersona().EscribirPersonas(personas);
	}
	private boolean LiberarPersonadeProyecto(TPersona Persona) {
		boolean find=false;
		int i=0, j=0;
		while(i<proyectos.size() && !find) {
			while(j<proyectos.get(i).getparticipantes().size() && !find) {
				if(proyectos.get(i).getparticipantes().get(j).equals(Persona.getDNI())){
					find=true;		
				}
				if(!find) {		
					j++;
				}
			}
			if(!find) {
				i++;
				j=0;
			}		
		}
		
		if(find) {
			if(proyectos.get(i).getparticipantes().size()==1) {
				return false;
			}
			else {
				proyectos.get(i).getparticipantes().remove(j);
				FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
				return true;
			}
		}
		else {			
			return false;
		}
	}
	
	@Override
	public ModeloTablaProyectos creartablaProyectos() {		
		ModeloTablaProyectos TP= FactoriaTabla.getInstancia().CrearObjetoProyecto();
		for(int i=0; i<proyectos.size();i++) {
			TP.addProyecto(proyectos.get(i));
		}
		return TP;
	}
	public boolean cambiarproyecto(TPersona persona, TProyecto proyecto) {
		TProyecto p=getProyecto(proyecto);
		boolean acabar= false;
		int i=0;
		while(i<p.getparticipantes().size() && !acabar) {
			if(p.getparticipantes().get(i).equals(persona.getDNI())) {
				acabar=true;
			}
			else {
				i++;
			}
		}
		if(acabar) {
			return false;
		}
		else if(ProyectoConTamaño1(persona)) {	
			return false;
		}
		else {
			intercambiarproyectos(persona, proyectos.indexOf(proyecto));
			FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
			return true;
		}
	}
	private boolean ProyectoConTamaño1(TPersona persona) {
		for(int i=0;i<proyectos.size();i++) {
			for(String s: proyectos.get(i).getparticipantes()) {
				if(s.equals(persona.getDNI())) {
					return proyectos.get(i).getparticipantes().size()==1;
				}
			}
		}
		return false;
	}
	private void intercambiarproyectos(TPersona persona, int indice) {
		boolean acabar=false;
		int i=0, j=0;
		while(i<proyectos.size() && !acabar) {		
				while(j<proyectos.get(i).getparticipantes().size() && !acabar){
					if(proyectos.get(i).getparticipantes().get(j).equals(persona.getDNI())) {
						proyectos.get(indice).getparticipantes().add(persona.getDNI());
						proyectos.get(i).getparticipantes().remove(j);
						acabar=true;
					}					
					j++;
				}
				j=0;
				i++;
			}
		
		}

	public void annadiraproyecto(TPersona persona, TProyecto proyecto) {
		proyecto.getparticipantes().add(persona.getDNI());
		FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
		persona.setEstado("No Disponible");
		FactoriaDAO.getInstancia().CrearObjetoPersona().EscribirPersonas(personas);
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
		int num= extraerNumeroDeVersion(proyecto.getVersion());
		proyecto.setVersion("Version "+num);
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		String fecha= sdf.format(date);
		proyecto.setFecha(fecha);
		FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
		
	}
	private int extraerNumeroDeVersion(String version) {
		int i=version.length()-1, exponente=1, numero=0;	
		while(i>7) {
			String s= version.charAt(i)+"";
			int numpos= Integer.parseInt(s);
			numero+=numpos * exponente;
			exponente*=10;
			i--;
		}
		return numero+1;
	}
	@Override
	public boolean pasarafabricacion(TProyecto proyecto) {	
		if(proyecto!=null) {
			if(proyecto.getVersion().equals("Version 1") || proyecto.getVersion().equals("Version 2")) {
				return false;
			}
			else {
				return true;
			}
		}
		else return false;
	}
	@Override
	public ModeloTablaPersona tablapersonaldeproyecto(TProyecto proyecto) {
		ModeloTablaPersona p= FactoriaTabla.getInstancia().CrearObjetoPersona();
		for(int i=0, j=0; i<personas.size() && j<proyecto.getparticipantes().size();i++) {
			if (personas.get(i).getDNI().equals(proyecto.getparticipantes().get(j))) {
				p.addPersonas(personas.get(i));
				j++;
			}
		}
		return p;
	}
	@Override
	public void ponerenfabricacion(TProyecto proyecto) {
		proyecto.setFabricacion("SI");
		FactoriaDAO.getInstancia().CrearObjetoProyecto().EscribirProyectos(proyectos);
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
