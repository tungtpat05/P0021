/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class StudentView {
    private String body;
    private ArrayList<String> arrlist = new ArrayList<>();
    private Map<String, Map<String, Integer>> map = new HashMap<>();
    
    // Setter & Getter

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList<String> getArrlist() {
        return arrlist;
    }

    public void setArrlist(ArrayList<String> arrlist) {
        this.arrlist = arrlist;
    }
        
    public Map<String, Map<String, Integer>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, Integer>> map) {
        this.map = map;
    }
    
    // Print body
    public void printBody() {
        System.out.println(body);
    }
    
    // Print ArrayList (Use special for Funtion 2)
    public void printArrayList() {
        for(String s : arrlist) {
            System.out.println(s);
        }
    }
    
    // Print Map (Use special for Funtion 4)
    public void printMap() {
        for (String id : map.keySet()) {
            Map<String, Integer> courseMap = map.get(id);
            for (String course : courseMap.keySet()) {
                System.out.println(String.format("%s | %s | %d", id, course, courseMap.get(course)));
            }
        }
    }
    
    // Display main menu
    public void displayMainMenu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }
}
