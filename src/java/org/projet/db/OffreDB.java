package org.projet.db;
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
import org.projet.entities.Employe;
import org.projet.entities.Offre;
import javax.servlet.http.HttpSession;


public class OffreDB {
public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
   
} catch (Exception e){System.out.println("e");}
return conn;
}
public static int save(Offre offre){
int status = 0;
try{
    
Connection conn = OffreDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into offre(titre,categorie,ville,description,recruteur_id,contact) values(?,?,?,?,?,?)");
ps.setString(1, offre.getTitre());
ps.setString(2, offre.getCategorie());
ps.setString(3, offre.getVille());
ps.setString(4, offre.getDescription());
ps.setString(5, offre.getRecruteurID());
ps.setString(6, offre.getContact());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
//afficher offre
    public static ArrayList<Offre> afficher(String cin)
    {
        ArrayList<Offre> vacance= new ArrayList<>();
        
        try{
            Connection cnx=OffreDB.getConnection();
            Statement st=cnx.createStatement();
            String req;
            if(cin.equals("*")){
                req="select * from Offre";            
            }
            else{
            
            req="select * from Offre where ville like '"+ cin+"'";
            }
            try (ResultSet rs = st.executeQuery(req)) {
                while(rs.next())
                {
                    Offre o=new Offre();
                  
                    
                    o.setId(rs.getString(1));    
                    o.setTitre(rs.getString(2));
                    o.setDescription(rs.getString(3));
                    o.setRecruteur(rs.getString(4));
                    o.setDatePublication(rs.getDate(5));
                    o.setCategorie(rs.getString(6));
                    o.setVille(rs.getString(7));
                    vacance.add(o);
                }
            }
        }catch(SQLException e){
            System.out.print(e);
        }
        
        return vacance;
    }
//************** offre by ID ***************//
public static Offre OffreByID(String id_offre){
Offre o=new Offre();
        try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select o.titre, o.categorie, o.ville, o.description, e.nommarque, o.contact, o.datepublication, o.id_offre from offre o, entreprise e where o.recruteur_id=e.id_entreprise and o.id_offre='"+id_offre+"'");
ResultSet rs=ps.executeQuery();
if(rs.next()){

o.setId(rs.getString(8));
o.setTitre(rs.getString(1));
o.setDescription(rs.getString(4));
o.setRecruteur(rs.getString(5));
o.setContact(rs.getString(6));
o.setDatePublication(rs.getDate(7));
o.setCategorie(rs.getString(2));
o.setVille(rs.getString(3));

}
con.close();

}catch(Exception e){e.printStackTrace();}
return o;
}    
//**********Récupération Produit par Id*****//
public static List<Offre> OffreByCityKeyw(String ville,String categorie){
List<Offre> list=new ArrayList<Offre>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select o.titre, o.categorie, o.ville, o.description, e.nommarque, o.contact, o.datepublication, o.id_offre from offre o, entreprise e where o.recruteur_id=e.id_entreprise and o.ville='"+ville+"' and o.categorie ='"+categorie+"'");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Offre o=new Offre();

o.setId(rs.getString(8));
o.setTitre(rs.getString(1));
o.setDescription(rs.getString(4));
o.setRecruteur(rs.getString(5));
o.setContact(rs.getString(6));
o.setDatePublication(rs.getDate(7));
o.setCategorie(rs.getString(2));
o.setVille(rs.getString(3));
/*o.setPhoto(rs.getString(8));*/
list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}
//********* saved offers *********//
public static List<Offre> savedOffers(String ensiaste_id){
List<Offre> list=new ArrayList<Offre>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select o.titre, o.categorie, o.ville, o.description, e.nommarque, o.contact, o.datepublication from offre o, entreprise e, sauvegarde s where o.recruteur_id=e.id_entreprise and s.id_ensiaste='"+ensiaste_id+"' and o.id_offre =s.id_offre");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Offre o=new Offre();

o.setTitre(rs.getString(1));
o.setDescription(rs.getString(4));
o.setRecruteur(rs.getString(5));
o.setContact(rs.getString(6));
o.setDatePublication(rs.getDate(7));
o.setCategorie(rs.getString(2));
o.setVille(rs.getString(3));
list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}
//**********Suppression des Produits*******//
public static int delete(String titre){
int status=0;
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("delete from offre where titre=?");
ps.setString(1,titre);
status=ps.executeUpdate();
con.close();
} catch(Exception e){e.printStackTrace();}
return status;
}
//**********Modification des Produits********//
public static int update(Offre o){
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
}
//**********Liste des Produits****************//
public static List<Offre> getAllOffres(){
List<Offre> list=new ArrayList<Offre>();
try{
Connection con=OffreDB.getConnection();
PreparedStatement ps=con.prepareStatement("select * from offre");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Offre o=new Offre();

o.setId(rs.getString(1));    
o.setTitre(rs.getString(2));
o.setDescription(rs.getString(3));
o.setRecruteur(rs.getString(4));
o.setDatePublication(rs.getDate(5));
o.setCategorie(rs.getString(6));
o.setVille(rs.getString(7));





list.add(o);
}
con.close();

}catch(Exception e){e.printStackTrace();}
return list;
}

