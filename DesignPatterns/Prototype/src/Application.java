import students.DancingStudent;
import students.ScienceStudent;
import students.Student;

public class Application {
    public static void main(String[] args) {

        StudentRegistry studentRegistry = new StudentRegistry();

        ScienceStudent scienceStudent1 = (ScienceStudent) studentRegistry.getStudent(StudentType.SCIENCE);
        scienceStudent1.setName("Gabriella Shaver");
        scienceStudent1.setLabHours(5);
        System.out.println(scienceStudent1);

        ScienceStudent scienceStudent2 = (ScienceStudent) studentRegistry.getStudent(StudentType.SCIENCE);
        scienceStudent2.setName("Darwin Cambareri");
        System.out.println(scienceStudent2);

        DancingStudent dancingStudent1 = (DancingStudent) studentRegistry.getStudent(StudentType.DANCING);
        dancingStudent1.setName("Nona Macarthur");
        System.out.println(dancingStudent1);
    }
}
