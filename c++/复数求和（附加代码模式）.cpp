#include <iostream>
#include <stdio.h>
using namespace std;
struct Complex{
	int r;
	int i;
};
Complex Add(Complex c1, Complex c2){
	Complex newc;
	newc.r=c1.r+c2.r;
	newc.i=c1.i+c2.i;
	return newc;
}
//int main(){
//	int n;
//	cin >> n;
//	Complex c;
//	for(int i=0;i<n;i++){
//		if(i==0)cin >> c.r >> c.i;
//		else{
//			Complex t;
//			cin >> t.r >> t.i;
//			c = Add(c, t);
//		}
//	}
//	cout << c.r << "+" << c.i << "i" << endl;
//	return 0;
//}
