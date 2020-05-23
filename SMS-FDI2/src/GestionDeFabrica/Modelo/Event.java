package GestionDeFabrica.Modelo;

public abstract class Event implements Comparable<Event> {

	Event(){
		
	}
	
	abstract void execute(MapaFabrica mapa);
}
