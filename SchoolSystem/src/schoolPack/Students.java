package schoolPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
	
	DataBaseConnection db = new  DataBaseConnection();
	Connection connection = db.getConnection();
	Scanner input = new Scanner(System.in);
	
	private int studentId;
	private int classId;
	private String studentName;
	private String fatherName;
	private int age;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//----------------------------------------------------------------------------
	
	public void setInsert() {
		 
	
		 
		 System.out.println("Enter Class Id :");
		 int classId = input.nextInt();
		 
		 System.out.println("Enter Student Name : ");
		 String studentName = input.next();
		 
		 System.out.println("Enter Student Father Name : ");
		 String fatherName = input.next();
		 
		 System.out.println("Enter Student Age :");
		 int studentAge= input.nextInt();
		
		
		this.setStudentName(studentName);
		this.setClassId(classId);
		this.setFatherName(fatherName);
		this.setAge(studentAge);
		
		
		 String sql = "INSERT INTO students (class_id , student_name , father_name , age ) VALUES (? ,? ,? ,? )";
		 PreparedStatement pstmt = null;
		 
		 try {
			 
			 pstmt = connection.prepareStatement(sql);
			 
			 pstmt.setInt(1 , this.getClassId());
			 pstmt.setString(2 , this.getStudentName());
			 pstmt.setString(3 , this.getFatherName());
			 pstmt.setInt(4 , this.getAge());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
		
	}
	
	//--------------------------------------------------------------------------

	
	public void getValues() {
		
		 System.out.println("Enter Student Id :");
		 int studentId = input.nextInt();
		 
		 this.setStudentId(studentId);
		 
		 String sql = "SELECT s.student_id, s.student_name , s.father_name , s.age , c.class_name , c.period  FROM students s LEFT JOIN classes c ON s.class_id = c.class_id WHERE s.student_id = ?";
         PreparedStatement pstmt = null;
         ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getStudentId());
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("Student Id : "+rs.getInt("student_Id"));
				 System.out.println("Student Name : "+rs.getString("student_name"));
				 System.out.println("Student Father Name : "+rs.getString("father_name"));
				 System.out.println("Age : "+rs.getInt("age"));
				 System.out.println("Class Name : "+rs.getString("class_name"));
				 System.out.println("Number of Periods : "+rs.getString("period"));
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//--------------------------------------------------------------------------
	
	public void getAllData() {
		
		String sql = "SELECT s.student_id, s.student_name , s.father_name , s.age , c.class_name , c.period  FROM students s LEFT JOIN classes c ON s.class_id = c.class_id";
		
		PreparedStatement pstmt = null;
        ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("Student Id : "+rs.getInt("student_Id"));
				 System.out.println("Student Name : "+rs.getString("student_name"));
				 System.out.println("Student Father Name : "+rs.getString("father_name"));
				 System.out.println("Age : "+rs.getInt("age"));
				 System.out.println("Class Name : "+rs.getString("class_name"));
				 System.out.println("Number of Periods : "+rs.getString("period"));
				
				 System.out.println("----------------------------------------------");
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
		
	}
	
	//---------------------------------------------------------------------
	
	public void deleteData() {
		
		 System.out.println("Enter Student Id :");
		 int studentId = input.nextInt();
		 
		 this.setStudentId(studentId);
		 
		 String sql = "DELETE FROM students WHERE student_id = ?";
         PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getStudentId());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//-------------------------------------------------------------
	public void deleteAllData() {
		
		 String sql = "DELETE FROM students ";
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
		 
		 System.out.println("Enter Student Id: ");
		 int studentId= input.nextInt();
		 
		 System.out.println("Enter Student Name  : ");
		 String studentName = input.next();
		 
		 System.out.println("Enter Student Father Name  : ");
		 String fatherName = input.next();
		 
		 System.out.println("Enter Student Age  : ");
		int studentAge = input.nextInt();
		 
		this.setStudentId(studentId);
		this.setClassId(classId);
		this.setStudentName(studentName);
		this.setFatherName(fatherName);
		this.setAge(studentAge);
		 
		 String sql = "UPDATE students SET  class_id = ? , student_name = ? , father_name = ? , age = ? WHERE student_id = ?";
         PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 
			 pstmt.setInt(1 , this.getClassId());
			 pstmt.setString(2 , this.getStudentName());
			 pstmt.setString(3 , this.getFatherName());
			 pstmt.setInt(4 , this.getAge());
			 pstmt.setInt(5 , this.getStudentId());
			 pstmt.executeUpdate();
			  
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
		
	}




}
