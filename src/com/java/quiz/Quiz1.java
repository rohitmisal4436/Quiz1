package com.java.quiz;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
public class Quiz1 {
	
	//This method check weather user have LogIn or Not 
	//If not then user need to Register Here First
     void AddDetail() {
    	 System.out.println("LogIn here- Enter 1 ");
    	 System.out.println("Register here- Enter 2");
          for(int x=1;x<=2;x++) {
    		Scanner sc = new Scanner(System.in);
    		int P =sc.nextInt();
    		if(P==1){
    			
    			 System.out.println("Please Enter USERNAME");
				 Scanner sc2=new Scanner(System.in);
				 String username = sc2.nextLine();
				 System.out.println("Please Enter password");
				 Scanner sc3=new Scanner(System.in);
				 String password = sc3.nextLine();
    		
    		
    				try {
   					Class.forName("com.mysql.cj.jdbc.Driver");
   					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
   					PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE USERNAME LIKE ?");
   					stmt.setString(1,username);
   					ResultSet rs = stmt.executeQuery();
   					while(rs.next()) {
   						String UI = rs.getString(2);
   						String PASS = rs.getString(3);
   	   					if ((UI.equals(username)) && (PASS.equals(password))){
   	   					System.out.println("Successfully LogIn With Username :" + UI); 
   	   					Random randomGenerator=new Random();
   	   				     Random randNum = new Random();
   	   			         Set set = new LinkedHashSet();
   	   			         while (set.size() < 10) {
   	   			         set.add(randNum.nextInt(10)+1);
   	   					} 
   	   			         System.out.println("Random numbers with no duplicates = "+set);
	   			         Object[] objects = set.toArray();
	   			         for(int i=0;i<objects.length;i++) {    //length is the property of the array  
	   			        	 System.out.println(objects[i].toString());
	 	   			         Class.forName("com.mysql.cj.jdbc.Driver");
	 	   			         Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
	 	   			         PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM quiz WHERE Sr_No LIKE ?");
	 	   			         stmt1.setString(1,(objects[i].toString()));
	 	   			         ResultSet rs1 = stmt1.executeQuery();
	 	   			         while(rs1.next()) {
	 	   			        	String que = rs1.getString(2);
	 	   			        	String op1 = rs1.getString(3);
	 	   			        	String op2 = rs1.getString(4);
	 	   			        	String op3 = rs1.getString(5);
	 	   			            String op4 = rs1.getString(6);
	 	   			            String ans = rs1.getString(7);
	 	   			            
	 	   			        	System.out.println("Q : " + que);
	 	   			        	System.out.println("Option1) : " + op1);
		 	   			        System.out.println("Option2) : " + op2);
	 	   			        	System.out.println("Option3) : " + op3);
		 	   			        System.out.println("Option4) : " + op4);
		 	   			        Scanner sc4 =new Scanner(System.in);
		 	   			        String ans_user = sc4.nextLine();
	 	   			        	System.out.println("ans : " + ans);
	 	   			        	System.out.println("ans_user : " + ans_user);

	 	   			         }
	   			         }
		
//		   	   			 int n = set.size(); 
//		   	   			 String arr[] = new String[n]; 
//			   	   		arr = set.toArray(arr); 
//			   	     
//			   	        System.out.println(Arrays.toString(arr));
			   	   	  
//   	   			         Iterator<String> itr = set.iterator();
//		   	   			  while (itr.hasNext()) {
//		   	   	            System.out.println(itr.next());
//		   	   	        }
//   	   			        int arr [] a =set.toArray();
//   	   			         for(int i=0;i<set.Size;i++) {   //length is the property of the array  
//   	   			        	 System.out.println(set[i]);  
//   	   			         }
   	   			         

   	   					
   	   					}else {
   						System.out.println("Invalid Username,Passowrd OR Not A Registereg Candidate");
   	   					}
       }
   					
    				conn.close();
 }   				
    			 catch(Exception e) {
    				 e.printStackTrace();
    				 
    			 }
    		}else {
    			
    			System.out.println("Register Here : ");
    			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERINFO(FULLNAME,USERNAME,PASSWORD)VALUES(?,?,?)");
					System.out.println("Enter the number of Students");
					int p1 = sc.nextInt();
					for(int i=1;i<=p1;i++) {
						Scanner sc2= new Scanner(System.in);
						System.out.println("User FULLNAME");
						String c2 = sc2.nextLine();
						System.out.println("User USERNAME");
						String c3= sc2.nextLine();
						System.out.println("User PASSWORD");
						String c4 = sc2.nextLine();
					
						stmt.setString(1, c2);
						stmt.setString(2, c3);
						stmt.setString(3, c4);
						int j = stmt.executeUpdate();
						System.out.println(j);
					
				}
					System.out.println("Registered Successfully.....");
					
					conn.close();
				    stmt.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}		
    	} 
    		  
     }
	
	
	
	public static void main(String[] args) {
	        Quiz1 k = new Quiz1();
	        k.AddDetail();
	}

}











































































































































