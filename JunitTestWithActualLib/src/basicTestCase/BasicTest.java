/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName BasicTest.java
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
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JunitTest3.class, ExtendedJunitTestClass.class })
// if extends a suit class in any level then nothing will run of all level of
// sub class except bc,ac and suits
public class BasicTest extends JunitTest2 {
    @Rule
    public static RuleClassTesterExtra r = new RuleClassTesterExtra(
	    "RULE - BasicTest.class - r");

    @ClassRule
    public static RuleClassTester rs = new RuleClassTester(
	    "BasicTest.class - rs");

    @ClassRule
    public static RuleClassTesterExtra tw = new RuleClassTesterExtra(
	    "BasicTest.class - Exr");

    @Rule
    public RuleClassTester s = new RuleClassTester("BasicTest.class - s");

    public String ab = "AB - Main";
    public String bb = "BC - MAIN";

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("BasicTest.class: oneTimeSetUpBeforeClass");
    }

    @Before
    public void setUp() {
	System.out.println("BasicTest.class: setUp");
    }

    @Test
    public void testMethodTwo() {
	System.out.println("BasicTest.class: testMethodTwo");
    }

    @Test
    public void testMethodTwosssss() {
	System.out.println("BasicTest.class: testMethodTwosssss");
    }

    @After
    public void tearDown() {
	System.out.println("BasicTest.class: tearDown");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("BasicTest.class: oneTimeTearDownAfterClass");
    }
}
