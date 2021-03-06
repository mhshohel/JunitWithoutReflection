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
 * Linnaeus University, V�xj�, Sweden
 *
 */
package tools.code.gen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class MainClass {
    /*
     * Character that separates components of a file path. This is "/" on UNIX
     * and "\" on Windows.
     */
    private static String fileSeparator = System.getProperty("file.separator");
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
    private static Set<Class<?>> testClasses = new HashSet<Class<?>>();
    /*
     * Keep the list of all non test classes
     */
    private static Set<Class<?>> nonTestClasses = new HashSet<Class<?>>();
    /*
     * Save output class directory information, so that it can print at the end
     * of code generation, Key: Directory, Value: Java file name
     */
    private static HashMap<String, String> outputClassDirectory = new HashMap<String, String>();
    /*
     * Keep all generated source files list and its name of its original test
     * clase source file name, Key: location with file name, Value: File Name
     */
    private static HashMap<String, String> genCodeAndTestClassSourceFiles = new HashMap<String, String>();
    /*
     * Keep source files list, Key: location with file name, Value: File Name
     */
    private static HashMap<String, String> sourceFiles = new HashMap<String, String>();

    public static void main(String[] args) {
	// Map<String, String> codes = new HashMap<String, String>();
	//
	// codes.put("A1", "Aania");
	// codes.put("X1", "Abatha");
	// codes.put("C1", "Acathan");
	// codes.put("S1", "Adreenas");
	// codes.put("A1", "Aania");
	//
	// for (Map.Entry entry : codes.entrySet()) {
	// System.out.println(entry.getKey() + ", " + entry.getValue());
	// }

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
	codeGen(args, true);
	verifySourcodeForGenCode();
	// readTestClasses();
	// readGeneratedTestCode();
    }

    /**
     * <li><strong><i>codeGen</i></strong></li>
     * 
     * <pre>
     * public static void codeGen(String[] args, boolean isMethodSorted)
     * </pre>
     * 
     * <p>
     * To make the code generation available while using it as a library file. A
     * String array should pass which can take any number of parameters but it
     * will count only first two. args[0] as folder name with path (not the
     * package name) ex: c:\temp and args[1] is optional as a specific name
     * filter. ex: a.t.Test, means codeGen will look for Test class of to
     * generate code, other test classes will be escaped.
     * </p>
     * 
     * @param args
     *            - String[], args[0] as location, args[1] as specific Test
     *            class.
     * @param isMethodSorted
     *            - boolean if test class should provide sorted method then
     *            true.
     * 
     * @author Shohel Shamim
     */
    public static void codeGen(String[] args, boolean isMethodSorted) {
	try {
	    String fileLocation = args[0].trim();
	    // Get specific class name
	    String nameFilter = (args.length > 1) ? args[1].trim() : "";
	    file = new File(fileLocation);

	    System.out.println("------------------------------\n"
		    + "***** Loading classes... *****\n"
		    + "------------------------------");
	    readFiles(file, nameFilter, "");
	    System.out
		    .println("------------------------------------------------\n");

	    System.out.println("---------------------------------------------");
	    System.out.println("****** Verify Test Classes - JUnit 4.0 ******");
	    System.out.println("---------------------------------------------");

	    Set<Class<?>> classes = (testClasses.isEmpty()) ? allClasses
		    : testClasses;
	    for (Class<?> cls : classes) {
		System.out.println("\nClass " + cls.getName());
		System.out
			.println("-------------------------------------------");
		// Verify JUnit Test class first, if there JUnit fails to
		// run Test case then it will not generate the output
		Result result = null;
		try {
		    result = JUnitCore.runClasses(cls);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (result != null && !result.getFailures().isEmpty()) {
		    nonTestClasses.add(cls);
		    System.out.println("\tis not a Test Class");
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

		    // Physical Path; Decode path to avoid unwanted chars,
		    // removed first char,
		    String directory = URLDecoder.decode(clss.getResource("")
			    .getFile().substring(1), "UTF-8");
		    directory = fileLocation
			    .concat(fileSeparator)
			    .concat(packageName.replace('.', (fileSeparator
				    .equalsIgnoreCase("/") ? '/' : '\\')))
			    .concat(fileSeparator);

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
		    boolean methodShouldSort = isMethodSorted; // or false
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
		    // Key is path with .java file and value is class name
		    outputClassDirectory.put(
			    (directory + outputClassName + ".java"),
			    clss.getSimpleName());
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

	    for (Entry<String, String> entry : outputClassDirectory.entrySet()) {
		System.out.println(entry.getKey());
	    }
	}
    }

    /**
     * <li><strong><i>readFiles</i></strong></li>
     * 
     * <pre>
     * private static void readFiles(final File folder, final String pack)
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
    private static void readFiles(final File folder, final String nameFilter,
	    final String pack) {
	try {
	    String pac = (pack.trim().equalsIgnoreCase("") ? "" : pack
		    .concat("."));
	    for (final File fileEntry : folder.listFiles()) {
		if (fileEntry.isDirectory()) {
		    readFiles(fileEntry, nameFilter,
			    pac.concat(fileEntry.getName()));
		} else {
		    if (fileEntry.getName().endsWith(".class")) {
			try {
			    URL url = file.toURI().toURL();
			    URL[] urls = new URL[] { url };
			    String cls = pac.concat(fileEntry.getName()
				    .replaceAll(".class", ""));
			    @SuppressWarnings("resource")
			    Class<?> clas = new URLClassLoader(urls)
				    .loadClass(cls);
			    System.out.println("\t" + clas.getName());
			    allClasses.add(clas);
			    if (cls.equalsIgnoreCase(nameFilter)) {
				testClasses.add(clas);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    } else if (fileEntry.getName().endsWith(".java")) {
			genCodeAndTestClassSourceFiles.put(
				fileEntry.getAbsolutePath(),
				fileEntry.getName());
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * Sample code for 2nd part of the Thesis
     */
    public static void verifySourcodeForGenCode() {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out
		.println("\nWarning: Source code that you provide should be same as class file."
			+ "Any changes in source code without re-compiling it may cause invalid results."
			+ "\n2nd Part.....\n\n");
	String requiredJavaFile = null;
	String genCodeDiractory = null;
	String searchForJavaSourceFileWithPath = null;
	// first collect verify or collect all source code for Test classes
	for (Entry<String, String> entry : outputClassDirectory.entrySet()) {
	    boolean fileFound = false;
	    requiredJavaFile = entry.getValue().concat(".java");
	    genCodeDiractory = entry.getKey();
	    genCodeDiractory = genCodeDiractory.substring(0,
		    genCodeDiractory.lastIndexOf(fileSeparator) + 1);

	    searchForJavaSourceFileWithPath = genCodeDiractory.trim().concat(
		    requiredJavaFile.trim());
	    if (genCodeAndTestClassSourceFiles
		    .containsKey(searchForJavaSourceFileWithPath)) {
		// if source code found in the same directory with same name
	    } else {
		while (!fileFound) {
		    // Source code file must be named as requiredJavaFile
		    System.out.println("Please provide source code file "
			    + "location (ex: c:\\Temp) of : \n"
			    + requiredJavaFile);

		    File folder = null;
		    try {
			genCodeDiractory = br.readLine();
			System.out.println(genCodeDiractory);
			folder = new File(genCodeDiractory);
		    } catch (IOException e) {
			e.printStackTrace();
		    }

		    try {
			for (final File fileEntry : folder.listFiles()) {
			    if (fileEntry.getName().endsWith(".java")) {
				if (fileEntry.getName().equalsIgnoreCase(
					requiredJavaFile)) {
				    fileFound = true;
				    break;
				}
			    }
			}
		    } catch (Exception e) {
			System.err
				.println("Error!: Please provide a valid PATH.");
		    }
		}
		sourceFiles.put(genCodeDiractory, requiredJavaFile);
	    }
	}

	Class<?> cls = A.class;
	System.out.println("Class Name: " + cls);
	// Methods
	System.out.println("Methods:" + cls.getDeclaredMethods().length);
	// Inner classes
	System.out.println("Inner Classes: " + cls.getDeclaredClasses().length);
	// Constructors
	System.out.println("Constructors: "
		+ cls.getDeclaredConstructors().length);
	// Fields
	System.out.println("Fields :" + cls.getDeclaredFields().length);
	Method[] ms = cls.getDeclaredMethods();
	Method m = ms[0];
	System.out.println(m);
    }
}