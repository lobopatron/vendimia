<%@page import="DBConexion.Validar"%>
<html>
    <head>
        <%
            Validar v = new Validar();
            String clie = v.selec_clientes();
            String Art = v.selec_articulos();
            String art = v.selec_folleto();
            String confi = v.conf();
            String ventas=v.ventas_activas();
        %>
        <title>La Vendimia</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="estilos.css" type="text/css" >
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript">
            var items = [<%out.println(art);%>];
            var totalTr = 0;
            var tasa =<%=confi%>[0];
            var plazo =<%=confi%>[1];
            var enganche =<%=confi%>[2];
            var bandera = false;
            function nuevo() {
                document.getElementById("cont1").style.display = "none";
                document.getElementById("cont2").removeAttribute("style");
            }
            function cancel() {
                document.getElementById("rfccliente").removeAttribute("style");
                document.getElementById("cont2").style.display = "none";
            }
            function rfc(c) {
                document.getElementById("rfccliente").value = c;
                document.getElementById("rfccliente").removeAttribute("style");
            }
            function arr() {
                var art = document.getElementById("art_vent").value;
                var tr = document.createElement('tr');
                tr.setAttribute("id", items[art - 1][0]);
                tr.innerHTML = "<td>" + items[art - 1][1] + "</td>\n\
        <td>" + items[art - 1][2] + "</td>\n\
<td><input type=\"text\" id=\"numArt\" name=\"numArt\" style=\"width:2em;\" onchange=\"comparar(this);\" class=\"input\" required> \n\
/" + items[art - 1][4] + "</td>\n\
<td style=\"display:none;\">" + items[art - 1][4] + "</td>\n\
<td>" + Math.round((((items[art - 1][3]) * (1 + ((tasa * plazo) / 100))) * 100) / 100) + "</td>\n\
<td name=\"importe\"></td>\n\
<td id=\"cancelar\"><label class='fa fa fa-times-circle fa-lg' for='cancel' aria-hidden='true'></label>\n\
<input type=\"button\" id=\"cancel\" name=\"agregarArt\" value=\"\" style=\"display: none;\" onclick=\"cancelar(" + items[art - 1][0] + ");\" >";
                document.getElementById('tbody').appendChild(tr);
                totalTr++;
                tr.getElementsByTagName('input')[0].focus();
                document.getElementById("totales").removeAttribute("style");
                document.getElementById("siguiente").removeAttribute("style");
            }
            function comparar(nodo) {
                var nodoTd = nodo.parentNode; //Nodo TD
                var nodoTr = nodoTd.parentNode; //Nodo TR
                var nodosEnTr = nodoTr.getElementsByTagName('td');
                var numero = parseFloat(nodo.value);
                var existe = parseFloat(nodosEnTr[4].textContent);
                if (numero <= existe) {
                    nodosEnTr[5].textContent = numero * existe;
                } else {
                    alert("Solo existen " + nodosEnTr[3].textContent + " articulos");
                    nodoTr.getElementsByTagName('input')[0].value = "";
                    nodoTr.getElementsByTagName('input')[0].focus();
                }
                enganch();
            }
            function enganch() {
                var eng = document.getElementById("enganche");
                var nodosTd = document.getElementsByName("importe");
                var e = 0;
                for (i = 0; i < nodosTd.length; i++) {
                    e = e + parseFloat(nodosTd[i].textContent)
                }
                eng.value = parseFloat(parseFloat((enganche / 100) * e)).toFixed(2);
                bonifica();
            }
            function bonifica() {
                var eng = document.getElementById("enganche");
                var bon = document.getElementById("boni");
                bon.value = parseFloat(eng.value * (parseFloat(tasa * plazo) / 100)).toFixed(2);
                totales();
            }
            function totales() {
                var total = document.getElementById("total");
                var eng = document.getElementById("enganche");
                var bon = document.getElementById("boni");
                var nodosTd = document.getElementsByName("importe");
                var e = 0;
                for (i = 0; i < nodosTd.length; i++) {
                    e = e + parseFloat(nodosTd[i].textContent)
                }
                total.value = (parseFloat(e - eng.value - bon.value).toFixed(2));
            }
            function cancelar(name) {
                var elemento = document.getElementById(name);
                if (confirm('¿desea quitarlo?') == true) {
                    padre = elemento.parentNode;
                    padre.removeChild(elemento);
                    totalTr--;
                    if (totalTr == 0) {
                        document.getElementById("totales").style.display = "none";
                        document.getElementById("siguiente").style.display = "none";
                    }
                    enganch();
                }
            }
            function verifica() {
                var elemento = document.getElementById("numArt");
                var elemento2 = document.getElementById("select");
                var elemento3 = document.getElementById("art_vent");
                var ok = true;
                if (elemento.value == null || elemento.value == 0 || elemento.value == "0") {
                    alert("La cantidad ingresada sea mayor a cero");
                    elemento.value = "";
                    elemento.focus();
                    ok = false;
                }
                if (elemento2.value == null || elemento2.value == "") {
                    alert("Seleccione un cliente");
                    elemento2.value = "";
                    elemento2.focus();
                    ok = false;
                }
                if (totalTr == 0) {
                    alert("Seleccione al menos un articulo");
                    elemento3.value = "";
                    elemento3.focus();
                    ok = false;
                }
                if (ok == true) {
                    document.getElementById("abonos").removeAttribute("style");
                    abonos();
                }
            }
            function abonos() {
                if (bandera == false) {
                    bandera = true;
                    var art = document.getElementById("tabonos");
                    var c = "";
                    var pContado = 0;
                    var tPagar = 0;
                    var abono = 0;
                    var ahorro = 0;
                    var mAbonos = [3, 6, 9, 12];
                    var total = document.getElementById("total").value;
                    pContado = parseFloat((((total) / (1 + ((tasa * plazo) / 100))) * 100) / 100).toFixed(2);
                    for (i = 0; i < mAbonos.length; i++) {
                        tPagar = parseFloat(pContado * (1 + (parseFloat(tasa) * parseFloat(mAbonos[i])) / 100)).toFixed(2);
                        abono = parseFloat(parseFloat(tPagar) / parseFloat(mAbonos[i])).toFixed(2);
                        ahorro = parseFloat(total - tPagar).toFixed(2);
                        var tr = document.createElement('tr');
                        c = '<td><label for="' + mAbonos[i] + 'abonos">' + mAbonos[i] + ' ABONOS DE</label></td><td><label for="' + mAbonos[i] + 'abonos">$ <div>' + abono + '</div></label></td><td><label for="' + mAbonos[i] + 'abonos">TOTAL A PAGAR $ <div>' + tPagar + '</div></label></td><td><label for="' + mAbonos[i] + 'abonos">SE AHORRA $ <div>' + ahorro + '</div></label></td><td><input name="abono" id="abono" onclick="check(this.value);" value="' + tPagar + '" type="radio"></td>';
                        tr.innerHTML = c;
                        art.appendChild(tr);
                    }
                } else {
                    if (!document.getElementById("abono").checked) {
                        alert("Selecciona un Plazo de abono");
                    }
                }
            }
            
            function check(e) {
                document.getElementById("saveVenta").type = "submit";
                document.getElementById("tPagar").value=e;
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
        <section id="cont1">
            <div id="newvent">
                <input id="new_venta" type="button" name="boton" value="Nueva Venta" onclick="nuevo();">
            </div>
            <table>
                <caption>Ventas Activas</caption>
                <thead>
                    <tr>
                        <th>Folio Venta</th>
                        <th>Folio Cliente</th>
                        <th>Nombre</th>
                        <th>Total</th>
                        <th>Fecha</th>
                        <th>Estatus</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%=ventas%>
                </tbody>
            </table>
        </section>
        <form action="peticiones" method="post" name="form-articulo">
            <section id="cont2" style="display: none;">
                <div class="renglon1">Registro de Ventas</div>
                <div id="registro">
                    <div class="renglon_venta">
                        <div class="label">
                            Cliente:
                        </div>
                        <div class="label_input">
                            <select id="select" name="cliente" onchange="rfc(this.value);" required>
                                <%=clie%>
                            </select>
                        </div>
                        <div class="label_input">
                            <input type="text" id="rfccliente" name="cliVenta" class="input" placeholder="RFC">
                        </div>
                    </div>
                    <div class="renglon_venta">
                        <div class="label">
                            Articulo:
                        </div>
                        <div class="label_input">
                            <select id="art_vent" name="articulo_venta" class="form__select2" required>
                                <%=Art%>
                            </select>
                        </div>
                        <div class="label_input">
                            <label class='fa fa-plus-square fa-lg' for="agregaArt" aria-hidden='true'>Agregar</label>
                            <input type="button" id="agregaArt" name="agregarArt" value="" style="display: none;" onclick="arr();" >
                        </div>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Descripcion Articulo</th>
                                <th>Modelo</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Importe</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                        </tbody>
                    </table>
                    <div id="totales" style="display: none;">
                        <div class="precios">
                            <label> Enganche:</label> <input type="text" id="enganche" value="0" name="enganche" class="input" placeholder="Enganche">
                        </div>
                        <div class="precios">
                            <label>Bonificacion Enganche:</label> <input type="text" value="0" id="boni" name="bonificacion" class="input" placeholder="Bonificacion de Enganche">
                        </div>
                        <div class="precios">
                            <label>Total: </label><input type="text" id="total" value="0" name="total" class="input" placeholder="Total">
                        </div>
                    </div>
                    <section id="abonos" class="abonos" style="display: none;">
                        <table>
                            <caption>Abonos Mensuales</caption>
                            <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="tabonos">

                            </tbody>
                        </table>
                    </section>
                    <div id="siguiente" class="siguiente" style="display: none;">
                        <div class="label">
                            <label for="canVenta">Cancelar </label>
                            <input style="display: none;" type="button" id="canVenta" class="input" value="Cancelar" onclick="cancelar();">
                        </div>
                        <div class="label">
                            <label for="saveVenta">Siguiente </label>
                            <input name="tPagar" id="tPagar" style="display: none;" value="0">
                            <input style="display: none;" type="button" id="saveVenta" name="saveVenta" onclick="verifica();" class="input" value="Siguiente">
                        </div>
                    </div> 
                </div>
            </section>
        </form>
    </body>
</html>
