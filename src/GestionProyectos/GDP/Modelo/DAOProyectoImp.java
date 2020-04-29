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

import javax.swing.JOptionPane;

public class DAOProyectoImp implements DAOProyecto{
       private List<TProyecto> proyectos;
       
       public DAOProyectoImp() {
    	   proyectos= new ArrayList<TProyecto>();
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
				line= read2.readLine();
				for(int i=0;i < nparticipantes;i++) {
					personas.add(line);
					line=read2.readLine();
				}
				proyectos.add(new TProyecto(NombreProy, Descripcion,personas, Version, Fecha, MododeFabricacion));
				personas = new ArrayList<String>();	
				line=read2.readLine();
				read2.close();
			}
	    
		}
			catch (IOException e) {	
			e.printStackTrace();
		}
    }
	  public int BuscarProyecto(String Nombre) {
			int ret=1;	
			boolean find=false;
			try {
				BufferedReader read= new BufferedReader(new FileReader(new File("src/BaseDatos/Proyectos.txt")));
				String line=read.readLine();
				while(line!=null && !find) {			
					if(line.equals(Nombre)) {
						ret=-1;
						find=true;
					}			
					line=read.readLine();
				}
				read.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		
			return ret;
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
				j++;	
			}
			i++;
		}
		
		if(find) {
			if(proyectos.get(i-1).getparticipantes().size()==1) {
				return false;
			}
			else {
				proyectos.get(i-1).getparticipantes().remove(j-1);
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


}
