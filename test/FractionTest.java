import org.junit.Before;
import org.junit.Test;

import java.beans.FeatureDescriptor;

public class FractionTest {


        Fraction test1 = new Fraction();
        Fraction test2 = new Fraction(2);
        Fraction test3 = new Fraction(2,-3);
        Fraction test4 = new Fraction(1,7);
        Fraction test5 = new Fraction(1,7);
        Fraction test6 = new Fraction(2,8);

    @Test
    public void testtoString(){
        Fraction t = new Fraction(2,-3);
        System.out.println("to String Excepted: -2/3  \nOutput:"+t.toString());
    }

    @Test
    public void testtoDouble() throws Exception {
        double dd = test3.toDouble();
        System.out.println("to Double Excepted: -0.6777  \nOutput: "+ dd);
    }

    @Test
    public void testadd() throws Exception {
//        Fraction test3 = new Fraction(2,-3);
//        Fraction test4 = new Fraction(1,7);
        Fraction result = test3.add(test4);
        System.out.println("add Excepted(-2/3)+(1/7) = : -11/21  \nOutput:"+result.toString());
    }

    @Test
    public void testsubtract() throws Exception {
        Fraction result = test3.subtract(test4);
        System.out.println("subtract Excepted: -17/21  \nOutput:"+result.toString());
    }

    @Test
    public void testmultiply() throws Exception {
        Fraction result = test3.multiply(test4);
        System.out.println("multiply Excepted: -2/21  \nOutput:"+result.toString());
    }

    @Test
    public void divide() throws Exception {
        Fraction result = test3.divide(test4);
        System.out.println("divide Excepted: -14/3  \nOutput:"+result.toString());
    }

    @Test
    public void equals() throws Exception {
        Fraction test2 = new Fraction(2);
        System.out.println("equals Excepted: true  \nOutput:"+test4.equals(test5));
        System.out.println("equals Excepted: false  \nOutput:"+test4.equals(test2));
    }

    @Test
    public void testtoLowestTerms() throws Exception {
        test6.toLowestTerms();
        System.out.println("toLowertTerms Excepted: 1/4  \nOutput:"+test6);
    }

    @Test
    public void testgcd() throws Exception {
        System.out.println("gcd Excepted: 2  \nOutput:"+test6.gcd(test6.getNumerator(),test6.getDenominator()));
    }

}