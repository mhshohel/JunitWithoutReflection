/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName ClassB.java
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
package actualSeperatedCode;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

//@RunWith(Suite.class)
@RunWith(Categories.class)
// @IncludeCategory(IntegrationTests.class)
// @ExcludeCategory(SlowTests.class)
@SuiteClasses({ AfterAfterClassBeforeBeforeClassIgnore3.class,
	TestedOnClassTest.class })
public class ClassB {
    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("ClassB.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("ClassB.class: setUp()");
    }

    @Test
    public void b() {
	System.out.println("ClassB.class: ClassB_b() - Normal Test");
    }

    @Category(SlowTests.class)
    @Test
    public void bb() {
	System.out.println("ClassB.class: ClassB_bb() - SlowTests");
    }

    @Category(FastTests.class)
    @Test
    public void bbb() {
	System.out.println("ClassB.class: ClassB_bbb() - FastTests");
    }

    // @After
    // public void tearDown() {
    // System.out.println("ClassB.class: tearDown()");
    // }
    //
    // @AfterClass
    // public static void oneTimeTearDownAfterClass() {
    // System.out.println("ClassB.class: oneTimeTearDownAfterClass()");
    // }
}
