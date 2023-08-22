import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static String find(String f, Map<String, String> unf) {
        if(f.equals(unf.get(f))) {
            return f;
        }
        String root = find(unf.get(f), unf);
        unf.put(f, root);
        return root;
    }

    public static int union(String friend1, String friend2, Map<String, String> unf, Map<String, Integer> groupSizes) {
        String fa = find(friend1, unf);
        String fb = find(friend2, unf);

        if(!fa.equals(fb)) {
            unf.put(fa, fb);
            groupSizes.put(fb, groupSizes.get(fb) + groupSizes.get(fa));
        }

        return groupSizes.get(fb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());

            Map<String, String> unf = new HashMap<>();
            Map<String, Integer> groupSizes = new HashMap<>();

            for(int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(!unf.containsKey(friend1)) {
                    unf.put(friend1, friend1);
                    groupSizes.put(friend1, 1);
                }

                if(!unf.containsKey(friend2)) {
                    unf.put(friend2, friend2);
                    groupSizes.put(friend2, 1);
                }

                bw.write(union(friend1, friend2, unf, groupSizes) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
