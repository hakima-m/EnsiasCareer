package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.CommentaireDB;
import org.projet.db.EntrepriseDB;
import org.projet.db.RatingDB;
import org.projet.entities.Commentaire;
import org.projet.entities.Entreprise;
import org.projet.entities.Rating;

/**
 *
 * @author acer
 */
public class ModifierCommentaireServlet extends HttpServlet {
    public static int identreprise;
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
            out.println("<title>Servlet ModifierStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String  comment =   request.getParameter("comment");
            String id_ensiaste =request.getParameter("id_ensiaste");;
            String id_offre = request.getParameter("id_offre");;
            
            
            Commentaire c = new Commentaire();

            c.setComment(comment);
            c.setId_offre(id_offre);
            c.setId_ensiaste(id_ensiaste);
            
            String  rating = request.getParameter("rating");
    
    
            Rating rt = new Rating();
            rt.setId_ensiaste(Integer.parseInt(id_ensiaste));
            rt.setId_offre(Integer.parseInt(id_offre));
            rt.setRateindex(Float.parseFloat(rating));
            
            boolean test = CommentaireDB.update(c);
            boolean test1 = RatingDB.update(rt);
            if(test && test1){
                request.getRequestDispatcher("afficherMore.jsp").include(request, response);
                
            }else{
                out.println("operation failed");
            }
            
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
