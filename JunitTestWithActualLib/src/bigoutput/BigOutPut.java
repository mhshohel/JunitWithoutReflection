/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName bigoutput
 *
 * @FileName BigOutPut.java
 * 
 * @FileCreated Mar 22, 2013
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-0533
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, Växjö, Sweden
 *
 */
package bigoutput;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import actualSeperatedCode.ClassRuleTester;
import actualSeperatedCode.RuleClassTester;

@RunWith(Theories.class)
public class BigOutPut {
    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester(
	    "SuiteClassTest.class: ");

    @Rule
    public RuleClassTester ilf = new RuleClassTester("SuiteClassTest.class: ");

    @Test
    public void testMethodFive() {
	System.out.println("TestedOnClassTest.class: testMethodFive()");
    }

    @DataPoints
    public static int[] inputs = new int[] { 1, 2, 4, 5, 6 };

    @DataPoints
    public static String[][] inputg = new String[][] { { "$", "L" },
	    { "$", "L" }, { "$", "L" }, { "$", "L" } };

    @Theory
    public void testString5(int input, int i, int j, int k, String[] mm,
	    String[] n) {
	System.out.println("TheoryTest1.class DataPoint(s): " + input);
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("TestedOnClassTest.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("TestedOnClassTest.class: setUp()");
    }

    @After
    public void tearDown() {
	System.out.println("TestedOnClassTest.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("TestedOnClassTest.class: oneTimeTearDownAfterClass()");
    }
}
