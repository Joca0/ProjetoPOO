<%-- 
    Document   : search
    Created on : 25 de mai. de 2024, 13:33:35
    Author     : joaos
--%>
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
         <span style="color:#01939c; font-size:26px; font-weight:bold; letter-spacing: 1px;margin-left: 20px;">Pesquisar</span>
        </div>
        <ul class="nav-links">
            <li class="inputs"><a href="http://localhost:8080/ProjetoPOO/">Voltar</a></li>
        </ul>
    </nav>
        <%
            Produto p = (Produto) request.getAttribute("p");
        %>
        <%if (p.getnome() != null) {%>
    <main class="content">
        <section class="forms">
            <form method="get" action="ProdutoControle">
                <ul class="lista_forms">
                    <h1>Insira os dados do Produto</h1>
                    <li class="form_input">
                        <label>Insira o ID para a pesquisa:</label>
                        <input type="text" name="pesquisaID" value="<%out.print(p.getId());%>" size="78">
                    </li>
                    <li class="form_input">
                        <label>Nome do Produto:</label>
                        <input type="text" name="nomeprod" value="<%out.print(p.getnome());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Processador:</label>
                        <input type="text" name="CPU" value="<%out.print(p.getCPU());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Memoria RAM:</label>
                        <input type="text" name="RAM" value="<%out.print(p.getram());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Placa de vídeo:</label>
                        <input type="text" name="GPU" value="<%out.print(p.getplacavdo());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Polegadas da tela:</label>
                        <input type="text" name="Tela" value="<%out.print(p.gettela());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Resolução:</label>
                        <input type="text" name="resolucao" value="<%out.print(p.getresolucao());%>"size="78">
                    </li>
                    <li class="form_input">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" value="<%out.print(p.getdescricao());%>"size="78">
                    </li>
                    <div class="checkbox_div">
                        <li class="form_input">
                            <label class="container_check">Possuí Wi-fi?</label>   
                            <input type="text" name="wifi" size="78" value="<%out.print(p.getwifi());%>">                 
                        </li>
                        <li class="form_input">
                            <label class="container_check">Possuí Bluetooth?</label>    
                            <input type="text" name="bt" size="78" value="<%out.print(p.getbluetooth());%>">
                        </li>
                        <li class="form_input">
                            <label class="container_check">Possuí teclado numerico?</label> 
                            <input type="text" name="numpad" size="78" value="<%out.print(p.getnumpad());%>">   
                        </li>
                    </div>
                    <div class="buttons">
                        <button class="submits" type="submit" name="Botao" value="deletar">Deletar</button>
                        <button class="submits" type="submit" name="Botao" value="consultarID">Consultar</button>
                        <button class="submits" type="submit" name="Botao" value="atualizar">Atualizar</button>
                    </div>
                </ul>
            </form>
            <%} else {%>
            <h2 class="resultado">Produto não encontrado.</h2>
            <%}%>        
        </section>
    </main>
    <footer>
        <P>Desenvolvido por Erico Marin e João Salustiano</P>
    </footer>
</body>
</html>

