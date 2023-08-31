package schoolPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Schools {
	
	DataBaseConnection db = new  DataBaseConnection();
	Connection connection = db.getConnection();
	Scanner input = new Scanner(System.in);
	
	private int schoolId;
	private String schoolName;
	private String schoolPhoneNumber;
	
	public int getSchoolId() {
		return this.schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return this.schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolPhoneNumber() {
		return this.schoolPhoneNumber;
	}
	public void setSchoolPhoneNumber(String schoolPhoneNumber) {
		this.schoolPhoneNumber = schoolPhoneNumber;
	}

	
	public String toString() {
		return "Schools [schoolId=" + schoolId + ", \nschoolName=" + schoolName + ", \nschoolPhoneNumber="
				+ schoolPhoneNumber + "]";
	}
	
	//----------------------------------------------------------------------------
	
	public void setInsert() {
		
		
		
		 System.out.println("Enter School Name : ");
		 String schoolName = input.next();
		 
		 System.out.println("Enter School Phone Number : ");
		 String schoolPhoneNumber = input.next();
		
		this.setSchoolName(schoolName);
		this.setSchoolPhoneNumber(schoolPhoneNumber);
		
		 String sql = "INSERT INTO schools ( school_name , school_phone_number) VALUES (? ,? )";
		 PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1 , this.getSchoolName());
			 pstmt.setString(2 , this.getSchoolPhoneNumber());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
		
	}
	
	//--------------------------------------------------------------------------
	
	public void getValues() {
		
		 System.out.println("Enter School Id :");
		 schoolId = input.nextInt();
		 
		 this.setSchoolId(schoolId);
		 
		 String sql = "SELECT * FROM schools WHERE school_id = ?";
         PreparedStatement pstmt = null;
         ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getSchoolId());
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("School Id : "+rs.getInt("school_Id"));
				 System.out.println("School Name : "+rs.getString("school_name"));
				 System.out.println("School Phone Number: "+rs.getString("school_Phone_number"));
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//--------------------------------------------------------------------------
	
	public void getAllData() {
		
		String sql = "SELECT s.school_id , s.school_name, s.school_phone_number , p.principal_name  FROM schools s LEFT JOIN principals p ON p.school_id = s.school_id";
		
		PreparedStatement pstmt = null;
        ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("School Id : "+rs.getInt("school_Id"));
				 System.out.println("School Name : "+rs.getString("school_name"));
				 System.out.println("School Phone Number: "+rs.getString("school_Phone_number"));
				 System.out.println("School Principal Name: "+rs.getString("principal_name"));
				 System.out.println("----------------------------------------------");
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
		
	}
	
	//---------------------------------------------------------------------
	
	public void deleteData() {
		
		 System.out.println("Enter School Id :");
		 schoolId = input.nextInt();
		 
		 this.setSchoolId(schoolId);
		 
		 String sql = "DELETE FROM schools WHERE school_id = ?";
         PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getSchoolId());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//-------------------------------------------------------------
	public void deleteAllData() {
		
		 String sql = "DELETE FROM schools ";
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
		System.out.println("Enter School Id :");
		 int schoolId = input.nextInt();
		 
		 System.out.println("Enter School Name : ");
		 String schoolName = input.next();
		 
		 System.out.println("Enter School Phone Number : ");
		 String schoolPhoneNumber = input.next();
		
		this.setSchoolId(schoolId);
		this.setSchoolName(schoolName);
		this.setSchoolPhoneNumber(schoolPhoneNumber);
		 
		 String sql = "UPDATE schools SET school_name = ? , school_phone_number = ?  WHERE school_id = ?";
         PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1 , this.getSchoolName());
			 pstmt.setString(2 , this.getSchoolPhoneNumber());
			 pstmt.setInt(3 , this.getSchoolId());
			 pstmt.executeUpdate();
			  
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
		
	}

}
