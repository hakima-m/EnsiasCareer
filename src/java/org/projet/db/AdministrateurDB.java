package org.projet.db;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.projet.entities.Administrateur;


public class AdministrateurDB {
public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
                     
} catch (Exception e){System.out.println("e");}
return conn;
}


public static int save1(Administrateur ad){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = EnsiasteDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into administrateur(typecompte,login,mdp,email) values(?, ?, ?,?)");

ps.setString(1, ad.getTypeCompte());
ps.setString(2, ad.getLogin());
ps.setString(3, ad.getMdp());
ps.setString(4, ad.getEmail());
status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
public static int save2(Administrateur ad){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = EnsiasteDB.getConnection();
PreparedStatement ps = conn.prepareStatement("update administrateur set nom=?, prenom=?, cne=? where id_ad = (select MAX(id_ad) from administrateur)");

ps.setString(1,ad.getNom());
ps.setString(2, ad.getPrenom());
ps.setString(3, ad.getCne());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}

}
