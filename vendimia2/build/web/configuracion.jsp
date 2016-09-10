<%@page import="DBConexion.Validar"%>
<html>
    <head>
        <%
            Validar v = new Validar();
            String conf = v.configuracion();
        %>
        <title>La Vendimia</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="estilos.css" type="text/css" >
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">
            function nuevo() {
                document.getElementById("cont1").style.display = "none";
                document.getElementById("cont2").removeAttribute("style");
            }
            function cancel() {
                document.getElementById("cont1").removeAttribute("style");
                document.getElementById("cont2").style.display = "none";
            }
            function precio(e){
                var letra = e.keyCode || e.which;
                var tecla = String.fromCharCode(letra).toString();
                var letras = " 0123456789.";
                var especiales = [8, 37, 39, 44, 45, 46, 6];
                var tecla_especial = false
                for (var i in especiales) {
                    if (letra == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }
                if (letras.indexOf(tecla) == -1 && !tecla_especial)
                    return false;
            }
        </script>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="#" style="color:white;">Inicio</a>
                    <ul>
                        <li><a href="./index.jsp">Ventas</a></li>
                        <li><a href="./clientes.jsp">Clientes</a></li>
                        <li><a href="./articulos.jsp">Articulos</a></li>
                        <li><a href="./configuracion.jsp">Configuracion</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <%
            if (session.getAttribute("noConfiguracion") != null || session.getAttribute("NoUpConfiguracion") != null) {
        %>
        <div class="avisoMal">
            <h3>
                <%
                    out.print(session.getAttribute("noConfiguracion"));
                    out.print(session.getAttribute("NoUpConfiguracion"));
                %>
            </h3>
        </div>
        <%
            }
            if (session.getAttribute("saveConfiguracion") != null) {
        %>
        <div class="avisoBien">
            <h3>
                <%
                    out.print(session.getAttribute("saveConfiguracion"));
                %>
            </h3>
        </div>
        <%
            }
            session.setAttribute("saveConfiguracion", "");
            session.setAttribute("noConfiguracion", "");
            session.setAttribute("NoUpConfiguracion", "");
        %>
        <section id="cont2">
            <div class="renglon1">Configuracion</div>
            <div id="registro">
                <form action="peticiones" method="post" name="form-articulo">
                    <%=conf%>
                </form>
            </div>
        </section>
    </body>
</html>