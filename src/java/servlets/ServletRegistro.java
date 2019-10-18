/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielaMarcela
 */
@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRegistro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       // processRequest(request, response);
       
        PrintWriter out=response.getWriter();
       String usuario=request.getParameter("usuario");
       String genero=request.getParameter("genero");
      
       out.println("<html>");

        
        //background: url('fondo.jpeg') no-repeat center center fixed;
        
         String titulo=null;
            String tipoNavegador=request.getHeader("User-Agent");
            System.out.print("El tipo de navegador es"+tipoNavegador);
            
            if(tipoNavegador!=null&& tipoNavegador.contains("Trident"))
            {
                titulo="Navegador Internet Explorer";
                
            }
            if(tipoNavegador!=null&& tipoNavegador.contains("Firefox"))
            {
                titulo="Navegador Internet Firefox";
                
            }
            if(tipoNavegador!=null&& tipoNavegador.contains("Chrome"))
            {
                titulo="Navegador Internet Chrome";
                
            }
         out.println(" <link rel='stylesheet' type='text/css' href='css/estiloMuestraFinal.css'>");
       out.println("<body>");
       out.println("<center>");
       out.println("<div class='lateral'>");
       out.println("<h2>Bienvenido(a) :</h2>");
        out.println("<br>");
       out.println("<h3>"+ usuario +"<h3>");
        out.println("<br>");
         out.println("<h4>Te damos la bienvenida desde :</h4>"+titulo);
        out.println("<br>");
         out.println("<br>");
        out.println("<a href='index.html' target='_blank'>Iniciar</a>");
       out.println("<br>");
        out.println("<br>");
         out.println("<br>");
       
       out.println("</div>");
       out.println("</center>");
       out.println("<br>");
       out.println("<br>");
       out.println("<br>");
       out.println("</body>");
       out.println("</html>");
       out.close();
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
