import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] input = new char[5][];

        for(int i = 0; i < 5; i++) {
            input[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                try {
                    bw.write(input[j][i]);
                }
                catch(ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
