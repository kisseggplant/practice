/**
根据输入的n，打印n行乘法口诀表。
需要使用二维字符串数组存储乘法口诀表的每一项，比如存放1*1=1.
为了保证程序中使用了二维数组，需在打印完乘法口诀表后使用Arrays.deepToString打印二维数组中的内容。  

提醒：格式化输出可使用String.format或者System.out.printf。

输出格式说明
每行末尾无空格。
每一项表达式之间(从第1个表达式的第1个字符算起到下一个表达式的首字符之间)，共包含7个字符。如2*1=2  2*2=4从第1个2开始到第二项``2*2=4`首字母之间，总共有7个字符(包含空格，此例中包含2个空格)。
输入样例:
2
5

输出样例:
1*1=1
2*1=2  2*2=4
[[1*1=1], [2*1=2, 2*2=4]]
1*1=1
2*1=2  2*2=4
3*1=3  3*2=6  3*3=9
4*1=4  4*2=8  4*3=12 4*4=16
5*1=5  5*2=10 5*3=15 5*4=20 5*5=25
[[1*1=1], [2*1=2, 2*2=4], [3*1=3, 3*2=6, 3*3=9], [4*1=4, 4*2=8, 4*3=12, 4*4=16], [5*1=5, 5*2=10, 5*3=15, 5*4=20, 5*5=25]]
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            String[][] s = new String[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    s[i][j]=String.format("%d*%d=%d",i+1,j+1,(i+1)*(j+1));
                    if(j!=i){
                        System.out.printf("%-7s",s[i][j]);
                    }else{
                        System.out.printf("%s\n",s[i][j]);
                    }
                }
            }
            System.out.println(Arrays.deepToString(s).replace(", null",""));
        }
        in.close();
    }
}
