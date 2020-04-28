package GestionProyectos.GDP.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class GDP_DAOPersonaImp implements GDP_DAOPersona{
	private List<GDP_TPersona> personas;
	private List<GDP_TProyecto> proyectos;
    public GDP_DAOPersonaImp() {
    	personas= new ArrayList<GDP_TPersona>();
    	proyectos= new ArrayList<GDP_TProyecto>();
  
    }

	
    private void leerPersonas() {
    	 try {
         	BufferedReader read= new BufferedReader(new FileReader(new File("src/BaseDatos/Personas.txt")));
 			String line=read.readLine();			
 			while(line!=null) {				
 				String DNI=line;			
 				line=read.readLine();
                 String Nombre=line;
 				line=read.readLine(); 
 				String Apellido1=line;
 				line=read.readLine();
 				String Apellido2=line;
 				line=read.readLine();
 				String Profesion=line;
 				line=read.readLine();
 				String Estado=line;
 				line=read.readLine();
 				String Rol=line;
 				line=read.readLine();		
 				personas.add(new GDP_TPersona(DNI,Nombre,Apellido1,Apellido2,Profesion,Estado,Rol));					
 			}
 			read.close();
 		} catch (IOException e) {			
 			e.printStackTrace();
 		}
    }
    private void leerProyectos() {
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
				int nparticipantes= Integer.parseInt(line);
				line= read2.readLine();
				for(int i=0;i < nparticipantes;i++) {
					personas.add(line);
					line=read2.readLine();
				}
				proyectos.add(new GDP_TProyecto(NombreProy, Descripcion,personas));
				personas.clear();
				line=read2.readLine();
				read2.close();
			}
	    
		}
			catch (IOException e) {	
			e.printStackTrace();
		}
    }
	@Override
	public GDP_ModeloTabla creartabla(String tipo) {
		GDP_ModeloTabla TA=new GDP_ModeloTabla();
        for(int i=0; i<personas.size();i++) {
        	if(personas.get(i).getRol().toLowerCase().equals(tipo)) {
        		TA.addPersonas(personas.get(i));
        	}
        }
		return TA;
	}
	@Override
	public int BuscarProyecto(String nombreProy) {
		int ret=1;	
		boolean find=false;
		try {
			BufferedReader read= new BufferedReader(new FileReader(new File("src/BaseDatos/Proyectos.txt")));
			String line=read.readLine();
			while(line!=null && !find) {			
				if(line.equals(nombreProy)) {
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
	
	
	private void escribirProyectos() {
		int i=0;
		String line=null;
		try {
		BufferedWriter w= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Proyectos.txt")));
		String s="";
		while(i<proyectos.size()) {
			s+=proyectos.get(i).getNombre()+"\n";
			s+=proyectos.get(i).getDescripcion()+"\n";
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
	
	private void escribirPersonas() {
		String s="";
		String line=null;
		int k=0;
		try {
		BufferedWriter w= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Personas.txt")));
		while(k<personas.size()) {			
			s+=personas.get(k).getDNI()+"\n"+personas.get(k).getNombre()+"\n"+personas.get(k).getApellido1()+"\n"+personas.get(k).getApellido2()+"\n"+personas.get(k).getProfesion()+"\n"+personas.get(k).getEstado()+"\n"+personas.get(k).getRol()+"\n";
			k++;
		}
		w.write(s);
		w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void AddProyecto(GDP_TProyecto proyecto) {
		proyectos.add(proyecto);
		escribirProyectos();	
		int i=0, j=0;
		while(i<personas.size() && j<proyecto.getparticipantes().size()) {
				if(personas.get(i).getDNI().equals(proyecto.getparticipantes().get(j))) {
					personas.get(i).setEstado("No Disponible");
					j++;
				}
			   i++;
			}
		escribirPersonas();

	}

	@Override
	public void liberar(String DNI) {
		boolean find=false;
		int i=0;
		while(i<personas.size() && !find) {
			if(personas.get(i).getDNI().equals(DNI)) {
				personas.get(i).setEstado("Disponible");
				find=true;
			}			
			i++;
		}
		escribirPersonas();
	}

	@Override
	public void leerdatos() {
		leerPersonas();
		leerProyectos();
	}



}
