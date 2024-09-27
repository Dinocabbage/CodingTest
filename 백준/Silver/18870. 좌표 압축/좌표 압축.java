import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] coords = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sortedCoords = Arrays.stream(coords).distinct().sorted().toArray();

        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> coordMap = new HashMap<>();

        for(int i = 0; i < sortedCoords.length; i++) {
            coordMap.put(sortedCoords[i], i);
        }

        for(int coord : coords) {
            sb.append(coordMap.get(coord)).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}