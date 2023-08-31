package schoolPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principals {
	
	DataBaseConnection db = new  DataBaseConnection();
	Connection connection = db.getConnection();
	Scanner input = new Scanner(System.in);
	
	private int principalId;
	private int schoolId;
	private String principalName;
	
	
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	
	//----------------------------------------------------------------------------
	
			public void setInsert() {
				 
				 System.out.println("Enter School Id :");
				 int schoolId = input.nextInt();
				 
				 System.out.println("Enter Principal Name : ");
				 String principalName = input.next();
				
				this.setSchoolId(schoolId);
				this.setPrincipalName(principalName);
				
				
				 String sql = "INSERT INTO principals ( school_id , principal_name ) VALUES (? ,? )";
				 PreparedStatement pstmt = null;
				 
				 try {
					 pstmt = connection.prepareStatement(sql);
					 
					
					 pstmt.setInt(1 , this.getSchoolId());
					 pstmt.setString(2 , this.getPrincipalName());
					 pstmt.executeUpdate();
					 
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }
				
			}
			
			//--------------------------------------------------------------------------
		
			
			public void getValues() {
				
				 System.out.println("Enter Principal Id :");
				 int principalId = input.nextInt();
				 
				 this.setPrincipalId(principalId);;
				 
				 String sql = "SELECT p.principal_id , p.principal_name,  s.school_name  FROM principals p LEFT JOIN schools s ON s.school_id = p.school_id WHERE principal_id = ?";
		         PreparedStatement pstmt = null;
		         ResultSet rs = null;
				 
				 try {
					 pstmt = connection.prepareStatement(sql);
					 pstmt.setInt(1 , this.getPrincipalId());
					 rs = pstmt.executeQuery();
					 
					 while(rs.next()){
						 System.out.println("Principal Id : "+rs.getInt("principal_Id"));
						 System.out.println("School Name : "+rs.getString("school_name"));
						 System.out.println("Principal Name : "+rs.getString("principal_name"));
						
						
					 }
					 
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }	
			}
			
			//--------------------------------------------------------------------------
			
			public void getAllData() {
				
				String sql = "SELECT p.principal_id , p.principal_name,  s.school_name  FROM principals p LEFT JOIN schools s ON s.school_id = p.school_id";
				
				PreparedStatement pstmt = null;
		        ResultSet rs = null;
				 
				 try {
					 pstmt = connection.prepareStatement(sql);
					 rs = pstmt.executeQuery();
					 
					 while(rs.next()){
						 System.out.println("Principal Id : "+rs.getInt("principal_Id"));
						 System.out.println("Principal Name : "+rs.getString("principal_name"));
						 System.out.println("School Name : "+rs.getString("school_name"));
						 
						 System.out.println("----------------------------------------------");
					 }
					 
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }	
				
			}
			
			//---------------------------------------------------------------------
			
			public void deleteData() {
				
				 System.out.println("Enter Principal Id :");
				 int principalId = input.nextInt();
				 
				 this.setPrincipalId(principalId);
				 
				 String sql = "DELETE FROM principals WHERE principal_id = ?";
		         PreparedStatement pstmt = null;
				 
				 try {
					 pstmt = connection.prepareStatement(sql);
					 pstmt.setInt(1 , this.getPrincipalId());
					 pstmt.executeUpdate();
					 
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }	
			}
			
			//-------------------------------------------------------------
			public void deleteAllData() {
				
				 String sql = "DELETE FROM principals ";
		         PreparedStatement pstmt = null;
		        
				 try {
					 pstmt = connection.prepareStatement(sql);
					 pstmt.executeUpdate();
					 
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }	
			}
			
			//-----------------------------------------------------------------

			public void updateData() {
				
				System.out.println("Enter Principal Id :");
				 int principalId = input.nextInt();
				 
				 System.out.println("Enter School Id: ");
				 int schoolId= input.nextInt();
				 
				 System.out.println("Enter Principal Name  : ");
				 String principalName = input.next();
				 
				this.setPrincipalId(principalId);
				this.setSchoolId(schoolId);
				this.setPrincipalName(principalName);
				 
				 String sql = "UPDATE principals SET  school_id = ? , principal_name = ?  WHERE principal_id = ?";
		         PreparedStatement pstmt = null;
				 
				 try {
					 pstmt = connection.prepareStatement(sql);
					 
					 pstmt.setInt(1 , this.getSchoolId());
					 pstmt.setString(2 , this.getPrincipalName());
					 pstmt.setInt(3 , this.getPrincipalId());
					 pstmt.executeUpdate();
					  
				 }catch(SQLException e) {
					 throw new RuntimeException(e);
				 }	
				
			}



}
