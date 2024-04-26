package se.yrgo.domain;

import jakarta.persistence.*;


import java.util.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 30)
    private int id;
    @Column(length = 30)
    private String tutorId;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private int salary;
    @OneToMany
    @Column(length = 30)
    private List<Student> teachingGroup;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup() {
        List<Student> unmodifiable = Collections.unmodifiableList(this.teachingGroup);
        return unmodifiable;
    }

    @Override
    public String toString() {
        return "Tutor" +
                "Tutor-ID: " + tutorId + '\'' +
                ", Name: " + name + '\'' +
                ", Salary: " + salary;
    }
}
