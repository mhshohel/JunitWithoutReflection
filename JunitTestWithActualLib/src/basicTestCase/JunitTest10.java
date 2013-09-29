/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase
 *
 * @FileName JunitTest.java
 * 
 * @FileCreated Nov 7, 2012
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

import java.io.Closeable;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class JunitTest10 {

    static class ExpensiveExternalResource extends ExternalResource {

	private final String info;

	ExpensiveExternalResource(String info) {
	    this.info = info;
	}

	@Override
	protected void after() {
	    System.out.println("JunitTest10.class: after " + this.info);
	};

	@Override
	protected void before() throws Throwable {
	    System.out.println("JunitTest10.class: before " + this.info);
	};
    };

    static class ExpensiveManagedResource implements Closeable {
	@Override
	public void close() throws IOException {
	}
    }

    static class ManagedResource implements Closeable {
	@Override
	public void close() throws IOException {
	}
    }

    @BeforeClass
    public static void setUpClass() {
	System.out.println("JunitTest10.class: @BeforeClass setUpClass");
	MyExpensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
	System.out.println("JunitTest10.class: @AfterClass tearDownClass");
	MyExpensiveManagedResource.close();
	MyExpensiveManagedResource = null;
    }

    @Rule
    public ExternalResource resource = new ExpensiveExternalResource("rule");

    @ClassRule
    public static ExternalResource StaticResource = new ExpensiveExternalResource(
	    "classRule");

    private ManagedResource myManagedResource;

    private static ExpensiveManagedResource MyExpensiveManagedResource;

    private void println(String string) {
	System.out.println(string);
    }

    @Before
    public void setUp() {
	this.println("JunitTest10.class: @Before setUp");
	this.myManagedResource = new ManagedResource();
    }

    @After
    public void tearDown() throws IOException {
	this.println("JunitTest10.class: @After tearDown()");
	this.myManagedResource.close();
	this.myManagedResource = null;
    }

    @Test
    public void test1() {
	this.println("JunitTest10.class: @Test test1()");
    }

    @Test
    public void test2() {
	this.println("JunitTest10.class: @Test test2()");
    }
}
