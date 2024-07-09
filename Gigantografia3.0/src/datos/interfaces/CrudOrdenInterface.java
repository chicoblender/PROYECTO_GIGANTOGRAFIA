package datos.interfaces;

import java.util.List;

public interface CrudOrdenInterface <T,D>{
   public List<T> listar(String texto);
   public List<D> listarDetalle(int id);
   public boolean insertar(T obj);
   public boolean actualizar(T obj);
   public boolean anular(int id);
   public int total();
   public boolean existe(String texto);
}
