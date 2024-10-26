package test_4;
import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String name;
    private int year;
    private int month;
    private int day;
    private String id;
    private String school;
    
    public Student(String name, int year, int month, int day, String id, String school) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.id = id;
        this.school = school;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + year;
        result = prime * result + month;
        result = prime * result + day;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((school == null) ? 0 : school.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (year != other.year)
            return false;
        if (month != other.month)
            return false;
        if (day != other.day)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (school == null) {
            if (other.school != null)
                return false;
        } else if (!school.equals(other.school))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ", birthday=" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + ", studentId=" + id + ", school=" + school
                + "]";
    }
    public int compareTo(Student othStudent){
        return id.compareTo(othStudent.id);
    }   
}
public class Main_test_4_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Student[] stus = new Student[n];
        for(int i=0;i<n;i++){
            String line = in.nextLine();
            String[] parts = line.split("\\s+");
            String name = parts[0];
            int year = Integer.parseInt(parts[1]);
            int month = Integer.parseInt(parts[2]);
            int day = Integer.parseInt(parts[3]);
            String id = parts[4];
            String school = parts[5];
            stus[i] = new Student(name, year, month, day, id, school);
        }
        Arrays.sort(stus);
        for(Student s : stus){
            System.out.println(s);
        }
        in.close();
    }
}
