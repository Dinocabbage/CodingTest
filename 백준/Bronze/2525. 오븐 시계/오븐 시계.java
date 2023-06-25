import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int cookTime = sc.nextInt();

        minute += (hour * 60) + cookTime;

        if(minute >= 24 * 60) {
            minute -= 24 * 60;
        }

        System.out.println(minute / 60 + " " + minute % 60);
    }
}