/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest3.java
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
import org.junit.Test;

public class JunitTest3 {
    @ClassRule
    public static RuleClassTesterExtra rss = new RuleClassTesterExtra(
	    "JunitTest3.class: - r");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest3.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest3.class: setUp()");
    }

    @Test
    public void testMethodFour() {
	System.out.println("JunitTest3.class: testMethodFour()");
    }

    @After
    public void tearDowns() {
	System.out.println("JunitTest3.class: tearDowns()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClasss() {
	System.out.println("JunitTest3.class: oneTimeTearDownAfterClasss()");
    }
}
