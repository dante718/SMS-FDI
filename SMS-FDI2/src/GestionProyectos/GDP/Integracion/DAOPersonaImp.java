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
	private List<TPersona> personas;
    public DAOPersonaImp() {
    	personas= new ArrayList<TPersona>();
    }
    public static DAOPersona getInstancia() {
    	if(instancia==null) {
    		instancia= new DAOPersonaImp();
    	}
    	return instancia;
    }
    public void leerPersonas() {
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
    	 
    }
  
	
	
	public void EscribirPersonas() {
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
    public TPersona getPersona(TPersona Persona) {
   	 for(TPersona p: personas) {
			  if(p.leerDNI().equals(Persona.leerDNI())) return p;
		  }
		  
		  return null;
	}
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
    public void liberar(TPersona persona) {
		LiberarPersona("Disponible", persona);
	}
	private void LiberarPersona(String Estado, TPersona persona) {
		getPersona(persona).updateEstado(Estado);
		EscribirPersonas();
	}
	public void AddProyecto(TProyecto proyecto) {
		updateEstado(proyecto, "No Disponible");
		EscribirPersonas();
	}
	private void updateEstado(TProyecto proyecto, String Estado) {
		for(int i=0, j=0; i<personas.size() && j<proyecto.leerparticipantes().size();i++) {
			if(personas.get(i).leerDNI().equals(proyecto.leerparticipantes().get(j))) {
				personas.get(i).updateEstado(Estado);
				j++;
			}
		}
		
	}
	public void annadiraproyecto(TPersona persona) {
		personas.get(personas.indexOf(persona)).updateEstado("No Disponible");
		EscribirPersonas();
	}
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
	public int getTamPersonas() {		
		return personas.size();
	}

}
