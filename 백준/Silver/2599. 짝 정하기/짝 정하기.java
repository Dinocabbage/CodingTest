import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] students = new int[3][2];
        boolean isAllStudentCanPair = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                students[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i <= students[0][0]; i++) {
            int[][] result = new int[3][2];

            result[0][0] = i;
            result[0][1] = students[0][0] - i;
            result[1][1] = students[2][1] - result[0][1];
            result[1][0] = students[1][0] - result[1][1];
            result[2][0] = students[0][1] - result[1][0];
            result[2][1] = students[2][0] - result[2][0];

            if(result[0][0] >= 0 && result[0][1] >= 0 && result[1][0] >= 0 && result[1][1] >= 0 && result[2][0] >= 0 && result[2][1] >= 0) {
                System.out.println(1);
                System.out.println(result[0][0] + " " + result[0][1]);
                System.out.println(result[1][0] + " " + result[1][1]);
                System.out.println(result[2][0] + " " + result[2][1]);
                isAllStudentCanPair = true;
                break;
            }
        }

        if(!isAllStudentCanPair) {
            System.out.println(0);
        }


    }
}
