package javamongo;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class admin {
	  void admin() {
		   Scanner sc=new Scanner(System.in);
		 
		   MongoClient ml=new MongoClient("localhost",27017);
		   MongoDatabase db=ml.getDatabase("test");
		  int ch=1;
		  MongoCollection <Document>dc=db.getCollection("admin");
		  
		  
		int ad=  sc.nextInt();
		if(ad==123) {
		  while(ch!=0) {
		  System.out.println("Press 1 for add Emp");
		  System.out.println("Press 2 for Remove Emp");
		  System.out.println("Press 3 for Update Emp");
	   	  int   n=sc.nextInt();
		  switch(n) {
		  case 1:
			  sc.nextLine();
			  System.out.println("Enter Emp name");
			  String s=sc.nextLine();
			 System.out.println("Enter Emp new Id");
			 int a=sc.nextInt();
		    Document d=new Document("Emp name:",s)
				 .append("id", a);
		      dc.insertOne(d);
		      System.out.println("Emp details added Successfully");
		      break;
		 
		  case 2:
			  sc.nextLine();
			  System.out.println("Enter Emp name for remove");
			  String s1=sc.nextLine();
			  Document query = new Document("Emp name:", s1);
		     dc.deleteOne(query);
		     System.out.println("Emp details removed Successfully");
		     break;
		     
		  case 3:
			  sc.nextLine();
			  System.out.println("Enter Emp name for Update:");
			  String s2=sc.nextLine();
			  Document q=new Document("Emp name:",s2);
			 

              System.out.println("Enter new Emp id:");
              int uc = sc.nextInt();

                dc.updateOne(
                      Filters.eq("Emp name:", s2),
                      Updates.set("id", uc) 
              );
              System.out.println("Product details updated Successfully");
		  }
		  
		  System.out.println("Press 0 for exit...press 1 for continue");
		 ch=sc.nextInt();
		 
			 
		 if(ch==0) {
			 exit cl=new exit();
			 cl.show();
		 }
	   }}else{
		   System.out.print("Your admin Id is Invalid");}
	   }
	  
  }

