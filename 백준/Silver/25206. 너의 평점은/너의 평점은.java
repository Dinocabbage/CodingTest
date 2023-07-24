import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Float> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5f);
        gradeMap.put("A0", 4.0f);
        gradeMap.put("B+", 3.5f);
        gradeMap.put("B0", 3.0f);
        gradeMap.put("C+", 2.5f);
        gradeMap.put("C0", 2.0f);
        gradeMap.put("D+", 1.5f);
        gradeMap.put("D0", 1.0f);
        gradeMap.put("F", 0.0f);

        float totalCredit = 0;
        float totalScore = 0;

        while(true) {
            StringTokenizer st;
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (NullPointerException e) {
                break;
            }
            st.nextToken();

            float credit = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();

            if(gradeMap.containsKey(grade)) {
                totalCredit += credit;
                totalScore += credit * gradeMap.get(grade);
            }
        }

        bw.write(String.format("%.6f", totalScore / totalCredit));

        bw.flush();
        bw.close();
        br.close();
    }
}
