package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Manipulation {

    public String[] Equation_To_Array(String equation) {
        String[] function =
                (equation.replaceAll("\\s+", "")).split("(?!^)");

        for (int x=0; x<=function.length-2; x++) {

            while (isInteger(function[x]) && isInteger(function[x+1])) {
                function[x] = function[x] + function[x+1];
                function = removeFromArray(function, function[x+1]);
            }
            //If there's a number next to a number then those numbers are combined
            //So that [2,2,+,x] is read as [22,+,x]

            if (function[x].equals("-") && isInteger(function[x+1])) {
                function[x] = function[x] + function[x+1];
                function = removeFromArray(function, function[x+1]);
                x=x-1;
                //for index issues
            }
            //puts negative sign in front of number

            if (isInteger(function[x]) && isLetter(function[x+1]) ) {
                function = addToArray(function, x+1, "*");
            }
            //If there's a number next to a letter this inserts a multiplication symbol
            //So that 2x is read as 2*x for java
            //Java is lowkey stupid

            if (isLetter(function[x]) && isLetter(function[x+1])) {
                function = addToArray(function, x+1, "*");
            }
            //If there's a letter next to another letter this inserts a multiplication symbol
            //So that xx is read as x*x
        }
        return function;
        //returns the alternated string array
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    //Tests if a string is an integer

    public static boolean isLetter(String s) {
        return s.matches("[a-zA-Z]+");
    }
    //Tests if a string is a letter

    public static String[] removeFromArray(String[] array, String c) {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == c)
            {
                String[] copy = new String[array.length-1];
                System.arraycopy(array, 0, copy, 0, i);
                System.arraycopy(array, i+1, copy, i, array.length-i-1);
                return copy;
            }
        }
        return array;
    }
    //Finds value in an array and removes that value

    public static String[] addToArray(String[] array, int index, String symbol) {

        array = Arrays.copyOf(array, array.length + 1);
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[index] = symbol;

        return array;
    }
    //Adds value to an Array at index (index)

    //These could and should probably be placed in their own separate Class that deals with arrays but,,,, meh

}

