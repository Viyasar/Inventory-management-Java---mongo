package javamongo;
import java.util.Scanner;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;




import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);

        System.out.println("Do you want to proceed (y/n)?");
        String ch = sc.next();

        if (ch.equals("y") || ch.equals("Y")) {
             proceed p=new proceed();
            p.show();
        } else {
            exit cho = new exit();
            cho.show();
        }

        sc.close();
    }
static  class proceed {
	MongoClient ml=new MongoClient("localhost",27017);
	   MongoDatabase database=ml.getDatabase("test");
	   MongoCollection<Document> doc=database.getCollection("admin");
	   
	   void show() {
		   Scanner sc=new Scanner(System.in);
		   int n=0;
		  
     System.out.println("Welcome...✌️");
     System.out.println("if you are employee press 1");
     System.out.println("if you are Manager press 2");
     System.out.println("if you are Admin press 3");
     System.out.println("Press 0 at Exit");
     n=sc.nextInt();
     if(n==1) {
 
  	   System.out.println("Enter your User name");
  	   employee em=new employee();
  	  
  	   em.empd();
  	   
  	   
     }
     else if(n==2) {
  	  
  	   manager man=new manager();
  	   man.show();
     }
     else if(n==3) {
  	   System.out.println("Enter your Admin id");
  	   admin adm=new admin();
  	  adm.admin();
  	   
     }
     else if(n==0) {
  	   exit cl=new exit();
  	  cl.show();
  	  
     }
		   
		   }
}
}