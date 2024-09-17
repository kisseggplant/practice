#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;
int main(){
	int n;
	double arr[10005]={0}, x, res=0;
	cin >> n;
	for(int i=0;i<n+1;i++)	cin >> arr[i];
	cin >> x;
	for(int i=0;i<n+1;i++)
		res+=arr[i]*pow(x, i);
	printf("%.2lf\n",res);
	return 0;
}
