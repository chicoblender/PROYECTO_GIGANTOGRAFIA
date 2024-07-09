package basedatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    //atributos
    private final String DRIVER="org.gjt.mm.mysql.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String BD="bdgigantografia";
    private final String USUARIO="root";
    private final String PASSWORD="";
    
   
    public Connection cadena;
    public static Conexion instancia;
    
     //metodos
    private Conexion(){
        this.cadena=null;
    }
    
    public Connection conectar(){
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+BD, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }
    
    public void desconectar(){
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public synchronized static Conexion getInstancia(){
        if (instancia==null) {
            instancia=new Conexion();
        }
        return instancia;
    }
}
