package GestionProyectos.GDP.Integracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;



public class DAOPersonaImp implements DAOPersona{
	private static DAOPersona instancia=null;
    public DAOPersonaImp() {
    	
    }
    public static DAOPersona getInstancia() {
    	if(instancia==null) {
    		instancia= new DAOPersonaImp();
    	}
    	return instancia;
    }
	public List<TPersona> leerPersonas() {
		List<TPersona> personas= new ArrayList<TPersona>();
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
    	 return personas;
    }
  
	
	
	public void EscribirPersonas(List<TPersona> personas) {
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

	



}
