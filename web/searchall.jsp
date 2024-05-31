<%-- 
    Document   : searchall
    Created on : 25 de mai. de 2024, 12:10:05
    Author     : joaos
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css"/>
    <title>ProjetoPOO</title>
    <script src="script.js" defer></script>
</head>
<body>
    <nav>
        <div class="logo" style="display: flex; align-items: center;">
         <span style="color:#01939c; font-size:26px; font-weight:bold; letter-spacing: 1px;margin-left: 20px;">Lista de itens</span>
        </div>
        <ul class="nav-links">
            <li class="inputs"><a href="http://localhost:8080/ProjetoPOO/">Voltar</a></li>
        </ul>
    </nav>
    <main class="content">
        <%
            List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");
        %>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPU</th>
                <th>Memória</th>
                <th>GPU</th>
                <th>Polegadas</th>
                <th>Resolução</th>
                <th>Wi-fi</th>
                <th>Bluetooth</th>
                <th>NumPad</th>
            </tr>
               
            <%for (Produto p : lprod) {%>
            <tr>
                <td><%out.print(p.getId());%></td>
                    <td><%out.print(p.getnome());%></td>
                    <td><%out.print(p.getCPU());%></td>
                    <td><%out.print(p.getram());%></td>
                    <td><%out.print(p.getplacavdo());%></td>
                    <td><%out.print(p.gettela());%></td>
                    <td><%out.print(p.getresolucao());%></td>
                    <td><%out.print(p.getwifi());%></td>
                    <td><%out.print(p.getbluetooth());%></td>
                    <td><%out.print(p.getnumpad());%></td>
                </tr>
                <%}%>
        </table>
    </main>
    <footer>
        <P>Desenvolvido por Erico Marin e João Salustiano</P>
    </footer>
</body>
</html>
