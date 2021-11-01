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
import org.projet.db.EntrepriseDB;
import org.projet.entities.Entreprise;

/**
 *
 * @author acer
 */
public class ModifierEntrepriseServlet extends HttpServlet {
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
            
            
            String RaisonSocial = request.getParameter("RaisonSocial");
            String NomMarque = request.getParameter("NomMarque");
            String StatutJuridique = request.getParameter("StatutJuridique");
            String capital = request.getParameter("capital");
            String effectif = request.getParameter("effectif");
            String domaine = request.getParameter("domaine");
            
            String  id_entreprise = request.getParameter("id_entreprise");
            Entreprise en = new Entreprise();
            en.setId(id_entreprise);
            en.setRaisonSocial(RaisonSocial);
            en.setNomMarque(NomMarque);
            en.setStatutJuridique(StatutJuridique);
            en.setCapital(capital);
            en.setEffectif(effectif);
            en.setDomaine(domaine);
            boolean test = EntrepriseDB.update(en);
            if(test){
                request.getRequestDispatcher("entrepriseHome.jsp").include(request, response);
                
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
