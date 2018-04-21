import java.sql.*;
import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class jdbcTest {
	public static void main(String[] args) throws SQLException {  	 
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "Lieutenant3721");
            pstmt = conn.prepareStatement("SELECT * FROM Student");
            res = pstmt.executeQuery(); 
            
            pstmt = conn.prepareStatement("insert into Student values(?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
            pstmt.setInt(1, 345);
  	        pstmt.setString(2, "Nathan");
  	        pstmt.setString(3,  "j");
  	        pstmt.setString(4, "Jung");
  	        pstmt.setDate(5, java.sql.Date.valueOf("2013-09-04"));
  	        pstmt.setString(6, "efr");
  	        pstmt.setInt(7, 314);
  	        pstmt.setInt(8, 30041);
          	pstmt.setInt(9, 123);
          	
          	pstmt.executeUpdate();
          	
            System.out.println("Result:");
  	        System.out.println(" ssn \t firstName \t mi \t lastName \t dateBirth \t street \t phone \t zipCode \t deptID");
  	        
  	      while (res.next()) { 
  	    	System.out.println(res.getInt(1) + "   " + res.getString(2) + "   " + res.getString(3) + "   " 
  	                  + res.getString(4) + "   " + res.getDate(5) + "   " + res.getString(6)
  	                  + "   " + res.getInt(7) + "   " + res.getInt(8) + "   " + res.getInt(9));
  	      }
 

        } catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch (SQLException e){
    		e.printStackTrace();
    	} finally {
    		if(pstmt != null) try{pstmt.close();} catch(SQLException e){};
    		if(res != null) try{res.close();} catch(SQLException e){};
    		if(conn != null) try{conn.close();} catch(SQLException e){};
    	}
	}
	
}