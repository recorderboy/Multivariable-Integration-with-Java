package com.company;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Calculus calculate = new Calculus();
        Array_Manipulation arrays = new Array_Manipulation();

        Double lower1;
        Double upper1;
        Double lower2;
        Double upper2;
        Double integral;
        String equation;
        String[] function;
        String variable1;
        String variable2;
        //Defines variables of integration

        view.Introduction();
        //Displays explanation of program to user.
        view.Directions();
        //Displays directions for using program to user.

        do {
            equation = view.getString("f(x,y) = ");
            //Gets equation from user
            function = arrays.Equation_To_Array(equation);
            // Converts equation into a string array


            lower1 = Double.parseDouble(view.getString("1st Lower Bound:"));
            upper1 = Double.parseDouble(view.getString("1st Upper Bound:"));
            lower2 = Double.parseDouble(view.getString("2nd Lower Bound:"));
            upper2 = Double.parseDouble(view.getString("2nd Upper Bound:"));
            //Gets the bounds of integration from user

            variable1 = view.getString("First Variable of Integration: ");
            variable2 = view.getString("Second Variable of Integration: ");
            //Gets the preferred variables of integration from user
            System.out.println("An approximate of the integral " + equation + " integrated from " + lower1 + " to " + upper1 + " over the " + variable1 + " axis");
            System.out.println("And then integrated from " + lower2 + " to " + upper2 +" over the " + variable2 + " axis");

            integral = calculate.Integrate_Double(function, lower1, upper1, lower2, upper2, variable1, variable2);
            //Approximates the integral
            System.out.println();
            System.out.print("Integral: ");
            System.out.println(integral);


        } while(view.ShouldIStayOrShouldIGo() != 0);
        System.out.println();
        System.out.println("Thank You!");
        System.out.println("Via: Chris Wash");


	// write your code here
    }
}
