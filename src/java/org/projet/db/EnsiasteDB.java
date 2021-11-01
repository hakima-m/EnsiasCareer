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
import org.projet.entities.Ensiaste;


public class EnsiasteDB {
public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
                    
                     
} catch (Exception e){System.out.println("e");}
return conn;
}
public static int save2(Ensiaste ensiaste){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = EnsiasteDB.getConnection();
PreparedStatement ps = conn.prepareStatement("update ensiaste set nom=?, prenom=?, cne=?, filiere=?, annee=?, ville=?, contact=?  where id_ensiaste = (select MAX(id_ensiaste) from ensiaste)");

ps.setString(1,ensiaste.getNom());
ps.setString(2, ensiaste.getPrenom());
ps.setString(3, ensiaste.getCNE());
ps.setString(4, ensiaste.getFiliere());
ps.setString(5, ensiaste.getAnnee());
ps.setString(6, ensiaste.getVille());
ps.setString(7, ensiaste.getContact());
status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}

public static int save1(Ensiaste ensiaste){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = EnsiasteDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into ensiaste(typecompte,login,mdp,email) values(?, ?, ?,?)");

ps.setString(1, ensiaste.getTypeCompte());
ps.setString(2, ensiaste.getLogin());
ps.setString(3, ensiaste.getMdp());
ps.setString(4, ensiaste.getEmail());
status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}

public static List<Ensiaste> EnsiasteByFilAn(String filiere,String annee){
List<Ensiaste> list=new ArrayList<Ensiaste>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select prenom, nom, annee, filiere, ville, contact from ensiaste  where filiere='"+filiere+"' and annee = '"+annee+"'");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Ensiaste o=new Ensiaste();

o.setPrenom(rs.getString(1));
o.setNom(rs.getString(2));
o.setAnnee(rs.getString(3));
o.setFiliere(rs.getString(4));
o.setVille(rs.getString(5));
o.setContact(rs.getString(6));

list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}        
        
//**********Récupération Produit par Id*****//
public static Ensiaste select(int id_proj)
    {
        Ensiaste o= new Ensiaste();
        
        try{
            Connection cnx=EnsiasteDB.getConnection();
            Statement st=cnx.createStatement();
        
            ResultSet rs=st.executeQuery("select * from ensiaste where id="+id_proj+" ");
            
            if(rs.next())
            {
                o.setId(rs.getString(1));    
                o.setPrenom(rs.getString(2));
                o.setNom(rs.getString(3));
                o.setFiliere(rs.getString(4));
                o.setAnnee(rs.getString(5));
                o.setVille(rs.getString(6));
                

            }
           
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        return o;
    }
public static List<Ensiaste> EnsiasteByBrLev(String filiere,String annee){
List<Ensiaste> list=new ArrayList<Ensiaste>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select * from ensiaste  where filiere='"+filiere+"' and annee ='"+annee+"' ");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Ensiaste o=new Ensiaste();

o.setId(rs.getString(1));    
o.setPrenom(rs.getString(2));
o.setNom(rs.getString(3));
o.setFiliere(rs.getString(4));
o.setAnnee(rs.getString(5));
o.setVille(rs.getString(6));


list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}
//**********Suppression des Produits*******//
/*public static int delete(String titre){
int status=0;
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("delete from offre where titre=?");
ps.setString(1,titre);
status=ps.executeUpdate();
con.close();
} catch(Exception e){e.printStackTrace();}
return status;
}*/
//**********Modification des Produits********//
/*public static int update(Offre o){
int status=0;
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement(
"update offre set titre=?,description =?,recruteur =?,datePublication =?,categorie =? where titre=?");


ps.setString(1, o.getTitre());
ps.setString(2, o.getDescription());
ps.setString(3, o.getRecruteur());
ps.setDate(4, (Date) o.getDatePublication());
ps.setString(5, o.getCategorie());

status=ps.executeUpdate();
con.close();
}catch(Exception ex){ex.printStackTrace();}
return status;
}*/
//**********Liste des Produits****************//
public static List<Ensiaste> getAllEnsiaste(){
List<Ensiaste> list=new ArrayList<Ensiaste>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select * from ensiaste");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Ensiaste o=new Ensiaste();

o.setId(rs.getString(1));    
o.setPrenom(rs.getString(2));
o.setNom(rs.getString(3));
o.setFiliere(rs.getString(4));
o.setAnnee(rs.getString(5));
o.setVille(rs.getString(6));

list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}


    public static List<Ensiaste> getAllEnsiaste1(){
            List<Ensiaste> list=new ArrayList<Ensiaste>();
            try{
            Connection con=EnsiasteDB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from ensiaste");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Ensiaste o=new Ensiaste();

            o.setId(Integer.toString(rs.getInt(1)));   
            o.setNom(rs.getString(2));
            o.setPrenom(rs.getString(3));
            o.setCNE(rs.getString(4));
            o.setFiliere(rs.getString(5));
            o.setAnnee(rs.getString(6));
            o.setLogin(rs.getString(7));
            o.setMdp(rs.getString(8));
            o.setTypeCompte(rs.getString(9));
            o.setEmail(rs.getString(10));
            o.setVille(rs.getString(11));
            o.setChemin(rs.getString(12));
            o.setContact(rs.getString(13));
            o.setValidation(rs.getString(14));
            list.add(o);
            }
            con.close();

            }catch(Exception e){e.printStackTrace();}
            return list;
}

public static Ensiaste getStudent(int id) {
		
		Ensiaste o = new Ensiaste();
		try {
			String sql= "SELECT * FROM ensiaste WHERE id_ensiaste=?";
			Connection con = EnsiasteDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			if(rs.next()) {
                                o.setId(Integer.toString(rs.getInt(1)));   
                                o.setNom(rs.getString(2));
                                o.setPrenom(rs.getString(3));
                                o.setCNE(rs.getString(4));
                                o.setFiliere(rs.getString(5));
                                o.setAnnee(rs.getString(6));
                                o.setLogin(rs.getString(7));
                                o.setMdp(rs.getString(8));
                                o.setTypeCompte(rs.getString(9));
                                o.setEmail(rs.getString(10));
                                o.setVille(rs.getString(11));
                                o.setChemin(rs.getString(12));
                                o.setContact(rs.getString(13));
                                o.setValidation(rs.getString(14));
			
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
		

	}

public static boolean update(Ensiaste stu) {
		boolean test = false;
		try {
			String sql ="UPDATE ensiaste SET `nom`=?,`prenom`=?,`cne`=?,`filiere`=?,`annee`=?,`ville`=? WHERE id_ensiaste=? ";
			Connection con = EnsiasteDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(7,Integer.parseInt(stu.getId()));
			preparedStatement.setString(1,stu.getNom());
			preparedStatement.setString(2,stu.getPrenom());
                        preparedStatement.setString(3,stu.getCNE());
                        preparedStatement.setString(4,stu.getFiliere());
			preparedStatement.setString(5,stu.getAnnee());
			preparedStatement.setString(6,stu.getVille());
                        
			
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}

public static boolean validate(Ensiaste stu) {
		boolean test = false;
		try {
			String sql ="UPDATE ensiaste SET `validation`=? WHERE id_ensiaste=? ";
			Connection con = EnsiasteDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(2,Integer.parseInt(stu.getId()));
			preparedStatement.setString(1,"checked");
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}
public static void deleteStudent(int id){
                try{

                Connection conn = EnsiasteDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM ensiaste WHERE id_ensiaste=? ");
                ps.setInt(1,id);
		ps.execute();
                conn.close();
                } catch (Exception e){System.out.println(e);
                }

}
}
