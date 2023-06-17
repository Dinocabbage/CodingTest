import java.util.Scanner;

public class Main {
    static int N, S;
    static int[] sequence;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        S = scanner.nextInt();
        sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = scanner.nextInt();
        }

        count = 0;
        backtrack(0, 0);
        if(S == 0) {
            count--;
        }
        System.out.println(count);
    }

    static void backtrack(int index, int sum) {     // index : sequence의 인덱스, sum : 현재까지의 합계
        if (sum == S) {     // 합계가 S가 되면 count + 1
            count++;
        }

        if (index == N) {   // index가 N이 되면 0 ~ 4의 모든 요소를 탐색했으므로 return
            return;
        }

        for (int i = index; i < N; i++) {   // index 부터 N - 1까지
            sum += sequence[i];           // 합계에 값을 더해줌
            backtrack(i + 1, sum);  // 인덱스를 1 올리고 합계를 넘겨줌
            sum -= sequence[i];           // 해당 index의 값을 더하지 않은 경우를 확인하기 위해 빼줌
        }
    }
}
