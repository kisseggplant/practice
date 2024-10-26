/**
 * 定义IntegerStack接口，该接口描述了一个存放Integer的栈的常见方法：

public Integer push(Integer item); // 如item为null，则不入栈直接返回null。否则直接入栈，然后返回item。
public Integer pop(); // 出栈，如栈为空，则返回null。
public Integer peek(); // 获得栈顶元素，如栈顶为空，则返回null。注意：不要出栈
public boolean empty(); // 如果栈为空返回true
public int size();  // 返回栈中元素数量
定义IntegerStack的实现类ArrayListIntegerStack，内部使用ArrayList存储。该类中包含：  

构造方法：
在无参构造方法中新建ArrayList或者LinkedList，作为栈的内部存储。
思考：查询JDK文档，尝试说明本题到底使用哪个List实现类最好。

方法:
public String toString()       //用于输出List中的内容,可直接调用List的toString()方法。可用System.out.println(list)进行输出。

提示：

不建议使用top指针。最好直接复用List实现类中已有的方法。
pop时应将相应的元素从列表中移除。
main方法说明
建立ArrayListIntegerStack对象
输入m个值，均入栈。每次入栈均打印入栈返回结果。
输出： 栈顶元素，输出是否为空，然后输出size.
输出栈中所有元素（调用其toString()方法）
输入x，然后出栈x次，每次均打印出栈的对象。
输出:栈顶元素，输出是否为空，输出size。注意：这里的输出栈顶元素，仅输出、不出栈。
输出栈中所有元素（调用其toString()方法）。注意：返回null，也要输出。

输入样例
5
1 3 5 7 -1
2
输出样例
1
3
5
7
-1
-1,false,5
[1, 3, 5, 7, -1]
-1
7
5,false,3
[1, 3, 5]
 */package pra_5;

import java.util.ArrayList;
import java.util.Scanner;

interface IntegerStack {
    public Integer push(Integer item); // 如item为null，则不入栈直接返回null。否则直接入栈，然后返回item。

    public Integer pop(); // 出栈，如栈为空，则返回null。

    public Integer peek(); // 获得栈顶元素，如栈顶为空，则返回null。注意：不要出栈

    public boolean empty(); // 如果栈为空返回true

    public int size(); // 返回栈中元素数量
}

class ArrayListIntegerStack implements IntegerStack {
    private ArrayList<Integer> arr;

    public ArrayListIntegerStack() {
        this.arr = new ArrayList<Integer>();
    }

    public ArrayListIntegerStack(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return arr.toString();
    }

    @Override
    public boolean empty() {
        if(arr.size()==0)
            return true;
        return false;
    }

    @Override
    public Integer peek() {
        //if(arr.get(arr.size()-1)==null)
        if(this.empty())//上面的判断方法会导致IndexOutOfBoundsException
            return null;
        return arr.get(arr.size()-1);
    }

    @Override
    public Integer pop() {
        if(this.empty())
            return null;
        else{
            Integer res = this.peek();
            arr.remove(arr.size()-1);
            return res;
        }
    }

    @Override
    public Integer push(Integer item) {
        if(item == null)
            return null;
        else{
            arr.add(item);
            return item;
        }
    }

    @Override
    public int size() {
        return arr.size();
    }
    
}

public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayListIntegerStack a = new ArrayListIntegerStack();
        int m = Integer.parseInt(in.nextLine());
        for(int i=0;i<m;i++){
            Integer aitem = in.nextInt();
            System.out.println(a.push(aitem));
        }
        in.nextLine();
        System.out.println(a.peek()+","+a.empty()+","+a.size());
        System.out.println(a.toString());
        int x = in.nextInt();
        for(int i=0;i<x;i++){
            System.out.println(a.pop());
        }
        System.out.println(a.peek()+","+a.empty()+","+a.size());
        System.out.println(a.toString());
        in.close();
    }
}
