/**
 * 
 * 输入一篇英文文章，碰到"!!!!!"的时候停止，输出文章中出现的不重复单词的个数(注意：单词不区分大小写，如：The和the为一个单词)
 * 只需要分隔空格的情况
 * 用trim会导致结果错误
 */
package pra_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(true){
            line = in.nextLine();
            if(line.equals("!!!!!")) break;
            String[] parts = line.split("\\s+");//在这里使用trim()会导致结果错误
            for (int i=0;i<parts.length;i++) {
                String slow = parts[i].toLowerCase();
                if(!map.containsKey(slow)){
                    map.put(slow, 1);
                }else{
                    map.put(slow, map.get(slow)+1);
                }
            }
        }
        System.out.println(map.size());
        in.close();
    }
}
