#include<iostream>
using namespace std;
int main(){
	int m = 0;
	while(scanf("%d",&m)!=EOF){
		int a[210], b[105],n=0;
		for(int i=0;i<m;i++)	cin >> a[i];
		cin >> n;
		for(int i=0;i<n;i++)	cin >> b[i];
		for(int i=0;i<m;i++){
			if(i==0)	cout << a[i];
			else	cout << " " << a[i];
		}
		cout << endl;
		for(int i=0;i<n;i++){
			if(i==0)	cout << b[i];
			else	cout << " " << b[i];
		}
		cout << endl;
		for(int j=0;j<n;j++){
			int flag = 1;
			for(int i=0;i<m;i++)
				if(a[i]==b[j]){
					flag = 0;
					break;
				}
		
			if(flag==1)
				a[m++] = b[j];
			for(int i=0;i<m;i++){
				if(i==0)	cout << a[i];
				else	cout << " " << a[i];
			}
			cout << endl;
		}
		cout << endl;
	}
	return 0;
}
