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

public class ClassRuleTester extends TemporaryFolder {

    ClassRuleTester() {

    }

    @Override
    protected void after() {
	System.err.println("ClassRuleTester.class: after ");
    }

    @Override
    protected void before() throws Throwable {
	System.err.println("ClassRuleTester.class: before ");
    }

    // @Override
    // protected void after() {
    // System.err.println("RuleClassTester.class: after()");
    // }
    //
    // @Override
    // protected void before() throws Throwable {
    // System.err.println("RuleClassTester.class: before()");
    // }
    //
    // protected void ruleOne() {
    // System.err.println("RuleClassTester.class: ruleOne()");
    // }
}
