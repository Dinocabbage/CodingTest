import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int maxValue = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        bw.write(String.valueOf(maxValue));
        bw.newLine();
        bw.write(String.valueOf(list.indexOf(maxValue) + 1));

        bw.flush();
        br.close();
        bw.close();

    }
}