/**
前言
前面题目形状中我们看到，为了输出所有形状的周长与面积，需要建立多个数组进行多次循环。这次试验使用继承与多态来改进我们的设计。

本题描述
1.定义抽象类Shape
属性：不可变静态常量double PI，值为3.14，
抽象方法:public double getPerimeter(),public double getArea()

2.Rectangle与Circle类均继承自Shape类。
Rectangle类(属性：int width,length)、Circle类(属性：int radius)。
带参构造方法为Rectangle(int width,int length),Circle(int radius)。
toString方法(Eclipse自动生成)

3.编写double sumAllArea方法计算并返回传入的形状数组中所有对象的面积和与
double sumAllPerimeter方法计算并返回传入的形状数组中所有对象的周长和。  

4.main方法
4.1 输入整型值n，然后建立n个不同的形状。如果输入rect，则依次输入宽、长。如果输入cir，则输入半径。
4.2 然后输出所有的形状的周长之和，面积之和。并将所有的形状信息以样例的格式输出。  提示：使用Arrays.toString。
4.3  最后输出每个形状的类型与父类型.使用类似shape.getClass() //获得类型, shape.getClass().getSuperclass() //获得父类型;

注意：处理输入的时候使用混合使用nextInt与nextLine需注意行尾回车换行问题。

思考
你觉得sumAllArea和sumAllPerimeter方法放在哪个类中更合适？
是否应该声明为static?
*/
import java.util.Arrays;
import java.util.Scanner;

class Shape{
    protected static final double PI = 3.14;
    public double getPerimerter(){return 0;};
    public double getArea(){return 0;};
    public static double sumAllArea(Shape[] arr){
        double res = 0;
        for(Shape s : arr){
            res += s.getArea();
        }
        return res;
    }
    public static double sumAllPerimeter(Shape[] arr){
        double res = 0;
        for(Shape s : arr){
            res += s.getPerimerter();
        }
        return res;
    }
}
class Rectangle extends Shape{
    private int width;
    private int length;
    Rectangle(){};
    Rectangle(int width, int length){
        this.length = length;
        this.width = width;
    }
    public double getPerimerter(){
        return 2*(length+width);
    }
    public double getArea(){
        return length*width;
    }
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", length=" + length + "]";
    }
    
}
class Circle extends Shape{
    private int radius;
    Circle(){};
    Circle(int radius){
        this.radius = radius;
    }
    public double getPerimerter(){
        return 2*radius*PI;
    }
    public double getArea(){
        return radius*radius*PI;
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
    
}
public class Main {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Shape[] arr = new Shape[n];
        for(int i=0;i<n;i++){
            String temp = in.nextLine();
            if(temp.equals("rect")){
                String lines = in.nextLine();
                String[] parts = lines.split("\\s+");
                int length = Integer.parseInt(parts[0]);
                int width = Integer.parseInt(parts[1]);
                arr[i] = new Rectangle(length, width);
            }
            else if(temp.equals("cir")){
                int radius = Integer.parseInt(in.nextLine());
                arr[i]=new Circle(radius);
            }
        }
        System.out.println(Shape.sumAllPerimeter(arr));
        System.out.println(Shape.sumAllArea(arr));
        System.out.println(Arrays.toString(arr));
        for(Shape e : arr){
            System.out.println(e.getClass()+","+e.getClass().getSuperclass());
        }
        in.close();
    }
}
