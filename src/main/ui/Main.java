package ui;

import java.io.FileNotFoundException;

//CITATION: exception handling inspired by CPSC 210's JsonSerializationDemo
//runs the App
public class Main {
    public static void main(String[] args) {
        try {
            new AutocorerctApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
