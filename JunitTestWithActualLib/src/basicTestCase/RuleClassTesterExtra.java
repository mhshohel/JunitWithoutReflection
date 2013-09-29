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

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class RuleClassTesterExtra extends TestWatcher {

    private String m = "";

    public RuleClassTesterExtra(String s) {
	m = s;
    }

    public RuleClassTesterExtra() {
	System.out.println("RuleClassTesterExtra.class: Constructor");
    }

    @Override
    public void succeeded(Description d) {
	System.out.println(m + " RuleClassTesterExtra.class: succeeded()");
    }

    @Override
    public void finished(Description d) {
	System.out.println(m + " RuleClassTesterExtra.class: finished()");
    }

    @Override
    public void starting(Description d) {
	System.out.println(m + " RuleClassTester.class: starting()");
    }

    @Override
    public void failed(Throwable e, Description d) {
	System.out.println(m + " RuleClassTester.class: failed()");
    }
}
