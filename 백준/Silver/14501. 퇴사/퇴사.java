import java.util.Scanner;

public class Main {
    static int N;   // 남은 일수
    static int[] time, price;   // 상담 기간, 금액을 각각 배열로 저장

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        time = new int[N];
        price = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = scanner.nextInt();
            price[i] = scanner.nextInt();
        }

        int maxProfit = getMaxProfit(0, 0);  // 메서드 호출(첫 날, 누적 수익)
        System.out.println(maxProfit);
    }

//  가능한 모든 상담 조합 탐색 및 최대 수익 계산
    static int getMaxProfit(int day, int profit) {   // day : 현재 상담일, profit : 누적 수익
        if (day >= N) {     // 재귀 종료 조건 : day가 N보다 크거나 같은지 확인(N일까지의 모든 상담을 고려했다는 의미)
            return profit;  // 현재까지 누적된 수익 반환
        }

        int maxProfit = 0;  // 최대 수익을 저장할 변수

        if (day + time[day] <= N) {     // 현재 날짜의 상담을 일정에 포함시킬 수 있는지 확인(현재 상담일 + 해당 상담일의 소요 기간이 N보다 작은지 검사)
            maxProfit = Math.max(maxProfit, getMaxProfit(day + time[day], profit + price[day]));    // 현재의 최대 수익과 포함 시킨 후의 최대 수익 중 큰 값을 저장
        }

        maxProfit = Math.max(maxProfit, getMaxProfit(day + 1, profit));     // 포함시키지 않는 경우도 고려하여 최대값 저장

        return maxProfit;
    }
}
