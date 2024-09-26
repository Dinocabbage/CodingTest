import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Coord> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(list.stream()
                .sorted(Comparator.comparingInt(Coord::getY).thenComparing(Coord::getX))
                .map(c -> c.getX() + " " + c.getY())
                .collect(Collectors.joining("\n")));

        bw.flush();
        bw.close();
        br.close();
    }
}