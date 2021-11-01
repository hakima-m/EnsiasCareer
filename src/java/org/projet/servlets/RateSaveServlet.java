package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.RatingDB;
import org.projet.db.SauvegardeDB;
import org.projet.entities.Rating;
import org.projet.entities.Sauvegarder;




public class RateSaveServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        
    String  rating = request.getParameter("rating");
    String  id_offre = request.getParameter("id_offre");
    String  id_ensiaste = request.getParameter("id_ensiaste");
    
    Rating rt = new Rating();
    rt.setId_ensiaste(Integer.parseInt(id_ensiaste));
    rt.setId_offre(Integer.parseInt(id_offre));
    rt.setRateindex(Integer.parseInt(rating));
    RatingDB.save(rt);
    /*out.println("Données enregistrées avec succès : "+id_offre+" "+id_ensiaste);*/
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