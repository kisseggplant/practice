#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;
struct  Node{
    int r;  // 系数
    int e;  // 指数
};
// 线性表存储一元多项式
struct List{
    Node data[10000+5];
    int len;
};

// 输出多项式
void PrintList(const List& list){
	int num=0;
	for(int i=0;i<list.len;i++){
		if(list.data[i].r!=0){
			num++;
			cout << list.data[i].r << " " << list.data[i].e << " ";
		}
	}
	if(num==0)
		cout << 0;
	cout << endl;

}

// 输入多项式
List InputList(){
	List list;
	int r, e, len=0;
	while(cin >> r >> e){
		if(r!=-1&&e!=-1){
			list.data[len].e = e;
			list.data[len].r = r;
			len++;
		}
		else break;
	}
	list.len = len;
	return list;
}

// 多项式求导
List getDerivation(const List& list){
	List newlist;
	for(int i=0;i<list.len;i++){
		newlist.data[i].r=list.data[i].r*list.data[i].e;
		newlist.data[i].e=list.data[i].e-1;
	}
	newlist.len = list.len;
	return newlist;
}

int main(){
    // freopen("/config/workspace/answer/DataStructure/test.in","r",stdin);    
    List list = InputList();
    List newlist = getDerivation(list);
    PrintList(newlist);
    return 0;
}
