package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@IncludeCategory(IntegrationTests.class)
@Suite.SuiteClasses({ AfterAfterClassBeforeBeforeClassIgnore2.class })
public class SuiteClassTest {

    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester(
	    "SuiteClassTest.class: ");

    @Rule
    public RuleClassTester ilf = new RuleClassTester("SuiteClassTest.class: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClasss() {
	System.out.println("SuiteClassTest.class: oneTimeSetUpBeforeClasss()");
    }

    @Before
    // Not work
    public void setUp() {
	System.out.println("SuiteClassTest.class: setUp()");
    }

    @Category(SlowTests.class)
    @Test
    // Not work
    public void testMethodOnes() {
	System.out.println("SuiteClassTest.class: testMethodOnes()");
    }

    @Test
    // Not work
    public void tesstMethodTwos() {
	System.out.println("SuiteClassTest.class: tesstMethodTwos()");
    }

    @After
    // Not work
    public void tearDown() {
	System.out.println("SuiteClassTest.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("SuiteClassTest.class: oneTimeTearDownAfterClass()");
    }
}