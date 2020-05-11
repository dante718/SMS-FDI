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

import GestionProyectos.GDP.Negocio.FabricaTransfer;
import GestionProyectos.GDP.Negocio.TProyecto;


public class DAOProyectoImp implements DAOProyecto{
       private static DAOProyecto instancia=null;
       private DAOProyectoImp() {
    	   
       }
       public static DAOProyecto getInstancia() {
    	   if(instancia==null) {
    		   instancia= new DAOProyectoImp();
    	   }
    	   return instancia;
       }
            
	  public List<TProyecto> leerProyectos() {
		List<TProyecto> proyectos= new ArrayList<TProyecto>();
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
				proyectos.add((TProyecto) FabricaTransfer.getInstancia().getTransfer("Proyecto", datosproyecto));
				personas = new ArrayList<String>();
				datosproyecto= new ArrayList<Object>();
				line=read2.readLine();
			}
			read2.close();
		}
			catch (IOException e) {	
			e.printStackTrace();
		}
		return proyectos;
    }

	public void EscribirProyectos(List<TProyecto> proyectos) {
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


		
}
