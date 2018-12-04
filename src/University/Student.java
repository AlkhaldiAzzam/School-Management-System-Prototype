package University;


import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import University.Student;

//import University.Student;

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
	
	private static ArrayList <Long> idList = new ArrayList<>();
    
    private String firstName;
    private String middleName;
    private String lastName;
    private int year; // needed when adding
    final private long id;
    private String major;
    
    private ArrayList <Section> sections = new ArrayList<>(10); 
  //index 0 for 7 am class ..... index 9 for 4:10 class

    private Faculty advisor;

    //private ArrayList <Course> courses;
    //private ArrayList <String> grades;
    

    private final static File studentsFile = new File("students.txt");
    
    
    public Student (String name, long ID, String major, Faculty advisor) { // Read From File.
        
        // read and add to ArrayList.
        // index = last item index's + 1
    	
        if(idList.contains(ID)) {
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
        
    }
    
    public Student(String name, int year) throws IOException{ // new Students

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
        id = generateID(year*100000);
        System.out.println(id);
        major = "undecided";
        sections = new ArrayList <>();
        
        
        writeToFile(this);
            
        // Add to ArrayList 
        // index is 0, unless there's initial info in txt.
    }
    
    private boolean addSection(Section sec) {
    	boolean done = true;
    	for (int i=0;i<sections.size();i++) {
    		if(sec.getTime()==sections.get(i).getTime()) {
    			done = false;
    			break;
    		}
    	}
    	if (done) {
    		sections.add(sec);
    	}
    	return done; // if there is a section registered at the same time it will return false
    }
    private long generateID(int year) {
    	long id =0;
    	do {
        int random = 10000 + (int)(Math.random() * ((89999) + 1));
        id = year + random;
    	}while (idList.contains(id));
    	idList.add(id);
        return id;
    }

    private void writeToFile(Student s) throws IOException{
    	
        FileWriter fw = new FileWriter(studentsFile, true);	    
        PrintWriter out = new PrintWriter(fw);
        	
        // write index
        out.println(s.firstName+" "+s.middleName+" "+s.lastName);
        out.println(s.id);
        out.println(s.major);
        //out.println(s.advisor.getId());
        
        // write crns for sections for sections arrayList

        
        out.close();
    }
    public String toString () {
        return ("Name: " + firstName + " " + middleName + " " + lastName + ", ID: " + id + ", Major: " + major + ", \nAdvisor: " + advisor);
    }
    
}
