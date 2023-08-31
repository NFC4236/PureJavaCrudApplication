package schoolPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Courses {
	
	DataBaseConnection db = new  DataBaseConnection();
	Connection connection = db.getConnection();
	Scanner input = new Scanner(System.in);
	
	
	private int courseId;
	private int studentId;
	private String courseName;
	private String duration;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String coursename) {
		this.courseName = coursename;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	//----------------------------------------------------------------------------
	
	public void setInsert() {
		 

		 System.out.println("Enter Student Id :");
		 int studentId = input.nextInt();
		 
		 System.out.println("Enter Course Name : ");
		 String courseName = input.next();
		 
		 System.out.println("Enter Course Complete Duration : ");
		 String duration = input.next();
		 
		
		
		this.setStudentId(studentId);
		this.setCourseName(courseName);
		this.setDuration(duration);
		
		
		 String sql = "INSERT INTO courses ( student_id , course_name ,course_duration ) VALUES (? ,? ,? )";
		 PreparedStatement pstmt = null;
		 
		 try {
			 
			 pstmt = connection.prepareStatement(sql);
			 
			
			 pstmt.setInt(1 ,this.getStudentId() );
			 pstmt.setString(2 , this.getCourseName());
			 pstmt.setString(3 ,this.getDuration());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
		
	}
	
	//--------------------------------------------------------------------------

	
	public void getValues() {
		
		 System.out.println("Enter Course Id :");
		 int courseId = input.nextInt();
		 
		 this.setCourseId(courseId);
		 
		 String sql = "SELECT   c.course_id , s.student_id,  c.course_name, c.course_duration ,  s.student_name , s.father_name , s.age  FROM courses c LEFT JOIN students s ON s.student_id = c.student_id WHERE c.course_id = ?";
         PreparedStatement pstmt = null;
         ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getCourseId());
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("Course Id : "+rs.getInt("course_id"));
				 System.out.println("Course Name : "+rs.getString("course_name"));
				 System.out.println("Course Completion Duration : "+rs.getString("course_duration"));
				 System.out.println("Student Name : "+rs.getString("student_name"));
				 System.out.println("Student Father Name : "+rs.getString("father_name"));
				 System.out.println("Age : "+rs.getInt("age"));
				
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//--------------------------------------------------------------------------
	
	public void getAllData() {
		
		 String sql = "SELECT s.student_id,c.course_id , c.course_name, c.course_duration ,  s.student_name , s.father_name , s.age  FROM courses c LEFT JOIN students s ON s.student_id = c.student_id";
		
		PreparedStatement pstmt = null;
        ResultSet rs = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("Course Id : "+rs.getInt("course_id"));
				 System.out.println("Course Name : "+rs.getString("course_name"));
				 System.out.println("Course Completion Duration : "+rs.getString("course_duration"));
				 System.out.println("Student Name : "+rs.getString("student_name"));
				 System.out.println("Student Father Name : "+rs.getString("father_name"));
				 System.out.println("Age : "+rs.getInt("age"));
				
				 System.out.println("----------------------------------------------");
			 }
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
		
	}
	
	//---------------------------------------------------------------------
	
	public void deleteData() {
		
		 System.out.println("Enter Course Id :");
		 int courseId = input.nextInt();
		 
		 this.setCourseId(courseId);;
		 
		 String sql = "DELETE FROM courses WHERE course_id = ?";
         PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 pstmt.setInt(1 , this.getCourseId());
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }	
	}
	
	//-------------------------------------------------------------
	public void deleteAllData() {
		
		 String sql = "DELETE FROM courses ";
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
		
		 
		 System.out.println("Enter Course Id :");
		 int courseId = input.nextInt();
		 
		 System.out.println("Enter Student Id :");
		 int studentId = input.nextInt();
		 
		 System.out.println("Enter Course Name : ");
		 String courseName = input.next();
		 
		 System.out.println("Enter Course Complete Duration : ");
		 String duration = input.next();
		 
		
		this.setCourseId(courseId);
		this.setStudentId(studentId);
		this.setCourseName(courseName);
		this.setDuration(duration);
		
		
		 String sql = "UPDATE courses SET student_id = ?,  course_name = ? , course_duration = ? WHERE course_id = ?";
		 PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = connection.prepareStatement(sql);
			 
			 pstmt.setInt(1 ,this.getStudentId() );
			 pstmt.setString(2 , this.getCourseName());
			 pstmt.setString(3 ,this.getDuration());
			 pstmt.setInt(4 , this.getCourseId() );
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
		
	   }
		
	}





