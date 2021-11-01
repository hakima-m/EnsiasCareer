package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.OffreDB;
import org.projet.entities.Offre;


@WebServlet(name = "RechercherOffre", urlPatterns = {"/RechercherOffre"})
public class RechercherOffre extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<a href='AjouterOffre.jsp'>Ajouter une nouvelle offre</a>");
out.println("<h1>Liste des offres</h1>");
out.println(request.getParameter("villeR"));

List<Offre> list=OffreDB.OffreByCityKeyw(request.getParameter("villeR"), request.getParameter("motcle"));
out.print("<table border='1' width='100%'");
out.print("<tr><th>id</th><th>titre</th><th>description</th><th>recruteur</th><th>categorie</th><th>date de publication</th><th>ville</th></tr>");
for(Offre o:list){
out.print("<tr><td>"+o.getId()+"</td><td>"+o.getTitre()+"</td><td>"+o.getDescription()+"</td><td>"+o.getRecruteur()+"</td><td>"+o.getCategorie()+"</td><td>"+o.getDatePublication()+"</td><td>"+o.getVille()+"</td><td></tr>");
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
