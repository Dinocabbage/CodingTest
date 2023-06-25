import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            System.out.println(Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).sum());
        }
        sc.close();

    }
}