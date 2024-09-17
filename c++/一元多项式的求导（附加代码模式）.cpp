#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;
struct  Node{
    int r;  // ϵ��
    int e;  // ָ��
};
// ���Ա�洢һԪ����ʽ
struct List{
    Node data[10000+5];
    int len;
};

// �������ʽ
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

// �������ʽ
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

// ����ʽ��
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
