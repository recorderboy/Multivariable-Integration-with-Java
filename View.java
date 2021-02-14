package com.company;

import java.util.Scanner;

public class View {
    public void Introduction() {
        System.out.println();
        System.out.println("Welcome to the Double Integration app");
    }

    public void Directions() {
        System.out.println();
        System.out.println("Enter a function and the app will approximate the definite integral");
    }
    public String getString(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt);
        return userInput.nextLine();
    }
    public Double getNumber(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println(prompt);
        return Double.parseDouble(userInput.nextLine());
    }
    public static int ShouldIStayOrShouldIGo() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to continue? (Yes = 1, No = 0)");
        return Integer.parseInt(userInput.nextLine());
    }
    public void Print_Array(String[] array) {
        for (int x=0; x<=array.length-1; x++) {
            System.out.print(array[x] + " ");
        }
        System.out.println("");
    }
    //Method to print arrays


}
