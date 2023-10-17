import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch(order) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
                    break;
                case "pop_back":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
                    break;
                case "back":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}