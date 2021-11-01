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
import org.projet.db.AdministrateurDB;
import org.projet.db.CompteDB;
import org.projet.db.EnsiasteDB;
import org.projet.db.EntrepriseDB;
import org.projet.entities.Administrateur;
import org.projet.entities.Compte;
import org.projet.entities.Ensiaste;
import org.projet.entities.Entreprise;

/**
 *
 * @author acer
 */
public class RegisterServlet extends HttpServlet {

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
            
            String  typeCompte = request.getParameter("typeCompte");
            String  login = request.getParameter("login");
            String  mdp = request.getParameter("mdp");
            String  email = request.getParameter("email");
            
            Compte compte = new Compte();
            
            compte.setTypeCompte(typeCompte);
            compte.setLogin(login);
            compte.setMdp(mdp);
            compte.setEmail(email);
            CompteDB.save(compte);
            
            
            /*out.println("Données enregistrées avec succès");*/
            if(typeCompte.equals("student")){
                Ensiaste ensiaste= new Ensiaste();
                ensiaste.setTypeCompte(typeCompte);
                ensiaste.setLogin(login);
                ensiaste.setMdp(mdp);
                ensiaste.setEmail(email);
                EnsiasteDB.save1(ensiaste);
            request.getRequestDispatcher("ensiasteProfile.jsp").include(request, response);
            }
            else{
                if(typeCompte.equals("company")){
                Entreprise entreprise =new Entreprise();
                
                entreprise.setTypeCompte(typeCompte);
                entreprise.setLogin(login);
                entreprise.setMdp(mdp);
                entreprise.setEmail(email);
                EntrepriseDB.save1(entreprise);
            request.getRequestDispatcher("entrepriseProfile.jsp").include(request, response);
                }
                else
                {
                  Administrateur a= new Administrateur();
                  
                a.setTypeCompte(typeCompte);
                a.setLogin(login);
                a.setMdp(mdp);
                a.setEmail(email);
                AdministrateurDB.save1(a);
                request.getRequestDispatcher("adminProfile.jsp").include(request, response);
                }
            }
            
            }
            }
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            }
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            }
            @Override
            public String getServletInfo() {
            return "Short description";
            }
            
            
            
            
            
            
    }
