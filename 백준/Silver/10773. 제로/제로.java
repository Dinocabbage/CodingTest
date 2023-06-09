import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<Integer>();

        for(int i = 0; i < k; i++) {
            int j = sc.nextInt();

            if(j == 0) {
                input.remove(input.size() - 1);
            }
            else {
                input.add(j);
            }

        }

        for(int i : input) {
            answer += i;
        }
        
        System.out.println(answer);
    }
}
