/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a_3bd
 */
public class University {
    
    public static int number_Of_Students = 0;
    static int number_Of_Faculty = 0;
    static int number_Of_Courses = 0;
    static int number_Of_Sections = 0;
    
    
    
    
    private static int studentIndex = 1;
    private static int facultyIndex = 1;
    //static Faculty[] faculty = new Faculty[100];
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Faculty> faculty = new ArrayList<>();
    //static Student[] students = new Student[100];
    //private Course[] courses;

    
    private final static File studentsFile = new File("data/students.txt");
    private final static File facultyFile = new File("data/faculty.txt");
    
    
    
    public static void readStudents() throws Exception {
        Scanner fscn = new Scanner(studentsFile);

        while (fscn.hasNextLine()) {
            
           //if (fscn.nextLine().trim().isEmpty())
              //  continue;
            //int index = Integer.parseInt(fscn.nextLine());
            String name = new String(fscn.nextLine());
            long ID = Long.parseLong( fscn.nextLine() );
            String major = new String(fscn.nextLine());
            String advID = (fscn.nextLine());
            String sections = new String(fscn.nextLine()); // CRN's
            
            Faculty f = null;
            
            for (Faculty x : faculty) {
                if (x.getID().equals(advID))
                    f = x;
            }

            //Student s = new Student(name, ID, major, advID, faculty[advID]);
            Student s = new Student(name, ID, major, f);

            //students[index] = s;
            //studentIndex = index + 1;
            students.add(s);
            number_Of_Students++;
        }
        fscn.close();
    }
    
    public static void readFaculty() throws Exception {
        Scanner fscn = new Scanner(facultyFile);

        while (fscn.hasNextLine()) {
            
            //int index = Integer.parseInt(fscn.nextLine());
            String name = new String(fscn.nextLine());
            String ID = new String(fscn.nextLine());
            String department = new String(fscn.nextLine());
            //int advID = Integer.parseInt(fscn.nextLine());
            String classes = new String(fscn.nextLine()); // 2,3,5

            Faculty f = new Faculty (name, ID, department);
            //faculty[index] = f;
            //facultyIndex = index + 1;
            faculty.add(f);
            number_Of_Faculty++;
        }
        fscn.close();
    }
    
}
