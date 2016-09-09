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