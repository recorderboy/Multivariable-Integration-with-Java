package com.company;

import java.util.Arrays;

public class Calculus {
    View view = new View();
    Array_Manipulation arrays = new Array_Manipulation();

    public Double Integrate_Double(String[] function, Double lower1, Double upper1, Double lower2, Double upper2, String v1, String v2) {
        String[] func = Arrays.copyOf(function, function.length);
        //Creates local copy of the equation array

        Double m_n =
                Double.parseDouble(view.getString("Accuracy (m=n=...): "));
        Double change1 = (upper1-lower1) / (m_n);
        Double change2 = (upper2-lower2) / (m_n);
        Double area = change1*change2;
        Double integral = 0.0;
        //The integration is calculated using two riemann sums.
        // m an n represent the the number of times the equation is evaluated over each axis of integration
        //This is correlated with the accuracy of the integrals calculation
        //Since this program evaluates double integrals, m multiplied by n is the area of integration

        System.out.println();
        System.out.println("Area of Integration:");
        System.out.println(area);
        System.out.println();

        for (Double a = lower1 + change1; a <= upper1; a = a + change1) {
            for (Double b = lower2 + change2; b <= upper2; b = b + change2) {
                integral = integral + PEMDAS_Implicit(func, v1, v2, a, b);
            }
        }
        integral = (integral*area);
        //Approximates the integral by evaluating the equation from the lowest variables of integration to the
        //Highest variables of integration in steps of change1 and change2 variables and adding those to a sum

        return integral;
    }

    public Double PEMDAS_Implicit(String[] f, String variable1, String variable2, Double value1, Double value2) {
        String[] equation = Arrays.copyOf(f, f.length);
        //Please Excuse My Dear Aunt Sally
        //Exponents, Multiplication, Division, Addition, Subtraction

        while( Arrays.asList(equation).contains("^") || Arrays.asList(equation).contains("*") ||
                Arrays.asList(equation).contains("/") || Arrays.asList(equation).contains("+") ||
                Arrays.asList(equation).contains("-")) {
            //If there are still math symbols in the string array (equation) then this process will repeat until there are none

            for (int i = 0; i <= equation.length - 1; i++) {
                if ( equation[i].equals(variable1) ) {
                    equation[i] = Double.toString(value1);
                }
                if ( equation[i].equals(variable2) ) {
                    equation[i] = Double.toString(value2);
                }
            }
            //Evaluates variables

            while (Arrays.asList(equation).contains("^")) {
                for (int i = 0; i <= equation.length - 1; i++) {
                    if (equation[i].equals("^")) {
                        equation[i] = Double.toString(Math.pow(Double.parseDouble(equation[i - 1]), Double.parseDouble(equation[i + 1])));
                        equation = arrays.removeFromArray(equation, equation[i-1]);
                        equation = arrays.removeFromArray(equation, equation[i]);
                    }
                }
            }
            //Evaluates Exponents

            while (Arrays.asList(equation).contains("*")) {
                for (int i = 0; i <= equation.length - 1; i++) {
                    if (equation[i].equals("*")) {
                        equation[i] = Double.toString(Double.parseDouble(equation[i - 1]) * Double.parseDouble(equation[i + 1]));
                        equation = arrays.removeFromArray(equation, equation[i-1]);
                        equation = arrays.removeFromArray(equation, equation[i]);
                    }
                }
            }
            //Evaluates Multiplication

            while (Arrays.asList(equation).contains("/")) {
                for (int i = 0; i <= equation.length - 1; i++) {
                    if (equation[i].equals("/")) {
                        equation[i] = Double.toString(Double.parseDouble(equation[i - 1]) * Double.parseDouble(equation[i + 1]));
                        equation = arrays.removeFromArray(equation, equation[i-1]);
                        equation = arrays.removeFromArray(equation, equation[i]);
                    }
                }
            }
            //Evaluates Division

            while (Arrays.asList(equation).contains("+")) {
                for (int i = 0; i <= equation.length - 1; i++) {
                    if (equation[i].equals("+")) {
                        equation[i] = Double.toString(Double.parseDouble(equation[i - 1]) + Double.parseDouble(equation[i + 1]));
                        equation = arrays.removeFromArray(equation, equation[i-1]);
                        equation = arrays.removeFromArray(equation, equation[i]);
                    }
                }
            }
            //Evaluates Addition

            while (Arrays.asList(equation).contains("+")) {
                for (int i = 0; i <= equation.length - 1; i++) {
                    if (equation[i].equals("-")) {
                        equation[i] = Double.toString(Double.parseDouble(equation[i - 1]) - Double.parseDouble(equation[i + 1]));
                        equation = arrays.removeFromArray(equation, equation[i-1]);
                        equation = arrays.removeFromArray(equation, equation[i]);
                    }
                }
            }
            //Evaluates Subtraction
        }
        return Double.parseDouble(equation[0]);
    }
    //(Please Excuse My Dear Aunt Sally)
}
