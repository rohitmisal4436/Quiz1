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
    			for(int n=1;n<5;n++) {
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
   						String NAME = rs.getString(1);
   						String UI = rs.getString(2);
   						String PASS = rs.getString(3);
   	   					if ((UI.equals(username)) && (PASS.equals(password))){
   	   					System.out.println("Successfully LogIn With Username :" + UI); 
   	   					System.out.println("  ");
   	   					Random randomGenerator=new Random();
   	   				     Random randNum = new Random();
   	   			         Set set = new LinkedHashSet();
   	   			         while (set.size() < 10) {
   	   			         set.add(randNum.nextInt(10)+1);
   	   					} 
   	   			      //   System.out.println("Random numbers with no duplicates = "+set);
   	   			         
   	   			         System.out.println("Start Quiz");
   	   			         System.out.println("");
	   			         Object[] objects = set.toArray();
	   			         int Marks=0;
	   			         for(int i=0;i<objects.length;i++) {    //length is the property of the array  
	   			        	 //System.out.println(objects[i].toString());
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
	 	   			        	System.out.println("A) : " + op1);
		 	   			        System.out.println("B) : " + op2);
	 	   			        	System.out.println("C) : " + op3);
		 	   			        System.out.println("D) : " + op4);
		 	   			        Scanner sc4 =new Scanner(System.in);
		 	   			        System.out.println("Select Your Option : ");
		 	   			        String ans_user = sc4.nextLine();
		 	   			        System.out.println("  ");
	 	   			        	
	 	   			        	System.out.println("Your Answer : " + ans_user);
	 	   			            System.out.println("Correct Answer : " + ans);
	 	   			            System.out.println("");
	 	   			            if(ans_user.equals(ans)) {
	 	   			            	Marks++;
	 	   			            }else {
	 	   			            	System.out.println("");
	 	   			            	System.out.println("Wrong Answer");
	 	   			            }
	 	   			            
	 	   			            
	 	   			            
	 	   			            System.out.println("................................................................................................................");

	 	   			         }
	   			         }
	   			         System.out.println("Your score is  "+ Marks +"  out of 10");
	   			         String Grade = null;
	   			         if(Marks>=8) {
	   			        	 Grade = "A";
	   			        	 System.out.println("You have get Class A");
	   			         }else if(Marks<=7 && Marks>=6) {
	   			        	 Grade ="B";
	   				        System.out.println("You have get Class B");
	   			         }else if(Marks==5) {
	   			        	 Grade = "C";
	   			        	 System.out.println("You have get Class C");
	   			         }else {
	   			        	 Grade = "F";
	   			        	 System.out.println("You failed to crack the Test");
	   				}
	   			      Class.forName("com.mysql.cj.jdbc.Driver");
	   			         Connection conn3=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata","root","Rohit@4436");
	   			         PreparedStatement stmt3 = conn3.prepareStatement("INSERT INTO marksdetail(StudentName, USERNAME , MARKS , Out_Of , Grade) Values(?,?,?,?,?)");
	   			            
	   			             String outof = "10";
	   			             
	   			         	stmt3.setString(1,NAME );
	   			         	stmt3.setString(2, username);
	   			         	stmt3.setLong(3,Marks );
	   			         	stmt3.setString(4, outof);
	   			         	stmt3.setString(5, Grade );	
	   			         	
	   			         	int K=stmt3.executeUpdate();
	   			          conn3.close();
	   			          stmt3.close();
	   			         
	   			         
			
   	   					}else {
   						System.out.println("Invalid Username,Passowrd OR Not A Registereg Candidate");
   	   					}
   	   					
   					}
   					
    				 conn.close();
    			}   				
    			     catch(Exception e) {
    				 e.printStackTrace();
    				 
    			 }
    				
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











































































































































