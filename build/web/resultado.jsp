<%-- 
    Document   : resultado
    Created on : 22/05/2023, 09:07:40
    Author     : PTOLEDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Resultado</title>
        <link rel="stylesheet"href="style.css">
    </head>
    <body>
        <nav>
        <div class="logo" style="display: flex; align-items: center;">
         <span style="color:#01939c; font-size:26px; font-weight:bold; letter-spacing: 1px;margin-left: 20px;">Pesquisar</span>
        </div>
        <ul class="nav-links">
            <li class="inputs"><a href="http://localhost:8080/ProjetoPOO/">Voltar</a></li>
        </ul>
    </nav>
        <%
           String msg = (String) request.getAttribute("message");
        %>
        
        <h1 class="resultado"><%out.println(msg);%> realizada com sucesso.</h1>
    </body>
</html>
