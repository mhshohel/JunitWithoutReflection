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
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
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
	File root = new File("c:\\java"); // On Windows running on C:\, this is
					  // C:\java.
	File sourceFile = new File(root, "test\\Test.java");
	sourceFile.getParentFile().mkdirs();
	try {
	    new FileWriter(sourceFile).append(source).close();
	} catch (IOException e1) {

	    e1.printStackTrace();
	}

	// Compile source file.
	// JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	JavaCompiler compiler = null;
	try {
	    compiler = ToolProvider.getSystemJavaCompiler();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	compiler.run(null, null, null, sourceFile.getPath());

	// Load and instantiate compiled class.
	URLClassLoader classLoader = null;
	try {
	    classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
		    .toURL() });
	} catch (MalformedURLException e) {

	    e.printStackTrace();
	}
	Class<?> cls = null;
	try {
	    cls = Class.forName("test.Test", true, classLoader);
	} catch (ClassNotFoundException e) {

	    e.printStackTrace();
	} // Should
	  // print
	  // "hello".
	Object instance = null;
	try {
	    instance = cls.newInstance();
	} catch (InstantiationException e) {

	    e.printStackTrace();
	} catch (IllegalAccessException e) {

	    e.printStackTrace();
	} // Should print "world".
	System.out.println(instance); // Should print "test.Test@hashcode".
    }

}
