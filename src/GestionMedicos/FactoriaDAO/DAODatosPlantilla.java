package GestionMedicos.FactoriaDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class DAODatosPlantilla {
	private static String ruta="src/BaseDatos/plantillas.txt";
	
	private TransPlantilla ListaPlantillas[];
	
	public DAODatosPlantilla() {
	LeerDatos();

	}
	
	public void LeerDatos() {
		String datos;
		BufferedReader buffer = null;
		String Es = "", Etpa = "";
		String Past=" ";
	
		
		try {
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			ListaPlantillas =new TransPlantilla[Integer.parseInt(buffer.readLine())];
			int i=0;
			 while((datos=buffer.readLine())!=null) {
				 int numTokens = 0;
				 int cont=0;
				 StringTokenizer st = new StringTokenizer (datos);

			        // bucle por todas las palabras
			     while (st.hasMoreTokens()){
			        	if(cont==0)
			        		Es = st.nextToken();
			        	if(cont==1){
			        		Past = st.nextToken();
			        	}
			        	if(cont==1) {
			        		Etpa = st.nextToken();
			        	}
			        	cont++;
			            numTokens++;
			        }
			      ListaPlantillas[i]=new TransPlantilla(Es,Past,Etpa);
			      i++;
			 }
					
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
	}
		
		
	
	public TransPlantilla CrearPlantilla (String estudio, String farmaco,String etapa) {
		return new TransPlantilla(estudio,  farmaco, etapa);
		
	}
	
	public TransPlantilla cargarPlantilla(String estudio, String pastilla, String etapa) {
		//aqui a tendre� que buscar la plantilla desde el almacen voy a buscar con los 3 datos y si lo hay 
		//genero un nombre de fichero en el cual van a estar los datos
		//2 opciones que este creado o que tengamos que crearlo
		TransPlantilla plantilla=  CrearPlantilla(estudio,pastilla, etapa);
		boolean encontrado=false;
		int i=0;
		while((!encontrado)&&(i<this.ListaPlantillas.length)) {
			if(this.ListaPlantillas[i].equals(plantilla)){
				encontrado=true;
			}
			else {
				i++;
			}
			
		}
		
		if(encontrado) {
			return this.ListaPlantillas[i];
		}
		else {
			actualizarPlantillas(plantilla);
			//tengo que crear el fichero
		crearFichero("src/BaseDatos/"+estudio+"_"+pastilla+"_"+etapa+".txt");
			return plantilla;
			}
	}
	private void  crearFichero(String ruta) {
		File file=new File(ruta);
		try {
			if(!file.exists()) {

				file.createNewFile();
				
			}
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		System.out.println("IMPOSIBLE CREAR FICHERO");
			//e.printStackTrace();
		}
		
	}
	public void actualizarPlantillas(TransPlantilla p) {
		FileWriter fichero = null;
		try {
		
			fichero = new FileWriter(ruta);
			int aux=ListaPlantillas.length+1;
			fichero.write(""+aux+"\n");
			for(int i=0;i<this.ListaPlantillas.length;i++) {

				fichero.write(this.ListaPlantillas[i].getEstudio()+" "+this.ListaPlantillas[i].getFarmaco()+
						" "+this.ListaPlantillas[i].getEtapa()+"\n");
			}
			fichero.write(p.getEstudio()+" "+p.getFarmaco()+
					" "+p.getEtapa()+"\n");
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

	
		
}
