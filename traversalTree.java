package Graph;

// BFS---> go to immediate neighbour first

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class traversalTree {
    public static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    private static int curr;

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[2].add(new Edge(3, 1));
        graph[2].add(new Edge(3, 2));

    }

    public static void bfs(ArrayList<Edge> graph[], int v, boolean visit[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (visit[curr] == false) {
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    // dfs
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visit[]) {
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visit[e.dest] == false)
                dfs(graph, e.dest, visit);
        }
    }

    public static void main(String ar[]) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visit[] = new boolean[v];
        // for (int i = 0; i < v; i++) {
        // if (visit[i] == false) {
        // bfs(graph, v, visit, i);

        // }
        // }

        dfs(graph, curr, visit);
        System.out.println();
    }
}
