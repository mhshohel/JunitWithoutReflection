/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName RuleClassTester.java
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

import org.junit.rules.TemporaryFolder;

public class RuleClassTester extends TemporaryFolder {

    private String m = "";

    public RuleClassTester(String s) {
	m = s;
    }

    public RuleClassTester() {
	System.out.println("RuleClassTester.class: Constructor");
    }

    @Override
    public void after() {
	System.out.println(m + " RuleClassTester.class: after()");
    }

    int i = 0;

    public void before() throws Throwable {
	System.out.println(m + " RuleClassTester.class: before() => " + i++);
    }
}
