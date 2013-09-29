package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class RuleAndClassRuleTest {
    @Rule
    public RuleClassTester ilf = new RuleClassTester(
	    "RuleAndClassRuleTest.java: ");

    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester(
	    "RuleAndClassRuleTest.java: ");

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("RuleAndClassRuleTest.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("RuleAndClassRuleTest.class: setUp()");
    }

    @Test
    public void testMethodFive() {
	System.out.println("RuleAndClassRuleTest.class: testMethodFive()");
    }

    @Test
    public void testMethodFiveFive() {
	System.out.println("RuleAndClassRuleTest.class: testMethodFiveFive()");
    }

    @After
    public void tearDown() {
	System.out.println("RuleAndClassRuleTest.class: tearDown");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("RuleAndClassRuleTest.class: oneTimeTearDownAfterClass");
    }
}