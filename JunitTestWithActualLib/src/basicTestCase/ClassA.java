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
package basicTestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;

public class ClassA {
    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out.println("ClassA.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("ClassA.class: setUp()");
    }

    @Category(SlowTests.class)
    @Test
    public void a() {
	System.out.println("ClassA.class: ClassA_a() - SlowTests");
    }

    @Category(FastTests.class)
    @Test
    public void aa() {
	System.out.println("ClassA.class: ClassA_aa() - FastTests");
    }

    @IncludeCategory(FastTests.class)
    @Test
    public void aaa() {
	System.out.println("ClassA.class: ClassA_aaa() - FastTests");
    }

    @Test
    public void aaaa() {
	System.out.println("ClassA.class: ClassA_aaaa()");
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
