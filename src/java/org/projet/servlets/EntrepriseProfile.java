package org.projet.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.projet.entities.Entreprise;
import org.projet.db.EntrepriseDB;


public class EntrepriseProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
    
    String  NomMarque = request.getParameter("NomMarque");
    String  RaisonSocial = request.getParameter("RaisonSocial");
    String StatutJuridique = request.getParameter("StatutJuridique");
    String capital = request.getParameter("capital");
    String effectif = request.getParameter("effectif");
    String  domaine = request.getParameter("domaine");    
    
    Entreprise entreprise = new Entreprise();
    
    
    entreprise.setNomMarque(NomMarque);
    entreprise.setRaisonSocial(RaisonSocial);
    entreprise.setStatutJuridique(StatutJuridique);
    entreprise.setCapital(capital);
    entreprise.setEffectif(effectif);
    entreprise.setDomaine(domaine);
     EntrepriseDB.save2(entreprise);
    /*out.println("Données enregistrées avec succès");*/
    response.sendRedirect("registernotvalid.jsp");
                    
    
    
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