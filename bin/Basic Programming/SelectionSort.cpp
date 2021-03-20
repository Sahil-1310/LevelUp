#include<bits/stdc++.h>
using namespace std;

//Time complexity of selection Sort O(N^2);
void Selection_Sort(int arr[],int len){
	for(int i = 0; i<len; i++){
		int minValue = i;
		for(int j = i+1; i<len; j++){
			if(arr[j] < arr[minValue]){
				minValue = j;
			}
		}
		swap(arr[i], arr[minValue]);
	}
}
int main()
{
	/* code */
	int arr[10];
	for(int i = 0; i<10; i++){
		cin>>arr[i];
	}
	

	//Finding the size of an array	
	int len = sizeof(arr)/sizeof(arr[0]);
	Selection_Sort(arr,len);
	
	cout<<" sorted array";
	for(int i = 0; i<len; i++){
		cout<<arr[i]<<" ";
	}
	return 0;
}	