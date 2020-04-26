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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


public class GDP_DAOPersonaImp implements GDP_DAOPersona{
	//(Metodo alternativo) Atributos que use para acceder a la bse de datos de mysql
    /*private PreparedStatement ps;
    private ResultSet rs;
    private Connection cn;*/
	private List<GDP_TPersona> personas;
	private List<GDP_TProyecto> proyectos;
	private String [] NIFS;
    public GDP_DAOPersonaImp() {
    	personas= new ArrayList<GDP_TPersona>();
    	proyectos= new ArrayList<GDP_TProyecto>();
    	/*
    	ps=null;
    	rs=null;
    	cn=GDP_Conexion.getConexion();
    	*/
    }

	public void inidatos() {
		try {
					
		String line=null;
		BufferedReader read2= new BufferedReader(new FileReader(new File("src/BaseDatos/Proyectos.txt")));
		line=read2.readLine();
	    int tamNif=0;	
		while(line!=null) {
			String NombreProy=line;
			line=read2.readLine();
			String Descripcion=line;
			line=read2.readLine();
			int nparticipantes= Integer.parseInt(line);
			tamNif+=nparticipantes;
			proyectos.add(new GDP_TProyecto(NombreProy, Descripcion,nparticipantes));
			line=read2.readLine();
		}
							
		read2.close();
		NIFS= new String[tamNif];
		BufferedReader read3= new BufferedReader(new FileReader(new File("src/BaseDatos/PersonaldeProyectos.txt")));
		line=read3.readLine();
		int i=0, j=0,n=0, k=0;
		while(line!=null) {		
			if(k==n) {
				k=0;
				if(line.equals(proyectos.get(i).getNombre())) {
					n=proyectos.get(i).getNparticipantes();
					i++;
				}
				line=read3.readLine();
			}			
			NIFS[j]=line;
			j++;
			k++;
			line=read3.readLine();			
		}	
		read3.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public TableModel leerdatosini(String tipo) {
		GDP_TableModel TA=new GDP_TableModel();
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
				if(Rol.toLowerCase().equals(tipo.toLowerCase())) {
					personas.add(new GDP_TPersona(DNI,Nombre,Apellido1,Apellido2,Profesion,Estado,Rol));
					TA.addPersonas(new GDP_TPersona(DNI,Nombre,Apellido1,Apellido2,Profesion,Estado,Rol));
				}
			}
			read.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		/*
		 //(Metodo alternativo) Acceso a la base de datos
		try {
			ps= cn.prepareStatement("SELECT * FROM personas");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(7).toLowerCase().equals(tipo.toLowerCase())) {
					TA.addPersonas(new GDP_TPersona(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
				}
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}*/
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
		/*
		 //(Metodo alternativo)Acceso a la informacion con la base de datos
        try {
			ps= cn.prepareStatement("SELECT Nombre FROM proyectos WHERE Nombre = ?");
			ps.setString(1,nombreProy);
			rs=ps.executeQuery();	
		   if(!rs.next()) {
			   ret=1;
		   }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/		
		return ret;
	}
	@Override
	public void CrearProyecto(GDP_TProyecto proyecto, List<GDP_TPersona> participantes) {
		int i=0;
	    try {
	    	String line=null;
			BufferedWriter write1= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Proyectos.txt")));
			String s1="";
			while(i<proyectos.size()) {
				s1+=proyectos.get(i).getNombre()+"\n";
				s1+=proyectos.get(i).getDescripcion()+"\n";
				s1+=proyectos.get(i).getNparticipantes()+"\n";
				i++;
			}
			
			if(!s1.equals("")) {
				write1.write(s1);
			}
			write1.write(proyecto.getNombre()+"\n");
			write1.write(proyecto.getDescripcion()+"\n");
			write1.write(proyecto.getNparticipantes()+"\n");
			write1.close();
			
			
			BufferedWriter write2= new BufferedWriter(new FileWriter(new File("src/BaseDatos/PersonaldeProyectos.txt")));
			
			String s2="";
			int f=0,g=0, h=0, n=0;
			while(h<this.NIFS.length) {
				if(f==n) {
					f=0;
					s2+=proyectos.get(g).getNombre()+"\n";
					n=proyectos.get(g).getNparticipantes();
					g++;
				}
				s2+=(this.NIFS[h]+"\n");
				f++;
				h++;
			}
			if(!s2.equals("")) {
				write2.write(s2);
			}

			write2.write(proyecto.getNombre()+"\n");
			for(int j=0;j<participantes.size();j++) {				
				write2.write(participantes.get(j).getDNI()+"\n");	
			}			
			write2.close();
			
			BufferedWriter write3= new BufferedWriter(new FileWriter(new File("src/BaseDatos/Personas.txt")));
			
		
			String s3="";
			int j=0, k=0;

			while(k<personas.size()) {
				line=personas.get(k).getEstado();
				if(j<participantes.size() && personas.get(k).getDNI().equals(participantes.get(j).getDNI())) {
					line="No Disponible";
					j++;
				}			
				s3+=personas.get(k).getDNI()+"\n"+personas.get(k).getNombre()+"\n"+personas.get(k).getApellido1()+"\n"+personas.get(k).getApellido2()+"\n"+personas.get(k).getProfesion()+"\n"+line+"\n"+personas.get(k).getRol()+"\n";
				k++;
			}
			write3.write(s3);
			write3.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		/*
		//(Metodo alternativo)Añadir proyecto a la base de datos  
		try {
			ps= cn.prepareStatement("SELECT DNI FROM personas");
			rs= ps.executeQuery();
			
			while(rs.next() && i<proyecto.getPersonal().size()) {
				if(rs.getString(1).equals(proyecto.getPersonal().get(i).getDNI())) {
					i++;
				}
			}
			if(i!=proyecto.getPersonal().size()) {
				return false;
			}
			
			ps= cn.prepareStatement("INSERT INTO proyectos(Nombre,Descripcion) VALUES(?,?)");
			
			ps.setString(1, proyecto.getNombre());
			ps.setString(2, proyecto.getDescripcion());
			
			ps.execute();
			
			ps= cn.prepareStatement("INSERT INTO proypersonas(DNI, NombreProy) VALUES(?,?)");
	       for(int j=0; j<proyecto.getPersonal().size();j++) {		
			   ps.setString(1, proyecto.getPersonal().get(j).getDNI());
			   ps.setString(2, proyecto.getNombre());	   
			   ps.execute();
	       }
	       
	       
	       ps=cn.prepareStatement("UPDATE personas SET Estado= ? WHERE DNI= ?");
	       String s="No Disponible";
	       for(int k=0; k<proyecto.getPersonal().size();k++) {		
			   ps.setString(1, s);
			   ps.setString(2, proyecto.getPersonal().get(k).getDNI());	   
			   ps.execute();
	       }			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		*/

	}



}
