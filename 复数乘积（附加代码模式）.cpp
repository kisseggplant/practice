#include<iostream>
using namespace std;
struct Complex{
	int r;//Êµ²¿
	int i;//Ðé²¿ 
};
Complex Add(Complex c1, Complex c2){
	Complex newc;
	newc.r=c1.r+c2.r;
	newc.i=c1.i+c2.i;
	return newc;
}
Complex Mul(Complex c1, Complex c2){
	Complex newc;
	newc.r=c1.r*c2.r-c1.i*c2.i;
	newc.i=c1.r*c2.i+c1.i*c2.r;
	return newc;
}
//int main(){
//	Complex c1, c2;
//	cin >> c1.r >> c1.i >> c2.r >> c2.i;
//	Complex c = Mul(c1, c2);
//	cout << c.r << " " << c.i << endl;
//	return 0;
//}
