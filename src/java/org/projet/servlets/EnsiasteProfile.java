package org.projet.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.projet.db.EnsiasteDB;
import org.projet.entities.Ensiaste;




public class EnsiasteProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
    
    /* InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part savePath = request.getPart("photo");
        if (savePath != null) {
           
            inputStream = savePath.getInputStream();
        }*/
        
        
    /*String  id = request.getParameter("id");    */
    String  cne = request.getParameter("cne");
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    String annee = request.getParameter("annee");
    String  ville = request.getParameter("ville");    
    String filiere = request.getParameter("filiere");
    String contact = request.getParameter("contact");
    
    Ensiaste ensiaste = new Ensiaste();
    
    /*ensiaste.setId(id);*/
    ensiaste.setCNE(cne);
    ensiaste.setNom(nom);
    ensiaste.setPrenom(prenom);
    ensiaste.setAnnee(annee);
    ensiaste.setFiliere(filiere);
    ensiaste.setVille(ville);
    ensiaste.setContact(contact);
    /*ensiaste.setInputStream(inputStream);*/


    EnsiasteDB.save2(ensiaste);
    /*out.println("Données enregistrées avec succès"+ensiaste.getVille()+ensiaste.getId()+ensiaste.getCNE()+ensiaste.getNom()+ensiaste.getPrenom()+ensiaste.getAnnee()+ensiaste.getFiliere());*/
    
    
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

    private String extractFileName(Part part) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }