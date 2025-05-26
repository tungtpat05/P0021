/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.StudentDTO;
import java.util.ArrayList;
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
    private ArrayList<Student> listStudent  = new ArrayList<>();
    
    public void setInputInfo(StudentDTO inputForm) {
        this.studentDTO = inputForm;
    }
    
    public boolean insertStudent(StudentDTO inputForm) {
        studentService.insertStudent(inputForm);
    }
    
    public boolean findAndSortStudent(String studentName) {
        studentService.findAndSortStudent(studentName);
    }
    
    public boolean updateStudent(String studentID, StudentDTO studentDTO) {
        studentService.updateStudent(studentID);
    }
    
    public boolean deleteStudent(String studentID) {
        studentService.deleteStudent(studentID);
    }
    
    public void reportStudent() {
        studentService.reportStudent();
    }
    
    public void displayMainMenu() {
        studentView.displayMainMenu();
    }
} 
