import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        bw.write(list.stream()
                .sorted(Comparator.comparingInt(Member::getAge))
                .map(c -> c.getAge() + " " + c.getName())
                .collect(Collectors.joining("\n")));

        bw.flush();
        bw.close();
        br.close();
    }
}