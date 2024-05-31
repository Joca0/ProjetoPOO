/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Produto;
import DAO.ProdutoDAO;
import java.util.List;

/**
 *
 * @author joaos
 */
@WebServlet(name = "ProdutoControle", urlPatterns = {"/ProdutoControle"})
public class ProdutoControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto();
            String botao = request.getParameter("Botao");
            
            if (botao.equals("cadastrar")) {
                String nomeprod = request.getParameter("nomeprod");
                String processador = request.getParameter("CPU");
                String ram = request.getParameter("RAM");
                String GPU = request.getParameter("GPU");
                String tela = request.getParameter("Tela");
                String resolucao = request.getParameter("resolucao");
                String descricao = request.getParameter("descricao");
                String wifi = request.getParameter("wifi");
                String bt = request.getParameter("bt");
                String numpad = request.getParameter("numpad");
                
                
                p.setnome(nomeprod);
                p.setCPU(processador);
                p.setram(ram);
                p.setplacavdo(GPU);
                p.settela(tela);
                p.setresolucao(resolucao);
                p.setdescricao(descricao);
                p.setwifi(wifi);
                p.setbluetooth(bt);
                p.setnumpad(numpad);
                String msg = "Ação";
               
                try {
                    pdao.cadastrar(p);
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else if (botao.equals("deletar")) {
                int id = Integer.parseInt(request.getParameter("pesquisaID"));
                
                p.setId(id);
                String msg = "Ação";
                try {
                    pdao.deletar(p);
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }    
            } else if (botao.equals("consultarID")) {
                int id = Integer.parseInt(request.getParameter("pesquisaID"));
                p.setId(id);
                try {
                    p = pdao.consultarById(p);
                    request.setAttribute("p", p );
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound" + ex.getMessage());
                }
            } else if (botao.equals("consultartodos")) {
                try {
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("searchall.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (botao.equals("atualizar")) {
                int id = Integer.parseInt(request.getParameter("pesquisaID"));
                String nomeprod = request.getParameter("nomeprod");
                String processador = request.getParameter("CPU");
                String ram = request.getParameter("RAM");
                String GPU = request.getParameter("GPU");
                String tela = request.getParameter("Tela");
                String resolucao = request.getParameter("resolucao");
                String descricao = request.getParameter("descricao");
                String wifi = request.getParameter("wifi");
                String bt = request.getParameter("bt");
                String numpad = request.getParameter("numpad");
                
                p.setnome(nomeprod);
                p.setCPU(processador);
                p.setram(ram);
                p.setplacavdo(GPU);
                p.settela(tela);
                p.setresolucao(resolucao);
                p.setdescricao(descricao);
                p.setwifi(wifi);
                p.setbluetooth(bt);
                p.setnumpad(numpad);
                p.setId(id);
                String msg = "Ação";
                try {
                    pdao.atualizar(p);
                    System.out.println("Atualizado com sucesso!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound " + ex.getMessage());
                    request.setAttribute("message", msg); 
                    request.getRequestDispatcher("erro.jsp").forward(request,response);
                }
                
            }
                
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
