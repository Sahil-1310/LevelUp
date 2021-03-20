// import java.util.*;
// public class Basic {
//     public static class Edge {
//         int v = 0;
//         int w = 0;

//         Edge(int v, int w) {
//             this.v = v;
//             this.w = w;
//         }
//     }
//    static int N = 0;
//     LinkedList<Edge> graph [];

//     Basic (int N) {
//         @SuppressWarnings("unchecked")
//         this.N = N;
//         graph = new LinkedList[N];
//     }

//         //Making Bidirectional Graph
//         for(int i = 0; i < N; i++) {
//             graph[i] = new LinkedList<>();
//         } 

//     public static void addEdge(int u, int v, int w) {
//         graph[u].add(new Edge(v, w));
//         graph[v].add(new Edge(u, w));
//     }

//     public static class primspair {
//     	int vex = 0;
//     	int par = 0;
//     	int wt =0;
//     	public primspair(int vex, int par, int wt) {
//     		this.vex = vex;
//     		this.par = par;
//     		this.wt = wt;
//     	}
//     }
//     public static void primsAlg(int src, boolean [] vis, LinkedList<Edge> graph) {
//     	LinkedList<Edge>[] MST = new LinkedList[N];
//     	for(int i = 0; i < N; i++) {
//     		 MST[i] = new LinkedList<>();
//     	}
//     	PriorityQueue<primspair> pt = new PriorityQueue<>(a,b) ->{
//     		return a.wt - b.wt;
//     	}

//     }
//     public static void main(String [] args) {

//     }
// }
import java.util.*;
class Basic {
    static Scanner sc = new Scanner(System.in);
    static void goodNessString() {
        int T = sc.nextInt();
        while(T > 0) {
            int L1 = sc.nextInt();
            int C1 = sc.nextInt();
            String st = sc.next();
            System.out.println(goodness2(L1, C1, st));
            T--;
        }
    }
    static int goodness2(int l1, int c1, String str) {
        int count = 0;
        for(int i = 0;i < l1;i++) {
            if(str.charAt(0) != str.charAt(l1-i))
                count++;
        }
        return count = c1 - count;
    }
    public static void main(String []args) {
        goodNessString();
    }
}