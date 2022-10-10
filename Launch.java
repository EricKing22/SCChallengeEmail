import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Launch {
    public static void main(String[] args) throws Exception {
        //C1.SCChallengeEmail();
        // Get user id from input
        String user_id = Getuserid();
        // Initialise fields
        String First_name, Second_name, line, text, title;
        int pos;
        // Set the url location
        URL url = new URL("https://www.ecs.soton.ac.uk/people/" + user_id);
        // Instantiate ir and br objects
        InputStreamReader ir = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(ir);

        // Keep reading from the web page
        while ((text = br.readLine()) != null)
            if (text.contains("name=\"description\"")){ // Target on the line contains name="description"

                // Find the position of the starting point
                pos = text.indexOf("content=\"");

                // Extract the rest of the line
                line = text.substring(pos+9);

                // Instantiate a new scanner object to read title, first name and second name
                Scanner scanner = new Scanner(line);
                title = scanner.next();
                First_name = scanner.next();
                Second_name = scanner.next();

                // Output the result
                System.out.println("Title: " + title);
                System.out.println("Name: " + First_name + " " + Second_name);
            }
    }

    // Reads user input and return as user id
    public static String Getuserid() throws  Exception{
        System.out.println("Input user id: ");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String user_id = br.readLine();
        return user_id;
    }

}
