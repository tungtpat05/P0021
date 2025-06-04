/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import constants.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Student;

/**
 *
 * @author nguye
 */
public class StudentService {

    private ArrayList<Student> listStudent = new ArrayList<>();

    // Setter
    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    // Getter
    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    
    // Report student (Funtion 4 Menu)
    public Map<String, Map<Course, Integer>> reportStudent() {
        
        // Create a map to store id, course, time regis course
        Map<String, Map<Course, Integer>> result = new HashMap<>();
        
        // Iterate through each student in listStudent
        for (Student student : listStudent) {
            String id = student.getId();
            Course courseName = student.getCourseName();
            
            String idAndName = String.format("%s | %s ", id, student.getStudentName());
            // Put to map if not exist
            result.putIfAbsent(idAndName, new HashMap<>());
            
            // Take map of each student
            Map<Course, Integer> courseMap = result.get(idAndName);
            
            // Update time of each course
            courseMap.put(courseName, courseMap.getOrDefault(courseName, 0) + 1);
        }
        return result;     
    }
}
