package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.EnsiasteDB;
import org.projet.entities.Ensiaste;


@WebServlet(name = "RechercherEnsiaste", urlPatterns = {"/RechercherEnsiaste"})
public class RechercherProfile extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<a href='AjouterOffre.jsp'>Ajouter une nouvelle offre</a>");
out.println("<h1>Liste des profiles </h1>");
out.println(request.getParameter("villeR"));

List<Ensiaste> list=EnsiasteDB.EnsiasteByBrLev(request.getParameter("filiere"), request.getParameter("annee"));
out.print("<table border='1' width='100%'");
out.print("<tr><th>id</th><th>prenom</th><th>nom</th><th>filiere</th><th>annee</th><th>ville</th></tr>");
for(Ensiaste o:list){
out.print("<tr><td>"+o.getId()+"</td><td>"+o.getPrenom()+"</td><td>"+o.getNom()+"</td><td>"+o.getFiliere()+"</td><td>"+o.getAnnee()+"</td><td>"+o.getVille()+"</td><td></tr>");
}
out.print("</table>");
out.close();

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
