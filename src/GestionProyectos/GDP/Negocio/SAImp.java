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
			  if(p.leerNombre().equals(Proyecto.leerNombre())) return p;
		  }
		  
		  return null;
		 
	}
    public TPersona getPersona(TPersona Persona) {
    	 for(TPersona p: personas) {
			  if(p.leerDNI().equals(Persona.leerDNI())) return p;
		  }
		  
		  return null;
	}
    
	@Override
	public ModeloTablaPersona creartablaPersonas(String RolPersona)  {

		ModeloTablaPersona TA= FactoriaTabla.getInstancia().CrearObjetoPersona(null);
		
		for(int i=0;i<personas.size();i++) {
			if(RolPersona.equals(personas.get(i).leerRol())) {
				TA.addPersonas(personas.get(i));
				TA.fireTableDataChanged();			
			}
		}	
		return TA;
	}

	@Override
	public TProyecto BuscarProyecto(TProyecto proyecto) {		
         for(TProyecto p: proyectos) {
        	 if(p.leerNombre().equals(proyecto.leerNombre())) return p;
         }
         return null;
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		proyectos.add(proyecto);
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
		updateEstado(proyecto, "No Disponible");
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).EscribirPersonas(personas);
	}
	private void updateEstado(TProyecto proyecto, String Estado) {
		for(int i=0, j=0; i<personas.size() && j<proyecto.leerparticipantes().size();i++) {
			if(personas.get(i).leerDNI().equals(proyecto.leerparticipantes().get(j))) {
				personas.get(i).updateEstado(Estado);
				j++;
			}
		}
		
	}
	@Override
	public void leerdatos() {
		personas= FactoriaDAO.getInstancia().CrearObjetoPersona(null).leerPersonas();	
		proyectos= FactoriaDAO.getInstancia().CrearObjetoProyecto(null).leerProyectos();
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
		getPersona(persona).updateEstado(Estado);
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).EscribirPersonas(personas);
	}
	private boolean LiberarPersonadeProyecto(TPersona Persona) {
		boolean find=false;
		int i=0, j=0;
		while(i<proyectos.size() && !find) {
			while(j<proyectos.get(i).leerparticipantes().size() && !find) {
				if(proyectos.get(i).leerparticipantes().get(j).equals(Persona.leerDNI())){
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
			if(proyectos.get(i).leerparticipantes().size()==1) {
				return false;
			}
			else {
				proyectos.get(i).leerparticipantes().remove(j);
				FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
				return true;
			}
		}
		else {			
			return false;
		}
	}
	
	@Override
	public ModeloTablaProyectos creartablaProyectos() {		
		ModeloTablaProyectos TP= FactoriaTabla.getInstancia().CrearObjetoProyecto(null);
		for(int i=0; i<proyectos.size();i++) {
			TP.addProyecto(proyectos.get(i));
		}
		return TP;
	}
	public boolean cambiarproyecto(TPersona persona, TProyecto proyecto) {
		TProyecto p=getProyecto(proyecto);
		boolean acabar= false;
		int i=0;
		while(i<p.leerparticipantes().size() && !acabar) {
			if(p.leerparticipantes().get(i).equals(persona.leerDNI())) {
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
			FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
			return true;
		}
	}
	private boolean ProyectoConTamaño1(TPersona persona) {
		for(int i=0;i<proyectos.size();i++) {
			for(String s: proyectos.get(i).leerparticipantes()) {
				if(s.equals(persona.leerDNI())) {
					return proyectos.get(i).leerparticipantes().size()==1;
				}
			}
		}
		return false;
	}
	private void intercambiarproyectos(TPersona persona, int indice) {
		boolean acabar=false;
		int i=0, j=0;
		while(i<proyectos.size() && !acabar) {		
				while(j<proyectos.get(i).leerparticipantes().size() && !acabar){
					if(proyectos.get(i).leerparticipantes().get(j).equals(persona.leerDNI())) {
						proyectos.get(indice).leerparticipantes().add(persona.leerDNI());
						proyectos.get(i).leerparticipantes().remove(j);
						acabar=true;
					}					
					j++;
				}
				j=0;
				i++;
			}
		
		}

	public void annadiraproyecto(TPersona persona, TProyecto proyecto) {
		proyecto.leerparticipantes().add(persona.leerDNI());
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
		persona.updateEstado("No Disponible");
		FactoriaDAO.getInstancia().CrearObjetoPersona(null).EscribirPersonas(personas);
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
		int num= extraerNumeroDeVersion(proyecto.leerVersion());
		proyecto.updateVersion("Version "+num);
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		String fecha= sdf.format(date);
		proyecto.updateFecha(fecha);
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
		
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
			if(proyecto.leerVersion().equals("Version 1") || proyecto.leerVersion().equals("Version 2")) {
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
		ModeloTablaPersona p= FactoriaTabla.getInstancia().CrearObjetoPersona(null);
		for(int i=0, j=0; i<personas.size() && j<proyecto.leerparticipantes().size();i++) {
			if (personas.get(i).leerDNI().equals(proyecto.leerparticipantes().get(j))) {
				p.addPersonas(personas.get(i));
				j++;
			}
		}
		return p;
	}
	@Override
	public void ponerenfabricacion(TProyecto proyecto) {
		proyecto.updateFabricacion("SI");
		FactoriaDAO.getInstancia().CrearObjetoProyecto(null).EscribirProyectos(proyectos);
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
	public int getTamProyectos() {
		return proyectos.size();
	}
	public int getTamPersonas() {
		return personas.size();
	}
}
