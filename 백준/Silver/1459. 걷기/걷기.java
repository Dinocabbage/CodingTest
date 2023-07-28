import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long answer = 0;

        if(2 * W < S) {
            answer = (X + Y) * W;
        }
        else if(W > S) {
            if((X + Y) % 2 == 0) {
                answer = Math.max(X, Y) * S;
            }
            else {
                answer = (Math.max(X, Y) - 1) * S + W;
            }
        }
        else {
            answer = (Math.min(X, Y) * S) + (Math.abs(X - Y) * W);
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
