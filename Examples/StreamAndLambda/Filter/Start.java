import java.util.ArrayList;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) {
        ArrayList<Student> students1 =  new ArrayList<>();
        students1.add(new Student("Kamal",60));
        students1.add(new Student("Nimal",90));
        students1.add(new Student("Amal",50));
        System.out.println("Students \n"+ students1);

        System.out.println("Students filtered \n"+students1.stream().filter((s)->s.getMarks()>55).collect(Collectors.toList()));


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
