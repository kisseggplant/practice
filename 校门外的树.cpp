#include<iostream>
using namespace std;
#define MAX 10005
int main(){
	int arr[MAX], L, num=0, n;
	cin >> L >> n;
	for(int i=0;i<MAX;i++)	arr[i]=0;
	for(int i=0;i<=L;i++)	arr[i]=1;
	while(n--){
		int a, b;
		cin >> a >> b;
		for(int i=a;i<=b;i++)	arr[i]=0;
	}
	for(int i=0;i<=L;i++) num+=arr[i];
	cout << num << endl;
	return 0;	
} 

//加入一段判断是否有重合，有重合合并到一起，没重合单独加入
//难点：重合加入后还要判断一次重合，应该要用到递归 
//舍弃了
 
//int init(int arr[][], int j){
//	for(i)
//}
//int main(){
//	int num, n, arr[105][2], j=0;
//	cin >> num >> n;
//	for(int i=0;i<n;i++){
//		int a, b;
//		cin >> a >> b;
//		if(j==0){
//			arr[j][0]=a;
//			arr[j][1]=b;
//			j++;
//		}else{
//			int t=0;
//			for(int k=0;k<j;k++){
//				if(a>=arr[k][0]&&b<=arr[k][1]){
//					t=1;
//					break;
//				}
//				else if(a>=arr[k][0]&&a<=arr[k][1]&&b>=arr[k][1]){
//					arr[k][1]=b;
//					t=1;
//					break;
//				} 
//				else if(a<=arr[k][0]&&b>=arr[k][0]&&b<=arr[k][1]){
//					arr[k][0]=a;
//					t=1;
//					break;
//				} 
//				else if(a<=arr[k][0]&&b>=arr[k][1]){
//					arr[k][0]=a;
//					arr[k][1]=b;
//					t=1;
//					break;
//				}
//			}
//			if(t==0){
//				arr[j][0]=a;
//				arr[j][1]=b;
//				j++;
//			}
//		}	
//	}
//	int mis = 0;
//	for(int i=0;i<j;i++)	mis+=(arr[i][1]-arr[i][0]+1);
//	num = num+1-mis;
//	cout << num << endl;
//	return 0;
//}
