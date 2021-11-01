package org.projet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.projet.entities.Sauvegarder;

public class SauvegardeDB {
    
   public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
                    
} catch (Exception e){System.out.println("e");}
return conn;
}    
 
   
   public static int save(Sauvegarder sauvegarde){
int status = 0;
try{
    
Connection conn = SauvegardeDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into sauvegarde(id_ensiaste,id_offre) values(?,?)");
ps.setString(1, sauvegarde.getId_ensiaste());
ps.setString(2, sauvegarde.getId_offre());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
      public static int unsave(Sauvegarder sauvegarde){
int status = 0;
try{
    
Connection conn = SauvegardeDB.getConnection();
PreparedStatement ps = conn.prepareStatement("delete from sauvegarde where id_offre='"+sauvegarde.getId_offre()+"' and id_ensiaste= "+sauvegarde.getId_ensiaste()+"'");
status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
   
}
