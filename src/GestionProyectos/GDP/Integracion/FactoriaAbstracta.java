package GestionProyectos.GDP.Integracion;

import java.util.List;

public interface FactoriaAbstracta<T,S> {
      public T CrearObjetoPersona(List<Object> datos);
      public S CrearObjetoProyecto(List<Object> datos);
}
