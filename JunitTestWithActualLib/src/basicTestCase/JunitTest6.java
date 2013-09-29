/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest6.java
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

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JunitTest6 {
    private int number;

    public JunitTest6(int number) {
	this.number = number;
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest6.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest6.class: setUp()");
    }

    @After
    public void tearDown() {
	System.out.println("JunitTest6.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("JunitTest6.class: oneTimeTearDownAfterClass()");
    }

    @Parameters
    public static Collection<Object[]> data() {
	Object[][] data = new Object[][] { { 1 }, { 2 }, { 3 }, { 4 } };
	return Arrays.asList(data);
    }

    @Test
    public void pushTest() {
	System.out.println("JunitTest6.class: Parameterized Number is : "
		+ number);
    }
}
