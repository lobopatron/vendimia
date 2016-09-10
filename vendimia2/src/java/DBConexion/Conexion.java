package DBConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion 
{
    Connection conex=null;
    Statement sql=null;
// protected Statement stmt;   
    
    public Conexion()
    {
            
    }
    public String Conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conex= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/vendimia", "root","root");
            sql=conex.createStatement(); 
            return "Conexion establecida";
        }
        catch(Exception e)
        {
            return "Conexion no establecida: "+e;
        }
    }
    public Statement getStmt()
    {
        return this.sql;
    }
}