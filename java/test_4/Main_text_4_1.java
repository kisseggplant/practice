package test_4;

import java.util.Scanner;

abstract class Shape{
    abstract public double area();
} 
class Circle extends Shape{
    private double radius;
    Circle(double radius){this.radius=radius;}
    public double area(){
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double area(){
        return length * width;
    }
}
class Triangle extends Shape{
    private double height;
    private double bottom;
    Triangle(double height, double bottom) {
        this.height = height;
        this.bottom = bottom;
    }
    public double area() {
        return height*bottom/2;
    }
}
public class Main_text_4_1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[5];
        for(int i=0;i<5;i++)    arr[i]=in.nextDouble();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(arr[0]);
        shapes[1] = new Rectangle(arr[1], arr[2]);
        shapes[2] = new Triangle(arr[3], arr[4]); 
        for (Shape shape : shapes) {
            System.out.printf("%.2f\n", shape.area());
        }
        in.close();
    }
}
