package actualSeperatedCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestedOnClassTest {
    @Test
    public void testMethodFiveTheory() {
	System.out.println("TestedOnClassTest.class: testMethodFiveTHeory()");
    }

    @Theory
    public void a() {
	System.out.println("TestedOnClassTest.class: a()");
    }

    @Theory
    public void testIntegers() {
	System.out.println("TestedOnClassTest.class: testIntegers()");
    }

    @Theory
    public void testInteger(@TestedOn(ints = { 5, 6, 7 }) int i,
	    @TestedOn(ints = { 2, 3 }) int j, @TestedOn(ints = { 20, 30 }) int k) {
	System.out
		.println("TestedOnClassTest.class: testInteger(int, int, int)"
			+ i + j + k);
    }

    @Category({ SlowTests.class })
    @Theory
    public void testIntegerx(@TestedOn(ints = { 2, 3 }) int i) {
	System.out.println("TestedOnClassTest.class: testIntegerx(int)" + i);
    }

    @Category({ IntegrationTests.class })
    @Theory
    public void testInteger(@TestedOn(ints = { 2, 3, 5, 6, 9, 10 }) int i) {
	System.out.println("TestedOnClassTest.class: testInteger(int)" + i);
    }

    @BeforeClass
    public static void oneTimeSetUpBeforeClass() {
	System.out
		.println("TestedOnClassTest.class: oneTimeSetUpBeforeClass()");
    }

    @Before
    public void setUp() {
	System.out.println("TestedOnClassTest.class: setUp()");
    }

    @After
    public void tearDown() {
	System.out.println("TestedOnClassTest.class: tearDown()");
    }

    @AfterClass
    public static void oneTimeTearDownAfterClass() {
	System.out
		.println("TestedOnClassTest.class: oneTimeTearDownAfterClass()");
    }
}
