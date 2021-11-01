/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.projet.db.AdministrateurDB;
import org.projet.db.CompteDB;
import org.projet.entities.Administrateur;
import org.projet.entities.Compte;
import org.projet.entities.Ensiaste;
import org.projet.entities.Entreprise;


/**
 *
 * @author acer
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String login = request.getParameter("login");
            String mdp = request.getParameter("mdp");
            
            CompteDB db = new CompteDB();
        
            Compte compte = db.logIn(login, mdp);
            
            if (compte != null) {
                HttpSession session = request.getSession();
                session.setAttribute("login", compte.getLogin());
                session.setAttribute("typeCompte",compte.getTypeCompte());
                if(session.getAttribute("typeCompte").equals("student")){
                    CompteDB db3 = new CompteDB();
                    Ensiaste ensiaste =db3.logInEnsiaste(login, mdp);
                    session.setAttribute("id_ensiaste",ensiaste.getId());
                    session.setAttribute("ville",ensiaste.getVille());
                    session.setAttribute("filiere",ensiaste.getFiliere());
                    
                    if (ensiaste.getValidation().equals("new")){
                        response.sendRedirect("registernotvalid.jsp");
                    }else{
                        response.sendRedirect("ensiasteHome.jsp");
                    }
                }
                else{
                    if(session.getAttribute("typeCompte").equals("company")){
                    CompteDB db2 = new CompteDB();
                    Entreprise entreprise= db2.logInEntreprise(login, mdp);
                    session.setAttribute("id_entreprise",entreprise.getId());
                    session.setAttribute("domaine",entreprise.getDomaine());
                    session.setAttribute("nommarque",entreprise.getNomMarque());
                    if (entreprise.getValidation().equals("new")){
                        response.sendRedirect("registernotvalid.jsp");
                    }else{
                        response.sendRedirect("entrepriseHome.jsp");
                    }}
                    else{
                    CompteDB db3 = new CompteDB();
                    Administrateur ad=db3.logInAdmin(login, mdp);
                    session.setAttribute("id_ad",ad.getId_ad());
                    session.setAttribute("nom",ad.getNom());
                    session.setAttribute("prenom",ad.getPrenom());
                    session.setAttribute("cne",ad.getCne());
                    response.sendRedirect("adminHome.jsp");
                    }
                }
               
                }else{
                    out.print("user not found");
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
