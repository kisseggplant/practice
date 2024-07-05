#include <iostream>
using namespace std;
#define MAX 1000000
struct client{
    int p;
    int k;
};
struct clients{
    int len;
    struct client client[MAX+5];
};
int main(){
    struct clients cs;
    cs.len = 0;
    int op=-1;
    cin >> op;
    while(op != 0){
        if(op==1){
            int k, p, flag=0;
            cin >> k >> p;
            for(int i=0;i<cs.len;i++){
                if(cs.client[i].p<p){
                    for(int j=cs.len;j>i;j--){
                        cs.client[j].k=cs.client[j-1].k;
                        cs.client[j].p=cs.client[j-1].p;
                    }
                    cs.client[i].p=p;
                    cs.client[i].k=k;
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                cs.client[cs.len].k=k;
                cs.client[cs.len].p=p;
            }
            cs.len+=1;
        }
         else if(op==2){
            if(cs.len==0){
                cout << "0" << endl;
            }   
            else{
                cout << cs.client[0].k << endl;
                for(int i=0;i<cs.len-1;i++){
                    cs.client[i].k=cs.client[i+1].k;
                    cs.client[i].p=cs.client[i+1].p;
                }
                cs.len-=1;
            }
        }
        else if(op==3){
            if(cs.len==0){
                cout << "0" << endl;
            }   
            else{
                cout << cs.client[cs.len--].k << endl;
            }
        }
        cin >> op;
    }
    return 0;
}
