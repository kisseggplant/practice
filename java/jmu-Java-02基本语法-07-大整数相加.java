/**
有若干大整数，需要对其进行求和操作。

输入格式
每行输入一个字符串代表一个大整数，连续输入若干行，当某行字符为e或E时退出。

输入样例:
42846280183517070527831839425882145521227251250327
55121603546981200581762165212827652751691296897789
e
输出样例:
97967883730498271109594004638709798272918548148116
*/
import java.util.*;
import java.math.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BigInteger sum = new BigInteger("0");
        while(in.hasNext()){
            String s = in.nextLine();
            if(s.equalsIgnoreCase("e"))
                break;
            BigInteger a = new BigInteger(s);
            sum = sum.add(a);
        }
        System.out.println(sum);
        in.close();
    }
}
