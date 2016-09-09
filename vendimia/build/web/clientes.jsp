<%@page import="DBConexion.Validar"%>
<html>
    <%
        Validar v= new Validar();
        String cli=v.clientes();
        String modCli=request.getParameter("modCli");
        String modiCli="";
        String cont1="style=\"display:none;\"",cont2="style=\"display:none;\"",cont3="style=\"display:none;\"";
        try{
            modiCli=v.mod_clientes(Integer.parseInt(modCli));
            cont1="style=\"display:none;\"";
            cont2="style=\"display:none;\"";
            
        }catch(Exception e){
            cont1="";
        }
    %>
    <head>
        <title>La Vendimia</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="estilos.css" type="text/css" >
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">
            function nuevo() {
                document.getElementById("cont1").style.display = "none";
                document.getElementById("cont2").removeAttribute("style");
            }
            function cancelar() {
                document.getElementById("cont1").removeAttribute("style");
                document.getElementById("cont2").style.display = "none";
                document.getElementById("cont3").style.display = "none";
            }
            function numeros(e)
            {
                var keynum = window.event ? window.event.keyCode : e.which;
                if ((keynum == 8) || (keynum == 46))
                    return true;
                return /\d/.test(String.fromCharCode(keynum));
            }
            function precio(numero)
            {
                var val = /^\d+(?:\.\d{0,2})$/;
                if (val.test(numero))
                    alert("Numero incorrecto");
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
        <section id="cont1" <%=cont1%>>
            <div id="newvent">
                <input id="new_venta" type="button" name="boton" value="Nuevo Cliente" onclick="nuevo();">
            </div>
            <table>
                <caption>Clientes Registrados</caption>
                <thead>
                    <tr>
                        <th>Clave Cliente</th>
                        <th>Nombre</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%=cli%>
                </tbody>
            </table>
        </section>
        <section id="cont2" <%=cont2%>>
            <div class="renglon1">Registro de Clientes</div>
            <div id="registro">
                <form action="peticiones" method="post" name="form-articulo">
                    <div class="renglon">
                        <div class="label">
                            Nombre:
                        </div>
                        <div class="label_input">
                            <input type="text" id="busclien" name="nom_cliente" class="input" placeholder="Nombre" required>
                        </div>
                    </div>
                    <div class="renglon">
                        <div class="label">
                            Apellido Paterno:
                        </div>
                        <div class="label_input">
                            <input type="text" id="busclien" class="input" name="aPaterno_cliente" placeholder="Apellido Paterno" required>
                        </div>
                    </div>
                    <div class="renglon">
                        <div class="label">
                            Apellido Materno:
                        </div>
                        <div class="label_input">
                            <input type="text" id="busclien" class="input" name="aMaterno_cliente" placeholder="Apellido Materno" >
                        </div>
                    </div>
                    <div class="renglon">
                        <div class="label">
                            RFC:
                        </div>
                        <div class="label_input">
                            <input type="text" id="busclien" class="input" name="rfc_cliente" placeholder="R.F.C." required>
                        </div>
                    </div>
                    <div class="renglon">
                        <div class="label">
                            <input type="submit" id="busclien" name="saveCliente" class="input" value="Guardar">
                        </div>
                        <div class="label_input">
                            <input type="button" id="busclien" class="input" value="Cancelar" onclick="cancelar();">
                        </div>
                    </div>
                </form>
            </div>
        </section>
                <%out.print(modiCli);%>
    </body>
</html>