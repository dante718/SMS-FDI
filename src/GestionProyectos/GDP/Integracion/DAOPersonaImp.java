package GestionProyectos.GDP.Integracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import GestionProyectos.GDP.Negocio.FactoriaTransfer;
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
		List<Object> datospersona= new ArrayList<Object>();
    	 try {
         	BufferedReader read= new BufferedReader(new FileReader(new File("src/BaseDatos/Personas.txt")));
 			String line=read.readLine();			
 			while(line!=null) {				
 				String DNI=line;			
 				line=read.readLine();
 				datospersona.add(DNI);
                String Nombre=line;
 				line=read.readLine(); 
 				datospersona.add(Nombre);
 				String Apellido1=line;
 				line=read.readLine();
 				datospersona.add(Apellido1);
 				String Apellido2=line;
 				line=read.readLine();
 				datospersona.add(Apellido2);
 				String Profesion=line;
 				line=read.readLine();
 				datospersona.add(Profesion);
 				String Estado=line;
 				line=read.readLine();
 				datospersona.add(Estado);
 				String Rol=line;
 				line=read.readLine();
 				datospersona.add(Rol);
 				personas.add(FactoriaTransfer.getInstancia().CrearObjetoPersona(datospersona));
 				datospersona= new ArrayList<Object>();
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
			s+=personas.get(k).leerDNI()+"\n"+personas.get(k).leerNombre()+"\n"+personas.get(k).leerApellido1()+"\n"+personas.get(k).leerApellido2()+"\n"+personas.get(k).leerProfesion()+"\n"+personas.get(k).leerEstado()+"\n"+personas.get(k).leerRol()+"\n";
			k++;
		}
		w.write(s);
		w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	



}
