import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C1 {
    public static void SCChallengeEmail() throws Exception{
        // Get user id from inputeg
        String user_id = Getuserid();
        // Initialise fields
        String First_name, Second_name, line, text;
        int pos;
        // Set the url location
        URL url = new URL("https://www.ecs.soton.ac.uk/people/" + user_id);
        // Instantiate ir and br objects
        InputStreamReader ir = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(ir);

        // Keep reading from the web page
        while ((text = br.readLine()) != null)
            if (text.contains("name=\"description\"")){ // Target on the line contains name="\description\"

                // Find the position of the word Professor
                pos = text.indexOf("Professor ");

                // Extract the rest of the line after the word Professor
                line = text.substring(pos+10);

                // Instantiate a new scanner object to read first name and second name
                Scanner scanner = new Scanner(line);
                First_name = scanner.next();
                Second_name = scanner.next();

                // Output the result
                System.out.println("Name: " + First_name + " " + Second_name);
            }
    }
    public static String Getuserid() throws  Exception{
        System.out.println("Input user id: ");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String user_id = br.readLine();
        return user_id;
    }
}
