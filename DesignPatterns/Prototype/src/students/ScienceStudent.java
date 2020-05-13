package students;

public class ScienceStudent extends Student {

    private Integer labHours;

    public Integer getLabHours() {
        return labHours;
    }

    public void setLabHours(Integer labHours) {
        this.labHours = labHours;
    }


    @Override
    public String toString() {
        return "ScienceStudent{" +super.toString()+ ", labHours=" + labHours + '}';
    }
}
