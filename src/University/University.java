package University;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class University {

    public static int number_Of_Students = 0;
    static int number_Of_Faculty = 0;
    static int number_Of_Courses = 0;
    static int number_Of_Sections = 0;

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Faculty> faculty = new ArrayList<>();
    static ArrayList<Section> sections = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();

    private final static File sectionsFile = new File("data/sections.txt");
    private final static File studentsFile = new File("data/students.txt");
    private final static File facultyFile = new File("data/faculty.txt");

    public static void readSections() throws Exception {
        Scanner fscn = new Scanner(sectionsFile);

        while (fscn.hasNextLine()) {

            int number = Integer.parseInt(fscn.nextLine());
            String courseName = fscn.nextLine();
            String CRN = fscn.nextLine();
            String instructorID = fscn.nextLine();
            String location = fscn.nextLine();
            int maxNumber = Integer.parseInt(fscn.nextLine());

            Section sec = new Section(number, courseName, CRN, instructorID, location, maxNumber);

            sections.add(sec);
            number_Of_Sections++;
        }
        fscn.close();
    }

    public static void readStudents() throws Exception {
        Scanner fscn = new Scanner(studentsFile);

        while (fscn.hasNextLine()) {

            String name = new String(fscn.nextLine());
            long ID = Long.parseLong(fscn.nextLine());
            String major = new String(fscn.nextLine());
            String advID = (fscn.nextLine());
            String sections = new String(fscn.nextLine()); // CRN's

            Faculty f = null;

            for (Faculty x : faculty) {
                if (x.getID().equals(advID)) {
                    f = x;
                }
            }

            Student s = new Student(name, ID, major, f);

            students.add(s);
            number_Of_Students++;
        }
        fscn.close();
    }

    private static ArrayList<Section> readCRN(String CRNs) {

        ArrayList<Section> classes = new ArrayList<>();
        ;
        try {

            ArrayList<String> CRNsList = (ArrayList<String>) Arrays.asList(CRNs.split(","));

            for (Section s : sections) {
                if (CRNsList.contains(s.getCRN())) {
                    classes.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at -readCRN- in University Class");
        }
        return classes;

    }

    public static void readFaculty() throws Exception {
        Scanner fscn = new Scanner(facultyFile);

        while (fscn.hasNextLine()) {

            String name = new String(fscn.nextLine());
            String ID = new String(fscn.nextLine());
            String department = new String(fscn.nextLine());
            ArrayList<Section> s = readCRN(fscn.nextLine());

            // When find CRN, set this Faculty as an instructor for that CRN's section.
            Faculty f = new Faculty(name, ID, department, s);

            faculty.add(f);
            number_Of_Faculty++;
        }
        fscn.close();
    }

}
