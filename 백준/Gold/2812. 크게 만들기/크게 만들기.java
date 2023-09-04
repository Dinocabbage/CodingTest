import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for(int i : input) {
            while(K > 0 && !stack.empty() && stack.peek() < i) {
                stack.pop();
                K--;
            }

            stack.push(i);
        }

        while(K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();

        for(int i : stack) {
            sb.append(i);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
