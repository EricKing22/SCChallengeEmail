import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C1 {
    public static void SCChallengeEmail() throws Exception{
        String user_id = Getuserid();
        String name;
        String line;
        int p;
        //https://www.southampton.ac.uk/people/5wzk7h/professor-david-millard
        URL url = new URL("https://www.ecs.soton.ac.uk/people/" + user_id);
        InputStreamReader ir = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(ir);
        String First_name;
        String Second_name;
        String text;

        while ((text = br.readLine()) != null)
            if (text.contains("name=\"description\"")){
                p = text.indexOf("Professor ");
                line = text.substring(p+10, text.length());
                Scanner scanner = new Scanner(line);
                First_name = scanner.next();
                Second_name = scanner.next();

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
