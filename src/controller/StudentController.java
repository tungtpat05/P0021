/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Map;
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
    
    // Take input infor from DTO
    public void setInputInfo(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }
    
    // Call insert funtion from Service
    public void insertStudent() {
        if(studentService.insertStudent(studentDTO)) {
            studentView.setBody("Success!");
            studentView.printBody();
        } else {
            studentView.setBody("Fail!");
            studentView.printBody();
        }
    }
    
    // Call find and sort function form Service --> display
    public void findAndSortStudentByName() {
        ArrayList<String> arrlist = studentService.findAndSortStudentByName(studentDTO);
        studentView.setArrlist(arrlist);
        studentView.printArrayList();
    }
    
    // Call update function form Service
    public void updateStudent() {
        if(studentService.updateStudent(studentDTO)) {
            studentView.setBody("Success!");
            studentView.printBody();
        } else {
            studentView.setBody("ID not existed");
            studentView.printBody();
        }
    }
    
    // Call delete function form Service
    public void deleteStudent() {
        if(studentService.deleteStudent(studentDTO)) {
            studentView.setBody("Success!");
            studentView.printBody();
        } else {
            studentView.setBody("ID not existed");
            studentView.printBody();
        }
    }
    
    // Call report function form Service
    public void reportStudent() {
        Map<String, Map<String, Integer>> result = studentService.reportStudent();
        studentView.setMap(result);
        studentView.printMap();
    }
    
    // Display main menu
    public void displayMainMenu() {
        studentView.displayMainMenu();
    }
} 
