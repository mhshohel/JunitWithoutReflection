package basicTestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ ClassA.class, ClassB.class })
public class JunitTest7 {
    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("JunitTest7.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("JunitTest7.class: setUp()");
    }

    @After
    public void tearDown() {
	System.out.println("JunitTest7.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("JunitTest7.class: oneTimeTearDownAfterClass()");
    }
}