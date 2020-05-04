package GestionProyectos.GDP.Modelo;

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


public class DAOProyectoImp implements DAOProyecto{
       private List<TProyecto> proyectos;
       
       public DAOProyectoImp() {
    	   proyectos= new ArrayList<TProyecto>();
       }
	  public TProyecto getProyecto(String NombreProy) {
		  boolean acabar=false;
		  int i=0;
		  while(i<proyectos.size() && !acabar) {
			  if(proyectos.get(i).getNombre().equals(NombreProy)) {
				  acabar=true;
			  }
			  else {
				  i++;
			  }
		  }
		  if(acabar) {
			  return proyectos.get(i); 
		  }
		  else {
			  return null;
		  }
	  }
	  public void leerProyectos() {
    	List<String> personas= new ArrayList<String>();		 	
		String line=null;
		
		try {
			BufferedReader read2 = new BufferedReader(new FileReader(new File("src/BaseDatos/Proyectos.txt")));
			line=read2.readLine();
			int tamNif=0;	
			while(line!=null) {
				String NombreProy=line;
				line=read2.readLine();
				String Descripcion=line;
				line=read2.readLine();
				String Version=line;
				line=read2.readLine();
				String Fecha=line;
				line=read2.readLine();
				String MododeFabricacion=line;
				line=read2.readLine();
				int nparticipantes= Integer.parseInt(line);
				for(int i=0;i < nparticipantes;i++) {
					line=read2.readLine();
					personas.add(line);
				}
				proyectos.add(new TProyecto(NombreProy, Descripcion,personas, Version, Fecha, MododeFabricacion));
				personas = new ArrayList<String>();	
				line=read2.readLine();
			}
			read2.close();
		}
			catch (IOException e) {	
			e.printStackTrace();
		}
    }
	@Override
	public void AddProyecto(TProyecto proyecto) {
		proyectos.add(proyecto);
		EscribirProyectos();	
	}
	
	public void EscribirProyectos() {
		int i=0;
		String line=null;
		try {
		BufferedWriter w= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Proyectos.txt")));
		String s="";
		while(i<proyectos.size()) {
			s+=proyectos.get(i).getNombre()+"\n";
			s+=proyectos.get(i).getDescripcion()+"\n";
			s+=proyectos.get(i).getVersion()+"\n";
			s+=proyectos.get(i).getFecha()+"\n";
			s+=proyectos.get(i).getFabricacion()+"\n";
			s+=proyectos.get(i).getparticipantes().size()+"\n";
			for(int j=0;j<proyectos.get(i).getparticipantes().size();j++) {
				s+=proyectos.get(i).getparticipantes().get(j)+"\n";
			}							
			i++;
		}				
			w.write(s);
			w.close();
	} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean LiberarPersonadeProyecto(String DNI) {
		boolean find=false;
		int i=0, j=0;
		while(i<proyectos.size() && !find) {
			while(j<proyectos.get(i).getparticipantes().size() && !find) {
				if(proyectos.get(i).getparticipantes().get(j).equals(DNI)){
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
				EscribirProyectos();
				return true;
			}
		}
		else {			
			return false;
		}
	}


	@Override
	public ModeloTablaProyectos creartablaProyectos() {
		
		ModeloTablaProyectos Tp= new ModeloTablaProyectos();
		
		for(int i=0;i<proyectos.size();i++) {
			Tp.addProyecto(proyectos.get(i));
		}
		
		return Tp;
	}
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		TProyecto proyecto=getProyecto(NombreProy);
		boolean acabar= false;
		int i=0;
		while(i<proyecto.getparticipantes().size()) {
			if(proyecto.getparticipantes().get(i).equals(DNI)) {
				acabar=true;
			}
			else {
				i++;
			}
		}
		if(acabar) {
			return false;
		}
		else {
			intercambiarproyectos(DNI, NombreProy, proyectos.indexOf(proyecto));
			EscribirProyectos();
			return true;
		}
	}

	private void intercambiarproyectos(String DNI, String NombreProy, int indice) {
		boolean acabar=false;
		int i=0, j=0;
		while(i<proyectos.size() && !acabar) {		
				while(j<proyectos.get(i).getparticipantes().size() && !acabar){
					if(proyectos.get(i).getparticipantes().get(j).equals(DNI)) {
						proyectos.get(indice).getparticipantes().add(DNI);
						proyectos.get(i).getparticipantes().remove(j);
						acabar=true;
					}					
					j++;
				}
				j=0;
				i++;
			}
		
		}


	@Override
	public void añadirpersona(String DNI, String NombreProy) {	
		getProyecto(NombreProy).getparticipantes().add(DNI);
		EscribirProyectos();
	}
	@Override
	public void GenerarNuevaVersion(String NombreProy) {
		TProyecto proyecto=getProyecto(NombreProy);
		int num= extraerNumeroDeVersion(proyecto.getVersion());
		proyecto.setVersion("Version "+num);
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		String fecha= sdf.format(date);
		proyecto.setFecha(fecha);	
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
	public boolean pasarafabricacion(String NombreProy) {
		TProyecto proyecto=getProyecto(NombreProy);
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
	public List<String> getParticipantesProyecto(String NombreProy) {
		return getProyecto(NombreProy).getparticipantes();
	}
	@Override
	public void ponerenfabricacion(String nombreProy) {
		getProyecto(nombreProy).setFabricacion("SI");
		EscribirProyectos();
	}
		
}
