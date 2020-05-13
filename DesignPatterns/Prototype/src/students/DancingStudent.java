package students;

public class DancingStudent extends Student {

    private Integer practiceHours;

    public Integer getPracticeHours() {
        return practiceHours;
    }

    public void setPracticeHours(Integer practiceHours) {
        this.practiceHours = practiceHours;
    }


    @Override
    public String toString() {
        return "DancingStudent{" + super.toString() + ", practiceHours=" + practiceHours + '}';
    }
}
