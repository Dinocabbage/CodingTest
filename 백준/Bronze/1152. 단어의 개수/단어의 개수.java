import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String question = br.readLine();

        if(question.startsWith(" ")) {
            question = question.substring(1);
        }


        int answer = question.split(" ").length;
        if(question.equals("")) {
            answer = 0;
        }

        System.out.println(answer);
    }
}