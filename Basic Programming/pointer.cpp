#include<bits/stdc++.h>
using namespace std;


void Vector() {
	std::vector<int> v;
	for(int i = 0; i<5; i++) {
		v.push_back(i);// I will be entering the values in the last of vectors
	}
	 for(int i = 0; i<v.size(); i++) {
	 	cout<<v[i]<<" ";
	 }
	 cout<<endl;

	vector<int>::iterator it; //Traverse By Iterator
	for(it = v.begin(); it!=v.end(); it++) {
		cout<<*it<<" ";
	}
	cout<<endl;
	// auto, it will automatically detect which datatype of vector is this
	for(auto i = v.begin(); i!=v.end(); i++) {
		cout<<*i<<" ";
	}

}


int main() {
	// int x = 5; 
	// int *p_x;     //Pointer In C++
	// p_x = &x;
	// cout<< &x<<endl;
	// cout<< &p_x<<endl;
	// cout<< "Pointer address:" << p_x<< endl;
	// Vector();


	// int arr[10];
	// arr[0] = 0;
	// arr[1] = 1;
	// cout<<&arr<<" "<<arr<<" "<<arr+1<<" "<<&arr+1;
	int arr[]={1,2,3,4,5,7};
	cout<< sizeof(arr)/sizeof(arr[0])<<endl;
	int indegree [6];	
	for(int i = 0; i < 6; i++) {
		indegree[i]++;

	}
	for(int i = 0; i < 6; i++) {
		cout<< indegree[i]<<endl;
	}

}