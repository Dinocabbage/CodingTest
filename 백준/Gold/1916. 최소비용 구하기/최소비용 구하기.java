import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    private int destination;
    private int cost;

    public Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public int compareTo(Bus b) {
        return Integer.compare(this.cost, b.getCost());
    }
}

public class Main {
    public int solution(int sectionStart, int sectionDestination, ArrayList<ArrayList<Bus>> graph, int[] costs) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(sectionStart, 0));
        costs[sectionStart] = 0;

        while(!pq.isEmpty()) {
            Bus tmp = pq.poll();

            int now = tmp.getDestination();
            int nowCost = tmp.getCost();

            if(nowCost > costs[now]) {
                continue;
            }

            for(Bus b : graph.get(now)) {
                int newCost = b.getCost() + nowCost;
                
                if(costs[b.getDestination()] > newCost) {
                    costs[b.getDestination()] = newCost;
                    pq.offer(new Bus(b.getDestination(), newCost));
                }
            }
        }

        return costs[sectionDestination];
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Bus>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Bus(destination, cost));
        }

        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sectionStart = Integer.parseInt(st.nextToken());
        int sectionDestination = Integer.parseInt(st.nextToken());

        int answer = m.solution(sectionStart, sectionDestination, graph, costs);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
