package GestionMedicos.CapaDeIntegracion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import GestionMedicos.CapaDeNegocio.TransDatosClinicos;
import GestionMedicos.CapaDeNegocio.TransPlantilla;

public class DAODatosClinicos extends ModeloPlantilla {
	private ArrayList<String> plantillaDatosClinicos;
	private String ruta;
	private TransPlantilla p;
	TransDatosClinicos dato;
	public DAODatosClinicos(String ruta,TransPlantilla p) throws IOException{
		this.ruta=ruta;
		this.p=p;
	try {
		plantillaDatosClinicos=leerDatos(ruta);
			convertirDatos();
		}catch(IOException e) {
			
		}
	}
	@Override
	public void crearDatos(String dato) {
		String aux[]=dato.split(" ");
		int edad=Integer.parseInt(aux[2]);
		int cantidad=Integer.parseInt(aux[4]);
		 agregarDatosEnAlmacen( new TransDatosClinicos( aux[0],aux[1],edad,aux[3],cantidad));
		
	}
	
	
	public ArrayList<String> getDatosClinicos(){
		return this.plantillaDatosClinicos;
	}
	
	
	private void actualizarDatosEnAlmacen () {
	
		FileWriter fichero = null;

		int cont=0;
	
		try {
			fichero = new FileWriter(ruta);
			
			for(;cont<this.plantillaDatosClinicos.size();cont++) {
				fichero.write(this.plantillaDatosClinicos.get(cont)+"\n" );	
				
			}
		
			fichero.close();
			
		} 
		 catch (IOException e3) {
			 System.out.println("Fallo al actualizar los datos");
			e3.printStackTrace();
		}

	}
	
	public void agregarDatosEnAlmacen(TransDatosClinicos  tablaDatos) {   
		
		String Estudio=p.getEstudio();
		String Pastilla=p.getFarmaco();
		String Etapa=p.getEtapa();
		String ruta="src/BaseDatos/"+Estudio+"_"+Pastilla+"_"+Etapa+".txt";
		
		String d="";
		d+=tablaDatos.getId()+" "+tablaDatos.getSexo()+" "+tablaDatos.getEdad()
		+" "+tablaDatos.getFecha()+" "+tablaDatos.GetCantidad();
		
		String datos="";
		int cont=this.plantillaDatosClinicos.size();
	
		try {
		if(cont!=0){
			for(int i=0;i<cont-1;i++) {
				datos+=this.plantillaDatosClinicos.get(i)+"\n";
			}
			datos+=this.plantillaDatosClinicos.get(cont-1);
			
		}
				agregarDato(datos,d,ruta);
				
		} catch (IOException  e2) {
			System.out.println("fichero no encontrado");
			e2.printStackTrace();
		}
	
		

			
	}
	public void modificarDatos(String  datos,int i) {
		
		this.plantillaDatosClinicos.remove(i);
		this.plantillaDatosClinicos.add(datos);
		actualizarDatosEnAlmacen();
		
		
	}
	public boolean eliminarDatoTabla(String id) {
		boolean encontrado=false;
		int i=0;
		String[] idlista;
		while(!encontrado&& i<this.plantillaDatosClinicos.size()) {
			idlista=this.plantillaDatosClinicos.get(i).split(" ");
			if(id.equals(idlista[0])) {
				encontrado=true;
			}
			else {
				i++;
			}
		}
		if(encontrado) {
		this.plantillaDatosClinicos.remove(i);
		actualizarDatosEnAlmacen();
		}
		return encontrado;
	}
	@Override
	public void convertirDatos() {
	}
	
}
