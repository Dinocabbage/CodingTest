import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == -1) {
                break;
            }

            String tmp = n + " = 1";
            int total = 1;

            for(int i = 2; i <= n / 2; i++) {
                if(n % i == 0) {
                    tmp += " + " + i;
                    total += i;
                }
            }

            if(total == n) {
                bw.write(tmp);
            }
            else {
                bw.write(n + " is NOT perfect.");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
