#include<iostream>
#include<cstdio>
#include<cstring>
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
	int num = 0;
	for(int i=0;i<list.len;i++){
		if(list.data[i].r!=0){
			if(num==0){
				num++;
				cout << list.data[i].r << " " << list.data[i].e;
			}else{
				num++;
				cout << " " << list.data[i].r << " " << list.data[i].e;
			}
		}
	}
	if(num==0)	cout << "0";
	cout << endl;
}

// 输入多项式
List InputList(){
	struct List list;
	int r, e, len=0;
	while(cin >> r >> e){
		if(r==-1&&e==-1)	break;
		else{
			list.data[len].e=e;
			list.data[len].r=r;
			len++;
		}
	}
	list.len=len;
	return list;
}

// 多项式求和
List add(const List& list1, const List& list2){
	struct List list3;
	int i=0, j=0, k=0;
	while(i<list1.len&&j<list2.len){
		if(list1.data[i].e==list2.data[j].e){
			list3.data[k].e=list1.data[i].e;
			list3.data[k].r=list1.data[i].r+list2.data[j].r;
			i++;j++;k++;
		}
		else if(list1.data[i].e>list2.data[j].e){
			list3.data[k].e=list1.data[i].e;
			list3.data[k].r=list1.data[i].r;
			i++;k++;
		}
		else if(list1.data[i].e<list2.data[j].e){
			list3.data[k].e=list2.data[j].e;
			list3.data[k].r=list2.data[j].r;
			j++;k++;
		}
	}
	while(i<list1.len){
			list3.data[k].e=list1.data[i].e;
			list3.data[k].r=list1.data[i].r;
			i++;k++;
	}
	while(j<list2.len){
			list3.data[k].e=list2.data[j].e;
			list3.data[k].r=list2.data[j].r;
			j++;k++;
	}
	list3.len=k;
	return list3;
}
//int main(){
//    // freopen("/config/workspace/answer/DataStructure/test.in","r",stdin);    
//    List list1 = InputList();
//    List list2 = InputList();
//    List list = add(list1, list2);
//    PrintList(list);
//    return 0;
//}
