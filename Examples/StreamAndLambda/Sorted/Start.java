import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) {
        ArrayList<Student> students1 =  new ArrayList<>();
        students1.add(new Student("Kamal",60));
        students1.add(new Student("Nimal",90));
        students1.add(new Student("Amal",50));
        System.out.println("Students unsorted\n"+ students1);
        System.out.println("Students sorted using inner class\n"+  students1.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMarks() - o2.getMarks();
            }
        }).collect(Collectors.toList()));
        System.out.println("Students sorted using a class that implement Comparator interface\n"+  students1.stream().sorted(new StudentRanker()).collect(Collectors.toList()));
        System.out.println("Students sorted with lambda expression\n"+  students1.stream().sorted((s1,s2)->s1.getMarks()-s2.getMarks()).collect(Collectors.toList()));

    }
}
class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return getName()+" "+getMarks();
    }
}
class StudentRanker implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMarks() - o2.getMarks();
    }
}