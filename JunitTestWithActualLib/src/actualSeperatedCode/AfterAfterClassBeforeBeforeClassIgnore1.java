package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AfterAfterClassBeforeBeforeClassIgnore1 {
    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: setUp()");
    }

    @Test
    public void testMethodOne() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: testMethodOne()");
    }

    @Category(IntegrationTests.class)
    @Test
    public void tesssstMethodTwoss() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: testMethodTwo()ss");
    }

    @After
    public void tearDown() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore1.class: oneTimeTearDownAfterClass()");
    }
}