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

    //private constructor
    private Validation() {

    }

    //Dùng để nhập thông tin như id, studentName, semester
    public static String getString(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s.trim();
            } else {
                System.out.println("Please input a string!");
            }
        }
    }

    //Check input for integer
    public static int getInt() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println("Please input an integer!");
            }
        }
    }

    //Dành riêng cho courseName vì chỉ có một số course nhất định
    public static Course getCourse(String input) {
        while (true) {
            System.out.print(input);
            String inputCourseName = sc.nextLine();
//            if (courseName.equalsIgnoreCase(Course.C_CPP.toString())) {
//                return Course.C_CPP;
//            } else if (courseName.equalsIgnoreCase(Course.JAVA.toString())) {
//                return Course.JAVA;
//            } else if (courseName.equalsIgnoreCase(Course.DOT_NET.toString())) {
//                return Course.DOT_NET;
//            } else {
//                System.out.println("Course must be 1 of 3 Java, .Net, C/C++");
//            }
            try {
                for (Course c : Course.values()) {
                    if (inputCourseName.equalsIgnoreCase(c.toString())) {
                        return c;
                    }
                }
            } catch (Exception e) {
                System.err.println("Invalid course! Course must be 1 of 3 Java, .Net, C/C++");
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
                System.out.println("Please input option Y or N!");
            }
        }
    }

}
