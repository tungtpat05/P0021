/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static constants.Message.MSG_CHOICE_MESSAGE;
import controller.StudentController;
import dto.StudentDTO;
import java.util.Scanner;
import static utils.Validation.getString;
import static utils.Validation.getCourse;

/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        StudentDTO inputForm = new StudentDTO();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            //In ra menu chính
            studentController.displayMainMenu();
            int numberChoice = sc.nextInt();
            switch(numberChoice) {
                case 1:
                    inputForm = inputStudent();
                    studentController.insertStudent(inputForm);
                    break;
                case 2:
                    studentController.findAndSortStudent(getString("Student name:"));
                    break;
                case 3:
                    String letterChoice  = getString(MSG_CHOICE_MESSAGE);
                    if(letterChoice.equalsIgnoreCase("U")) {
                        studentController.updateStudent(getString("Student ID: "), inputStudentForUpdate());
                    }
                    if(letterChoice.equalsIgnoreCase("D")) {
                        studentController.deleteStudent(getString("Student ID: "));
                    }
                case 4:
                    studentController.reportStudent();
                    break;
                default:
                    System.out.println("Please choice option from 1 to 4!");
                    break;
            }
            studentController.setInputInfo(inputForm);
        }
    }
    
    public static StudentDTO inputStudent() {
        String id = getString("ID: ");
        String studentName = getString("Name: ");
        String semester = getString("Semester: ");
        String courseName = getCourse("Course (Java - .Net - C/C++): "); 
        
        return new StudentDTO(id, studentName, semester, courseName);
    }
    
    public static StudentDTO inputStudentForUpdate() {
        String studentName = getString("Name: ");
        String semester = getString("Semester: ");
        String courseName = getCourse("Course (Java - .Net - C/C++): "); 
        
        return new StudentDTO(studentName, semester, courseName);
    }
}
