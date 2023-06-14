import java.util.Scanner;

public class Main {
    public int solution(int[][] arr) {
        int answer = 1;

        for(int x = 0; x < arr.length - 1; x++) {
            for(int y = 0; y < arr[0].length - 1; y++) {
                int count = 0;
                for(int i = y + 1; i < arr[0].length; i++) {
                    count++;
                    if(x + count < arr.length
                            && arr[x][i] == arr[x][y]
                            && arr[x][y] == arr[x + count][y]
                            && arr[x][i] == arr[x + count][i]) {
                        answer = Math.max(answer, (count + 1) * (count + 1));
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main b = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next().chars().map(Character::getNumericValue).toArray();
        }

        System.out.println(b.solution(arr));

    }
}
