/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import constants.Course;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    //Dùng để nhập thông tin như id, studentName, semester
    public static String getString(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s.trim();
            } else {
                return "Please input a string!";
            }
        }
    }

    //Dành riêng cho courseName vì chỉ có một số course nhất định
    public static String getCourse(String input) {
        while (true) {
            System.out.print(input);
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase(Course.JAVA.toString())
                    || courseName.equalsIgnoreCase(Course.DOT_NET.toString())
                    || courseName.equalsIgnoreCase(Course.C_CPP.toString())) {
                return courseName.trim();
            } else {
                return "Course must be 1 of 3 Java, .Net, C/C++";
            }
        }
    }

    //Kiểm tra ý kiến người dùng là Yes hay No
    public static String checkYN(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N")) {
                return s;
            } else {
                return "Please input option Y or N!";
            }
        }
    }
  
}
