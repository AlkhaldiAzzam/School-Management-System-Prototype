package University;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student {

    private static ArrayList<Long> idList = new ArrayList<>();

    String fullName;
    String advisorName;

    String firstName;
    String middleName;
    String lastName;
    private int year; // needed when adding
    private long id;
    //final private long id;
    String major;

    private ArrayList<Section> classes = new ArrayList<>(10);
    //index 0 for 7 am class ..... index 9 for 4:10 class

    private Faculty advisor;
    private final static File studentsFile = new File("data/students.txt");

    public Student(String name, long ID, String major, Faculty advisor) { // Read From File.

        if (idList.contains(ID)) {
            //throw exception (duplicated id)
        }

        name = name.trim();
        int startSpace = name.indexOf(" ");
        int endSpace = name.lastIndexOf(" ");

        if (startSpace >= 0) {
            firstName = name.substring(0, startSpace);
            if (endSpace > startSpace) {
                middleName = name.substring(startSpace + 1, endSpace);
            }
            lastName = name.substring(endSpace + 1, name.length());
        }

        id = ID;
        this.major = major;
        this.advisor = advisor;

        //this.setAdvisorName(advisor.toString());
        //advisorName = advisor.name;
    }
    
    public Student (Student other) { // Copy Constructor.
        
        this.firstName = other.firstName;
        this.middleName = other.middleName;
        lastName = other.lastName;
        id = other.id;
        major = other.major;
        advisor = other.advisor;
        
        
    }

    public Student(String name, int year, String major)  { // new Students

        
        try {
        name = name.trim();
        
        int startSpace = name.indexOf(" ");
        int endSpace = name.lastIndexOf(" ");

        if (startSpace >= 0) {
            firstName = name.substring(0, startSpace);
            if (endSpace > startSpace) {
                middleName = name.substring(startSpace + 1, endSpace);
            }
            lastName = name.substring(endSpace + 1, name.length());
        }

        this.year = year;
        id = generateID(year * 100000);
        //System.out.println(id);
        this.major = major;
        classes = new ArrayList<>();

        University.students.add(this);
        University.number_Of_Students++;
        writeToFile();
        
        } catch (Exception e) {
            System.out.println("Exception at Student Class");
        }

    }

    public boolean addToSection(Section sec) {

        if (sec.getStatus().equals(Section.Status.Closed)) {
            return false;
        }

        for (Section x : classes) {
            if (x.getTime() == sec.getTime()) {
                return false;
            }
        }

        classes.add(sec);
        sec.addStudent(this);
        return true;
    }

    public boolean removeFromSection(Section sec) {

        for (Section x : classes) {
            if (x.getCRN().equals(sec.getCRN())) {
                classes.remove(x);
                sec.removeStudent(this);
                return true;
            }
        }

        return false;
    }

    private long generateID(int year) {
        long id = 0;
        do {
            int random = 10000 + (int) (Math.random() * ((89999) + 1));
            id = year + random;
        } while (idList.contains(id));
        idList.add(id);
        return id;
    }

    private void writeToFile()  {

        BufferedWriter bw;
        try {
            /*
            bw = new BufferedWriter( new FileWriter("data/students.txt", true));
            bw.write(this.firstName +" " + this.middleName + " " + this.lastName + "\n");
            bw.write(this.id+"\n");
            bw.write(this.major + "\n");
            bw.write("TBA\n");
            bw.newLine();
            bw.flush();
            bw.close(); */
            
        FileWriter fw = new FileWriter(studentsFile, true);
        PrintWriter out = new PrintWriter(fw);

        // write index
        out.println(firstName + " " + middleName + " " + lastName);
        out.println(id);
        out.println(major);
        out.println("TBA");
        out.println("0");

        // write crns for sections for sections arrayList
        out.close();
                    
        }
        catch (Exception e) {
            System.out.println("Exception at writeToFile method  - at Student class.");
        }
    }

    public String toString() {
        return ("Name: " + firstName + " " + middleName + " " + lastName + ", ID: " + id + ", Major: " + major + ", \nAdvisor: " + advisor);
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getMajor() {
        return major;
    }

    public Long getId() {
        return id;
    }

    public void setAdvisorName(String n) {
        advisorName = n;
    }

    public boolean equals (Student s) {
        return ( this.id == (s.id));
    }
}
