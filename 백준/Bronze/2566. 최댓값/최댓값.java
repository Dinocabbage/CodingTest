import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = -1;
        int row = 0;
        int col = 0;

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        bw.write(max + "\n" + row + " " + col);

        bw.flush();
        bw.close();
        br.close();
    }
}
