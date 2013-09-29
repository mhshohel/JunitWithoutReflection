/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest2.java
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

public class JunitTest2 {
    @ClassRule
    public static RuleClassTesterExtra rgg = new RuleClassTesterExtra(
	    "JunitTest2.class:");

    @Rule
    public static RuleClassTester rss = new RuleClassTester(
	    "RULE - BasicTest.class - r");

    @Rule
    public RuleClassTester s = new RuleClassTester("BasicTest.class - s");

    public String ab = "Junit2 - AB";

    @BeforeClass
    public static void oneTimeSetUpBeforeClasss() {
	System.out.println("JunitTest2.class: oneTimeSetUpBeforeClass");
    }

    @Before
    public void setUps() {
	System.out.println("JunitTest2.class: setUp");
    }

    @Test
    public void testMethodThree() {
	System.out.println("JunitTest2.class: testMethodThree()");
    }

    @After
    public void tearDowns() {
	System.out.println("JunitTest2.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClasss() {
	System.out.println("JunitTest2.class: oneTimeTearDownAfterClass()");
    }
}
