import java.io.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 28).forEach(index -> {
            try {
                list.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        IntStream.rangeClosed(1, 30).filter(num -> !list.contains(num)).forEach(num -> {
            try {
                bw.write(String.valueOf(num));
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();
        br.close();
    }
}