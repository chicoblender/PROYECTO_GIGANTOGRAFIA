package entidades;
import java.sql.Date;

public class Usuario {
    //atributos
    private int id;
    private int rolId;
    private String rolNombre;
    private String nombres;
    private String apellidos;
    private String ci;
    private String email;
    private String clave;
    private Date fechaNacimiento;
    private String foto;
    private boolean activo;
    
    //metodos

    public Usuario() {
    }

    public Usuario(int id, int rolId, String rolNombre, String nombres, String apellidos, String ci, String email, String clave, Date fechaNacimiento, String foto, boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.email = email;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.activo = activo;
    }

    public Usuario(int id, int rolId, String rolNombre, String nombres, String apellidos, String ci, String email, boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.email = email;
        this.activo = activo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", rolId=" + rolId + ", rolNombre=" + rolNombre + ", nombres=" + nombres + ", apellidos=" + apellidos + ", ci=" + ci + ", email=" + email + ", clave=" + clave + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto + ", activo=" + activo + '}';
    }

    
}
