// import java.util.*;
// public class TreeHouse {
//     static Scanner sc = new Scanner(System.in);
//         public static class Edge {
//         int v = 0;
//         int w = 0;

//         Edge(int v, int w) {
//             this.v = v;
//             this.w = w;
//         }
//     }
//     static int N;
//     @SuppressWarnings("unchecked")
//     static ArrayList<Edge>[] graph = new ArrayList[N];
//     static int gcd(int a, int b) {
//         if (a == 0)
//             return b;
//         return gcd(b % a, a);
//     }
//     public static void addEdge(int u, int v) {

//         graph[u].add(new Edge(v, w));
//     }

//     public static void main(String[] args) {
//         int t = sc.nextInt();
//         while(t-- > 0) {
//             N = sc.nextInt();
//             int x = sc.nextInt();
//             graph[0].add(new Edge(1, x));
//             while(N-- > 1) {
//                 addEdge(sc.nextInt(), sc.nextInt());
//             }
//         }
//     }
// }
#include<bits/stdc++.h>
using namespace std;
#define int long long int

bool comparator(pair<int, int>&a, pair<int, int>&b) {
    return a.second > b.second;
}

int32_t main() {
    int t;
    cin>>t;
    while(t--){
        int n, x;
        cin>>n >>x;
        map<int, vector<int>>d;
        for(int i = 2; i < n + 1; i++) {
            int u,v;
            cin >> u >> v;
            auto itr = d.find(u);
            if(itr->first == u){
                itr->second.push_back(v);
            } else {
                vector<int> l;
                l.push_back(v);
                d.insert({u,l});
            }
        }
        for(auto i = d.begin(); i != d.end(); i++) {
            vector<pair<int, int>>d_new;
            auto v = i->second;
            for(auto x = v.begin(); x != v.end(); x++){
                int c = 0;
                auto it = d.find(*x);
                if(it->first == *x){
                    c = it->second.size();
                }else {
                    c = 0;
                }
                d_new.push_back({*x, c});
            }
            sort(d_new.begin(), d_new.end(), comparator);
            vector<int>l;
            for(auto it = d_new.begin(); it != d_new.end(); it++){
                l.push_back(it->first);
            }
            i->second = l;
        }
        map<int, int> d1;
        for(int i = 1; i < n+1;i++){
            auto ir = d.find(i);
            if(ir->first == i){
                int num = 0;
                if(i == 1) {
                    num = x;
                }else {
                    num = d1.find(i)->second;
                }
                int j =1;
                for(auto itr = ir->second.begin(); itr != ir->second.end();itr++){
                    d1.insert({*itr, num*j});
                    j++;
                }
            }
        }
        int sum = x;
        for(auto itr = d1.begin(); itr != d1.end();itr++){
            sum += itr->second;
            sum = sum%10000000007;
    }
       cout<<sum%10000000007<<endl;
}
    return 0;
}
