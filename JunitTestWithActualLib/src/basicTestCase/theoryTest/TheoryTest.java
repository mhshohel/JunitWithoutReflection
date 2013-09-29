package basicTestCase.theoryTest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryTest {
    @Theory
    public void testIntegers(@TestedOn(ints = { 2, 3, 4 }) int i) {
	System.out.println("TheoryTest.class: @TestedON: testIntegers() " + i);
    }

    @DataPoint
    public static int input1 = 1;

    @DataPoint
    public static int input2 = 2;

    @DataPoints
    public static int[] inputs = new int[] { 2 };

    @DataPoints
    public static int[] input = new int[] { 3 };

    @Theory
    public void testString1(int input) {
	System.out
		.println("ParameterSuppliedByClassTest.class DataPoint(s) testString1: "
			+ input);
    }

    @Theory
    public void testString1(int input, int i, int j) {
	System.out
		.println("TheoryTest.class DataPoint(s): testString1" + input);
    }

    @Theory
    public void testString121(int input, int i, int j) {
	System.out.println("TheoryTest.class DataPoint(s): testString121"
		+ input);
    }

    // @ClassRule
    // public static ClassRuleTester i = new
    // ClassRuleTester("TheoryTest.class: ");
    //
    // @Rule
    // public RuleClassTester ilf = new RuleClassTester("TheoryTest.class: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("TheoryTest.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("TheoryTest.class: setUp()");
    }

    // @Ignore("Not Implemented")
    // @Test
    // public void testMethodOne() {
    // System.out.println("TheoryTest.class: testMethodOne()");
    // }
    //
    // @Test
    // public void tesstMethodTwo() {
    // System.out.println("TheoryTest.class: testMethodTwo()");
    // }
    //
    // @After
    // public void tearDown() {
    // System.out.println("TheoryTest.class: tearDown()");
    // }
    //
    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("TheoryTest.class: oneTimeTearDownAfterClass()");
    }
}