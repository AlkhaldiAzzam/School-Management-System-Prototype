/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import java.util.ArrayList;

public class Faculty {

    String name = "ZG";
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String id;
    private String department;
    //private Student [] advises;
    public ArrayList<Section> classes = new ArrayList<>();

    public Faculty() {
        title = "";
        firstName = "TBA";
        middleName = "";
        lastName = "";
    }

    public Faculty(String name, String ID, String department, ArrayList<Section> classes) { // to add from TXT file. //

        this.title = name.substring(0, name.indexOf('.'));

        name = name.substring(name.indexOf('.') + 1, name.length());
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

        this.department = department;

    }

    public Faculty(String title, String name, String id, String department) {

        this.title = title;
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

        this.id = id;
        this.department = department;
    }

    public String getID() {
        return this.id;
    }

    private boolean setAsInstructor(Section sec) {
        classes.add(sec);
        return true;
    }

    private boolean removeAsInstructor(Section sec) {
        classes.remove(sec);
        return true;
    }

    public String toString() {
        //return ("Name: " + title + ". " + firstName + " " + middleName + " " + lastName + ", ID: " + id + ", Department: " + department);
        return firstName + " " + lastName;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getName() {
        return firstName + " " + lastName;
    }
}
