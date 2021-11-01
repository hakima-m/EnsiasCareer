package org.projet.db;
import static java.lang.System.out;
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
import javax.servlet.http.HttpSession;
import org.projet.entities.Commentaire;


public class CommentaireDB {
public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
   
} catch (Exception e){System.out.println("e");}
return conn;
}


public static int save(Commentaire commentaire){
int status = 0;
try{
    
Connection conn = CommentaireDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into commentaire(comment,id_offre,id_ensiaste) values(?,?,?)");
ps.setString(1, commentaire.getComment());
ps.setString(2, commentaire.getId_offre());
ps.setString(3, commentaire.getId_ensiaste());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}

public static List<Commentaire> comments(String id_offre){
List<Commentaire> list=new ArrayList<Commentaire>();
try{
Connection con=CommentaireDB.getConnection();
PreparedStatement ps=con.prepareStatement("select c.comment, c.datePub, e.nom, e.prenom, c.id_ensiaste from commentaire c, ensiaste e where e.id_ensiaste=c.id_ensiaste and c.id_offre='"+id_offre+"'");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Commentaire o=new Commentaire();

o.setComment(rs.getString(1));
o.setDatePub(rs.getDate(2));
o.setNom(rs.getString(3));
o.setPrenom(rs.getString(4));
o.setId_ensiaste(rs.getString(5));
list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}

public static Commentaire getCommentaire(int id, int id1) {
		
		Commentaire o = new Commentaire();
		try {
			String sql= "SELECT * FROM commentaire WHERE id_offre=? AND id_ensiaste=? ";
			Connection con = CommentaireDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
                        preparedStatement.setInt(2,id1);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			if(rs.next()) {
				o.setComment(rs.getString(2));   
                                o.setDatePub(rs.getDate(5));
				
			
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
		

	}
public static boolean update(Commentaire stu) {
		boolean test = false;
		try {
			String sql ="UPDATE commentaire SET `comment`=? WHERE id_ensiaste=? AND id_offre=?";
			Connection con = CommentaireDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(2,Integer.parseInt(stu.getId_ensiaste()));
                        preparedStatement.setInt(3,Integer.parseInt(stu.getId_offre()));
			preparedStatement.setString(1,stu.getComment());
                        
                        
			
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}
public static void deleteCommentaire(int id, int id1){
                try{

                Connection conn = CommentaireDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM commentaire WHERE id_offre=? AND id_ensiaste=?");
                ps.setInt(1,id);
                ps.setInt(2,id1);
		ps.execute();
                conn.close();
                } catch (Exception e){System.out.println(e);
                }

}

}
