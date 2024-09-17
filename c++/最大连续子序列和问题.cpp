#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
	int n, low_index, high_index, max, arr[100005];
	while(cin >> n){
		int low = 0, high = 0;
		low_index=-1;
		high_index=-1;
		max = 0;
		for(int i=0;i<n;i++)	cin >> arr[i];
		while(low<n){
			int temp=0;
			for(int i=low;i<n;i++){
				temp = temp + arr[i];
				if(temp>max){
					max=temp;
					low_index=low;
					high_index=i;
				}
				else if(temp<=0){
					low=i;
					break;
				}
			}
			low+=1;
		}
		if(max>0)
			cout << max << " " << low_index << " " << high_index << endl;
		else
			cout << "0 -1 -1" << endl;
	}
	return 0;
}
