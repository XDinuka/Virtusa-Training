import students.DancingStudent;
import students.ScienceStudent;
import students.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    private Map<StudentType, Student> studentMap;

    public StudentRegistry() {
        studentMap = new HashMap<>();
        initialize();
    }

    public Student getStudent(StudentType studentType) {
        try {
            return (Student) studentMap.get(studentType).clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    private void initialize() {
        ScienceStudent scienceStudent = new ScienceStudent();
        scienceStudent.setName("John Doe");
        scienceStudent.setSchoolHours(6);
        scienceStudent.setLabHours(2);
        studentMap.put(StudentType.SCIENCE, scienceStudent);
        DancingStudent dancingStudent = new DancingStudent();
        dancingStudent.setName("John Doe");
        dancingStudent.setSchoolHours(4);
        dancingStudent.setPracticeHours(4);
        studentMap.put(StudentType.DANCING, dancingStudent);
    }
}
