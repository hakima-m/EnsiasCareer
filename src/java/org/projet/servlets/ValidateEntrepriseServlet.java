package org.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.db.EntrepriseDB;
import org.projet.entities.Entreprise;

/**
 *
 * @author acer
 */
public class ValidateEntrepriseServlet extends HttpServlet {
        public static int identreprise1;
        public static String validation;
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String RaisonSocial = request.getParameter("RaisonSocial");
            String NomMarque = request.getParameter("NomMarque");
            String StatutJuridique = request.getParameter("StatutJuridique");
            String capital = request.getParameter("capital");
            String effectif = request.getParameter("effectif");
            String domaine = request.getParameter("domaine");
            int bid = Integer.parseInt(request.getParameter("id"));
            Entreprise en = new Entreprise();
            en.setId(Integer.toString(bid));
            boolean test = EntrepriseDB.validate(en);
           /* List<Entreprise>data1=new ArrayList<Entreprise>();
            try {
					 
					 String sql= "SELECT * FROM `entreprise` WHERE id=?"; 
					 Connection con=EntrepriseDB.getConnection();
					 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
					 preparedStatement.setInt(1,bid);
					 
                                        ResultSet rs=preparedStatement.executeQuery();
					 
					 while(rs.next()){
						 
						 
						 data1.add(new Entreprise(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9)));
						 
					 }
					 con.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				for (Entreprise gr : data1 )
				{       
                                        identreprise1=gr.getId_compte();
                                        
                                        validation=gr.getValidation();
				}
                               
            SendMail sm= new SendMail();
            Entreprise entreprise=new Entreprise(bid,RaisonSocial,NomMarque,StatutJuridique,capital,domaine,effectif,identreprise1,validation);*/
            
            if(test){
                request.getRequestDispatcher("adminEspaceEntreprise.jsp").include(request, response);
               /* boolean test1=sm.sendMail(entreprise);
                 if(test1){
                   request.getRequestDispatcher("adminEspace.jsp").include(request, response);

                 }
                */
            }else{
                out.println("operation failed");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
