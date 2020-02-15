package lk.dinuka.springone.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    String name;
    Integer age;

    public Employee() {
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", 24));
        employeeList.add(new Employee("Jane Doe", 25));
        employeeList.add(new Employee("Tim Apple",200));
        return employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
