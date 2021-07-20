import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class l001 {
    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;

   @SuppressWarnings("unchecked")
    // public static ArrayList<Edge>[] graph = new ArrayList[N];
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void constructGraph() {
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
    }

    public static void display() {

        for(int i = 0; i<N; i++) {
            System.out.print(i + "->");
            for(Edge e : graph[i]) {
                System.out.print("("+ e.v+","+ e.w + ")");
            }
            System.out.println();
        }
    }

    public static void removeEdge(int u,int v) {

    }
    static boolean visted []=new boolean[N];
    public static boolean hasPath( int u, int v) {
        if(u==v) return true;

        visted[u] = true;
        for(Edge edge : graph[u]) {
            if(visted[edge.v]==false) {
                boolean ishaspath = hasPath(edge.v,v);
                if(ishaspath == true) return true;
            }
        }
        return false;
    }
    static int count = 0;
    public static int printAllPath(int u,int v)
    {
        if(u==v) return 1;

        visted[u] = true;
        for(Edge edge : graph[u]) {
            if(visted[edge.v]==false) {
                 count += printAllPath(edge.v,v);
            }
            visted[edge.v] = false;
        }
        return count;
    }

    public static boolean hamiltonPathAndCycle(int src){
        if(src == N-1){
            for(int i = 0; i<N; i++){
                if(visted[i]!=true){
                    return false;
                }
            }
            return true;
        }
        visted[src] = true;
        for(Edge edge : graph[src]){
            if(visted[edge.v]!=true){
                boolean isHamiltonPath = hamiltonPathAndCycle(edge.v);
                if(isHamiltonPath!=false) return true;
            }
        }
        return false;
    }
    //class->23/02/2021
    public static void BFS_cycle(int src,boolean visted[],int des1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int des = des1;
        int atlevel = -1; //On which level my destination is there
        boolean iscyclic  = false;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.print(level+" ->");
            while(size!=0) {
                int front = queue.poll();
                System.out.print(front+" ");
                if(visted[front]){
                    iscyclic = true;
                    continue;
                }
                if(des == front){
                    atlevel = level;
                }
                visted[front] = true;
                for(Edge e : graph[front]) {
                    if(!visted[front]) {
                        queue.add(e.v);
                    }
                }
            }
            level++;
            System.out.println();
        }
    }

    //class 25 feb 2021   Toplogical sort




    //class 27 feb 2021
    public static void main(String []args)
    {
        constructGraph();
        display();
    }

}