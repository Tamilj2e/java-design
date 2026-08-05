package design_patterns.practice;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Parent{
    private void display(){
        System.out.println("parent display");
    }
}
class Child extends Parent{

}

class Student{
    int id;
    String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object other){
        System.out.println("calling equals");
        if(this==other) return true;
        if(!(other instanceof Student)) return false;
        Student obj = (Student) other;
        return this.id==obj.id && Objects.equals(this.name,obj.name);

    }

    public int hashCode(){
        System.out.println("calling hashcode");
//        return super.hashCode();
        return Objects.hash(id,name);
    }

}
public class Main {
    public static void main(String[] args) {
//        Set<Student> set = new HashSet<>();
//        var s1 =new Student(1,"tamil");
//        var s2 =new Student(1,"tamil");
//        System.out.println(s1==s2);
//        set.add(new Student(1,"tamil"));
//        System.out.println(set.size());
//        System.out.println(set.contains(new Student(1,"tamil")));

    }
}
