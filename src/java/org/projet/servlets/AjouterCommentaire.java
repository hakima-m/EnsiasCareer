package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.CommentaireDB;
import org.projet.db.OffreDB;
import org.projet.db.RatingDB;
import org.projet.entities.Commentaire;
import org.projet.entities.Offre;
import org.projet.entities.Rating;




public class AjouterCommentaire extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        
    String  comment =   request.getParameter("comment");
    String id_ensiaste =request.getParameter("id_ensiaste");
    String id_offre = request.getParameter("id_offre");
    
    
    Commentaire c = new Commentaire();
    
    c.setComment(comment);
    c.setId_offre(id_offre);
    c.setId_ensiaste(id_ensiaste);
    
    CommentaireDB.save(c);
    
    String  rating = request.getParameter("rating");
    
    
    Rating rt = new Rating();
    rt.setId_ensiaste(Integer.parseInt(id_ensiaste));
    rt.setId_offre(Integer.parseInt(id_offre));
    rt.setRateindex(Float.parseFloat(rating));
    RatingDB.save(rt);
    request.getRequestDispatcher("afficherMore.jsp").include(request, response);
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