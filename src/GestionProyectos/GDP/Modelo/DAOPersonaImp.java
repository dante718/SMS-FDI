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


public class DAOPersonaImp implements DAOPersona{
	private List<TPersona> personas;
	
    public DAOPersonaImp() {
    	personas= new ArrayList<TPersona>();
    }

	public void leerPersonas() {
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
 				personas.add(new TPersona(DNI,Nombre,Apellido1,Apellido2,Profesion,Estado,Rol));					
 			}
 			read.close();
 		} catch (IOException e) {			
 			e.printStackTrace();
 		}
    }
  
	@Override
	public ModeloTablaPersona creartablaPersonas(String tipo) {
		ModeloTablaPersona TA= new ModeloTablaPersona();
        for(int i=0; i<personas.size();i++) {
        	if(personas.get(i).getRol().toLowerCase().equals(tipo)) {
        		TA.addPersonas(personas.get(i));
        	}
        }
		return TA;
	}
	
	public void EscribirPersonas() {
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
	public void AddProyecto(TProyecto proyecto) {	
		int i=0, j=0;
		while(i<personas.size() && j<proyecto.getparticipantes().size()) {
				if(personas.get(i).getDNI().equals(proyecto.getparticipantes().get(j))) {
					personas.get(i).setEstado("No Disponible");
					j++;
					i=0;
				}
				else {
					i++;
				}
			}
		EscribirPersonas();
	}

	@Override
	public void LiberarPersonadeProyecto(String DNI) {
		boolean find=false;
		int i=0;
		while(i<personas.size() && !find) {
			if(personas.get(i).getDNI().equals(DNI)) {
				personas.get(i).setEstado("Disponible");
				find=true;
			}			
			i++;
		}
		EscribirPersonas();
	}


}
