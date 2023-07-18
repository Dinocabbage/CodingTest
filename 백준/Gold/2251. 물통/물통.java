import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int A, B, C;
    static boolean[][] isVisit;
    static ArrayList<Integer> answer;

    public static void solution(int a, int b, int c) {
        if(isVisit[a][c]) {
            return;
        }

        isVisit[a][c] = true;

        if(a == 0) {
            answer.add(c);
        }

        int sum = a + b;
        solution(sum > B ? sum - B : 0, sum > B ? B : sum, c);
        solution(sum > A ? A : sum, sum > A ? sum - A : 0, c);

        sum = a + c;
        solution(sum > C ? sum - C : 0, b, sum > C ? C : sum);
        solution(sum > A ? A : sum, b, sum > A ? sum - A : 0);

        sum = b + c;
        solution(a, sum > C ? sum - C : 0, sum > C ? C : sum);
        solution(a, sum > B ? B : sum, sum > B ? sum - B : 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        br.close();

        isVisit = new boolean[C + 1][C + 1];
        answer = new ArrayList<>();

        solution(0, 0, C);

        bw.write(answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();
    }
}
