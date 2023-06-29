import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] keys = new int[N];
        int topIndex = 0;
        int topKey = 0;
        int topValue = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(topValue < value) {
                topKey = key;
                topValue = value;
            }

            map.put(key, value);
            keys[i] = key;
        }

        int total = topValue;

        Arrays.sort(keys);

        for(int i = 0; i < N; i++) {
            if(topKey == keys[i]) {
                topIndex = i;
                break;
            }
        }

        int leftTopKey = 0;
        int lastTopKey = topKey;
        int lastTopIndex = topIndex;
        int leftTopValue = 0;
        int leftTopIndex = 0;

        while(lastTopKey != map.firstKey()) {
            for(int i = lastTopIndex - 1; i >= 0; i--) {
                if(leftTopValue <= map.get(keys[i])) {
                    leftTopKey = keys[i];
                    leftTopIndex = i;
                    leftTopValue = map.get(keys[i]);
                }
            }
            total += (lastTopKey - leftTopKey) * leftTopValue;
            lastTopKey = leftTopKey;
            lastTopIndex = leftTopIndex;
            leftTopValue = 0;
        }

        int rightTopKey = 0;
        lastTopKey = topKey;
        lastTopIndex = topIndex;
        int rightTopValue = 0;
        int rightTopIndex = 0;

        while(lastTopKey != map.lastKey()) {
            for(int i = lastTopIndex + 1; i < N; i++) {
                if(rightTopValue <= map.get(keys[i])) {
                    rightTopKey = keys[i];
                    rightTopIndex = i;
                    rightTopValue = map.get(keys[i]);
                }
            }
            total += (rightTopKey - lastTopKey) * rightTopValue;
            lastTopKey = rightTopKey;
            lastTopIndex = rightTopIndex;
            rightTopValue = 0;
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();

    }
}
