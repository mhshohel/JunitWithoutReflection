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
package basicTestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassB extends ClassA {
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
	System.out.println("ClassB.class: b() - SlowTests");
    }
}
