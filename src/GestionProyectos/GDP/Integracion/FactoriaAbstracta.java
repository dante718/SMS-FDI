package GestionProyectos.GDP.Integracion;

import java.util.List;

import GestionProyectos.GDP.Presentacion.IVista;

public interface FactoriaAbstracta<T,S> {
      public T CrearObjetoPersona(List<Object> datos);
      public S CrearObjetoProyecto(List<Object> datos);
      public IVista CrearObjetoVista(String tipo);
}
