#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
	int n , a[1005], x, flag = 0;
	cin >> n;
	for(int i=0;i<n;i++)	cin >> a[i];
	cin >> x;
	for(int i=0;i<n;i++)
		if(x<=a[i]){
			cout << i+1 << endl;
			flag = 1;
			break;
		}	
	if(flag==0)	cout << n+1 << endl;
	return 0;
}
