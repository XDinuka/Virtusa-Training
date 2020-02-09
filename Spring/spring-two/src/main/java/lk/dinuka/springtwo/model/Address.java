package lk.dinuka.springtwo.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String row_one;
    String row_two;
    String row_three;
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    public Address() {
    }

    public Address(String row_one, String row_two) {
        this.row_one = row_one;
        this.row_two = row_two;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRow_one() {
        return row_one;
    }

    public void setRow_one(String row_one) {
        this.row_one = row_one;
    }

    public String getRow_two() {
        return row_two;
    }

    public void setRow_two(String row_two) {
        this.row_two = row_two;
    }

    public String getRow_three() {
        return row_three;
    }

    public void setRow_three(String row_three) {
        this.row_three = row_three;
    }
}
