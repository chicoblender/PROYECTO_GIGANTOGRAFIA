
package basedatos;


public class PruebaConexion {

    public static void main(String[] args) {
        Conexion con=Conexion.getInstancia();
        con.conectar();
        if (con.cadena!=null) {
            System.out.println("Conectado con exito"+con.cadena);
            
        }else{
            System.out.println("No se pudo conectar a la BD, revise los datos de conexion, "+con.cadena);
        }
    }
    
}
