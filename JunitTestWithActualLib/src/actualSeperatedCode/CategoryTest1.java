package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
// @ExcludeCategory(FastTests.class)
@SuiteClasses({ ClassA.class })
public class CategoryTest1 {
    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester(
	    "CategoryTest1.class: ");

    @Rule
    public RuleClassTester ilf = new RuleClassTester("CategoryTest1.class: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("CategoryTest1.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("CategoryTest1.class: setUp()");
    }

    @Category(SlowTests.class)
    @Test
    public void testMethodOne() {
	System.out.println("CategoryTest1.class: testMethodOne()");
    }

    @Test
    public void tesssstMethodTwo() {
	System.out.println("CategoryTest1.class: testMethodTwo()");
    }

    @After
    public void tearDown() {
	System.out.println("CategoryTest1.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("CategoryTest1.class: oneTimeTearDownAfterClass()");
    }
}