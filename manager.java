package javamongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class manager {
    void show() {
        Scanner sc = new Scanner(System.in);
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);

        MongoClient ml = new MongoClient("localhost", 27017);
        MongoDatabase db = ml.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("admin");

        System.out.print("Enter Manager id: ");
        int mg = sc.nextInt();
          int ch=1;
        if (mg == 123) {
            
            while(ch!=0) {
            	System.out.println("Press 1 for View Product Details");
                System.out.println("Press 2 for View Employee Details");
            int d = sc.nextInt();

            if (d == 1) {
                Document filter = new Document()
                        .append("Product name:", new Document("$ne", null));
                        

                FindIterable<Document> documents = collection.find(filter);
                for (Document document : documents) {
                	System.out.println(document);
                 
                }
                System.out.println("Press 0 for Exit");
                System.out.println("Press 1 for Continue");
                ch=sc.nextInt();
            } else if (d == 2) {
                Document filter = new Document()
                        .append("Emp name:", new Document("$ne", null))
                        .append("id", new Document("$ne", null));

                FindIterable<Document> documents = collection.find(filter);
                for (Document document : documents) {
                    System.out.println(document);
                }
                System.out.println("Press 0 for Exit");
                System.out.println("Press 1 for Continue");
                ch=sc.nextInt();
                if(ch==0) {
                	exit cl=new exit();
                	cl.show();}
                	
                }
             else {
                System.out.println("Invalid choice");
                ch=1;
            }
        }} else {
            System.out.println("Manager id is invalid contact admin");
        }
    }

   
}
