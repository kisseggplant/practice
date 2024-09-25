//jmu-Java-03面向对象基础-05-覆盖
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
