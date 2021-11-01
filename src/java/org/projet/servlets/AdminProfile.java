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
import org.projet.db.AdministrateurDB;
import org.projet.entities.Entreprise;
import org.projet.db.EntrepriseDB;
import org.projet.entities.Administrateur;


public class AdminProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
    
    String  nom = request.getParameter("nom");
    String  prenom = request.getParameter("prenom");
    String cne = request.getParameter("cne");
    
    Administrateur a = new Administrateur();
    
    a.setPrenom(prenom);
    a.setNom(nom);
    a.setCne(cne);
    
     AdministrateurDB.save2(a);
    /*out.println("Données enregistrées avec succès");*/
    request.getRequestDispatcher("register.jsp").include(request, response);
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