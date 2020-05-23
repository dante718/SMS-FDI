package GestionDeFabrica.Modelo;

public interface Observable<T> {

	void addObserver(T o);
	void removeObserver(T o);
}
