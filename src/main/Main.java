/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import constants.Message;
import controller.StudentController;
import dto.StudentDTO;
import utils.Validation;
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

        int numberChoice = 1;
        while (1 <= numberChoice && numberChoice <= 4) {
            // Display main menu
            studentController.displayMainMenu();

            // Ask user option from menu
            numberChoice = Validation.getInt();
            switch (numberChoice) {
                case 1: // Insert a student

                    while (true) {
                        studentDTO = inputStudent();

                        // Transport info to controller through DTO
                        studentController.setInputInfo(studentDTO);

                        //Call input function
                        if (studentController.insertStudent()) {
                            System.out.println("Success to create!");
                        } else {
                            System.err.println("Fail to create!");
                        }

                        if (studentController.sizeOfStudentList() > 3) {
                            String letterChoice = Validation.checkYN(constants.Message.MSG_YESNO_MESSAGE);
                            if(letterChoice.equalsIgnoreCase("N")) {
                                break;
                            }
                        }
                    }
                    break;

                case 2: // Find and Sort by name

                    // Ask for inputing name or a part of name
                    String name = getString("Name: ");
                    studentDTO.setStudentName(name);

                    // Transport info to controller through DTO
                    studentController.setInputInfo(studentDTO);

                    // Call find and sort function
                    if (studentController.findAndSortStudentByName()) {
                        System.out.println("");
                    } else {
                        System.err.println("Not found!");
                    }

                    break;
                case 3: // Update or Delete by ID

                    // Ask for inputing an ID
                    String id = getString("ID: ");

                    // Message for choosing option Update or Delete
                    String letterChoice = getString(Message.MSG_UD_MESSAGE);
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

                        // Call update function
                        if (studentController.updateStudent()) {
                            System.out.println("Success to update!");
                        } else {
                            System.err.println("ID not existed!");
                        }
                    } else if (letterChoice.equalsIgnoreCase("D")) {
                        // Set infor for DTO
                        studentDTO.setId(id);

                        // Transport info to controller through DTO
                        studentController.setInputInfo(studentDTO);

                        // Call delete function
                        if (studentController.deleteStudent()) {
                            System.out.println("Success to delete!");
                        } else {
                            System.err.println("ID not existed!");
                        }
                    } else {
                        System.out.println("Please choose U or D!");
                    }
                    break;
                case 4: // Report Info

                    // Call report function
                    studentController.reportStudent();
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
