/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.code.gen
 *
 * @FileName MainClass.java
 * 
 * @FileCreated Jan 01, 2013
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
package tools.code.gen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import basicTestCase.BasicTest;

public class MainClass {
    /*
     * Keep the list of all test classes
     */
    private static List<Class<?>> testClasses = new ArrayList<Class<?>>();
    /*
     * Keep the list of all non test classes
     */
    private static List<Class<?>> nonTestClasses = new ArrayList<Class<?>>();

    public static void main(String[] args) {
	List<String> packageLocation = new ArrayList<String>();
	// must check dir...
	if (args.length == 0) {
	    System.err
		    .println("You must provide the package name with location. \nex: graph or graph.test");
	    System.exit(-1);
	}

	File file = new File("D:\test");
	if (file.isDirectory()) {

	}

	String fileSeparator = System.getProperty("file.separator");
	for (int i = 0; i < args.length; i++) {
	    packageLocation.add(args[i].replace('.', '/'));
	}

	try {
	    Class<?> clss = BasicTest.class;
	    // SuppliedByTest.class
	    // ParameterSuppliedByClassTest.class;
	    // ParametarizedTest.class
	    // BigOutPut.class;
	    // DataPointsTestClass.class;
	    // TheoryTest.class;
	    // SuiteClassTest.class;
	    // JunitTest1.class; 1-10
	    // BasicTest.class;
	    // ParametarizedTest.class;
	    // CategoryTest.class;
	    // AccountTest.class;
	    // AccountIntegrationTest.class;
	    // MyStuffJunitTest.class;
	    // TestSquareMatrix.class;
	    // AfterAfterClassBeforeBeforeClassIgnore.class;

	    // TestAlgorithms
	    // TestDFS
	    // TestDirectedGraph

	    // Verify JUnit Test class first, if there JUnit fails to run Test
	    // case then it will not generate the output
	    System.out.println("******Run Test Case - JUnit 4.0******\n");
	    Result result = null;
	    try {
		result = JUnitCore.runClasses(clss);
	    } catch (Exception e) {
		System.err.println("Not a test class");
	    }

	    // result = JUnitCore.runClasses(BasicTest.class);
	    if (result != null && !result.getFailures().isEmpty()) {
		for (Failure failure : result.getFailures()) {
		    System.err.println(failure.toString());
		}
		System.out.println("Code Generation Fail; Errors found in "
			+ clss.getSimpleName() + ".class");
	    } else {
		System.out.println("\n******Test Case Run Complete******\n\n");
		// Character that separates components of a file path. This is
		// "/"
		// on UNIX and "\" on Windows.
		String directory = System.getProperty("user.dir");
		String source = fileSeparator + "src";
		String output = fileSeparator + "tools" + fileSeparator
			+ "code" + fileSeparator + "gen" + fileSeparator
			+ "output" + fileSeparator;
		// Changed to class original name instead of hardcoded
		// "OutputClass"
		String outputClassName = clss.getSimpleName().concat("Output");// "OutputClass";
		String packageName = MainClass.class.getPackage().getName()
			+ ".output";
		// If isMethodSorted is true then method will be sorted
		// otherwise it
		// can be unsorted. In future Junit 4.11 there is a updated to
		// sort
		// method. However, 4.1 - 4.10 it is not available. If you run
		// Junit
		// then you may see method is sometimes read according to
		// alphabetical order but most of the time unsorted. That's why
		// for
		// long list of methods it is often creates confusion because
		// order
		// of method not match, until you run 2-3 time you will get
		// sorted.
		boolean methodShouldSort = true; // or false
		// Output generation begins;
		GenerateOutput outputClass = new GenerateOutput(clss,
			packageName, outputClassName, methodShouldSort,
			directory, source, output);
		// outputClass.execute() to write code in file; it returns code
		// as output
		System.out.println("\n******Generating Output Code******");
		// System.out.println(outputClass.execute());
		outputClass.execute();
		outputClass = null;
		System.out.println("\n******Code Generation Complete******");
		System.out.println("Output file: \n" + directory + source
			+ output);
	    }
	} catch (Exception e) {
	    System.err.println(e.getMessage());
	}
    }

    /**
     * <li><strong><i>getListOfFileFromFolder</i></strong></li>
     * 
     * <pre>
     * private static void getListOfFileFromFolder(final File folder)
     * </pre>
     * 
     * <p>
     * Save the list of .class files.
     * </p>
     * 
     * @param folder
     *            - entry point of the folder.
     * 
     * @author Shohel Shamim
     */
    private static void getListOfFileFromFolder(final File folder) {

    }
}