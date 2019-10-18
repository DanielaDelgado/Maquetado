/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DanielaMarcela
 */
@WebServlet(name = "ServletInicioSesionAdmin", urlPatterns = {"/ServletInicioSesionAdmin"})
public class ServletInicioSesionAdmin extends HttpServlet {

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
            out.println("<title>Servlet ServletInicioSesionAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInicioSesionAdmin at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
           HttpSession sesion= request.getSession();
           
            
        
        //Simulando valores 
        String usuarioCorrecto ="Giuliano";
        String passwordCorrecto ="123456789";
        
        String pUsuario=request.getParameter("usuario");
        String pPassword=request.getParameter("password");
        if(usuarioCorrecto.equals(pUsuario)&& passwordCorrecto.equals(pPassword))
        {
             boolean nuevoUsuario=true;
        
        Cookie[] cookies=request.getCookies();
        
        if(cookies != null)
        {
            for(Cookie c : cookies)
            {
                if(c.getName().equals("visitanteRecurrente")
                        && c.getValue().equals("si"))
                {
                    nuevoUsuario=false;
                    break;
                }
            }
        }
        
        String mensaje=null; 
        if(nuevoUsuario)
        {
            Cookie visitanteCookie= new Cookie ("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            
            mensaje="Gracias por visitar nuestro sitio";
           
            
        }
        else
        {
            mensaje="Gracias por visitar NUEVAMENTE nuestro sitio";
           
        }
        response.setContentType("text/html");
            
            //muestra
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioServlet</title>");            
            out.println("</head>");
            out.println(" <link rel='stylesheet' type='text/css' href='css/estiloMuestraFinal.css'>");
            out.println("<body>");
             out.println("<center>");
       out.println("<div class='lateral'>");
            out.println("<h1> Datos correctos: "+mensaje +"<h1>"
                    +"<h3>"
                    + "<br> Usuario: " + pUsuario
                    + "<br> Password: "+ pPassword
           
                    + "<br> ID sesion: "+ sesion.getId()
                    + "</h3>");
             out.println("<br>");
         out.println("<br>");
        out.println("<a href='index.html' target='_blank'>Iniciar Admin</a>");
       out.println("<br>");
        out.println("<br>");
         out.println("<br>");
             
            out.println("</div>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
             
        }
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
