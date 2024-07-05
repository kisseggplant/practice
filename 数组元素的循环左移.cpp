#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
	int n, m, arr[105];
	cin >> n >> m;
	for(int i=0;i<n;i++)	cin >> arr[i];
	m=m%n;
	for(int i=m;i<m+n;i++)
		cout << arr[i%n] << " ";
	cout << endl;
	return 0;
}
