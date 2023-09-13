import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        long maxArea = getMaxArea(N, heights);

        bw.write(String.valueOf(maxArea));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long getMaxArea(int N, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? N : N - stack.peek() - 1;
            long area = (long) height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
