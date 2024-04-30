package se.yrgo.domain;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

@Entity
//@Table(name="TBL_STUDENT)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 30)
    private int id;
    @Column(length = 30)
    private String enrollmentID;
    @Column(length = 30)
    private String name;
    @ManyToOne
    private Tutor tutor;

    public String getTutorName() {
        return this.tutor.getName();
    }


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getEnrollmentID() {
        return  enrollmentID;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
