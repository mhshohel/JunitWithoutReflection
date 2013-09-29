package basicTestCase.theoryTest;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class SuppliedByTest {
    @Theory
    public void imagineThisIsATest(@AllNames String x,
	    @AllCreditCards String y, @TestedOn(ints = { 5, 6 }) int i) {
	System.out.println("consider " + x + " tested.");
    }

    @Theory
    public void testIntegers(@TestedOn(ints = { 2, 3, 4, 7, 13, 23, 42 }) int i) {
	System.out.println("SuppliedByTest.class: " + i);
    }

    @Theory
    public void test2(@TestedOn(ints = { 1, 2 }) int input, @TestedOn(ints = {
	    3, 4 }) int i, @TestedOn(ints = { 5, 6 }) int j) {
	System.out.println("SuppliedByTest.class: " + input + i + j);
    }
}