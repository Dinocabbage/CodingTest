import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public Student(String name, int koreanScore, int englishScore, int mathScore) {
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return this.name;
    }

    public int getKoreanScore() {
        return this.koreanScore;
    }

    public int getEnglishScore() {
        return this.englishScore;
    }

    public int getMathScore() {
        return this.mathScore;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());

            students.add(new Student(name, koreanScore, englishScore, mathScore));
        }

        StringBuilder sb = new StringBuilder();

        sb.append(students.stream().sorted(Comparator
                        .comparing(Student::getKoreanScore).reversed()
                        .thenComparing(Student::getEnglishScore)
                        .thenComparing(Student::getMathScore, Comparator.reverseOrder())
                        .thenComparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.joining("\n")));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
