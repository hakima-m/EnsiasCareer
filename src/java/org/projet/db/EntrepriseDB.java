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
import org.projet.entities.Entreprise;


public class EntrepriseDB {
public static Connection getConnection(){
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
//jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");
                    
} catch (Exception e){System.out.println("e");}
return conn;
}
public static int save2(Entreprise entreprise){
int status = 0;
try{
    
Connection conn = EntrepriseDB.getConnection();
PreparedStatement ps = conn.prepareStatement("update entreprise set raisonsocial=?, nommarque=?, statutjuridique=?, capital=?, effectif=?, domaine=?  where id_entreprise = (select MAX(id_entreprise) from entreprise)");

ps.setString(1, entreprise.getRaisonSocial());
ps.setString(2, entreprise.getNomMarque());
ps.setString(3, entreprise.getStatutJuridique());
ps.setString(4, entreprise.getCapital());
ps.setString(5, entreprise.getEffectif());
ps.setString(6, entreprise.getDomaine());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
public static int save1(Entreprise entreprise){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = EntrepriseDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into entreprise(typecompte,login,mdp,email) values(?, ?, ?,?)");

ps.setString(1, entreprise.getTypeCompte());
ps.setString(2, entreprise.getLogin());
ps.setString(3, entreprise.getMdp());
ps.setString(4, entreprise.getEmail());

status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
//**********Récupération Produit par Id*****//
/*public static Ensiaste select(int id_proj)
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
/*public static List<Ensiaste> getAllEnsiaste(){
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
}*/


public static List<Entreprise> getAllEntreprise(){
            List<Entreprise> list=new ArrayList<Entreprise>();
            try{
            Connection con=EntrepriseDB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from entreprise");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Entreprise o=new Entreprise();

            o.setId(Integer.toString(rs.getInt(1)));   
            o.setRaisonSocial(rs.getString(2));
            o.setNomMarque(rs.getString(3));
            o.setStatutJuridique(rs.getString(4));
            o.setCapital(rs.getString(5));
            o.setEffectif(rs.getString(6));
            o.setCheminPhoto(rs.getString(7));
            o.setDomaine(rs.getString(8));
            o.setTypeCompte(rs.getString(9));
            o.setLogin(rs.getString(10));
            o.setMdp(rs.getString(11));
            o.setEmail(rs.getString(12));
            o.setValidation(rs.getString(13));
            list.add(o);
            }
            con.close();

            }catch(Exception e){e.printStackTrace();}
            return list;
}

public static Entreprise getEntreprise(int id) {
		
		Entreprise o = new Entreprise();
		try {
			String sql= "SELECT * FROM entreprise WHERE id_entreprise=?";
			Connection con = EntrepriseDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			if(rs.next()) {
				o.setId(Integer.toString(rs.getInt(1)));   
                                o.setRaisonSocial(rs.getString(2));
                                o.setNomMarque(rs.getString(3));
                                o.setStatutJuridique(rs.getString(4));
                                o.setCapital(rs.getString(5));
                                o.setEffectif(rs.getString(6));
                                o.setCheminPhoto(rs.getString(7));
                                o.setDomaine(rs.getString(8));
                                o.setTypeCompte(rs.getString(9));
                                o.setLogin(rs.getString(10));
                                o.setMdp(rs.getString(11));
                                o.setEmail(rs.getString(12));
                                o.setValidation(rs.getString(13));
				
			
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
		

	}

public static boolean update(Entreprise stu) {
		boolean test = false;
		try {
			String sql ="UPDATE entreprise SET `raisonsocial`=?,`nommarque`=?,`statutjuridique`=?,`capital`=?,`effectif`=?,`domaine`=? WHERE id_entreprise=? ";
			Connection con = EntrepriseDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(7,Integer.parseInt(stu.getId()));
			preparedStatement.setString(1,stu.getRaisonSocial());
			preparedStatement.setString(2,stu.getNomMarque());
                        preparedStatement.setString(3,stu.getStatutJuridique());
                        preparedStatement.setString(4,stu.getCapital());
			preparedStatement.setString(5,stu.getEffectif());
			preparedStatement.setString(6,stu.getDomaine());
                        
			
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}

public static boolean validate(Entreprise stu) {
		boolean test = false;
		try {
			String sql ="UPDATE entreprise SET `validation`=? WHERE id_entreprise=? ";
			Connection con = EntrepriseDB.getConnection();
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


public static void deleteEntreprise(int id){
                try{

                Connection conn = EntrepriseDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM entreprise WHERE id_entreprise=? ");
                ps.setInt(1,id);
		ps.execute();
                conn.close();
                } catch (Exception e){System.out.println(e);
                }

}
}
