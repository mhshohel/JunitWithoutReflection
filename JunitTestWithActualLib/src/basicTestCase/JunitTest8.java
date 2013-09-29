/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JUnitTest8.java
 * 
 * @FileCreated Nov 4, 2012
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

public class JunitTest8 {
    @Rule
    public RuleClassTester ilf = new RuleClassTester();

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JUnitTest8.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JUnitTest8.class: setUp()");
    }

    @Test
    public void JuintTest8Method() {
	System.out.println("JUnitTest8.class: JuintTest8Method()");
    }

    @After
    public void tearDown() {
	System.out.println("JUnitTest8.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("JUnitTest8.class: oneTimeTearDownAfterClass()");
    }
}