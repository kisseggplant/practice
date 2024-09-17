#include<iostream>
#define MAX 1005
using namespace std;
int in(int arr[], int max, int &k, int a){
	if(k==0){
		arr[k]=a;
		k++;
		return 0;
	} 
	else{
		int k1=k%max;
		int flag=0;
		for(int i=0;i<max&&i<k;i++){
			if(a==arr[i]){
				flag=1;
				break;
			}
		}
		if(flag==1)return 1;
		else if(flag==0){
			arr[k1]=a;
			k++;
			return 0;
		}
	}
}
int main(){
	int m, n, arr[MAX], k=0, num=0;
	cin >> m >> n;
	for(int i=0;i<m;i++)	arr[i]=-1;
	for(int i=0;i<n;i++){
		int a;
		cin >> a;
		if(!in(arr, m, k, a))	num++;
	}
	cout << num << endl;
	return 0;
}
