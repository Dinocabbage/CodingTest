import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")) {
                set.add(name);
            }
            else {
                set.remove(name);
            }
        }

        bw.write(String.join("\n", set));

        bw.flush();
        bw.close();
        br.close();
    }
}