package GestionProyectos.GDP.Integracion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import GestionProyectos.GDP.Negocio.FactoriaTransfer;
import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;


public class DAOProyectoImp implements DAOProyecto{
       private static DAOProyecto instancia=null;
       private List<TProyecto> proyectos;
       private DAOProyectoImp() {
    	   proyectos= new ArrayList<TProyecto>();
       }
       public static DAOProyecto getInstancia() {
    	   if(instancia==null) {
    		   instancia= new DAOProyectoImp();
    	   }
    	   return instancia;
       }
       public void leerProyectos() {
   		List<Object> datosproyecto= new ArrayList<Object>();
       	List<String> personas= new ArrayList<String>();		 	
   		String line=null;
   		
   		try {
   			BufferedReader read2 = new BufferedReader(new FileReader(new File("src/BaseDatos/Proyectos.txt")));
   			line=read2.readLine();
   			int tamNif=0;	
   			while(line!=null) {
   				String NombreProy=line;
   				line=read2.readLine();
   				datosproyecto.add(NombreProy);
   				String Descripcion=line;
   				line=read2.readLine();
   				datosproyecto.add(Descripcion);
   				String Version=line;
   				line=read2.readLine();
   				datosproyecto.add(Version);
   				String Fecha=line;
   				line=read2.readLine();
   				datosproyecto.add(Fecha);
   				String MododeFabricacion=line;
   				line=read2.readLine();
   				datosproyecto.add(MododeFabricacion);
   				int nparticipantes= Integer.parseInt(line);
   				for(int i=0;i < nparticipantes;i++) {
   					line=read2.readLine();
   					personas.add(line);
   				}
   				datosproyecto.add(personas);
   				proyectos.add(FactoriaTransfer.getInstancia().CrearObjetoProyecto(datosproyecto));
   				personas = new ArrayList<String>();
   				datosproyecto= new ArrayList<Object>();
   				line=read2.readLine();
   			}
   			read2.close();
   		}
   			catch (IOException e) {	
   			e.printStackTrace();
   		}
       }

   	public void EscribirProyectos() {
   		int i=0;
   		String line=null;
   		try {
   		BufferedWriter w= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Proyectos.txt")));
   		String s="";
   		while(i<proyectos.size()) {
   			s+=proyectos.get(i).leerNombre()+"\n";
   			s+=proyectos.get(i).leerDescripcion()+"\n";
   			s+=proyectos.get(i).leerVersion()+"\n";
   			s+=proyectos.get(i).leerFecha()+"\n";
   			s+=proyectos.get(i).leerFabricacion()+"\n";
   			s+=proyectos.get(i).leerparticipantes().size()+"\n";
   			for(int j=0;j<proyectos.get(i).leerparticipantes().size();j++) {
   				s+=proyectos.get(i).leerparticipantes().get(j)+"\n";
   			}							
   			i++;
   		}				
   			w.write(s);
   			w.close();
   	} catch (IOException e) {
   			e.printStackTrace();
   		}
   	}
       public TProyecto getProyecto(TProyecto Proyecto) {
 	  	  
 		  for(TProyecto p: proyectos) {
 			  if(p.leerNombre().equals(Proyecto.leerNombre())) return p;
 		  }
 		  
 		  return null;
 		 
 	}
       public boolean LiberarPersonaDeProyecto(TPersona Persona) {
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
   				EscribirProyectos();
   				return true;
   			}
   		}
   		else {			
   			return false;
   		}
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
   			EscribirProyectos();
   			return true;
   		}
   	}
   	public boolean ProyectoConTamaño1(TPersona persona) {
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
   	  public void AddProyecto(TProyecto proyecto) {
   		  proyectos.add(proyecto);
   		  EscribirProyectos();
   	  }
       public ModeloTablaProyectos creartablaProyectos() {	
		
		ModeloTablaProyectos TP= FactoriaTabla.getInstancia().CrearObjetoProyecto(null);
		for(int i=0; i<proyectos.size();i++) {
			TP.addProyecto(proyectos.get(i));
		}
		return TP;
	}
      public void annadiraproyecto(TPersona persona, TProyecto proyecto) {
    	   proyectos.get(proyectos.indexOf(proyecto)).leerparticipantes().add(persona.leerDNI());
    	   EscribirProyectos();
       }
      public void GenerarNuevaVersion(TProyecto proyecto) {
    	int num= extraerNumeroDeVersion(proyectos.get(proyectos.indexOf(proyecto)).leerVersion());
    	proyectos.get(proyectos.indexOf(proyecto)).updateVersion("Version "+num);
  		Date date = new Date();
  		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
  		String fecha= sdf.format(date);
  		proyectos.get(proyectos.indexOf(proyecto)).updateFecha(fecha);
  		EscribirProyectos();	
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
  	public boolean pasarafabricacion(TProyecto proyecto) {
  		if(proyectos.get(proyectos.indexOf(proyecto))!=null) {
			if(proyectos.get(proyectos.indexOf(proyecto)).leerVersion().equals("Version 1") || proyectos.get(proyectos.indexOf(proyecto)).leerVersion().equals("Version 2")) {
				return false;
			}
			else {
				return true;
			}
		}
		else return false;
  	}
  	public void ponerenfabricacion(TProyecto proyecto) {
  		proyectos.get(proyectos.indexOf(proyecto)).updateFabricacion("SI");
        EscribirProyectos();
  	}
	@Override
	public int getTamProyectos() {	
		return proyectos.size();
	}
	

		
}
