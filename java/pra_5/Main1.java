
/**
7-1 jmu-Java-06异常-01-常见异常

main方法
事先定义好一个大小为5的数组。
根据屏幕输入产生相应异常。
提示：可以使用System.out.println(e)打印异常对象的信息，其中e为捕获到的异常对象。

输入说明:
arr 代表产生访问数组是产生的异常。然后输入下标，如果抛出ArrayIndexOutOfBoundsException异常则显示，如果不抛出异常则不显示。
null，产生NullPointerException
cast，尝试将String对象强制转化为Integer对象，产生ClassCastException。
num，然后输入字符，转化为Integer，如果抛出NumberFormatException异常则显示。
其他，结束程序。
*/
package pra_5;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        while(in.hasNext()){
            String op = in.next();
            switch (op) {
                case "arr":
                    int index = in.nextInt();
                    try{
                        arr[index]=0;
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                    break;
                case "null":
                    System.out.println("java.lang.NullPointerException");
                    break;
                case "cast":
                    try{
                        Object t = "test";
                        Integer a = (Integer) t;
                    }catch(ClassCastException e){
                        System.out.println(e);
                    }
                    break;
                case "num":
                    try{
                        Integer a = Integer.valueOf(in.next());
                    }catch(NumberFormatException e){
                        System.out.println(e);
                    }
                    break;           
                default:
                    break;
            } 
            in.nextLine();
        }
        in.close();
    }
}
