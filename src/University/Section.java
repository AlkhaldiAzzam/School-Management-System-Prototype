package University;

import java.util.*;

public class Section {

    private int number;
    private String courseName;
    private String CRN;
    private Faculty instructor;
    private ArrayList<Student> students;
    private String location;

    public String instructorID;

    public enum Status {

        Open, Closed
    }

    private Status status;
    private int maxNumberOfStudents;

    int getTime() {
        return 0;
    }

    public Section(int number, String courseName, String CRN, String instructorID, String location, int max) { // When read from txt file.

        this.number = number;
        this.courseName = courseName;
        this.CRN = CRN;
        this.instructorID = instructorID;
        this.location = location;
        this.maxNumberOfStudents = max;

    }

    public Section(String courseName, int num) {

        this.courseName = courseName;
        number = num;
        CRN = generateCRN();
        instructor = new Faculty();
        location = "TBA";
        status = Status.Open;
        maxNumberOfStudents = 30;
    }

    private String generateCRN() {
        Random r = new Random(System.currentTimeMillis());
        int x = 10000 + r.nextInt(20000);
        return x + "";
    }

    public int getSectionNumber() {
        return number;
    }

    public void setInstructor(Faculty inst) {
        this.instructor = inst;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setMaxNumber(int num) {
        maxNumberOfStudents = num;
    }

    public int getMaxNumber() {
        return maxNumberOfStudents;
    }

    public boolean addStudent(Student stu) {

        students.add(stu);

        if (this.students.size() == this.maxNumberOfStudents) {
            this.status = Status.Closed;
        }

        return true;
    }

    public boolean removeStudent(Student stu) {

        students.remove(stu);

        if (this.students.size() < this.maxNumberOfStudents) {
            this.status = Status.Open;
        }

        return true;
    }

    public String getCRN() {
        return CRN;
    }

    public String toString() {
        return String.format("%7s-%02d\t%7s\t%7s", courseName, number, location, status);
    }
    
    public boolean equals (Section s) {
        return ( this.CRN.equals(s.CRN));
    }

}
