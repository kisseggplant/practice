package pra_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        //首先，输入字符串n-x-y。n代表所要处理的数据的数量，x代表姓，y代表名。
        String line = in.nextLine();
        String[] parts = line.split("-");
        int n = Integer.parseInt(parts[0]);
        String x = parts[1];
        String y = parts[2].toLowerCase();

        //然后输入n个人的信息，每一行代表一个人的信息。每行字符串格式为"姓-名-成绩-编号"，以-作为分隔符。  
        //将所有姓为x的字符串放入数组列表list1中。然后，输出list1。
        //将list1中的名字为y(忽略大小写)的字符串取出放入list2中。然后，输出list2。
        for(int i=0;i<n;i++){
            line = in.nextLine();
            parts = line.split("-");
            String xing = parts[0];
            String ming = parts[1].toLowerCase();
            if(xing.equals(x)){
                list1.add(line);
                if(ming.equals(y)){
                    list2.add(line);
                }
            }
        }
        System.out.println(list1);
        System.out.println(list2);

        //对list2中的字符串按成绩进行降序排序并输出。
        list2.sort((s1, s2) -> {
            String[] p1 = s1.split("-");
            String[] p2 = s2.split("-");
            int g1 = Integer.parseInt(p1[2]);
            int g2 = Integer.parseInt(p2[2]);
            return g2-g1;
        });
        System.out.println(list2);


        in.close();
    }
}
