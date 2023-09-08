import java.io.*;
import java.util.*;

class Node {
    private int num;
    private String command;

    Node(int num, String command) {
        this.num = num;
        this.command = command;
    }

    public int getNum() {
        return this.num;
    }

    public String getCommand() {
        return this.command;
    }
}

public class Main {

    private static int calculateD(int num) {
        return num * 2 % 10000;
    }

    private static int calculateS(int num) {
        return (num - 1 + 10000) % 10000;
    }

    private static int calculateL(int num) {
        return (num / 1000) + (num % 1000 * 10);
    }

    private static int calculateR(int num) {
        return (num % 10 * 1000) + num / 10;
    }
    private static String solution(int A, int B) {
        boolean[] isVisit = new boolean[10000];

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(A, ""));

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int num = current.getNum();
            String command = current.getCommand();

            if(num == B) {
                return command;
            }

            int newNum = calculateD(num);
            if(!isVisit[newNum]) {
                isVisit[newNum] = true;
                queue.offer(new Node(newNum, command + "D"));
            }

            newNum = calculateS(num);
            if(!isVisit[newNum]) {
                isVisit[newNum] = true;
                queue.offer(new Node(newNum, command + "S"));
            }

            newNum = calculateL(num);
            if(!isVisit[newNum]) {
                isVisit[newNum] = true;
                queue.offer(new Node(newNum, command + "L"));
            }

            newNum = calculateR(num);
            if(!isVisit[newNum]) {
                isVisit[newNum] = true;
                queue.offer(new Node(newNum, command + "R"));
            }
        }

        return "";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(solution(A, B) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}