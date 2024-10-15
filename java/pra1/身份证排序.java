import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        String[] lines = new String[n];
        String[] date = new String[n];
        String op = "";
        in.nextLine();
        for(int i =0;i<n;i++){
            lines[i] = in.nextLine();
            date[i] = lines[i].substring(6, 14);
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(lines[i]);
        // }
        while(in.hasNext()){
            op = in.nextLine();
            if(op.equals("sort1")){
                Arrays.sort(date);
                for(String d : date){
                    String temp = d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6,8);
                    System.out.println(temp);
                }
            }else if(op.equals("sort2")){
                Arrays.sort(lines, new Comparator<String>(){
                    public int compare(String id1, String id2){
                        String date1 = id1.substring(6,14);
                        String date2 = id2.substring(6,14);
                        return date1.compareTo(date2);
                    }
                });
                for(String id : lines){
                    System.out.println(id);
                }
            }else{
                System.out.println("exit");
                break;
            }
        }
        in.close();
    }
}
