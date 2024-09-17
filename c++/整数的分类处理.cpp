#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
	int n, arr[105], a1=-1, a2=-1, a3=0, a3_num = 0;
	cin >> n;
	for(int i=0;i<n;i++){
		cin >> arr[i];
		if(arr[i]%3==0&&arr[i]>a1)	a1=arr[i];
		else if(arr[i]%3==1) a2+=1;
		else if(arr[i]%3==2){
			a3 += arr[i];
			a3_num += 1;
		}
	}
	if(a1==-1)	cout << "NONE" << " ";
	else	cout << a1 << " ";
	if(a2==-1)	cout << "NONE" << " ";
	else	cout << a2+1 << " ";
	if(a3_num==0)	cout << "NONE" << endl;
	else	printf("%.1lf\n",a3*1.0/a3_num);
	return 0;
}
