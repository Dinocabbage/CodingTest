import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int total = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

            if(total != 0) {
                bw.write(total + "\n");
            }
            else {
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}