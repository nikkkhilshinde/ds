package codechef.graph;

import java.util.*;

public class Graph {
    int v; // no of vertices
    List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new List[v];
    }

    void addEdge(int u, int v, boolean bid) {
        if (adj[u] == null) {
            adj[u] = new ArrayList<>();
        }
        if(bid){
            if(adj[v] == null){
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);

        }
        adj[u].add(v);
    }

    public static Set<Integer> visited = new HashSet<>();

    void DFS(int u) {
        visited.add(u);
        System.out.println(u);
        if (adj[u] != null) {
            for (int i = 0; i < adj[u].size(); i++) {
                if (!visited.contains(adj[u].get(i))) {
                    DFS(adj[u].get(i));
                }
            }
        }
    }


    void BFS(int u) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(u);
        visited.add(u);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            System.out.println(cur);
            if (adj[cur] != null) {
                adj[cur].forEach(element -> {
                    if (!visited.contains(element)) {
                        queue.add(element);
                        visited.add(element);
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(2, 5, true);
        graph.addEdge(5, 6, true);
        graph.addEdge(5, 7, true);
        graph.addEdge(6, 7, true);
        graph.addEdge(4, 1, true);
        graph.BFS(1);
    }
}
