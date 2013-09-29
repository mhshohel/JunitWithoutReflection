/**
 *
 * @ProjectName JUnitWithoutReflection
 *
 * @FileName BasicTestOutput.java
 *
 * @FileCreated Sep 29, 2013 - 17:25:29
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
package tools.code.gen.output;

import org.junit.runner.Description;
import basicTestCase.BasicTest;
import actualSeperatedCode.TestedOnClassTest;
import basicTestCase.JunitTest3;
import basicTestCase.JunitTest2;
import basicTestCase.JunitTest1;
import java.lang.Throwable;
import basicTestCase.JunitTest5;
import basicTestCase.ExtendedJunitTestClass;

public class BasicTestOutput {
    public static BasicTest basicTest_0;
    public static BasicTest basicTest_1;
    public static JunitTest2 junitTest2_2;
    public static JunitTest2 junitTest2_3;
    public static ExtendedJunitTestClass extendedJunitTestClass_4;
    public static JunitTest5 junitTest5_5;
    public static JunitTest1 junitTest1_6;

    public static void main(String[] args) {
        try {
            BasicTest basicTest = new BasicTest();
            JunitTest3 junitTest3 = new JunitTest3();
            ExtendedJunitTestClass extendedJunitTestClass = new ExtendedJunitTestClass();
            TestedOnClassTest testedOnClassTest = new TestedOnClassTest();
            JunitTest2.rgg.starting(Description.createSuiteDescription(JunitTest2.class));
            BasicTest.tw.starting(Description.createSuiteDescription(BasicTest.class));
            BasicTest.rs.before();
            BasicTest.oneTimeSetUpBeforeClasss();
            BasicTest.oneTimeSetUpBeforeClass();
            JunitTest3.rss.starting(Description.createSuiteDescription(JunitTest3.class));
            JunitTest3.oneTimeSetUpBeforeClass();
            junitTest3.setUp();
            junitTest3.testMethodFour();
            junitTest3.tearDowns();
            JunitTest3.oneTimeTearDownAfterClasss();
            JunitTest3.rss.succeeded(Description.createSuiteDescription(JunitTest3.class));
            JunitTest3.rss.finished(Description.createSuiteDescription(JunitTest3.class));
            ExtendedJunitTestClass.oneTimeSetUpBeforeClasss();
            ExtendedJunitTestClass.oneTimeSetUpBeforeClass();
            TestedOnClassTest.oneTimeSetUpBeforeClass();
            testedOnClassTest.setUp();
            testedOnClassTest.testMethodFiveTheory();
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.a();
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(2);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(3);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(5);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(6);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(9);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(10);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(5,2,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(5,2,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(5,3,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(5,3,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(6,2,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(6,2,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(6,3,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(6,3,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(7,2,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(7,2,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(7,3,20);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testInteger(7,3,30);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testIntegers();
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testIntegerx(2);
            testedOnClassTest.tearDown();
            testedOnClassTest.setUp();
            testedOnClassTest.testIntegerx(3);
            testedOnClassTest.tearDown();
            TestedOnClassTest.oneTimeTearDownAfterClass();
            ExtendedJunitTestClass.oneTimeTearDownAfterClass();
            ExtendedJunitTestClass.oneTimeTearDownAfterClasss();
            BasicTest.oneTimeTearDownAfterClass();
            BasicTest.oneTimeTearDownAfterClasss();
            BasicTest.rs.after();
            BasicTest.tw.succeeded(Description.createSuiteDescription(BasicTest.class));
            BasicTest.tw.finished(Description.createSuiteDescription(BasicTest.class));
            JunitTest2.rgg.succeeded(Description.createSuiteDescription(JunitTest2.class));
            JunitTest2.rgg.finished(Description.createSuiteDescription(JunitTest2.class));
        }catch(Exception e) {
            e.printStackTrace();
        }catch(Throwable t) {
            t.printStackTrace();
        }
    }
}
