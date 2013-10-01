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
import java.net.URLDecoder;
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
     * Keep All classes
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

	// This version can only take one directory location
	if (args.length == 0) {
	    System.err
		    .println("You must provide the folder name with path, not the package name. "
			    + "ex: C:\\Temp\\src");
	    System.err
		    .println("You can also provide a specific Test class name as second parameter. "
			    + "ex: C:\\Temp\\src a.b.Test (without .class extension)");
	    System.err
		    .println("You can also use this jar file as a library by calling MainClass.codeGen "
			    + "by providing maximum 2 parameters using String array.");
	    System.exit(-1);
	}
	codeGen(args);
    }

    /**
     * <li><strong><i>codeGen</i></strong></li>
     * 
     * <pre>
     * public static void codeGen(String[] args)
     * </pre>
     * 
     * <p>
     * To make the code generation available while using it as a library file. A
     * String array should pass which can take any number of parameters but it
     * will count only first two. args[0] as folder name with path (not the
     * package name) ex: c:\temp\ and args[1] is optional as a specific name
     * filter. ex: a.t.Test, means codeGen will look for Test class of to
     * generate code, other test classes will be excaped.
     * </p>
     * 
     * @param args
     *            - String[], args[0] as location, args[1] as specific Test
     *            class.
     * 
     * @author Shohel Shamim
     */
    public static void codeGen(String[] args) {
	try {
	    String fileLocation = args[0].trim();
	    // Get specific class name
	    String nameFilter = (args.length > 1) ? args[1].trim() : "";
	    file = new File(fileLocation);

	    System.out
		    .println("------------------------------\n***** Loading classes... *****\n------------------------------");
	    getListOfClassesFromDirectory(file, nameFilter, "");
	    System.out
		    .println("------------------------------------------------\n");

	    String fileSeparator = System.getProperty("file.separator");

	    System.out.println("---------------------------------------------");
	    System.out.println("****** Verify Test Classes - JUnit 4.0 ******");
	    System.out.println("---------------------------------------------");
	    for (Class<?> cls : allClasses) {
		System.out.println("\nClass " + cls.getName());
		System.out
			.println("-------------------------------------------");
		// Verify JUnit Test class first, if there JUnit fails to run
		// Test
		// case then it will not generate the output
		Result result = null;
		try {
		    result = JUnitCore.runClasses(cls);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (result != null && !result.getFailures().isEmpty()) {
		    nonTestClasses.add(cls);
		    System.out.println("\tNot a Test Class");
		} else {
		    testClasses.add(cls);
		    System.out
			    .println("-------------------------------------------");
		    System.out.println(cls.getName() + " is a Test Class");
		}
	    }
	    System.out
		    .println("\n---------------------------------------------");

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
		    // Physical Path; Decode path to avoid unwanted char,
		    // removed first char,
		    String directory = URLDecoder.decode(clss.getResource("")
			    .getFile().substring(1), "UTF-8");
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
		    System.out.println("\n****** Generating Code for "
			    + clss.getName() + " ******");
		    // System.out.println(outputClass.execute());
		    outputClass.execute();
		    outputClass = null;
		    System.out.println("\tCode Generation Complete as "
			    + outputClassName + ".java");
		    outputClassDirectory.add(directory + outputClassName
			    + ".java");
		}
	    }
	} catch (Exception e) {
	    System.err.println(e.getMessage());
	} finally {
	    System.out
		    .println("\n--------------------------------------------------------");
	    System.out
		    .println("****** List of Generated code with physical path ******");
	    System.out
		    .println("--------------------------------------------------------");
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
			System.out.println("\t" + clas.getName());
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