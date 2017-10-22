/*
* The key difference between FractionCalculator and FractionCalculatorAdvanced is that the user can enter in their
* operations on a single line. Allow the user to enter their input onto a single line
*/


import java.util.Scanner;

public class FractionCalcultorAdvanced {

    public static void main(String[] args){
        FractionCalcultorAdvanced fca = new FractionCalcultorAdvanced();

        Scanner input = new Scanner(System.in);
        String inputString ;
        char operator = ' ';
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        Fraction result = new Fraction();
        boolean result1 = false;
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divede fractions until you type Q to quit.");
        System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\".");
        System.out.println("[FRAC] can be either a single integer or two integers separated by \"/\".");
        System.out.println("[OPERATION] can be +, -, *, / or =.");
        System.out.println("Enter an operation(q to quit):");
        System.out.println("------------------------------------------------------------------------------");
        inputString = input.nextLine();
        try {
            while(!fca.isQuit(inputString)){
                String[] allInput = fca.splitInput(inputString);
                if (fca.validFraction(allInput[0]) && fca.validOperator(allInput[1]) &&
                        fca.validFraction(allInput[2]) && allInput.length ==3 ) {
                    //Convert to two fractions and one operator
                    //Then calculte the result
                    operator = fca.getOperation(allInput[1]);
                    fraction1 = fca.getFraction(allInput[0]);
                    fraction2 = fca.getFraction(allInput[2]);
                    switch (operator) {
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
                    }
                    if (operator == '=') {
                        System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + "is " + result1);
                    } else if (!(operator == 'q' || operator == 'Q')) {
                        System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = " + result.toString());
                    }
                }else {
                    System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
                }
                System.out.println("Enter an operation(q to quit):");
                inputString = input.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("This program is over run.");

    }
    //Determine the input if is Q
    public boolean isQuit(String input){
        if(input.charAt(0)=='q' || input.charAt(0)=='Q')
            return true;
        return false;
    }

    //Split the inputString to three parts and return String[]
    public String[] splitInput(String input){
        String[] split = null;
        split = input.split(" ");
        return split;
    }
    //Determine the input if it is number.
    private boolean isNumber(String string){
        for(char e:string.toCharArray()){
            if(e<='0'&& e>='9'){
                return false;
            }
        }
        return true;
    }


    //returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
    public boolean validFraction(String input){
        int lo = 0; //lo is the location of '/'
        if(input.startsWith("-") || (input.charAt(0) >= '0' && input.charAt(0) <= '9')) {
            if (input.startsWith("-"))
                input = input.substring(1);
            if((lo = input.indexOf('/'))==0 || (lo = input.indexOf('/'))== -1){
                lo =0;
                return isNumber(input);
            }
            String firsts = input.substring(0,lo);
            String seconds = input.substring(lo+1);
            return isNumber(firsts) && isNumber(seconds);
        }
        return false;
    }

    //Determine the input if is operator that +, -, *, / or =
    public boolean validOperator(String input) {
        if(input.length()!=1)
            return false;
        char operator = input.charAt(0);
        if(operator =='+' || operator =='-' || operator=='/'
                || operator=='*' || operator=='='){
            return true;
        }
        return false;
    }


    //Input String input, return a Fraction object
    public Fraction getFraction(String input){
        Fraction fraction = new Fraction();
        int sign = 1;
        int lo = 0;//lo is the location of '/'
        if(input.charAt(0)=='-'){
            sign = -1;
            input = input.substring(1);
        }
        lo = input.indexOf('/');
        if(lo == 0 || lo == -1){
            lo = 0;
            return new Fraction(Integer.parseInt(input)*sign,1);
        }else{
            String firsts = input.substring(0,lo);
            String seconds = input.substring(lo+1);
            fraction.setDenominator(Integer.parseInt(seconds));
            fraction.setNumerator(Integer.parseInt(firsts)*sign);
            return fraction;
        }
    }

    //Input String input, return a char as operator
    public char getOperation(String input){
        char operator = input.charAt(0);
        return operator;
    }
}
