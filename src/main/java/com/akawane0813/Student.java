package com.akawane0813;
/**
 * A Student has a redid, FirstName, LastName and GPA.
 * @author Anuj Kawane <akawane0813@sdsu.edu>
 */
public class Student implements Comparable<Student> {
    private Integer redId;
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(Integer redId, String firstName, String lastName, double gpa) {
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public int compareTo(Student object) {
        return Double.compare(this.getRedId(),(object.getRedId()));
    }

    @Override
    public String toString() {
        return "Student{" +
                "RedId= " + redId +
                ", Name= " + lastName + " " + firstName +
                ", Gpa= " + gpa +
                '}';
    }
}
