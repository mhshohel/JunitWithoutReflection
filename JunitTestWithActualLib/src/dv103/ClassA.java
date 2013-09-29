/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName dv103
 *
 * @FileName ClassA.java
 * 
 * @FileCreated Feb 18, 2013
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-0533
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, Växjö, Sweden
 *
 */
package dv103;

import org.junit.Test;

import basicTestCase.theoryTest.ParameterSuppliedByClassTest;

//@RunWith(Suite.class)
//@SuiteClasses({ dv103.test.ClassA.class, dreamer.ClassA.class })
public class ClassA extends ParameterSuppliedByClassTest {
    @Test
    public void tesstMethodTwo() {
	System.out.println("dv103.ClassA.class: testMethodTwo()");
    }
}
