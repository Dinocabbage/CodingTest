import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean canAvoid;
    static char[][] field;
    static ArrayList<int[]> teachers;

    public static void placeObstacle(int count, int x, int y) {
        if(count == 3) {
            if(isCanAvoid()) {
                canAvoid = true;
            }

            return;
        }

        for(int i = x; i < N; i++) {
            for(int j = (i == x ? y : 0) ; j < N; j++) {
                if(field[i][j] == 'X') {
                    field[i][j] = 'O';
                    placeObstacle(count + 1, i, j + 1);

                    if(canAvoid) {
                        return;
                    }

                    field[i][j] = 'X';
                }
            }
        }
    }

    public static boolean isCanAvoid() {
        for(int[] teacher : teachers) {
            for(int i = teacher[0] - 1; i >= 0; i-- ) {
                if(field[i][teacher[1]] == 'S') {
                    return false;
                }
                else if(field[i][teacher[1]] == 'O') {
                    break;
                }
            }

            for(int i = teacher[0] + 1; i < N; i++) {
                if(field[i][teacher[1]] == 'S') {
                    return false;
                }
                else if(field[i][teacher[1]] == 'O') {
                    break;
                }
            }

            for(int i = teacher[1] - 1; i >= 0; i--) {
                if(field[teacher[0]][i] == 'S') {
                    return false;
                }
                else if(field[teacher[0]][i] == 'O') {
                    break;
                }
            }

            for(int i = teacher[1] + 1; i < N; i++) {
                if(field[teacher[0]][i] == 'S') {
                    return false;
                }
                else if(field[teacher[0]][i] == 'O') {
                    break;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        field = new char[N][N];
        teachers = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                field[i][j] = st.nextToken().charAt(0);

                if(field[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        canAvoid = false;

        placeObstacle(0, 0, 0);

        if(canAvoid) {
            bw.write("YES");
        }
        else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
