import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int start = 0;
        while(start < input.length()) {

            if(start + 10 > input.length()) {
                System.out.println(input.substring(start, start + (input.length() % 10)));
                break;
            }
            System.out.println(input.substring(start, start + 10));

            start += 10;
        }

    }
}