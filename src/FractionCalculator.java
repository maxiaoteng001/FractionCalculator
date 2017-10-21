/*
* The FractionCalculator class is a class that will allow the user to enter in
* fractions and operations, calculating and displaying the result. It will run
* until the user tells it to quit.
*
* The class has a main method and three helper methods.
* */

import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char operator;
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        Fraction result = new Fraction();
        boolean result1 = false;
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divede fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b,where a and b are integers.");
        System.out.println("------------------------------------------------------------------------------");
        operator = getOperation(input);
        while(operator!='q' && operator!='Q'){
            fraction1 = getFraction(input);
            fraction2 = getFraction(input);
            switch (operator){
                case '+':
                    result = fraction1.add(fraction2);
                    break;
                case '-':
                    result = fraction1.subtract(fraction2);
                    break;
                case '*':
                    result = fraction1.multiply(fraction2);
                    break;
                case '/':
                    result = fraction1.divide(fraction2);
                    break;
                case '=':
                    result1 = fraction1.equals(fraction2);
                    break;
                case 'q':
                case 'Q':
                    break;
            }
            if(operator == '=') {
                System.out.println(fraction1.toString()+" "+operator+" "+fraction2.toString()+"is "+result1);
            }else if(!(operator =='q' || operator =='Q')){
                System.out.println(fraction1.toString()+" "+operator+" "+fraction2.toString()+" = "+result.toString());
            }
            operator = getOperation(input);
        }
        System.out.println("This program is over run.");

    }

    //Asks the user to enter in a valid mathematical operation. If the user enters anything except "+", "-", "/",
    // "*",  "=", "q", or "Q" it should re-prompt them until there is valid input.
    public static char getOperation(Scanner input){
        char operator;
        do{
            System.out.print("Please enter an operation(+, -, /, *, = or Q to quit):");
            operator = input.next().charAt(0);
        }while(operator !='+' && operator !='-' && operator!='/'
                && operator!='*' && operator!='=' && operator!='q' && operator!='Q');
        return operator;
    }


    //returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
    public static boolean validFraction(String input){
        int lo = 0;//lo is the location of '/'
        if(input.startsWith("-") || (input.charAt(0) >= '0' && input.charAt(0) <= '9')) {
            if (input.startsWith("-"))
                input = input.substring(1);
            if((lo = input.indexOf('/'))==0){
                return isNumber(input);
            }
            String firsts = input.substring(0,lo);
            String seconds = input.substring(lo+1);
            return isNumber(firsts) && isNumber(seconds);
        }
        return false;
    }


    //It prompts the user for a String that is a validFraction. If they enter any thing that is not a valid Fraction,
    // it should re-prompt them until it is valid
    public static Fraction getFraction(Scanner input){
        Fraction fraction = new Fraction();
        System.out.print("Please enter a fraction(a/b) or integer(a):");
        String s = input.next() ;
        int sign = 1;
        int lo = 0;//lo is the location of '/'
        while(!validFraction(s)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a),where a and b are integers and b is not " +
                    "zero: ");
            s = input.next();
        }
        if(s.charAt(0)=='-'){
            sign = -1;
            s = s.substring(1);
        }
        lo = s.indexOf('/');
        if(lo == 0){
            return new Fraction(Integer.parseInt(s)*sign,1);
        }else{
            String firsts = s.substring(0,lo);
            String seconds = s.substring(lo+1);
            fraction.setDenominator(Integer.parseInt(seconds));
            fraction.setNumerator(Integer.parseInt(firsts)*sign);
            return fraction;
        }
    }

    private static boolean isNumber(String string){
        for(char e:string.toCharArray()){
            if(e<='0'&& e>='9'){
                return false;
            }
        }
        return true;
    }

}

