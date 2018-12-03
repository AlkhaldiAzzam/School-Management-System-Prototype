/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a_3bd
 */
public class Student {
    
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String year; // needed when adding
    final private String idNumber;
    private String major;
    private int advID;
    private ArrayList <String> section;

    private Faculty advisor;

    //private ArrayList <Course> courses;
    //private ArrayList <String> grades;
    

    public Student (String name, String ID, String major, int advID, Faculty advisor) { // Read From File.
        
        // read and add to ArrayList.
        // index = last item index's + 1
        
        
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

        idNumber = ID;
        this.major = major;
        this.advID = advID;
        this.advisor = advisor;
        
    }
    
    public Student(String name, String year) { // new Students

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
        idNumber = generateID(year);
        major = "undecided";
        advID = 0;
        
        section = new ArrayList <>();
        
        // Add to ArrayList & txt file
        // index is 0, unless there's intial info in txt.
    }
    
    
    private String generateID(String year) {
        Random r = new Random(System.currentTimeMillis());
        int x = 10000 + r.nextInt(20000);
        return year + x;
    }

    
    public String toString () {
        return ("Name: " + firstName + " " + middleName + " " + lastName + ", ID: " + idNumber + ", Major: " + major + ", \nAdvisor: " + advisor);
    }
    
}
