/*
*  The Fraction class is an object that holds information about a fraction
*  (numerator and denominator). It will have several constructors and both
*  private and public methods implementing the behavior of a fraction.
* */

public class Fraction {

    private int numerator;
    private int denominator;

    //a two parameter constructor that initializes the numerator and
    // denominator
    public Fraction(int numerator, int denominator) {
        if(denominator == 0 )
            throw new IllegalArgumentException();
        else{
            if(denominator<0){
                this.numerator = -numerator;
                this.denominator = Math.abs(denominator);
            }else{
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }
    }

    //one parameter constructor that initializes the object equal in value to
    // the integer parameter.
    public Fraction(int integer) {
        this.numerator = integer;
        this.denominator = 1;
    }

    //zero parameter constructor that initializes the object to 0, meaning
    // the numerator is 0 and the denominator is 1
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //"numerator/denominator", a String representation of the Fraction
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    //the result of numerator / denominator
    public double toDouble(){
        double decimal = 0;

        return decimal;
    }
    //returns a new Fraction that is the sum of other and this fractions
    public Fraction add(Fraction other){
        Fraction sum = null;
        
        return sum;
    }

    //returns a new Fraction that is the difference between the other and
    // this fraction
    public Fraction subtract(Fraction other){

        Fraction difference = null;
        return difference;
    }

    //returns a new Fraction that is the product of the other and this fraction
    public Fraction multiply(Fraction other){
        Fraction product = null;
        return product;
    }

    //returns a new Fraction that is the division of the other and this
    // fraction, throw an IllegalArgumentException() if the user asks you to
    // divide by 0
    public Fraction divide(Fraction other){
        if(other.getNumerator()==0)
            throw new IllegalArgumentException();
        else{
            Fraction division = null;
            return division;
        }
    }

    //must take in an "Object" to properly override the Object class's equals
    // method, but should ultimately check if two fractions are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction fraction = (Fraction) o;

        if (getNumerator() != fraction.getNumerator()) return false;
        return getDenominator() == fraction.getDenominator();
    }

    //converts the current fraction to the lowest terms
    public void toLowestTerms(){


    }

    //takes in two ints and determines the greatest common divisor of the two
    // ints, should be a static method
    public static int gcd(int num, int den){
        int gcd = 0;


        return gcd;
    }

}
