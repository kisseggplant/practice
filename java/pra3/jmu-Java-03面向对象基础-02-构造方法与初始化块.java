/**
1.定义一个Person类
属性：String name, boolean gender, int age, int id ,所有的变量必须为私有(private)。
无参构造函数:Person(), 功能：打印This is constructor  。
有参构造函数:Person(name, gender, age)   ，功能：给属性赋值。
建议：使用Eclipse自动生成toString方法  

2.定义类的初始化块
为Person类加入初始化块，在初始化块中对id属性赋值，并且要保证每次的值比上次创建的对象的值+1。然后在下一行打印This is initialization block, id is ...  其中...是id的值。
提示：可为Person类定义一个static属性来记录所创建的对象个数。

3.编写静态初始化块
打印This is static initialization block

4.编写main方法
首先输入n，代表要创建的对象数量。
然后从控制台分别读取n行的name age gender, 并调用有参构造函数Person(name, age, gender)新建对象 。
将创建好的n个对象逆序输出(即输出toString()方法)。
使用无参构造函数新建一个Person对象，然后直接打印该对象。
思考
初始化类与对象有几种方法，构造函数、初始化块、静态初始化块。这三种方法执行的先后顺序是什么？各执行几次。

输入样例:
3
a 11 false
b 12 true
c 10 false

输出样例:
This is static initialization block
This is initialization block, id is 0
This is initialization block, id is 1
This is initialization block, id is 2
Person [name=c, age=10, gender=false, id=2]
Person [name=b, age=12, gender=true, id=1]
Person [name=a, age=11, gender=false, id=0]
This is initialization block, id is 3
This is constructor
null,0,false,3
Person [name=null, age=0, gender=false, id=3]

*/
import java.util.*;
class Person{
    private String name;
    private int age;
    private boolean gender;
    private int id;
    private static int nextid = 0;
    {
        id = nextid;
        nextid++;
    }
    static{
        System.out.println("This is static initialization block");
    }
    public Person(){
        System.out.printf("This is initialization block, id is %d\n",id);
        System.out.printf("This is constructor\n%s,%d,%b,%d\n",name,age,gender,id);
    }
    public Person(String s, boolean b, int a){
        name = s;
        age = a;
        gender = b;
        System.out.printf("This is initialization block, id is %d\n",id);
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
        
        for(int i=0;i<n;i++){
            String name = in.next();
            int age = in.nextInt();
            boolean g = in.nextBoolean();
            p[i] = new Person(name, g, age);
        }
        for(int i=n-1;i>=0;i--){
            System.out.println(p[i]);
        }
        Person non = new Person();
        System.out.println(non);
        in.close();
    }
}
