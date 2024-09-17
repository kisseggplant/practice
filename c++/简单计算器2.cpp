#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
	int res, b, flag = 1;
	char op;
	cin >> res;
	cin >> op;
	while(op!='='){
		cin >> b;
		switch(op){
		case '+':res=res+b;break;
		case '-':res=res-b;break;
		case '*':res=res*b;break;
		case '/':if(b==0)	flag = 0;
				 else	res=res/b;
				 break;
		default:flag = 0;break; 
		}
		if(flag==0){
			cout << "ERROR" << endl;
			break;
		}
		cin >> op;
	}
	if(flag!=0)	cout << res << endl;
	return 0;
}
