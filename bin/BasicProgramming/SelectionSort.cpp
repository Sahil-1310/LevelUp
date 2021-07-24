// #include<bits/stdc++.h>
// using namespace std;

// //Time complexity of selection Sort O(N^2);
// void Selection_Sort(int arr[],int len){
// 	for(int i = 0; i<len; i++){
// 		int minValue = i;
// 		for(int j = i+1; i<len; j++){
// 			if(arr[j] < arr[minValue]){
// 				minValue = j;
// 			}
// 		}
// 		swap(arr[i], arr[minValue]);
// 	}
// }
// int main()
// {
// 	/* code */
// 	int arr[10];
// 	for(int i = 0; i<10; i++){
// 		cin>>arr[i];
// 	}
	

// 	//Finding the size of an array	
// 	int len = sizeof(arr)/sizeof(arr[0]);
// 	Selection_Sort(arr,len);
	
// 	cout<<" sorted array";
// 	for(int i = 0; i<len; i++){
// 		cout<<arr[i]<<" ";
// 	}
// 	return 0;
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