
package abc3_domain;


public class Cliente {
    
    private int id;
    private String nombre;
    private String telefono;
    private String profesion;
    private String email;
    private double saldo;
    
    //constructores

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombre, String telefono, String profesion, String email, double saldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.profesion = profesion;
        this.email = email;
        this.saldo = saldo;
    }

    public Cliente(int id, String nombre, String telefono, String profesion, String email, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.profesion = profesion;
        this.email = email;
        this.saldo = saldo;
    }

    public Cliente() {
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
   public String toString(){
       return "\n\nIdCliente: " + id +
               "\nNombre:" + nombre +
               "\nTelefono: " + telefono + 
               "\nProfesion: " + profesion +
               "\nemail: "+ email +
               "\nSaldo: " + saldo;
   } 
    
    
}