public static Offre getOffre(int id) {
		
		Offre o = new Offre();
		try {
			String sql= "SELECT titre, categorie, ville, description, contact, datepublication FROM offre  WHERE id_offre=?";
			Connection con = OffreDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			if(rs.next()) {
				
                                o.setTitre(rs.getString(1));
                                o.setCategorie(rs.getString(2));
                                o.setVille(rs.getString(3));
                                o.setDescription(rs.getString(4));
                                o.setContact(rs.getString(5));
                                o.setDatePublication(rs.getDate(6));
            
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
		

	}

public static boolean updateOffre(Offre stu) {
		boolean test = false;
		try {
			String sql ="UPDATE offre SET `titre`=?,`description`=?,`contact`=?,`categorie`=?,`ville`=? WHERE id_offre=? ";
			Connection con = OffreDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(6,Integer.parseInt(stu.getId()));
			preparedStatement.setString(1,stu.getTitre());
			preparedStatement.setString(2,stu.getDescription());
                        preparedStatement.setString(3,stu.getContact());
			preparedStatement.setString(4,stu.getCategorie());
			preparedStatement.setString(5,stu.getVille());
                        
			
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}
public static List<Offre> getAllOffre(){
            List<Offre> list=new ArrayList<Offre>();
            try{
            Connection con=OffreDB.getConnection();
            PreparedStatement ps=con.prepareStatement("select o.titre, o.categorie, o.ville, o.description, e.nommarque, o.datepublication, o.validation, o.id_offre from offre o, entreprise e where o.recruteur_id=e.id_entreprise");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Offre o=new Offre();    
            o.setTitre(rs.getString(1));
            o.setCategorie(rs.getString(2));
            o.setVille(rs.getString(3));
            o.setDescription(rs.getString(4));
            o.setRecruteur(rs.getString(5));
            o.setDatePublication(rs.getDate(6));
            o.setValidation(rs.getString(7)); 
            o.setId(Integer.toString(rs.getInt(8)));
            
            list.add(o);
            }
            con.close();

            }catch(Exception e){e.printStackTrace();}
            return list;
}

public static List<Offre> getAllOffreEntreprise(int id){
            List<Offre> list=new ArrayList<Offre>();
            try{
            Connection con=OffreDB.getConnection();
            PreparedStatement ps=con.prepareStatement("select o.titre, o.categorie, o.ville, o.description, o.contact, o.datepublication, o.validation, o.id_offre from offre o, entreprise e where o.recruteur_id=e.id_entreprise AND o.recruteur_id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Offre o=new Offre();    
            o.setTitre(rs.getString(1));
            o.setCategorie(rs.getString(2));
            o.setVille(rs.getString(3));
            o.setDescription(rs.getString(4));
            o.setContact(rs.getString(5));
            o.setDatePublication(rs.getDate(6));
            o.setValidation(rs.getString(7)); 
            o.setId(Integer.toString(rs.getInt(8)));
            
            list.add(o);
            }
            con.close();

            }catch(Exception e){e.printStackTrace();}
            return list;
}

public static void deleteOffre(int id){
                try{

                Connection conn = OffreDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM offre WHERE id_offre=? ");
                ps.setInt(1,id);
		ps.execute();
                conn.close();
                } catch (Exception e){System.out.println(e);
                }

}

public static boolean validate(Offre stu) {
		boolean test = false;
		try {
			String sql ="UPDATE offre SET `validation`=? WHERE id_offre=? ";
			Connection con = OffreDB.getConnection();
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
}
