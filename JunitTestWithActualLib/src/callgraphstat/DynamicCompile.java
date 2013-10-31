/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraph
 *
 * @FileName DynamicCompile.java
 * 
 * @FileCreated Oct 25, 2013
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
package callgraphstat;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DynamicCompile {
    // set jdk and tools.jar
    /**
     * @param DynamicCompile
     */
    public static void main(String[] args) {
	// Prepare source somehow.
	String source = "package test; public class Test { static { System.out.println(\"hello\"); } public Test() { System.out.println(\"world\"); } }";

	// Save source in .java file.
	File root = new File("C:\\java"); // On Windows running on C:\, this is
					  // C:\java.
	File sourceFile = new File(root, "test\\AClassFile.java");
	File tsource = new File(root, "test\\Test.java");
	sourceFile.getParentFile().mkdirs();
	// try {
	// new FileWriter(sourceFile).append(source).close();
	// } catch (IOException e1) {
	//
	// e1.printStackTrace();
	// }

	// Compile source file.
	// JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	JavaCompiler compiler = null;
	try {
	    compiler = ToolProvider.getSystemJavaCompiler();
	} catch (Exception e) {

	    e.printStackTrace();
	}

	// File f = new File(s);
	// URL u = null;
	// try {
	// u = root.toURI().toURL();
	// } catch (MalformedURLException e1) {
	//
	// e1.printStackTrace();
	// }
	// URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader
	// .getSystemClassLoader();
	// Class urlClass = URLClassLoader.class;
	// Method method = null;
	// try {
	// method = urlClass.getDeclaredMethod("addURL",
	// new Class[] { URL.class });
	// } catch (NoSuchMethodException e1) {
	//
	// e1.printStackTrace();
	// } catch (SecurityException e1) {
	//
	// e1.printStackTrace();
	// }
	// method.setAccessible(true);
	// try {
	// method.invoke(urlClassLoader, new Object[] { u });
	// } catch (IllegalAccessException e1) {
	//
	// e1.printStackTrace();
	// } catch (IllegalArgumentException e1) {
	//
	// e1.printStackTrace();
	// } catch (InvocationTargetException e1) {
	//
	// e1.printStackTrace();
	// }

	ClassLoader cl = ClassLoader.getSystemClassLoader();

	URL[] urls = ((URLClassLoader) cl).getURLs();

	for (URL url : urls) {
	    System.out.println(url.getFile());
	}

	String classpath = System.getProperty("java.class.path");
	String testpath = "C:\\java;" + classpath;
	List<String> optionList = new ArrayList<String>();
	optionList.addAll(Arrays.asList("-classpath", testpath));
	// optionList.addAll(Arrays.asList("-d",rootPath+"/target"));
	StandardJavaFileManager sjfm = compiler.getStandardFileManager(null,
		null, null);
	File[] files = new File[2];
	files[0] = new File("c:\\java\\test\\Test.java");
	files[1] = new File("c:\\java\\test\\AClassFile.java");
	Iterable fileObjects = sjfm.getJavaFileObjects(files);
	JavaCompiler.CompilationTask task = compiler.getTask(null, null, null,
		optionList, null, fileObjects);
	task.call();
	try {
	    sjfm.close();
	} catch (IOException e1) {

	    e1.printStackTrace();
	}

	// compiler.run(null, null, null, tsource.getPath());

	// compiler.run(null, null, null, sourceFile.getPath());

	// Load and instantiate compiled class.
	URLClassLoader classLoader = null;
	try {
	    classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
		    .toURL() });
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}

	Class<?> clss = null;
	try {
	    clss = Class.forName("test.AClassFile", true, classLoader);
	} catch (ClassNotFoundException e) {

	    e.printStackTrace();
	} // Should
	  // print
	  // "hello".
	Object instance = null;
	try {
	    instance = clss.newInstance();
	} catch (InstantiationException e) {

	    e.printStackTrace();
	} catch (IllegalAccessException e) {

	    e.printStackTrace();
	} // Should print "world".
	System.out.println(instance); // Should print "test.Test@hashcode".
    }

}
