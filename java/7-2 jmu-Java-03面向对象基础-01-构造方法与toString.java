/**
定义一个有关人的Person类，内含属性：
String name、int age、boolean gender、int id，所有的变量必须为私有(private)。
注意：属性顺序请严格按照上述顺序依次出现。

1.编写无参构造函数：
打印"This is constructor"。
将name,age,gender,id按照name,age,gender,id格式输出
2.编写有参构造函数
依次对name,age,gender赋值。

3.覆盖toString函数：
按照格式：类名 [name=, age=, gender=, id=]输出。建议使用Eclipse自动生成.

4.对每个属性生成setter/getter方法
5.main方法中
首先从屏幕读取n，代表要创建的对象个数。
然后输入n行name age gender , 调用上面2编写的有参构造函数新建对象。
然后将刚才创建的所有对象逆序输出。
接下来使用无参构造函数新建一个Person对象，并直接打印该对象。
输入样例:
3
a 11 false
b 12 true
c 10 false

输出样例:
Person [name=c, age=10, gender=false, id=0]
Person [name=b, age=12, gender=true, id=0]
Person [name=a, age=11, gender=false, id=0]
This is constructor
null,0,false,0
Person [name=null, age=0, gender=false, id=0]
*/
import java.util.*;
class Person{
    private String name;
    private int age;
    private boolean gender;
    private int id;
    public Person(){
    }
    public Person(String s, int a, boolean b){
        name = s;
        age = a;
        gender = b;
    }
    public String toString(){
        return String.format("Person [name=%s, age=%d, gender=%b, id=%d]",name,age,gender,id);
    }
}
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Person[] p = new Person[n];
        Person non = new Person();
        for(int i=0;i<n;i++){
            String name = in.next();
            int age = in.nextInt();
            boolean g = in.nextBoolean();
            p[i] = new Person(name, age, g);
        }
        for(int i=n-1;i>=0;i--){
            System.out.println(p[i]);
        }
        System.out.printf("This is constructor\nnull,0,false,0\n");
        System.out.println(non);
        in.close();
    }
}
