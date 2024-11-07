import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int getGCD(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int am = Integer.parseInt(st.nextToken());
        int ad = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int bm = Integer.parseInt(st.nextToken());
        int bd = Integer.parseInt(st.nextToken());

        int a = (am * bd) + (bm * ad);
        int b = ad * bd;

        int gcd = getGCD(a, b);
        
        bw.write((a / gcd) + " " + (b / gcd));

        bw.flush();
        bw.close();
        br.close();
    }
}
