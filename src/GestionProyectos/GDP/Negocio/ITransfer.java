package GestionProyectos.GDP.Negocio;

import java.util.List;

public interface ITransfer<T> {
        public T crearObjeto(List<Object> datos);
}
