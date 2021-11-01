package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.OffreDB;
import org.projet.entities.Offre;




public class AjouterOffre extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        
    String  titre = request.getParameter("titre");
    String contact = request.getParameter("contact");
    String description = request.getParameter("description");
    String categorie = request.getParameter("categorie");
    String  ville = request.getParameter("ville");  
    String  id_recruteur = request.getParameter("id_recruteur");  
    

    
    Offre offre = new Offre();
    /*offre.setId(id);*/
    offre.setTitre(titre);
    offre.setDescription(description);
    /*offre.setRecruteur(recruteur);*/
    offre.setCategorie(categorie);
    //offre.setDatePublication(datePublication);
    offre.setContact(contact);
    offre.setVille(ville);
    offre.setRecruteurID(id_recruteur);

    OffreDB.save(offre);
    /*out.println("Données enregistrées avec succès"+contact+" "+ville);*/
    request.getRequestDispatcher("AjouterOffre.jsp").include(request, response);
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