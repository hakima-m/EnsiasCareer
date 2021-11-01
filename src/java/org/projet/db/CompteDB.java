/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.projet.db;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.projet.entities.Administrateur;
import org.projet.entities.Compte;
import org.projet.entities.Ensiaste;
import org.projet.entities.Entreprise;


public class CompteDB {
    
   public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
} catch (Exception e){System.out.println("e");}
return conn;
}
public static int save(Compte cpt){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = CompteDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into compte(typeCompte, login, mdp, email) values(?,?, ?, ?)");
                            ps.setString(1, cpt.getTypeCompte());
                            ps.setString(2, cpt.getLogin());
                            ps.setString(3, cpt.getMdp());
                            ps.setString(4, cpt.getEmail());
                            



status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}   
   
   
   
    
    
    public static List<Compte> getCompte(){
	
	List<Compte>list=new ArrayList<Compte>();
    
	try {
		 String sql= "SELECT * FROM `compte` WHERE 1";
		 Connection con=CompteDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Compte cpt =new Compte();
			 
			 cpt.setTypeCompte(resultSet.getString(1));
			 cpt.setLogin(resultSet.getString(2));
			 cpt.setMdp(resultSet.getString(3));
			 cpt.setEmail(resultSet.getString(4));
			 
			 
			 list.add(cpt);
			 
		 }
		 con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

   
    
    public Compte logIn(String login, String mdp ) {
        Compte compte = null;
        
        try {
			 
			 String sql= "SELECT * FROM compte WHERE login=? AND mdp=?"; 
			 Connection con=CompteDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,login);
			 preparedStatement.setString(2,mdp);
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
                            if(rs.next()){
                                compte = new Compte();
                                compte.setTypeCompte(rs.getString("typeCompte"));
                                compte.setLogin(rs.getString("login"));
                                compte.setMdp(rs.getString("mdp"));
                                compte.setEmail(rs.getString("email"));
			 }
                            
			 con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
                return compte;
        
    }
        public Entreprise logInEntreprise(String login, String mdp ) {
        Entreprise entreprise=null;
        
        try {
			 
			 String sql= "SELECT * FROM entreprise WHERE login=? AND mdp=?"; 
			 Connection con=CompteDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,login);
			 preparedStatement.setString(2,mdp);
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
                            if(rs.next()){
                                entreprise = new Entreprise();
                                entreprise.setId(rs.getString("id_entreprise"));
                                entreprise.setRaisonSocial(rs.getString("raisonsocial"));
                                entreprise.setNomMarque(rs.getString("nommarque"));
                                entreprise.setStatutJuridique(rs.getString("statutjuridique"));
                                entreprise.setCapital(rs.getString("capital"));
                                entreprise.setEffectif(rs.getString("effectif"));
                                entreprise.setDomaine(rs.getString("domaine"));
                                entreprise.setTypeCompte(rs.getString("typeCompte"));
                                entreprise.setLogin(rs.getString("login"));
                                entreprise.setMdp(rs.getString("mdp"));
                                entreprise.setEmail(rs.getString("email"));
                                entreprise.setValidation(rs.getString("validation"));
			 }
                            
			 con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
                return entreprise;
        
    }
        public Ensiaste logInEnsiaste(String login, String mdp ) {
        Ensiaste ensiaste=null;
        
        try {
			 
			 String sql= "SELECT * FROM ensiaste WHERE login=? AND mdp=?"; 
			 Connection con=CompteDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,login);
			 preparedStatement.setString(2,mdp);
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
                            if(rs.next()){
                                ensiaste = new Ensiaste();
                                ensiaste.setId(rs.getString("id_ensiaste"));
                                ensiaste.setNom(rs.getString("nom"));
                                ensiaste.setPrenom(rs.getString("prenom"));
                                ensiaste.setCNE(rs.getString("cne"));
                                ensiaste.setFiliere(rs.getString("filiere"));
                                ensiaste.setAnnee(rs.getString("annee"));
                                ensiaste.setVille(rs.getString("ville"));
                                ensiaste.setContact(rs.getString("contact"));
                                ensiaste.setTypeCompte(rs.getString("typeCompte"));
                                ensiaste.setLogin(rs.getString("login"));
                                ensiaste.setMdp(rs.getString("mdp"));
                                ensiaste.setEmail(rs.getString("email"));
                                ensiaste.setValidation(rs.getString("validation"));
			 }
                            
			 con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
                return ensiaste;
        
    }

        public Administrateur logInAdmin(String login, String mdp ) {
        Administrateur ad=null;
        
        try {
			 
			 String sql= "SELECT * FROM administrateur WHERE login=? AND mdp=?"; 
			 Connection con=CompteDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,login);
			 preparedStatement.setString(2,mdp);
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
                            if(rs.next()){
                                ad = new Administrateur();
                                ad.setPrenom(rs.getString("prenom"));
                                ad.setNom(rs.getString("nom"));
                                ad.setCne(rs.getString("cne"));
                                ad.setTypeCompte(rs.getString("typeCompte"));
                                ad.setLogin(rs.getString("login"));
                                ad.setMdp(rs.getString("mdp"));
                                ad.setEmail(rs.getString("email"));
                                
			 }
                            
			 con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
                return ad;
        
    }        
}
