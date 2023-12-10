package javamongo;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
public class employee {

	void empd() {
        MongoClient ml = new MongoClient("localhost", 27017);
        MongoDatabase database = ml.getDatabase("test");
        MongoCollection<Document> doc = database.getCollection("admin");

        Scanner sc = new Scanner(System.in);

        
        String userName = sc.nextLine();

        System.out.println("Enter your User id");
        int userId = sc.nextInt();

        Document query = new Document("Emp name:", userName).append("id", userId);
        Document user = doc.find(query).first();

        if (user != null && user.getString("Emp name:").equals(userName) && user.getInteger("id") == userId) {
            System.out.println("Welcome: " + userName);

            System.out.println("Press 1 add a new product");
            System.out.println("Press 2 update a product");
            
            int z = sc.nextInt();
            int ch=1;
            while(ch!=0) {
            if (z == 1) {
                sc.nextLine();
                System.out.println("Product Name:");
                String Proname = sc.nextLine();

                System.out.println("Cost of Product:");
                int price = sc.nextInt();
                System.out.print("Net Weight in kg:");
                int kg = sc.nextInt();

                Document doc1 = new Document("Product name:", Proname)
                        .append("Price", price)
                        .append("kg", kg);

                doc.insertOne(doc1);
                System.out.println("Product details added Successfully");
                System.out.println("Press 0 for exit 1 for continue");
            }
            	else if (z == 2) {
                    sc.nextLine();
                    System.out.println("Enter Product name for update:");
                    String up = sc.nextLine();

                    System.out.println("Enter new Product cost:");
                    int uc = sc.nextInt();

                    doc.updateOne(
                            Filters.eq("Product name:", up),
                            Updates.set("Price", uc) 
                    );
                    System.out.println("Product details updated Successfully");
                    System.out.println("Press 0 for exit 1 for continue");
                }
            ch=sc.nextInt();
            if(ch==0) {
            	exit cl=new exit();
            	cl.show();}
            	}
            }
            else {
               System.out.println("User not found pls contact admin");
           }
        
   
	    		  
	    	 
	      }
	      
	      
		
		
   
}
