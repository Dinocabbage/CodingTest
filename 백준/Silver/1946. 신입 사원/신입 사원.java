import java.io.*;
import java.util.*;

class Volunteer {
    private int documentScore;
    private int interviewScore;

    public Volunteer(int documentScore, int interviewScore) {
        this.documentScore = documentScore;
        this.interviewScore = interviewScore;
    }

    public int getDocumentScore() {
        return this.documentScore;
    }

    public int getInterviewScore() {
        return this.interviewScore;
    }
}

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            List<Volunteer> list = new ArrayList<>();

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                list.add(new Volunteer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(list, Comparator.comparing(Volunteer::getDocumentScore));

            int minInterviewScore = Integer.MAX_VALUE;
            int answer = 0;

            for(Volunteer v : list) {
                if(minInterviewScore > v.getInterviewScore()) {
                    minInterviewScore = v.getInterviewScore();
                    answer++;
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
