package com.java.quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Quiz1 {
	
	//This method check weather user have LogIn or Not 
	//If not then user need to Register Here First
     void AddDetail() {
    	 System.out.println("LogIn here- Enter 1 ");
    	 System.out.println("Register here- Enter 2");
    //	 for(int x=1;x<=2;x++) {
    		Scanner sc = new Scanner(System.in);
    		int P =sc.nextInt();
    		if(P==1){
    			
    			
    			 
    	     	
    		
    		//	 System.out.println("Please Enter PASSWORD");
    		//	 String password = sc.nextLine();
    			 
    			 String T=null;
    				try {
   					Class.forName("com.mysql.cj.jdbc.Driver");
   					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
   					Statement stmt = conn.createStatement();
   					ResultSet rs = stmt.executeQuery("SELECT * FROM USERINFO");
  					 System.out.println("Please Enter USERNAME");
  					 Scanner sc2=new Scanner(System.in);
  	    			 String username = sc2.nextLine();
   					//Print Here Username And Password
   					while(rs.next()) {
   					  T = rs.getString(2);
   				    // System.out.println(T);
   			
       }
   					for(int j=1;j<=T.length();j++) {
   						System.out.println(T);
   					 if(T==username) {
  					  // System.out.println("Successfully LogIn ....");
  				                  }else {
  					  // System.out.println("Invalid Username,Passowrd OR Not A Registereg Candidate");
  					}
   						
   					}
   				
    				  
  
    				
    				conn.close();
 }   				
    			 catch(Exception e) {
    				 e.printStackTrace();
    				 
    			 }
    			 
    		 
  			
    			
    		}else {
    			
    			System.out.println("Register Here : ");
//    			try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
//					PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERINFO(FULLNAME,USERNAME,PASSWORD)VALUES(?,?,?)");
//					System.out.println("Enter the number of Students");
//					int p1 = sc.nextInt();
//					for(int i=1;i<=p1;i++) {
//						//Scanner sc2= new Scanner(System.in);
//						String c2 = sc.nextLine();
//						String c3= sc.nextLine();
//						String c4 = sc.nextLine();
//					
//						stmt.setString(1, c2);
//						stmt.setString(2, c3);
//						stmt.setString(3, c4);
//						int j = stmt.executeUpdate();
//						System.out.println(j);
//					
//				}
//					System.out.println("Registered Successfully.....");
//					
//					conn.close();
//				    stmt.close();
//					
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//    		}
 		}		
 //    } 
 }  

	
	
	
	public static void main(String[] args) {
	        Quiz1 k = new Quiz1();
	        k.AddDetail();
	}

}











































































































































