#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
	int a[105], b[105], c[210], m, n;
	cin >> m;
	for(int i=0;i<m;i++) cin >> a[i];
	cin >> n;
	for(int i=0;i<n;i++) cin >> b[i];
	int i=0,j=0,k=0;
	while(i<m&&j<n){
		if(a[i]==b[j]){
			c[k]=a[i];
			c[k+1]=a[i];
			k+=2;i++;j++;
		}
		else if(a[i]<b[j]){
			c[k]=a[i];
			i++;k++;
		}
		else{
			c[k]=b[j];
			j++;k++;
		}
	}
	while(i<m){
		c[k]=a[i];
		i++;k++;
	}
	while(j<n){
		c[k]=b[j];
		j++;k++;
	}
	for(int i=0;i<k;i++)
		cout << c[i] << " ";
	cout << endl;
	return 0;
}
