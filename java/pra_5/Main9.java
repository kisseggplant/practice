package pra_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        //输入不定个数的姓名字符串，直到遇到end为止，依次将字符串存入数组列表nameList。注意：每个名字只能存1次。
        while(true){
            String name = in.nextLine();
            if(name.equals("end"))  break;
            if(!nameList.contains(name)){
                nameList.add(name);
            }           
        }
        System.out.println(nameList);

        /*  输入下标i
            输入字符串x，然后加到nameList的第i个位置。
            输入下标j，然后移除下标为j的姓名。
        */
        int i = Integer.parseInt(in.nextLine());
        String x = in.nextLine();
        int j = Integer.parseInt(in.nextLine());
        nameList.add(i, x);
        nameList.remove(j);
        System.out.println(nameList);

        /*
         *  输入字符串name1
            输入字符串name2
            输出字符串name1所在下标k(从前往后找)。
            如果k>=0，将name2放在nameList中下标k位置处(即，替换掉原来k位置的元素)。
            否则，如果k=-1，将name2直接添加nameList最后一个元素之后。
         */
        String name1 = in.nextLine();
        String name2 = in.nextLine();
        int k = nameList.indexOf(name1);
        System.out.println("k="+k);
        if(k>=0){
            nameList.set(k, name2);
        }else{
            nameList.add(name2);
        }
        System.out.println(nameList);
        in.close();
    }
}
