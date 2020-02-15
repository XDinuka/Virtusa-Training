package lk.dinuka.springthreeemp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String location;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    List<Telephone> telephones;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "employee_projects",
            inverseJoinColumns = {@JoinColumn(name = "project_id",referencedColumnName = "id")},
            joinColumns  = {@JoinColumn(name = "employee_id",referencedColumnName = "id")}
    )
    List<Project> projects;

    @Transient
    Allocation[] allocations;

    public Employee() {
    }

    public Employee(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Allocation[] getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocation[] allocations) {
        this.allocations = allocations;
    }
}
