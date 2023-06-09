import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(j <= i) {
                    bw.write('*');
                }
                else {
                    bw.write(' ');
                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}