#include <iostream>
#include <stdio.h>
using namespace std;

double zhi(double x, int n){
	double zhi = 1;
	for(int i=0;i<n;i++)	zhi*=x;
	return zhi;
}
double f(double x, int n){
	if(n==1) return x;
	else{
		if(n%2==0) return -1*zhi(x, n)+f(x, n-1);
		else return zhi(x, n)+f(x, n-1);
	}
}
int main(){
	double x;
	int n;
	cin >> x >> n;
	printf("%.2lf\n",f(x, n));
	return 0;
}
