import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int getGCD(int A, int B) {
        int r;

        while(A != 0) {
            r = B % A;
            B = A;
            A = r;
        }

        return B;
    }

    private static int getLCM(int A, int B) {
        return (A * B) / getGCD(A, B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(getLCM(A, B)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}