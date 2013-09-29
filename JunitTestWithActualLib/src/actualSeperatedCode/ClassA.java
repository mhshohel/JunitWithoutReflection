/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName ClassA.java
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

//@RunWith(Categories.class)
// @IncludeCategory(FastTests.class)
// @ExcludeCategory(SlowTests.class)
// @IncludeCategory(IntegrationTests.class)
// @SuiteClasses({ AfterAfterClassBeforeBeforeClassIgnore2.class, ClassB.class
// })
// ClassB.class
public class ClassA {
    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester("ClassA.class: ");

    @Rule
    public RuleClassTester ilf = new RuleClassTester("ClassA.class: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("ClassA.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("ClassA.class: setUp()");
    }

    @Category({ SlowTests.class, IntegrationTests.class })
    @Test
    public void a() {
	System.out.println("ClassA.class: ClassA_a() - SlowTests");
    }

    @Category(FastTests.class)
    @Test
    public void aa() {
	System.out.println("ClassA.class: ClassA_aa() - FastTests");
    }

    @Category(SlowTests.class)
    @Test
    public void aaa() {
	System.out.println("ClassA.class: ClassA_aaa() - IntegrationTests");
    }

    @Test
    public void aaaa() {
	System.out.println("ClassA.class: ClassA_aaaa() - Normal Test");
    }

    @After
    public void tearDown() {
	System.out.println("ClassA.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out.println("ClassA.class: oneTimeTearDownAfterClass()");
    }
}
