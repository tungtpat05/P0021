/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package constants;

/**
 *
 * @author nguye
 */

// Viết như này để sau này Course. là hiện ra 
public enum Course {
    JAVA, DOT_NET, C_CPP;
    
    public String toString() {
        switch(this) {
            case JAVA: return "Java";
            case DOT_NET: return ".Net";
            case C_CPP: return "C/C++"; 
            default: return super.toString(); //Tác dụng gì đây
        }
    }
}
