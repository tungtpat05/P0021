/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import constants.Course;

/**
 *
 * @author nguye
 */
public class StudentDTO {
    private String id, studentName, semester;
    private Course courseName;

    //Default constructor
    public StudentDTO() {
    }

    //Parameter constructor
    
    public StudentDTO(String studentName, String semester, Course courseName) {
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public StudentDTO(String id, String studentName, String semester, Course courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    //Setter / Getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourseName() {
        return courseName;
    }

    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }
}
