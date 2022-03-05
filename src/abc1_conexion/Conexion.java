
package abc1_conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private Conexion(){}
    
    //creacion de una variable para guardar el estado de conexion de la base de datos
    private static Connection dbconexion;
    
    //variable para crear una sola instancia
    private static Conexion instanciac;
    
    //variable para conectarse a la bd 
    private static final String URL= "jdbc:mysql://localhost:3306/registros";
    private static final String USUARIO= "sa";
    private static final String CONTRASENA= "12345";
    
    
    //metod para conectar a la base de datos
    public Connection conectardb(){
    
        try{
            //cargando el driver, conectar a la bd
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbconexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            /*JOptionPane.showInputDialog(null, "CONEXION EXITOSA!!");*/
            return dbconexion;
            
        }catch(Exception ees){
          JOptionPane.showInputDialog(null, "Error: " + ees);
        }
        return dbconexion; 
    }
    
    public void cerrarResultado(ResultSet resultado){
        try{
            resultado.close();
        }catch(SQLException error){
            System.out.println(error);
        }
    }
    
    
    public void desconectar(Connection conexion){
        try{
            conexion.close();
        }catch(SQLException error){
            System.out.println(error);
        }
    }
    
        public void cerrarStament(PreparedStatement statement){
        try{
            statement.close();
        }catch(SQLException error){
            System.out.println(error);
        }
    }
    
    

    //metodo (cerrar)
    /*public void CerrarConexion() throws SQLException{
        try{
            dbconexion.close();
            JOptionPane.showInputDialog(null, "Se Desconecto!!! ");
            
        }catch(Exception ees){
          JOptionPane.showInputDialog(null, "Error: " + ees);
          dbconexion.close();
        }finally{
            dbconexion.close();
        }
    }*/
    
    //patron singleton
    public static Conexion getInstance(){
        if(instanciac ==null){
            instanciac = new Conexion();
        }
        return instanciac;
    } 
    
}
