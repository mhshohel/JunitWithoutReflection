/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JUnitTest9.java
 * 
 * @FileCreated Nov 5, 2012
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-R119
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, Växjö, Sweden
 *
 */
package basicTestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JunitTest9 {
    @DataPoint
    public static int input1 = 1;

    @DataPoint
    public static int input2 = 2;

    @DataPoints
    public static String[] inputs = new String[] { "foobar", "barbar" };

    @Theory
    public void testString1(String input, String i, String j) {
	System.out.println("JunitTest9.class: " + input);
    }

    @Theory
    public void testString2(String input) {
	System.out.println("JunitTest9.class: " + input);
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest9.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest9.class: setUp()");
    }

    @Theory
    public void test1(int input, int i, int j) {
	System.out.println("JunitTest9.class: " + input);
    }

    @Theory
    public void test2(int input, int i) {
	System.out.println("JunitTest9.class: " + input);
    }

    // @DataPoints
    // public static Object[] data() {
    // return new Object[] { "A", "B" };
    // }
    //
    // @Theory
    // public void theoryOligarchsHaveYachts(Object suit) {
    // // assertThat(suit.getVehicles(), hasItem("yacht"));
    // System.err.println(data().length);
    // }
}
