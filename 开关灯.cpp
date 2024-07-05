#include<iostream>
using namespace std;
int main(){
	int n, m, arr[5005];
	cin >> n >> m;
	for(int i=1;i<=n;i++)	arr[i]=1;
	for(int i=1;i<=m;i++){
		if(i==1){
			for(int j=i;j<=n;j++)	arr[j]=0;
		}
		else{
			for(int j=1;j<=n;j++){
				if(j%i==0){
					if(arr[j]==0)	arr[j]=1;
					else if(arr[j]==1)	arr[j]=0;
				}
			}
		}
	}
	int num=0;
	for(int i=1;i<=n;i++){
		if(arr[i]==0){
			if(num==0){
				cout << i;
				num++;
			}
			else{
				cout << "," << i;
				num++;
			}
		}			
	}
	cout << endl;
	return 0;
}
