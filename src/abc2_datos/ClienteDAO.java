
package abc2_datos;

import abc1_conexion.Conexion;
import abc3_domain.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAO {
    
    Conexion instanciaMysql = Conexion.getInstance();
    private Connection conexionTransacciones;
    
    private static final String SQL_SELECT = "select * from empleados";
    private static final String SQL_INSERT = "insert into empleados(NOMBRE, TELEFONO, PROFESION, EMAIL, SALDO) value (?,?,?,?,?)";
    private static final String SQL_UPDATE = "update empleados set NOMBRE=?, TELEFONO=?, PROFESION=?, EMAIL=?, SALDO=? where ID = ?";
    private static final String SQL_DELETE = "delete from empleados where ID=?";
    
    public ClienteDAO(){}
    
    public ClienteDAO(Connection conexionTransacciones){
        this.conexionTransacciones = conexionTransacciones;
    }
    
    //metodo para listar datos
    public List<Cliente> Listar(){
        Connection conexiondb = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;
        
        try{
            // conexiondb = instanciaMysql.conectardb();
            //conexion normal
            conexiondb = this.conexionTransacciones != null ? this.conexionTransacciones:instanciaMysql.conectardb();
            
            consulta = conexiondb.prepareStatement(SQL_SELECT);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                int id = resultado.getInt("Id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String profesion = resultado.getString("profesion");
                String email = resultado.getString("email");
                double saldo = resultado.getDouble("saldo");
                
                cliente = new Cliente(id, nombre, telefono, profesion, email, saldo);
                clientes.add(cliente);
                
            }    
        }catch(Exception error){
            System.out.println("error");
        }finally{
            instanciaMysql.cerrarResultado(resultado);
            instanciaMysql.cerrarStament(consulta);
            //instanciaMysql.desconectar(conexiondb);
            //conexion normal
            if(this.conexionTransacciones==null){
                instanciaMysql.desconectar(conexiondb);
            }
        }
        return clientes;
    }
//creacion de metodo para insertar
    public int insertar(Cliente cliente){
        Connection conexiondba = null;
        PreparedStatement consultac = null;
        int registros = 0;
        
        try{
            //conexiondba = instanciaMysql.conectardb();
            conexiondba = this.conexionTransacciones != null ? this.conexionTransacciones:instanciaMysql.conectardb();
            consultac = conexiondba.prepareStatement(SQL_INSERT);
            consultac.setString(1, cliente.getNombre());
            consultac.setString(2, cliente.getTelefono());
            consultac.setString(3, cliente.getProfesion());
            consultac.setString(4, cliente.getEmail());
            consultac.setDouble(5, cliente.getSaldo());
            
            registros = consultac.executeUpdate();
            
        }catch(SQLException error){
            System.out.println(error);
        }finally{
            instanciaMysql.cerrarStament(consultac);
            //instanciaMysql.desconectar(conexiondba);
            if(this.conexionTransacciones==null){
                instanciaMysql.desconectar(conexiondba);
            }
        }
        return registros;
    }
    
//creacion de metodo para modificar
    public int modificar(Cliente cliente){
        Connection conexiondba = null;
        PreparedStatement consultac = null;
        int registros = 0;
        
        try{
            //conexiondba = instanciaMysql.conectardb();
            conexiondba = this.conexionTransacciones != null ? this.conexionTransacciones:instanciaMysql.conectardb();
            consultac = conexiondba.prepareStatement(SQL_UPDATE);
            
            consultac.setString(1, cliente.getNombre());
            consultac.setString(2, cliente.getTelefono());
            consultac.setString(3, cliente.getProfesion());
            consultac.setString(4, cliente.getEmail());
            consultac.setDouble(5, cliente.getSaldo());
            consultac.setInt(6, cliente.getId());
            
            registros = consultac.executeUpdate();
            
        }catch(SQLException error){
            System.out.println(error);
        }finally{
            instanciaMysql.cerrarStament(consultac);
            //instanciaMysql.desconectar(conexiondba);
            if(this.conexionTransacciones==null){
                instanciaMysql.desconectar(conexiondba);
            }
        }
        return registros;
    }
    
    
//creacion de metodo para eliminar
    public int eliminar(Cliente cliente){
        Connection conexiondba = null;
        PreparedStatement consultac = null;
        int registros = 0;
        
        try{
            //conexiondba = instanciaMysql.conectardb();
            conexiondba = this.conexionTransacciones != null ? this.conexionTransacciones:instanciaMysql.conectardb();
            consultac = conexiondba.prepareStatement(SQL_DELETE);

            consultac.setInt(1, cliente.getId());           
            registros = consultac.executeUpdate();
            
        }catch(SQLException error){
            System.out.println(error);
        }finally{
            instanciaMysql.cerrarStament(consultac);
            //instanciaMysql.desconectar(conexiondba);
            if(this.conexionTransacciones==null){
                instanciaMysql.desconectar(conexiondba);
            }
        }
        return registros;
    }
}
