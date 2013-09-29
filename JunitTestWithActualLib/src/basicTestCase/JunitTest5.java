/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest5.java
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

public class JunitTest5 extends JunitTest1 {
    @Rule
    public RuleClassTester ilf = new RuleClassTester("JunitTest5");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest5.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest5.class: setUp()");
    }

    @Ignore("Not Implemented")
    @Test
    public void testMethodOne() {
	System.out.println("JunitTest5.class: testMethodOne()");
    }

    @Test
    public void testMethodTwo() {
	System.out.println("JunitTest5.class: testMethodTwo()");
    }

    @After
    public void tearDown() {
	System.out.println("JunitTest5.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("JunitTest5.class: oneTimeTearDownAfterClass()");
    }
}
