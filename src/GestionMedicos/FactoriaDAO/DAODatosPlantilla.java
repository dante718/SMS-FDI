package GestionMedicos.FactoriaDAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class DAODatosPlantilla extends ModeloPlantilla {
	private static String ruta="src/BaseDatos/plantillas.txt";
	TransPlantilla plantilla;
	private TransPlantilla ListaPlantillas[];
	private ArrayList<String> datos;
	public DAODatosPlantilla() {
		try {
			datos=leerDatos(ruta);
			convertirDatos();
		}catch(IOException e) {
			
		}
	}
	@Override
	public  void crearDatos(String dato) {
		String aux[]=dato.split(" ");
		this.plantilla=new TransPlantilla(aux[0],  aux[1], aux[2]);
		
	}
	@Override
	public void convertirDatos() {
		int cont=Integer.parseInt(datos.get(0));
		this.ListaPlantillas=new TransPlantilla[cont];
		String aux[];
		for(int i=1;i<=cont;i++) {
			aux=datos.get(i).split(" ");
			
				 this.ListaPlantillas[i-1]=new TransPlantilla(aux[0],aux[1], aux[2]);			
						
			
		}
	}
	
	
	public TransPlantilla cargarPlantilla(String estudio, String pastilla, String etapa) {
		//aqui a tendre� que buscar la plantilla desde el almacen voy a buscar con los 3 datos y si lo hay 
		//genero un nombre de fichero en el cual van a estar los datos
		//2 opciones que este creado o que tengamos que crearlo
		crearDatos(estudio+" "+pastilla+" "+etapa);
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
			actualizarPlantillas();
		
		crearFichero("src/BaseDatos/"+estudio+"_"+pastilla+"_"+etapa+".txt");
			return plantilla;
			}
	}
	
	private void actualizarPlantillas() {//escribo una nueva linea
		
		
		String dato=plantilla.getEstudio()+" "+plantilla.getFarmaco()+" "+plantilla.getEtapa()+"\n ";
		int cont=this.ListaPlantillas.length+1;
		String aux=cont+"\n";
		for(int i=0;i<this.ListaPlantillas.length;i++) {

			aux+=this.ListaPlantillas[i].getEstudio()+" "+this.ListaPlantillas[i].getFarmaco()+
					" "+this.ListaPlantillas[i].getEtapa()+"\n";
		}
		try {
			agregarDato(aux,dato,ruta);
		}
		catch(IOException e) {
			System.out.println("fallo al actualizar una plantilla");
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

	
		
}
