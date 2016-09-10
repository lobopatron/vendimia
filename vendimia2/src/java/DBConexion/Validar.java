package DBConexion;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validar {

    private final sentencias s = new sentencias();
    private ResultSet rs;

    public String articulos() {
        String series = "";
        try {
            rs = s.existencia_articulos();
            while (rs.next()) {
                series = series + "<tr><td>" + rs.getString("clave") + "</td><td>" + rs.getString("descripcion")
                        + "</td><td><form action=\"articulos.jsp\" method=\"post\" name=\"form-articulo\">"
                        + "<label class='fa fa-pencil-square-o' aria-hidden='true' for='" + rs.getString("clave") + "'>"
                        + "Editar<input type='submit' id='" + rs.getString("clave") + "' name='modArt' class='input' value='" + rs.getString("clave") + "' style='display:none;'>"
                        + "</label></form></td></tr>";
            }
            return series;
        } catch (Exception e) {
            return series;
        }
    }

    public String mod_articulos(int i) {
        String series = "";
        try {
            rs = s.modificar_articulos(i);
            while (rs.next()) {
                series = series + "<section id=\"cont3\">\n"
                        + "            <div class=\"renglon1\">Modificar Articulo</div>\n"
                        + "            <div id=\"registro\">\n"
                        + "                <form action=\"peticiones\" method=\"post\" name=\"form-modarticulo\">\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Descripcion:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" name=\"clavee\" class=\"input\" value=\"" + rs.getString("clave") + "\" style= \"display:none;\" required>\n"
                        + "                            <input type=\"text\" id=\"busclien\" name=\"moddescarticulo\" class=\"input\" value=\"" + rs.getString("descripcion") + "\" placeholder=\"Descripcion del articulo\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Modelo:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modmodarticulo\" value=\"" + rs.getString("modelo") + "\" placeholder=\"Modelo del articulo\">\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Precio:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modprecio\" value=\"" + rs.getString("precio") + "\" placeholder=\"Precio del articulo\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Existencia:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modexist\" value=\"" + rs.getString("existencia") + "\" placeholder=\"Articulos en existencia\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            <input type=\"submit\" id=\"busclien\" name=\"updArticulo\" class=\"input\" value=\"Guardar\">\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"button\" id=\"busclien\" class=\"input\" value=\"Cancelar\" onclick=\"cancelar();\">\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </form>\n"
                        + "            </div>\n"
                        + "        </section>";
            }
            return series;
        } catch (Exception e) {
            return series;
        }
    }

    public String clientes() {
        String series = "";
        try {
            rs = s.existencia_clientes();
            while (rs.next()) {
                series = series + "<tr><td>" + rs.getString("clave") + "</td><td>" + rs.getString("nombre")
                        + "</td><td><form action=\"clientes.jsp\" method=\"post\" name=\"form-articulo\">"
                        + "<label class='fa fa-pencil-square-o' aria-hidden='true' for='" + rs.getString("clave") + "'>"
                        + "Editar<input type='submit' id='" + rs.getString("clave") + "' name='modCli' class='input' value='" + rs.getString("clave") + "' style='display:none;'>"
                        + "</label></form></td></tr>";
            }
            return series;
        } catch (Exception e) {
            return series;
        }
    }

    public String mod_clientes(int i) {
        String series = "";
        try {
            rs = s.modificar_cliente(i);
            while (rs.next()) {
                series = series + "<section id=\"cont3\">\n"
                        + "            <div class=\"renglon1\">Modificar Cliente</div>\n"
                        + "            <div id=\"registro\">\n"
                        + "                <form action=\"peticiones\" method=\"post\" name=\"form-modarticulo\">\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Nombre:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" name=\"clavee\" class=\"input\" value=\"" + rs.getString("clave") + "\" style= \"display:none;\" required>\n"
                        + "                            <input type=\"text\" id=\"busclien\" name=\"modnombre\" class=\"input\" value=\"" + rs.getString("nombre") + "\" placeholder=\"Nombre del cliente\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Apellido Paterno:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modaPaterno\" value=\"" + rs.getString("aPaterno") + "\" placeholder=\"Apellido Paterno\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            Apellido Materno:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modaMaterno\" value=\"" + rs.getString("aMaterno") + "\" placeholder=\"Apellido Materno\">\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            R.F.C.:\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"text\" id=\"busclien\" class=\"input\" name=\"modrfc\" value=\"" + rs.getString("rfc") + "\" placeholder=\"RFC del cliente\" required>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"renglon\">\n"
                        + "                        <div class=\"label\">\n"
                        + "                            <input type=\"submit\" id=\"busclien\" name=\"updCliente\" class=\"input\" value=\"Guardar\">\n"
                        + "                        </div>\n"
                        + "                        <div class=\"label_input\">\n"
                        + "                            <input type=\"button\" id=\"busclien\" class=\"input\" value=\"Cancelar\" onclick=\"cancelar();\">\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </form>\n"
                        + "            </div>\n"
                        + "        </section>";
            }
            return series;
        } catch (Exception e) {
            return series;
        }

    }

    public String configuracion() {
        String conf = "", tasa = "", enganche = "", plazo = "", boton = "saveConf", id = "";

        try {
            rs = s.configuracion();
            while (rs.next()) {
                if (!rs.getString("tasa_fin").isEmpty() || !rs.getString("por_enganche").isEmpty() || !rs.getString("plazo").isEmpty()||rs.getString("tasa_fin")!=null|| rs.getString("por_enganche")!=null || rs.getString("plazo")!=null) {
                    id = rs.getString("id");
                    tasa = rs.getString("tasa_fin");
                    enganche = rs.getString("por_enganche");
                    plazo = rs.getString("plazo");
                    boton = "updConf";
                }            }
            conf = conf + "<div class=\"renglon\">\n"
                    + "                        <div class=\"label\">\n"
                    + "                            Tasa de Financiamiento\n"
                    + "                        </div>\n"
                    + "                        <div class=\"label_input\">\n"
                    + "                            <input type=\"text\" id=\"busclien\" name=\"idconf\" value=\"" + id + "\" class=\"input\" style=\"display:none;\">\n"
                    + "                            <input type=\"text\" id=\"busclien\" name=\"tasaFin\" value=\"" + tasa + "\" class=\"input\" onkeypress=\"return precio(event);\" required>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"renglon\">\n"
                    + "                        <div class=\"label\">\n"
                    + "                            % de Enganche:\n"
                    + "                        </div>\n"
                    + "                        <div class=\"label_input\">\n"
                    + "                            <input type=\"text\" id=\"busclien\" class=\"input\" value=\"" + enganche + "\" name=\"enganche\" onkeypress=\"return precio(event);\" required>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"renglon\">\n"
                    + "                        <div class=\"label\">\n"
                    + "                            Plazo Maximo:\n"
                    + "                        </div>\n"
                    + "                        <div class=\"label_input\">\n"
                    + "                            <input type=\"text\" id=\"busclien\" class=\"input\" value=\"" + plazo + "\" name=\"pazoMax\" onkeypress=\"return precio(event);\" required>\n"
                    + "                        </div>\n"
                    + "                    </div>"
                    + "                    <div class=\"renglon\">\n"
                    + "                        <div class=\"label\">\n"
                    + "                            <input type=\"submit\" id=\"busclien\" name=\"" + boton + "\" class=\"input\" value=\"Guardar\">\n"
                    + "                        </div>\n"
                    + "                        <div class=\"label_input\">\n"
                    + "                            <input type=\"button\" id=\"busclien\" class=\"input\" value=\"Cancelar\" onclick=\"cancelar();\">\n"
                    + "                        </div>\n"
                    + "                    </div>";

        } catch (Exception e) {
            conf = conf + "nada";
        }
        return conf;
    }

    public String selec_clientes() {
        String clien = "<option value=\"\" hidden>Clientes</option>";
        try {
            rs = s.existencia_clientes();
            while (rs.next()) {
                clien = clien + "<option value=\"" + rs.getString("rfc") + "\">" + rs.getString("clave") + " - " + rs.getString("nombre") + " " + rs.getString("aPaterno") + " " + rs.getString("aMaterno") + " </option>";
            }
            return clien;
        } catch (Exception e) {
            return clien;
        }
    }

    public String selec_articulos() {
        String articulos = "<option value=\"\" hidden>Articulos</option>";
        try {
            rs = s.existencia_articulos();
            while (rs.next()) {
                articulos = articulos + "<option value=\"" + rs.getString("clave") + "\">" + rs.getString("descripcion") + "</option>";
            }
        } catch (Exception e) {

        }
        return articulos;
    }

    public String selec_folleto() {
        String articulos = "";
        try {
            rs = s.existencia_articulos();
            while (rs.next()) {
                articulos = articulos + "['" + rs.getString("clave")
                        + "','" + rs.getString("descripcion")
                        + "','" + rs.getString("modelo")
                        + "','" + rs.getString("precio")
                        + "','" + rs.getString("existencia") + "'],";
            }
        } catch (Exception e) {
        }
        return articulos;
    }

    public String conf() {
        String p = "";
        String tasa = "";
        String plazo = "";
        String enganche = "";
        try {
            rs = s.configuracion();
            while (rs.next()) {
                tasa = rs.getString("tasa_fin");
                plazo = rs.getString("plazo");
                enganche = rs.getString("por_enganche");
            }
            p = "['" + tasa + "','" + plazo + "','" + enganche + "']";
        } catch (Exception ex) {
            
        }
        return p;
    }

    public boolean registrar_venta(String cliente, String total, String fecha) {
        boolean a=false;
        String nombre="";
        String clave="";
        try {
            rs = s.buscar_cliente(cliente);
            while (rs.next()) {
                nombre = rs.getString("nombre");
                clave = rs.getString("clave");
            }
            a=s.save_venta(clave, nombre, total, fecha);
        } catch (Exception e) {
        }
        return a;
    }
    public String ventas_activas(){
        String tr = "";
        try {
            rs = s.ventas_activas();
            while (rs.next()) {
                tr=tr+"<tr><td>"+rs.getString("idventas")+" </td>"
                        + "<td>"+rs.getString("clave")+"</td>"
                        + "<td>"+rs.getString("nombre")+"</td>"
                        + "<td>"+rs.getString("total")+"</td>"
                        + "<td>"+rs.getString("fecha")+"</td></tr>";
            }
        } catch (Exception ex) {
            
        }
        return tr;
    }
}
