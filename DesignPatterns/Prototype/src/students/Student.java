package students;

public abstract class Student implements Cloneable {

    private String name;
    private Integer schoolHours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchoolHours() {
        return schoolHours;
    }

    public void setSchoolHours(Integer schoolHours) {
        this.schoolHours = schoolHours;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public String toString() {
        return "name=" + name + ", schoolHours=" + schoolHours;
    }
}
