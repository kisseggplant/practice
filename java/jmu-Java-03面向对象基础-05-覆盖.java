/**
7-12 jmu-Java-03面向对象基础-05-覆盖
分数 20
作者 郑如滨
单位 集美大学
Java每个对象都继承自Object,都有equals、toString等方法。
现在需要定义PersonOverride类并覆盖其toString与equals方法。  

1. 新建PersonOverride类
a. 属性：String name、int age、boolean gender，所有的变量必须为私有(private)。

b. 有参构造方法，参数为name, age, gender

c. 无参构造方法，使用this(name, age,gender)调用有参构造方法。参数值分别为"default",1,true

d.toString()方法返回格式为：name-age-gender

e. equals方法需比较name、age、gender，这三者内容都相同，才返回true.

2. main方法
2.1 输入n1，使用无参构造方法创建n1个对象，放入数组persons1。
2.2 输入n2，然后指定name age gender。每创建一个对象都使用equals方法比较该对象是否已经在数组中存在，如果不存在，才将该对象放入数组persons2。
2.3 输出persons1数组中的所有对象
2.4 输出persons2数组中的所有对象
2.5 输出persons2中实际包含的对象的数量
2.5 使用System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));输出PersonOverride的所有构造方法。

提示：使用ArrayList代替数组大幅复简化代码，请尝试重构你的代码。

输入样例:
1
3
zhang 10 true
zhang 10 true
zhang 10 false

输出样例:
default-1-true
zhang-10-true
zhang-10-false
2
[public PersonOverride(), public PersonOverride(java.lang.String,int,boolean)]
*/

import java.util.*;

class PersonOverride {
    private String name;
    private int age;
    private boolean gender;

    public PersonOverride() {
        this("default", 1, true);
    }

    public PersonOverride(String n, int a, boolean g) {
        name = n;
        age = a;
        gender = g;
    }
    @Override
    public String toString() {
        return name + "-" + age + "-" + gender;
    }
    public boolean equals(PersonOverride p){
        return (name.equals(p.name)&&age==p.age&&gender==p.gender);
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = Integer.parseInt(in.nextLine());
        int n2 = Integer.parseInt(in.nextLine());
        int n2r = 0;
        PersonOverride[] persons1 = new PersonOverride[n1];
        PersonOverride[] persons2 = new PersonOverride[n2];
        for(int i=0;i<n1;i++){
            persons1[i]=new PersonOverride();
        }
        for(int i=0;i<n2;i++){
            String line = in.nextLine();
            String[] parts=line.split("\\s+");
            String name=parts[0];
            int age=Integer.parseInt(parts[1]);
            boolean gender=Boolean.parseBoolean(parts[2]);
            PersonOverride temp = new PersonOverride(name, age, gender);

            boolean flag = true;
            for(int j=0;j<n2r;j++){
                if(persons2[j].equals(temp)){
                    flag=false;
                    break;
                }
            }
            if(flag)    persons2[n2r++]=temp;
        }
        for(int i=0;i<n1;i++)   System.out.println(persons1[i]);
        for(int i=0;i<n2r;i++)  System.out.println(persons2[i]);
        System.out.println(n2r);
        System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));
        in.close();
    }
}
