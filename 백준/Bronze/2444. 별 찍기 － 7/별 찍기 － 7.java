import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int starCount = 1;
        int whiteSpace = N - 1;
        boolean check = false;

        for(int i = 0; i < N * 2 - 1; i++) {
            for(int j = 0; j < whiteSpace; j++) {
                bw.write(" ");
            }

            for(int j = 0; j < starCount; j++) {
                bw.write("*");
            }

            bw.newLine();

            if(whiteSpace == 0) {
                check = true;
            }

            if(check) {
                whiteSpace++;
                starCount -= 2;
            }
            else {
                whiteSpace--;
                starCount += 2;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
