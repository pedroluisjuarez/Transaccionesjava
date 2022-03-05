package abc5_respaldo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Respaldo{
    
    private static Respaldo instancia;
    
    //Creamos el método para generar la copia
    public void crearBackup() throws IOException{ //puede llamarse crearRespaldo()
        Process proceso = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u sa -p1234 registros"); //aqui pones tu ruta de Mysql , usuario y password
        InputStream entrada = proceso.getInputStream();
        FileOutputStream archivo = new FileOutputStream("CopiadeSeguridad_BD_registros.sql");
        
        byte[] buffer = new byte[3500];
        int byteLeido = entrada.read(buffer);
        
        while(byteLeido > 0){
            archivo.write(buffer,0, byteLeido);
            byteLeido = entrada.read(buffer);
        }
        
        archivo.close();
    }
  
    public static Respaldo getInstance(){
        if(instancia == null){
            instancia = new Respaldo();
        }
        return instancia;
    }
}
