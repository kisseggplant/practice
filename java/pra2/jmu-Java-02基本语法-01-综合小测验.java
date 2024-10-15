/**
运行程序后可以输入4个选项，分别为：fib,sort,search,getBirthDate

fib:根据输入n，打印斐波那契数列。比如输入：3，输出：1 1 2

sort:输入一串数字，然后进行排序并输出，注意数组元素输出的格式为使用[ ]包括。提示：可直接使用函数Arrays相关方法处理输出。

search:如果找到返回所找到的位置，如果没找到，返回-1。提示： 可以先对数组排序，然后使用Arrays相关函数进行查找。

getBirthDate:输入n个身份证，然后把输入的n个身份号的年月日抽取出来，按年-月-日格式输出。

当输入不是这几个字符串(fib,sort,search,getBirthDate)的时候，显示exit并退出程序。

注意： 在处理输入的时候，尽量只使用Scanner的nextLine()方法接收输入，不要将nextLine()与其它next方法混用，否则可能会出现行尾回车换行未处理影响下次输入的情况。

参考：jdk文档的Arrays，String

输入格式:
fib
3
sort
-1 10 3 2 5
search
-1
search
0
getBirthDate
1
330226196605054190
e

输出格式:
1 1 2
[-1, 2, 3, 5, 10]
0
-1
1966-05-05
exit

*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] array = new int[1000];
        int len = 0;
        while(in.hasNext()){
            String ch = in.nextLine();
            switch(ch){
                case "fib":{
                    int n = Integer.parseInt(in.nextLine());
                    int[] fib = new int[1000];
                    fib[0] = 1;
                    fib[1] = 1;
                    for(int i=0;i<n;i++){
                        if(i>1){
                            fib[i]=fib[i-1]+fib[i-2];
                        }
                        if(i<n-1)
                            System.out.printf("%d ",fib[i]);
                        else
                            System.out.println(fib[n-1]);
                    }
                    break;
                }
                case "sort":{
                    String s = in.nextLine();
                    String[] parts = s.split("\\s+");
                    int n = parts.length;
                    len = n;
                    int[] arr = new int[n];
                    for(int i=0;i<n;i++)
                        arr[i] = Integer.parseInt(parts[i]);
                    Arrays.sort(arr);
                    for(int i=0;i<n;i++)
                        array[i]=arr[i];
                    System.out.println(Arrays.toString(arr));
                    break;
                }
                case"search":{
                    String s = in.nextLine();
                    int a=Integer.parseInt(s);
                    int index=-1;
                    for(int i=0;i<len;i++){
                        if(array[i]==a){
                            index = i;
                            break;
                        }
                    }
                    System.out.println(index);
                    break;
                }
                case "getBirthDate":{
                    String s = in.nextLine();
                    int n=Integer.parseInt(s);
                    for(int i=0;i<n;i++){
                        String bir = in.nextLine();
                        System.out.printf("%s-%s-%s\n",bir.substring(6, 10),bir.substring(10, 12),bir.substring(12, 14));
                        
                    }
                    break;
                }
                default:{
                    System.out.println("exit");
                    break;
                }
            }
        }
        in.close();
    }
}
