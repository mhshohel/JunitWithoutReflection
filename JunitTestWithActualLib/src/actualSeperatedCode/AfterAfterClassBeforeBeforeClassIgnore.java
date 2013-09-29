package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AfterAfterClassBeforeBeforeClassIgnore {
    public static ClassRuleTester i = new ClassRuleTester(
	    "AfterAfterClassBeforeBeforeClassIgnore.class: ");

    @Rule
    public RuleClassTester ilf = new RuleClassTester(
	    "AfterAfterClassBeforeBeforeClassIgnore.class: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: setUp()");
    }

    public void testMethodOnes() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: testMethodOnes()");
    }

    @Category(FastTests.class)
    @Test
    public void tesssstMethodTwos() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: testMethodTwos()");
    }

    @After
    public void tearDown() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore.class: oneTimeTearDownAfterClass()");
    }
}