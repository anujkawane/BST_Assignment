package com.akawane0813.model;

import java.util.Objects;

/**
 * A Student has a redid, FirstName, LastName and GPA.
 * @author Anuj Kawane <akawane0813@sdsu.edu>
 */
public class Student implements Comparable<Student> {
    private Integer redId;
    private String firstName;
    private String lastName;
    private Double gpa;

    public Student(Integer redId, String firstName, String lastName, Double gpa) {
        this.redId = redId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public Integer getRedId() {
        return redId;
    }

    public void setRedId(Integer redId) {
        this.redId = redId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && redId.equals(student.redId) && firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redId, firstName, lastName, gpa);
    }

    @Override
    public int compareTo(Student object) {
        return Double.compare(this.getRedId(),(object.getRedId()));
    }

    @Override
    public String toString() {
        return "{ " + "RedId= " + redId + ", Name= " + lastName + " " + firstName + ", Gpa= " + gpa + " }";
    }
}
