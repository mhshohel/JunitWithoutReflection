package basicTestCase;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import actualSeperatedCode.ClassRuleTester;
import actualSeperatedCode.RuleClassTester;

@RunWith(value = Parameterized.class)
public class ParametarizedTest {
    public ParametarizedTest(int a, Object b, String c) {
	this.a = a;
	this.b = b;
	this.c = c;
    }

    int a;
    Object b;
    String c;

    // @Ignore
    @Test
    public void testMethodFive() {
	System.out.println("ParametarizedTest.class: testMethodFive()");
    }

    @Ignore
    @Parameters
    public static List<Object[]> data() {
	Object[][] data = new Object[][] { { 1, 2, "3" }, { 4, 5, "6" } };
	return Arrays.asList(data);
    }

    @Test
    public void testMethodSix() {
	System.out.println("ParametarizedTest.class: testMethodSix()");
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("ParametarizedTest.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("ParametarizedTest.class: setUp()");
    }

    @After
    public void tearDown() {
	System.out.println("ParametarizedTest.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("ParametarizedTest.class: oneTimeTearDownAfterClass()");
    }

    @ClassRule
    public static ClassRuleTester i = new ClassRuleTester(
	    "ParametarizedTest.class: ");

    @Rule
    public RuleClassTester ilfs = new RuleClassTester(
	    "ParametarizedTest.class: ");

    @Test
    public void pushTest() {
	System.out
		.println("ParametarizedTest.class: Parameterized Number is : "
			+ a + b + c);
    }
}
