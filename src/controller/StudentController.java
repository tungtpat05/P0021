/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Map;
import model.Student;
import service.StudentService;
import view.StudentView;

/**
 *
 * @author nguye
 */
public class StudentController {

    private StudentDTO studentDTO = new StudentDTO();
    private StudentView studentView = new StudentView();
    private StudentService studentService = new StudentService();
    ArrayList<Student> listStudent = new ArrayList<>();

    // Take input infor from DTO
    public void setInputInfo(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    // Insert a student
    public boolean insertStudent() {
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
    public boolean findAndSortStudentByName() {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(studentDTO.getStudentName().toLowerCase())) {
                result.add(student);
            }
        }

        //Sort student by name (increasing)
//        result.sort(Comparator.comparing(Student::getStudentName));
        //Bubble sort
        for (int i = 0; i < listStudent.size() - 1; i++) {
            for (int j = 0; j < listStudent.size() - i - 1; j++) {

                //Get name of 2 adjacent objects
                String name1 = listStudent.get(j).getStudentName();
                String name2 = listStudent.get(j + 1).getStudentName();

                //Compare
                if (name1.compareTo(name2) > 0) {
                    //Change position
                    Student tmp = listStudent.get(j);
                    listStudent.set(j, listStudent.get(j + 1));
                    listStudent.set(j + 1, tmp);
                }

            }
        }

        // Create ArrayList String to contains info with format in toString()
        ArrayList<String> finalResult = new ArrayList<>();
        for (Student student : result) {
            finalResult.add(student.toString());
        }

        if (!finalResult.isEmpty()) {
            // Set info of arraylist for view
            studentView.setArrlist(finalResult);

            //Print arraylist
            studentView.printArrayList();
            
            return true;
        }
        
        return false;
    }

    // Update student by ID
    public boolean updateStudent() {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(studentDTO.getId())) {
                student.setStudentName(studentDTO.getStudentName());
                student.setSemester(studentDTO.getSemester());
                student.setCourseName(studentDTO.getCourseName());
                return true;
            }
        }
        return false;
    }

    // Delete student by ID
    public boolean deleteStudent() {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(studentDTO.getId())) {
                listStudent.remove(student);
                return true;
            }
        }
        return false;
    }

    // Call report function form Service
    public void reportStudent() {
        Map<String, Map<String, Integer>> result = studentService.reportStudent();
        studentView.setMap(result);
        studentView.printMap();
    }

    //Calc size of list
    public int sizeOfStudentList() {
        return listStudent.size();
    }

    // Display main menu
    public void displayMainMenu() {
        studentView.displayMainMenu();
    }
}
