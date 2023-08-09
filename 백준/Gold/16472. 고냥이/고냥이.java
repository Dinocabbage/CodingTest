import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int lt = 0;
        int rt = 0;
        int len = input.length();

        Map<Character, Integer> map = new HashMap<>();

        int answer = 0;

        while (rt < len) {
            char newChar = input.charAt(rt);
            map.put(newChar, map.getOrDefault(newChar, 0) + 1);

            while (map.size() > N) {
                char leftChar = input.charAt(lt);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
            rt++;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
