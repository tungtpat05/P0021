/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Comparator;
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

    // Insert a student
    public boolean insertStudent(StudentDTO studentDTO) {
        for (Student student : listStudent) {
            
            //Check 1 student can take only 1 courseName in 1 semester
            if (student.getId().equalsIgnoreCase(studentDTO.getId())
                    && student.getCourseName().equalsIgnoreCase(studentDTO.getCourseName())
                    && student.getSemester().equalsIgnoreCase(studentDTO.getSemester())) {
                return false;
            }
        }
        // Add a student to the list
        listStudent.add(new Student(studentDTO.getId(), studentDTO.getStudentName(), studentDTO.getSemester(), studentDTO.getCourseName()));
        return true;
    }

    // Find and sort student by name
    public ArrayList<String> findAndSortStudentByName(StudentDTO studentDTO) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(studentDTO.getStudentName().toLowerCase())) {
                result.add(student);              
            }
        }
        
        //Sort student by name (increasing)
        result.sort(Comparator.comparing(Student::getStudentName));
        
        // Create ArrayList String to contains info with format in toString()
        ArrayList<String> finalResult = new ArrayList<>();
        for(Student student : result) {
            finalResult.add(student.toString());
        }
        return finalResult;
    }
    
    // Update student by ID
    public boolean updateStudent(StudentDTO studentDTO) {
        for(Student student : listStudent) {
            if(student.getId().equalsIgnoreCase(studentDTO.getId())) {
                student.setStudentName(studentDTO.getStudentName());
                student.setSemester(studentDTO.getSemester());
                student.setCourseName(studentDTO.getCourseName());
                return true;
            }
        }
        return false;
    }

    // Delete student by ID
    public boolean deleteStudent(StudentDTO studentDTO) {
        for(Student student : listStudent) {
            if(student.getId().equalsIgnoreCase(studentDTO.getId())) {
                listStudent.remove(student);
                return true;
            }
        }
        return false;
    }

    
    // Report student (Funtion 4 Menu)
    public Map<String, Map<String, Integer>> reportStudent() {
        
        // Create a map to store id, course, time regis course
        Map<String, Map<String, Integer>> result = new HashMap<>();
        
        // Iterate through each student in listStudent
        for (Student student : listStudent) {
            String id = student.getId();
            String courseName = student.getCourseName();
            
            // Put to map if not exist
            result.putIfAbsent(id, new HashMap<>());
            
            // Take map of each student
            Map<String, Integer> courseMap = result.get(id);
            
            // Update time of each course
            courseMap.put(courseName, courseMap.getOrDefault(courseName, 0) + 1);
        }
        return result;     
    }
}
