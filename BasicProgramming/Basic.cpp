#include<bits/stdc++.h>
#define ll long long int
using namespace std;

void swap(int &a, int &b){
	int temp = b;
	b = a;
	a = temp;
}

int main(){
	int a,b;
	cin>>a>>b;
	swap(a,b);
	cout<<a<<" "<<b<<endl;
}	