/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.projet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import org.projet.entities.Rating;

/**
 *
 * @author acer
 */
public class RatingDB {
    public static Connection getConnection(){
        Connection conn = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //jdbc:derby://localhost:1527/ensias12
conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projet", "root", "root");


        } catch (Exception e){System.out.println("e");}
        return conn;
}
    
    
    public static int save(Rating rating){
int status = 0;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//LocalDateTime now = LocalDateTime.now();  
try{
    
Connection conn = RatingDB.getConnection();
PreparedStatement ps = conn.prepareStatement("insert into rating(rateindex,id_ensiaste,id_offre) values(?, ?, ?)");

ps.setFloat(1, rating.getRateindex());
ps.setInt(2, rating.getId_ensiaste());
ps.setInt(3, rating.getId_offre());
status = ps.executeUpdate();
conn.close();
} catch (Exception e){System.out.println(e);}
return status;
}
    
    public static Rating getRating(int id, int id1) {
		
		Rating o = new Rating();
		try {
			String sql= "SELECT rateindex FROM rating  WHERE id_offre=? AND id_ensiaste=? ";
			Connection con = RatingDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
                        preparedStatement.setInt(2,id1);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			if(rs.next()) {
				
                                o.setRateindex(rs.getFloat(1));
                                
            
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
		

	}
    
    public static int getRatingSum(int id) {
		int Count=0;
		Rating o = new Rating();
		try {
			String sql= "SELECT SUM(rateindex) AS total FROM rating  WHERE id_offre=? ";
			Connection con = RatingDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				Count=Count+rs.getInt(1);
                                
            
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Count;
		

	}
     
     public static int getNumber(int id) {
		int Count=0;
		Rating o = new Rating();
		try {
			String sql= "SELECT COUNT(*) FROM rating  WHERE id_offre=? ";
			Connection con = RatingDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs =preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				Count=rs.getInt(1);
                                
            
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Count;
		

	}
     public static boolean update(Rating stu) {
		boolean test = false;
		try {
			String sql ="UPDATE rating SET `rateindex`=? WHERE id_ensiaste=? AND id_offre=?";
			Connection con = RatingDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(2,stu.getId_ensiaste());
                        preparedStatement.setInt(3,stu.getId_offre());
			preparedStatement.setFloat(1,stu.getRateindex());
                        
                        
			
			
			preparedStatement.executeUpdate();
                        test=true;
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
			
		
	}
     public static void deleteRating(int id, int id1){
                try{

                Connection conn = RatingDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM rating WHERE id_offre=? AND id_ensiaste=?");
                ps.setInt(1,id);
                ps.setInt(2,id1);
		ps.execute();
                conn.close();
                } catch (Exception e){System.out.println(e);
                }

}
    
}
