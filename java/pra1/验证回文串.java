import java.util.Scanner;
public class Main{
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String line= scanner.nextLine();
    int len = line.length();
    boolean t = true;
    for(int i=0;i<len/2;i++){
        if(line.charAt(i)!=line.charAt(len-i-1)){
            t = false;
            break;
        }
    }
    if(t)
        System.out.println("yes");
    else
        System.out.println("no");
    scanner.close();
}
    
}
