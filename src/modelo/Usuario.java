package modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private double identificacion;
    private String user;
    private String password;

    //Constructor vacio
    public Usuario() {

    }

    // constructor de agregar
    public Usuario(String nombre, String apellido, double identificacion, String user, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.user = user;
        this.password = password;
    }
    
    //Constructor para actualizar si lo necesitamos con el código

    public Usuario(int id, String nombre, String apellido, double identificacion, String user, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.user = user;
        this.password = password;
    }
    // getter y setter  --  Modificadores de acceso


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}// Fin de la clase Usuario

