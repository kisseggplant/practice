/** 

7-2 jmu-Java-06异常-02-使用异常机制处理异常输入

使用异常处理输入机制，让程序变得更健壮。

main方法：
输入n，创建大小为n的int数组。
输入n个整数，放入数组。输入时，有可能输入的是非整型字符串，这时候需要输出异常信息，然后重新输入。
使用Arrays.toString输出数组中的内容。
输入样例：
5
1
2
a
b
4
5
3

输出样例：
java.lang.NumberFormatException: For input string: "a"
java.lang.NumberFormatException: For input string: "b"
[1, 2, 4, 5, 3]
*/

package pra_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            try {
                int a = Integer.parseInt(in.nextLine());
                arr[i] = a;
            } catch (NumberFormatException e) {
                i--;
                System.out.println(e);
            }
        }
        System.out.println(Arrays.toString(arr));
        in.close();
    }
}
