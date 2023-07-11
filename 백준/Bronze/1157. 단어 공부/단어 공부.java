import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        for(char c : br.readLine().toCharArray()) {
            char a = Character.toUpperCase(c);
            arr[(int)a - 'A']++;
        }

        int max = 0;
        int count = 0;
        char answer = ' ';

        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                count = 1;
                answer = (char)('A' + i);
            }
            else if(arr[i] == max) {
                count++;
            }
        }

        if(count > 1) {
            bw.write("?");
        }
        else {
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
