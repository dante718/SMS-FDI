package GestionMedicos.FactoriaDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DAOIncidencias extends ModeloPlantilla {
	private ArrayList<String> listaIncidencias;
	private String ruta;
	public DAOIncidencias(){
		//leer
		ruta="src/BaseDatos/IncidenciasMedicos.txt";
		try {
		listaIncidencias=leerDatos(ruta);//leerIncidencias(ruta);
		}
		catch(IOException e) {
			System.out.println("Error al cargar las incidencias");
		}
	}
	
	public ArrayList<String> leerIncidencias(String r) throws IOException {
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(r)));
		String cadena=" ";
		ArrayList<String> l=new ArrayList<String>();
		while((cadena=buffer.readLine())!=null) {
			
			l.add(cadena);
			
		}
		buffer.close();
		return l;
		
	}
	
	//guardar
	private void guardar(ArrayList<String> d,String r) {
		FileWriter fichero = null;
		String datos="";
	
	
		try {
			
			for(int i=0;i<d.size();i++) {
				datos+=d.get(i)+"\n";
			}
			
			fichero = new FileWriter(r);
			fichero.write(datos);
			fichero.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		 catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	
	}
	//crear
	public boolean crearInforme(String informe) {
		boolean confirmacion=false;
	try {
		
		
			ArrayList<String>l=leerIncidencias("src/BaseDatos/IncidenciasInformatico.txt");
			l.add(informe);
			guardar(l,"src/BaseDatos/IncidenciasInformatico.txt");
			confirmacion=true;
			
			

	} catch (IOException e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return confirmacion;
	}
	public String  consultarInforme(boolean todos, String id) {
		try {
			listaIncidencias=leerIncidencias(ruta);
		} catch (IOException e) {
			System.out.println("error al actualizar");
		}
		String datos="";
		if(todos) {
			for(int i=0; i<this.listaIncidencias.size();i++) {
				datos+=this.listaIncidencias.get(i)+"\n";
			}
			
		}
		else {
			boolean encontrado=false;
			int i=0;
			String[] aux;
		
			while((!encontrado )&&(i<this.listaIncidencias.size())) {
				aux=this.listaIncidencias.get(i).split(" ");
				if((id.contentEquals(aux[0]))) {
					encontrado=true;
					
						datos=this.listaIncidencias.get(i)+"\n";
					
			
				}
				else {
					i++;
				}
			}
			
		}
		return datos;	
		
	}

	@Override
	public void crearDatos(String dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertirDatos() {
		// TODO Auto-generated method stub
		
	}
	
}
