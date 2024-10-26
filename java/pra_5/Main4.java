/**
 * 输入格式
输入: 若干字符串，放入strList。直到输入为!!end!!时，结束输入。

在strList头部新增一个begin，尾部新增一个end。

输出列表元素

输入: 字符串str

判断strList中有无包含字符串str，如包含输出true，否则输出false。并且输出下标，没包含返回-1。

在strList中从后往前找。返回其下标，找不到返回-1。

移除掉第1个(下标为0)元素,并输出。然后输出列表元素。

输入: 字符串str

将第2个（下标为1）元素设置为字符串str.

输出列表元素

输入: 字符串str

遍历strList，将字符串中包含str的元素放入另外一个ArrayList strList1，然后输出strList1。

在strList中使用remove方法，移除第一个和str相等的元素。

输出strList列表元素。

使用clear方法，清空strList。然后输出strList的内容，size()与isEmpty()，3者之间用,连接。

输入样例:
a1 b1 3b a2 b2 b1 12b c d !!end!!
b1
second
b

输出样例:
[begin, a1, b1, 3b, a2, b2, b1, 12b, c, d, end]
true
2
6
begin
[a1, b1, 3b, a2, b2, b1, 12b, c, d, end]
[a1, second, 3b, a2, b2, b1, 12b, c, d, end]
[3b, b2, b1, 12b]
[a1, second, 3b, a2, b2, b1, 12b, c, d, end]
[],0,true


 */


package pra_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> strList = new ArrayList<>();
        String line = in.nextLine();
        String[] parts = line.split("\\s+");
        for(int i=0;i<parts.length;i++){
            if(!parts[i].equals("!!end!!")){
                strList.add(parts[i]);
            }else{
                break;
            }
        }
        strList.add(0, "begin");
        strList.add("end");
        System.out.println(strList);
        String temp = in.nextLine(); //判断是否包含
        System.out.println(strList.contains(temp));
        System.out.println(strList.indexOf(temp));

        int index = strList.size()-1;
        // for(;index>-1;index--){
        //     String string = strList.get(index);
        //     if(string.equals(temp)){
        //         break;
        //     }
        // }
        // System.out.println(index);

        index = 0;
        int res = -1;
        for (String string : strList) {
            if(string.equals(temp)){
                res = index;
            }
            index++;
        }
        if(res!=-1){
            System.out.println(res);//要的是正序的序号
        }else{
            System.out.println(-1);
        }

        //移除掉第1个(下标为0)元素,并输出。然后输出列表元素
        System.out.println(strList.get(0));
        strList.remove(0);
        System.out.println(strList);

        //将第2个（下标为1）元素设置为字符串str
        temp = in.nextLine();
        strList.set(1, temp);
        System.out.println(strList);

        temp = in.nextLine();
        int count = 0;
        index = -1;
        int res_index = -1;
        ArrayList<String> strList1 = new ArrayList<>();
        for (String string : strList) {
            index++;
            if(string.contains(temp)){
                strList1.add(string);
            }
            if(string.equals(temp)&&count == 0){
                count++;
                res_index=index;
            }
        }//在遍历的同时删除元素会导致非零返回
        if(res_index>-1)
            strList.remove(res_index);

        System.out.println(strList1);
        System.out.println(strList);
        strList.clear();
        System.out.println(strList+","+strList.size()+","+strList.isEmpty());
        in.close();
    }
}
