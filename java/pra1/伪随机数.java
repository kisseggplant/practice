import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        Random rand = new Random(k);
        for(int i=0;i<n;i++){
            int res = rand.nextInt(m);
            if(i==n-1)
                System.out.println(res);
            
        }
        in.close();
    }
}
