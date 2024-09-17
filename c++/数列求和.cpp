#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;

/*int main(){
	int A, n;
	double res=0;
	cin >> A >> n;
	for(int i=0;i<n;i++){
		double b = pow(10, i);
		res+=(n-i)*A*b;
	}
	printf("%.0lf",res);
	return 0;
}*/
int main(){
	int A, n, arr[100010]={0};
	cin >> A >> n;
	if(n==0){
		cout << "0" << endl;
		return 0;
	}
	int i, temp=0;
	for(i=0;i<n;i++){
		arr[i]=temp+(n-i)*A;
		if(arr[i]>9){
			temp = arr[i]/10;
			arr[i]= arr[i]%10;
		}else temp = 0;
	}
	if(temp!=0){
		arr[i++]=temp;
	}
	for(i-=1;i>=0;i--)
		cout << arr[i];
	cout << endl;
	return 0;
}

