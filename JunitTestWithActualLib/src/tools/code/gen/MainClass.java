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
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class MainClass {
    /*
     * Store file info
     */
    private static File file = null;
    /*
     * Kepp All classes
     */
    private static Set<Class<?>> allClasses = new HashSet<Class<?>>();
    /*
     * Keep the list of all test classes
     */
    private static List<Class<?>> testClasses = new ArrayList<Class<?>>();
    /*
     * Keep the list of all non test classes
     */
    private static List<Class<?>> nonTestClasses = new ArrayList<Class<?>>();
    /*
     * Save output class directory information, so that it can print at the end
     * of code generation
     */
    private static List<String> outputClassDirectory = new ArrayList<String>();

    public static void main(String[] args) {
	try {
	    // This version can only take one directory location
	    if (args.length == 0) {
		System.err
			.println("You must provide the folder name with location, not the package names. "
				+ "\nex: C:\\Temp\\src");
		System.err
			.println("You can also provide a specific Test class name as second parameter. \n"
				+ "ex: C:\\Temp\\src a.b.Test (without .class extension)");
		System.exit(-1);
	    }

	    String fileLocation = args[0].trim();
	    // Get specific class name
	    String nafeFilter = (args.length > 1) ? args[1].trim() : "";
	    file = new File(fileLocation);
	    getListOfClassesFromDirectory(file, nafeFilter, "");

	    String fileSeparator = System.getProperty("file.separator");

	    for (Class<?> cls : allClasses) {
		// Verify JUnit Test class first, if there JUnit fails to run
		// Test
		// case then it will not generate the output
		Result result = null;
		try {
		    System.out
			    .println("******Run Test Case - JUnit 4.0******\n");
		    result = JUnitCore.runClasses(cls);
		    System.out
			    .println("\n******Test Case Run Complete******\n\n");
		} catch (Exception e) {

		}
		if (result != null && !result.getFailures().isEmpty()) {
		    nonTestClasses.add(cls);
		    System.err.println(cls.getName()
			    + " is not a JUnit Test class");
		} else {
		    testClasses.add(cls);
		    System.out.println("Loaded JUnit Test class: "
			    + cls.getName());
		}
	    }

	    // Class<?> clss = null;
	    // BasicTest.class;
	    // BasicTest.class;
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

	    if (testClasses.isEmpty()) {
		System.out.println("No Test classes found to Generate code.");
	    } else {
		for (Class<?> clss : testClasses) {
		    /*
		     * Changed to class original name instead of hard coded
		     * "OutputClass"
		     */
		    String outputClassName = clss.getSimpleName().concat(
			    "Output");
		    String packageName = clss.getPackage().getName();
		    // MainClass.class.getPackage().getName()+ ".output";

		    /*
		     * Character that separates components of a file path. This
		     * is "/" on UNIX and "\" on Windows.
		     */

		    String directory = clss.getResource("").getPath()
			    .substring(1); // Physical Path; removed first char
		    if (fileSeparator.equalsIgnoreCase("\\")) {
			directory = directory.replaceAll("/", fileSeparator
				+ fileSeparator);
		    }

		    /*
		     * If isMethodSorted is true then method will be sorted
		     * otherwise it can be unsorted. In future Junit 4.11 there
		     * is a updated to sort method. However, 4.1 - 4.10 it is
		     * not available. If you run Junit then you may see method
		     * is sometimes read according to alphabetical order but
		     * most of the time unsorted. That's why for long list of
		     * methods it is often creates confusion because order of
		     * method not match, until you run 2-3 time you will get
		     * sorted.
		     */
		    boolean methodShouldSort = true; // or false
		    // Output generation begins;
		    GenerateOutput outputClass = new GenerateOutput(clss,
			    packageName, outputClassName, methodShouldSort,
			    directory);
		    /*
		     * outputClass.execute() to write code in file; it returns
		     * code as output
		     */
		    System.out.println("\n****** Generating Output Code for "
			    + clss.getName() + " ******");
		    // System.out.println(outputClass.execute());
		    outputClass.execute();
		    outputClass = null;
		    System.out
			    .println("\n****** Code Generation Complete ******");
		    outputClassDirectory.add(directory + outputClassName
			    + ".java");
		}
	    }
	} catch (Exception e) {
	    System.err.println(e.getMessage());
	} finally {
	    System.out
		    .println("\n\n\n****** List of Generated code with physical path ******");
	    for (String vals : outputClassDirectory) {
		System.out.println(vals);
	    }
	}
    }

    /**
     * <li><strong><i>getListOfClassesFromDirectory</i></strong></li>
     * 
     * <pre>
     * private static void getListOfClassesFromDirectory(final File folder, final String pack)
     * </pre>
     * 
     * <p>
     * Save the list of .class files.
     * </p>
     * 
     * @param folder
     *            - entry point of the folder.
     * @param nameFilter
     *            - provide a specific class name.
     * @param pack
     *            - contains package names.
     * 
     * @author Shohel Shamim
     */
    private static void getListOfClassesFromDirectory(final File folder,
	    final String nameFilter, final String pack) {
	String pac = (pack.trim().equalsIgnoreCase("") ? "" : pack.concat("."));
	for (final File fileEntry : folder.listFiles()) {
	    if (fileEntry.isDirectory()) {
		getListOfClassesFromDirectory(fileEntry, nameFilter,
			pac.concat(fileEntry.getName()));
	    } else {
		if (fileEntry.getName().endsWith(".class")) {
		    try {
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };
			String cls = pac.concat(fileEntry.getName().replaceAll(
				".class", ""));
			@SuppressWarnings("resource")
			Class<?> clas = new URLClassLoader(urls).loadClass(cls);
			if (nameFilter.isEmpty()) {
			    allClasses.add(clas);
			} else {
			    if (cls.equalsIgnoreCase(nameFilter)) {
				allClasses.add(clas);
			    }
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    }
	}
    }
}