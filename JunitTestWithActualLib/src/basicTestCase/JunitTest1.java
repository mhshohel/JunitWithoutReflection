/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JUnitTest1.java
 * 
 * @FileCreated Nov 1, 2012
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import actualSeperatedCode.TestedOnClassTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestedOnClassTest.class })
public class JunitTest1 extends TestedOnClassTest {
    @Rule
    public RuleClassTester ilf = new RuleClassTester("JunitTest1");

    @DataPoint
    public static int input1 = 1;

    @Theory
    public void testIntegerx(@TestedOn(ints = { 2, 3 }) int i) {
	System.out.println("JUnitTest1.class: " + i);
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClasss() {
	System.out.println("JunitTest1.class: oneTimeSetUpBeforeClasss()");
    }

    @Before
    public void setUps() {
	System.out.println("JunitTest1.class: setUps()");
    }

    @Ignore("Not Implemented")
    @Test
    public void testMethodOne() {
	System.out.println("JunitTest1.class: testMethodOne()");
    }

    @Test
    public void tesstMethodTwo() {
	System.out.println("JunitTest1.class: tesstMethodTwo()");
    }

    @After
    public void tearDowns() {
	System.out.println("JunitTest1.class: tearDowns()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClasss() {
	System.out.println("JunitTest1.class: oneTimeTearDownAfterClasss()");
    }
}
