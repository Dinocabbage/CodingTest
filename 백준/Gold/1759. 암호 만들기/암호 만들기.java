import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] chars;
    static StringBuilder sb;
    public static void findPassword(int length, int index, int vowel, int consonants, String password) {
        if(length == L) {
            if(vowel >= 1 && consonants >= 2) {
                sb.append(password + "\n");
            }

            return;
        }

        for(int i = index; i < C; i++) {
            char c = chars[i];

            switch(c) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    findPassword(length + 1, i + 1, vowel + 1, consonants, password + c);
                    break;
                default:
                    findPassword(length + 1, i + 1, vowel, consonants + 1, password + c);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = br.readLine().replaceAll(" ", "").toCharArray();

        Arrays.sort(chars);
        sb = new StringBuilder();

        findPassword(0, 0, 0, 0, "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
