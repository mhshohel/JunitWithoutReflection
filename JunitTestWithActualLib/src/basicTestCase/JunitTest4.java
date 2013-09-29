/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest4.java
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
import org.junit.Test;

public class JunitTest4 {
    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest4.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest4.class: setUp()");
    }

    @Test
    public void testMethodFive() {
	System.out.println("JunitTest4.class: testMethodFive()");
    }

    @Test
    public void testMethodFiveFive() {
	System.out.println("JunitTest4.class: testMethodFiveFive()");
    }

    @After
    public void tearDowns() {
	System.out.println("JunitTest4.class: tearDowns()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClasss() {
	System.out.println("JunitTest4.class: oneTimeTearDownAfterClasss()");
    }

}
