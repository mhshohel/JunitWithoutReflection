/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName ExtendedJunitTestClass.java
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class ExtendedJunitTestClass extends JunitTest5 {
    @Rule
    public RuleClassTester r = new RuleClassTester(
	    "ExtendedJunitTestClass.class:");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("ExtendedJunitTestClass.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("ExtendedJunitTestClass.class: setUp()");
    }

    @Test
    public void testMethodExtends() {
	System.out.println("ExtendedJunitTestClass.class: testMethodExtends()");
    }

    @After
    public void tearDown() {
	System.out.println("ExtendedJunitTestClass.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("ExtendedJunitTestClass.class: oneTimeTearDownAfterClass()");
    }
}
