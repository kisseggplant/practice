package pra_5;

import java.util.Scanner;

class IllegalScoreException extends Exception{
    private int score;
    public IllegalScoreException(int a){
        super("IllegalScoreException: score out of range, score=");
        score=a;
    }
    public String toString() {
        return this.getMessage()+score;
    }
}
class IllegalNameException extends Exception{
    private String name;
    public IllegalNameException(String a){
        super("IllegalNameException: the first char of name must not be digit, name=");
        name=a;
    }
    public String toString() {
        return this.getMessage()+name;
    }
}

class Student{
    private String name;
    private int score;
    public String getName() {
        return name;
    }

    //如果姓名首字母为数字则抛出IllegalNameException
    public void setName(String name)throws IllegalNameException {
        String fir = name.substring(0, 1);
        if(fir.compareTo("0")>=0&&fir.compareTo("9")<=0)throw new IllegalNameException(name);
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }
    public int addScore(int score)throws IllegalScoreException{
        if(score+this.score<0||score+this.score>100)throw new IllegalScoreException(score);
        this.score+=score;
        return this.score;
    }
}
public class Main3 {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        String str;
        while(true){
            str=in.nextLine();
            if(str.equals("new")){
                str=in.nextLine();
                String []s=str.split("\\s+");
                if(s.length==2){
                    Student st=new Student();
                    try{
                        st.setName(s[0]);
                        st.addScore(Integer.parseInt(s[1]));
                        System.out.println(st);
                    }catch(IllegalNameException e){
                        System.out.println(e);
                    }catch(IllegalScoreException e){
                        System.out.println(e);
                    }catch(Exception e){
                        System.out.println(e);   
                    }
                }else System.out.println("java.util.NoSuchElementException");
                
            }else break;
        }
        in.close();
        System.out.println("scanner closed");
    }

}


/** 
————————————————

    版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
                        
    原文链接：https://blog.csdn.net/sylviiiiiia/article/details/133994371
*/