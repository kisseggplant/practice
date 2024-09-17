#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
	float a, b;
	char op;
	cin >> a >> b >> op;
	switch(op){
		case '+':printf("%g\n", a+b);break;
		case '-':printf("%g\n", a-b);break;
		case '*':printf("%g\n", a*b);break;
		case '/':if(b==0)cout << "Divided by zero!" << endl;
				 else	printf("%g\n", a/b);
				 break;
		default:cout << "Invalid operator!" << endl;break; 
	}
	return 0;
}
