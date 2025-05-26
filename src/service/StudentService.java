/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Comparator;
import model.Student;

/**
 *
 * @author nguye
 */
public class StudentService {

    private ArrayList<Student> listStudent = new ArrayList<>();

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public boolean insertStudent(StudentDTO inputForm) {
        for (Student student : listStudent) {
            //Kiểm tra xem sinh viên với semester và courseName vừa nhập đã tồn tại chưa
            if (student.getId().equalsIgnoreCase(inputForm.getId())
                    && student.getCourseName().equalsIgnoreCase(inputForm.getCourseName())
                    && student.getSemester().equalsIgnoreCase(inputForm.getSemester())) {
                return false;
            }
        }
        listStudent.add(new Student(inputForm.getId(), inputForm.getStudentName(), inputForm.getSemester(), inputForm.getCourseName()));
        return true;
//        while(listStudent.size() <10) {
//            
//        }
    }

    public ArrayList<Student> findAndSortStudent(String studentName) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                result.add(student);              
            }
        }
        //Sort student by name (increasing)
        result.sort(Comparator.comparing(Student::getStudentName));
        return result;
    }

    public boolean updateStudent(String studentID, StudentDTO studentDTO) {
        for(Student student : listStudent) {
            if(student.getId().equalsIgnoreCase(studentID)) {
                student.setStudentName(studentDTO.getStudentName());
                student.setSemester(studentDTO.getSemester());
                student.setCourseName(studentDTO.getCourseName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String studentID) {
        for(Student student : listStudent) {
            if(student.getId().equalsIgnoreCase(studentID)) {
                listStudent.remove(student);
                return true;
            }
        }
        return false;
    }

    public String reportStudent() {
        
    }
}
