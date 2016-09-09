package DBConexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sentencias extends Conexion {

    public sentencias() {
        Conectar();
    }
    ResultSet resultado;
    boolean b = false;

    public boolean nuevo_articulo(String descri, String modelo, String precio, String existe) throws Exception {
        try {
            if (modelo.isEmpty()) {
                modelo = "";
            }
            getStmt();
            sql.execute("INSERT INTO `vendimia`.`articulo` ( `descripcion`, `modelo`, `precio`, `existencia`)"
                    + " VALUES ('" + descri + "', '" + modelo + "', '" + precio + "', '" + existe + "');");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }

    public ResultSet existencia_articulos() throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.articulo;");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }

    public ResultSet modificar_articulos(int i) throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.articulo where clave='" + i + "';");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }

    public boolean mod_articulo(String clave, String descri, String modelo, String precio, String existe) throws Exception {
        try {
            if (modelo.isEmpty()) {
                modelo = "";
            }
            getStmt();
            sql.execute("UPDATE `vendimia`.`articulo` SET `descripcion`='" + descri + "', `modelo`='" + modelo + "', `precio`='" + precio + "', `existencia`='" + existe + "' WHERE `clave`='" + clave + "';");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }

    public boolean nuevo_cliente(String nombre, String aPaterno, String aMaterno, String rfc) throws Exception {
        try {
            if (aMaterno.isEmpty()) {
                aMaterno = "";
            }
            getStmt();
            sql.execute("INSERT INTO `vendimia`.`clientes` (`nombre`, `aPaterno`, `aMaterno`, `rfc`)"
                    + " VALUES ('" + nombre + "', '" + aPaterno + "', '" + aMaterno + "', '" + rfc + "');");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }

    public ResultSet existencia_clientes() throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.clientes;");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }

    public ResultSet modificar_cliente(int i) throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.clientes where clave='" + i + "';");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }

    public boolean mod_cliente(String clave, String nombre, String aPaterno, String aMaterno, String rfc) throws Exception {
        try {
            if (aMaterno.isEmpty()) {
                aMaterno = "";
            }
            getStmt();
            sql.execute("UPDATE `vendimia`.`clientes` SET `nombre`='" + nombre + "', `aPaterno`='"+aPaterno+"', `aMaterno`='" + aMaterno + "', `rfc`='" + rfc + "' WHERE `clave`='1';");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }
    public ResultSet configuracion() throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.configuracion;");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean configuracion(String tasaFin, String enganche, String plazoMax) throws Exception {
        try {
            getStmt();
            sql.execute("INSERT INTO `vendimia`.`configuracion` (`por_enganche`, `plazo`, `tasa_fin`)"
                    + " VALUES ('"+enganche+"', '"+plazoMax+"', '"+tasaFin+"');");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }
    public boolean mod_conf(String clave, String tasaFin, String enganche, String plazoMax) throws Exception {
        try {
            getStmt();
            sql.execute("UPDATE `vendimia`.`configuracion` SET `por_enganche`='"+enganche+"', `plazo`='"+plazoMax+"', `tasa_fin`='"+tasaFin+"'"
                    + " WHERE `id`='"+clave+"';");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }
    public boolean save_venta(String cliente, String cliVenta, String total, String fecha) throws Exception {
        try {
            getStmt();
            sql.execute("INSERT INTO `vendimia`.`ventas` (`clave cliente`, `nombre`, `total`, `fecha`)"
                    + " VALUES ('"+cliente+"', '"+cliVenta+"', '"+total+"', '"+fecha+"');");
            return true;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return false;
        }
    }
    public ResultSet buscar_cliente(String rfc) throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.clientes where rfc='"+rfc+"';");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }
    public ResultSet ventas_activas() throws Exception {
        try {
            getStmt();
            resultado = sql.executeQuery("SELECT * FROM vendimia.ventas;");
            return resultado;
        } catch (SQLException ex) {
            System.err.println("error en: " + ex.getMessage());
            return null;
        }
    }
}