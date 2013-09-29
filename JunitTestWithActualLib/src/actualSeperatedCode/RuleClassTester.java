/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName actualSeperatedCode
 *
 * @FileName RuleClassTester.java
 * 
 * @FileCreated Nov 11, 2012
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

import org.junit.rules.TemporaryFolder;

public class RuleClassTester extends TemporaryFolder {
    String m;

    public RuleClassTester(String m) {
	this.m = m;
    }

    @Override
    public void after() {
	System.out.println("   " + m + " ClassRuleTester.class: after ");
    }

    @Override
    public void before() throws Throwable {
	System.out.println("   " + m + " ClassRuleTester.class: before ");
    }
}
