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
        StudentDTO studentDTO = new StudentDTO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display main menu
            studentController.displayMainMenu();

            // Ask user option from menu
            int numberChoice = sc.nextInt();
            switch (numberChoice) {
                case 1: // Insert a student

                    studentDTO = inputStudent();

                    // Transport info to controller through DTO
                    studentController.setInputInfo(studentDTO);
                    studentController.insertStudent();
                    break;
                case 2: // Find and Sort by name

                    // Ask for inputing name or a part of name
                    String name = getString("Name: ");
                    studentDTO.setStudentName(name);

                    // Transport info to controller through DTO
                    studentController.setInputInfo(studentDTO);

                    // Call find and sort funtion
                    studentController.findAndSortStudentByName();
                    break;
                case 3: // Update or Delete by ID

                    // Ask for inputing an ID
                    String id = getCourse("ID: ");

                    // Message for choosing option Update or Delete
                    String letterChoice = getString(MSG_CHOICE_MESSAGE);
                    if (letterChoice.equalsIgnoreCase("U")) {
                        String updateName = getString("Update name: ");
                        String updateSemester = getString("Update semester: ");
                        String updateCourseName = getCourse("Update course name (Java - .Net - C/C++): ");

                        // Set infor for DTO
                        studentDTO.setId(id);
                        studentDTO.setStudentName(updateName);
                        studentDTO.setSemester(updateSemester);
                        studentDTO.setCourseName(updateCourseName);

                        // Transport info to controller through DTO
                        studentController.setInputInfo(studentDTO);

                        // Call update funtion
                        studentController.updateStudent();
                    }
                    if (letterChoice.equalsIgnoreCase("D")) {
                        // Set infor for DTO
                        studentDTO.setId(id);

                        // Transport info to controller through DTO
                        studentController.setInputInfo(studentDTO);

                        // Call delete funtion
                        studentController.deleteStudent();
                    }
                case 4: // Report Info

                    // Call report funtion
                    studentController.reportStudent();
                    break;
                default:
                    System.out.println("Please choice option from 1 to 4!");
                    break;
            }
        }
    }

    public static StudentDTO inputStudent() {
        String id = getString("ID: ");
        String studentName = getString("Name: ");
        String semester = getString("Semester: ");
        String courseName = getCourse("Course (Java - .Net - C/C++): ");

        return new StudentDTO(id, studentName, semester, courseName);
    }
}
