import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<Long, Integer> cards = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        long frequentNum = cards.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();

        bw.write(String.valueOf(frequentNum));

        bw.close();
        br.close();
    }
}
