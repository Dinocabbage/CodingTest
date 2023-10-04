import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            while(!stack.empty() && towers[stack.peek()] < towers[i]) {
                stack.pop();
            }

            if(stack.empty()) {
                sb.append(0 + " ");
            }
            else {
                sb.append(stack.peek() + 1 + " ");
            }

            stack.push(i);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}