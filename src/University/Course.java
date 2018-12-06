/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import java.util.ArrayList;

/**
 *
 * @author abdulrhman menshawi
 */
public class Course {
	private String name;
	private int numOfSections =0;
	public ArrayList <Section> sections = new ArrayList<>();
	
	
	
    public Course (String Name) {
    	this.name = name;
    	
    }
    
   public Section addSection() {
	   numOfSections++;
	   Section sec = new Section(this,numOfSections);
	   sections.add(sec);
	   return sec;
   }
   
   public void removeSection (Section sec) {
		   sections.remove(sec);
   }
   public String getName() {
	   return name;
   }
   public int getNumOfSections() {
	   return numOfSections;
   }
}
