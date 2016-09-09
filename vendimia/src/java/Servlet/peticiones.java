package Servlet;

import DBConexion.Validar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConexion.sentencias;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

/**
 *
 * @author Patron
 */
@WebServlet(name = "peticiones", urlPatterns = {"/peticiones"})
public class peticiones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("logout.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession respuesta = request.getSession(true);
        Calendar fechahoy = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = fechahoy.get(Calendar.DATE) + "-" + (fechahoy.get(Calendar.MONTH) + 1) + "-" + fechahoy.get(Calendar.YEAR);
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet peticiones</title>");
        out.println("</head>");
        out.println("<body>");

        String boton = request.getParameter("saveArticulo");
        String respon = "";
        if (boton != null) {
            sentencias s = new sentencias();
            Boolean a;
            String descri = request.getParameter("descarticulo");
            String modelo = request.getParameter("modarticulo");
            String precio = request.getParameter("precio");
            String existe = request.getParameter("exist");
            try {
                a = s.nuevo_articulo(descri, modelo, precio, existe);
                if (a != true) {
                    out.print("nada");
                }
            } catch (Exception e) {
                out.print("error");
            }
            respon = "./articulos.jsp";
        }
        String updArticulo = request.getParameter("updArticulo");
        if (updArticulo != null) {
            sentencias s = new sentencias();
            Boolean a;
            String clave = request.getParameter("clavee");
            String descri = request.getParameter("moddescarticulo");
            String modelo = request.getParameter("modmodarticulo");
            String precio = request.getParameter("modprecio");
            String existe = request.getParameter("modexist");
            try {
                a = s.mod_articulo(clave, descri, modelo, precio, existe);
                if (a != true) {
                    out.print("nada");
                }
            } catch (Exception e) {
                out.print("error");
            }
            out.print(updArticulo + ", " + descri + ", " + modelo + ", " + precio + ", " + existe);
            respon = "./articulos.jsp";
        }

        String saveCliente = request.getParameter("saveCliente");
        if (saveCliente != null) {
            try {
                sentencias s = new sentencias();
                Boolean a;
                String nombre = request.getParameter("nom_cliente");
                String aPaterno = request.getParameter("aPaterno_cliente");
                String aMaterno = request.getParameter("aMaterno_cliente");
                String rfc = request.getParameter("rfc_cliente");
                a = s.nuevo_cliente(nombre, aPaterno, aMaterno, rfc);
                if (a != true) {
                    out.print("nada");
                }
            } catch (Exception ex) {
                out.print("error");
            }
            respon = "./clientes.jsp";
        }
        String updCliente = request.getParameter("updCliente");
        if (updCliente != null) {
            sentencias s = new sentencias();
            Boolean a;
            String clave = request.getParameter("clavee");
            String nombre = request.getParameter("modnombre");
            String aPaterno = request.getParameter("modaPaterno");
            String aMaterno = request.getParameter("modaMaterno");
            String rfc = request.getParameter("modrfc");
            try {
                a = s.mod_cliente(clave, nombre, aPaterno, aMaterno, rfc);
                if (a != true) {
                    out.print("nada en clientes");
                }
                out.print(" ... " + updCliente + ", " + clave + ", " + nombre + ", " + aMaterno + ", " + aPaterno);
            } catch (Exception e) {
                out.print("error");
            }
            respon = "./clientes.jsp";
        }

        String saveconf = request.getParameter("saveConf");
        if (saveconf != null) {
            sentencias s = new sentencias();
            Boolean a;
            String tasaFin = request.getParameter("tasaFin");
            String enganche = request.getParameter("enganche");
            String pazoMax = request.getParameter("pazoMax");
            try {
                a = s.configuracion(tasaFin, enganche, pazoMax);
                if (a != true) {
                    out.print("nada en configuracion");
                }
            } catch (Exception e) {
                out.print("error");
            }

            respon = "./configuracion.jsp";
        }
        String updConf = request.getParameter("updConf");
        if (updConf != null) {
            sentencias s = new sentencias();
            Boolean a;
            String clave = request.getParameter("idconf");
            String tasaFin = request.getParameter("tasaFin");
            String enganche = request.getParameter("enganche");
            String pazoMax = request.getParameter("pazoMax");
            try {
                a = s.mod_conf(clave, tasaFin, enganche, pazoMax);
                if (a != true) {
                    out.print("nada en clientes");
                }
            } catch (Exception e) {
                out.print("error");
            }

            respon = "./configuracion.jsp";
        }
        String saveVenta = request.getParameter("saveVenta");
        if (saveVenta != null) {
            Boolean a;
            Validar v = new Validar();
            String clave = request.getParameter("cliente");
            String total = request.getParameter("tPagar");
            a = v.registrar_venta(clave, total, fecha);
            if (a != true) {
                out.print("nada en registrar venta");
            }
            respon = "./index.jsp";
        }
        out.println("</body>");
        out.println("</html>");
        response.sendRedirect(respon);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
