#include<iostream>
using namespace std;
int akm(int m, int n){
	if(m==0)	return n+1;
	else{
		if(n==0)
			return akm(m-1, 1);
		else
			return akm(m-1, akm(m, n-1));
	}
}
int main(){
	int m, n, res;
	cin >> m >> n;
	res = akm(m, n);
	cout << res << endl;
	return 0;
}
