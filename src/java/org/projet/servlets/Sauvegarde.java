package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.SauvegardeDB;
import org.projet.entities.Sauvegarder;




public class Sauvegarde extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
       if(request.getParameter("save")!=null){ 
    String  save = request.getParameter("save");
    String  id_offre = request.getParameter("id_offre");
    String  id_ensiaste = request.getParameter("id_ensiaste");
    
    Sauvegarder sauvegarde = new Sauvegarder();
    sauvegarde.setId_ensiaste(id_ensiaste);
    sauvegarde.setId_offre(id_offre);
    SauvegardeDB.save(sauvegarde);
    /*out.println("Données enregistrées avec succès : "+id_offre+" "+id_ensiaste);*/
       }
        if(request.getParameter("unsave")!=null){ 
    String  unsave = request.getParameter("unsave");
    String  id_offre = request.getParameter("id_offre");
    String  id_ensiaste = request.getParameter("id_ensiaste");
    
    Sauvegarder sauvegarde = new Sauvegarder();
    sauvegarde.setId_ensiaste(id_ensiaste);
    sauvegarde.setId_offre(id_offre);
    SauvegardeDB.unsave(sauvegarde);
    /*out.println("Données enregistrées avec succès : "+id_offre+" "+id_ensiaste);*/
       }
    
    request.getRequestDispatcher("ensiasteHome.jsp").include(request, response);
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