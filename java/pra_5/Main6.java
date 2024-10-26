/**
 * 输入样例:
杨利伟
费俊龙 聂海胜
翟志刚 景海鹏 刘伯明
景海鹏 刘旺 刘洋
聂海胜 张晓光 王亚平
景海鹏 陈东
end


输出样例:
杨利伟 1
费俊龙 1
聂海胜 2
翟志刚 1
景海鹏 3
刘伯明 1
刘旺 1
刘洋 1
张晓光 1
王亚平 1
陈东 1
 */
package pra_5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> persons = new LinkedHashMap<>();
        while(true){
            String line = in.nextLine();
            if(line.equals("end"))  break;
            String[] parts = line.split("\\s+");
            for(int i=0;i<parts.length;i++){
                if(!persons.containsKey(parts[i])){
                    persons.put(parts[i], 1);
                }else{
                    persons.put(parts[i], persons.get(parts[i])+1);
                }
            }
        }
        List<String> keys = new ArrayList<>(persons.keySet());
        List<Integer> values = new ArrayList<>(persons.values());
        for(int i=0;i<persons.size();i++){
            System.out.println(String.format("%s %d", keys.get(i), values.get(i)));
        }
        in.close();
    }
}
