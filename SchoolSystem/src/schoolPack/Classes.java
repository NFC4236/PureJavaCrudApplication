package schoolPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Classes {
	

	DataBaseConnection db = new  DataBaseConnection();
	Connection connection = db.getConnection();
	Scanner input = new Scanner(System.in);
	
	private int classId;
	private int school_id;
	private String periods;
	private String className;
	
	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public int getSchool_id() {
		return school_id;
	}
	
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	
	public String getPeriods() {
		return periods;
	}
	
	public void setPeriods(String periods) {
		this.periods = periods;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	//----------------------------------------------------------------------------
	
		public void setInsert() {
			 
			 
			 
			 System.out.println("Enter School Id :");
			 int schoolId = input.nextInt();
			 
			 System.out.println("Enter Class Name : ");
			 String className = input.next();
			 
			 System.out.println("Enter Class Periods : ");
			String classPeriods = input.next();
			
			
			this.setSchool_id(schoolId);
			this.setClassName(className);
			this.setPeriods(classPeriods);
			
			 String sql = "INSERT INTO classes ( school_id , class_name , period) VALUES (? ,? ,? )";
			 PreparedStatement pstmt = null;
			 
			 try {
				 pstmt = connection.prepareStatement(sql);
				 
				
				 pstmt.setInt(1 , this.getSchool_id());
				 pstmt.setString(2 , this.getClassName());
				 pstmt.setString(3 , this.getPeriods());
				 pstmt.executeUpdate();
				 
			 }catch(SQLException e) {
				 throw new RuntimeException(e);
			 }
			
		}
		
		//--------------------------------------------------------------------------
	
		//--------------------------------------------------------------------------
		
		public void getValues() {
			
			 System.out.println("Enter class Id :");
			 int classId = input.nextInt();
			 
			 this.setClassId(classId);
			 
			 String sql = "SELECT c.class_id , c.class_name, c.period , s.school_name  FROM classes c LEFT JOIN schools s ON c.school_id = s.school_id WHERE class_id = ?";
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
			 
			 try {
				 pstmt = connection.prepareStatement(sql);
				 pstmt.setInt(1 , this.getClassId());
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()){
					 System.out.println("Class Id : "+rs.getInt("class_Id"));
					 System.out.println("School Name : "+rs.getString("school_name"));
					 System.out.println("Class Name : "+rs.getString("class_name"));
					 System.out.println("Number of Periods : "+rs.getString("period"));
				 }
				 
			 }catch(SQLException e) {
				 throw new RuntimeException(e);
			 }	
		}
		
		//--------------------------------------------------------------------------
		
		public void getAllData() {
			
			String sql = "SELECT c.class_id , c.class_name, c.period , s.school_name  FROM classes c LEFT JOIN schools s ON c.school_id = s.school_id";
			
			PreparedStatement pstmt = null;
	        ResultSet rs = null;
			 
			 try {
				 pstmt = connection.prepareStatement(sql);
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()){
					 System.out.println("Class Id : "+rs.getInt("class_Id"));
					 System.out.println("Class Name : "+rs.getString("class_name"));
					 System.out.println("School Name : "+rs.getString("school_name"));
					 System.out.println("Number of Periods : "+rs.getString("period"));
					 System.out.println("----------------------------------------------");
				 }
				 
			 }catch(SQLException e) {
				 throw new RuntimeException(e);
			 }	
			
		}
		
		//---------------------------------------------------------------------
		
		public void deleteData() {
			
			 System.out.println("Enter Class Id :");
			 int classId = input.nextInt();
			 
			 this.setClassId(classId);
			 
			 String sql = "DELETE FROM classes WHERE class_id = ?";
	         PreparedStatement pstmt = null;
			 
			 try {
				 pstmt = connection.prepareStatement(sql);
				 pstmt.setInt(1 , this.getClassId());
				 pstmt.executeUpdate();
				 
			 }catch(SQLException e) {
				 throw new RuntimeException(e);
			 }	
		}
		
		//-------------------------------------------------------------
		public void deleteAllData() {
			
			 String sql = "DELETE FROM classes ";
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
			
			System.out.println("Enter Class Id :");
			 int classId = input.nextInt();
			 
			 System.out.println("Enter School Id: ");
			 int schoolId= input.nextInt();
			 
			 System.out.println("Enter Class Name  : ");
			 String className = input.next();
			 
			 System.out.println("Enter Number of Periods  : ");
			 String classPeriod = input.next();
			
			this.setClassId(classId);
			this.setSchool_id(schoolId);
			this.setClassName(className);
			this.setPeriods(classPeriod);
			 
			 String sql = "UPDATE classes SET  school_id = ? , class_name = ? ,period = ?  WHERE class_id = ?";
	         PreparedStatement pstmt = null;
			 
			 try {
				 pstmt = connection.prepareStatement(sql);
				 
				 pstmt.setInt(1 , this.getSchool_id());
				 pstmt.setString(2 , this.getClassName());
				 pstmt.setString(3 , this.getPeriods());
				 pstmt.setInt(4 , this.getClassId());
				 pstmt.executeUpdate();
				  
			 }catch(SQLException e) {
				 throw new RuntimeException(e);
			 }	
			
		}


}
