/**
 * 输入格式:
固定为2行，第一行为m，第二行为n个人的名称列表，用英文字母代表，元素直接使用英文逗号 ， 分开

输出格式:
一行，为出列元素序列，元素之间使用英文逗号 ， 分开【注意：末尾元素后没有逗号】

输入样例:
在这里给出一组输入。例如：

3
a,b,c,d,e,f,g
输出样例:
在这里给出相应的输出。例如：

c,f,b,g,e,a,d
 */
package pra_5;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        String[] parts = line.split("[ ,]+");
        int count = parts.length;
        int length = count;
        int index = -1;
        int k = 0;
        while(count>0){
            k++;

            //保证每次index跳跃有效
            while(parts[(index+1)%length]==null){
                index=(index+1)%length;
            }
            index=(index+1)%length;   
            
            if(k%m==0){
                k=0;
                count--;
                if(count>0){
                    System.out.printf(parts[index]+",");
                    parts[index]=null;
                }else{
                    System.out.println(parts[index]);
                    break;
                }
            }
        }
        in.close();
    }
}
