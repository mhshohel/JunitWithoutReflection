/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraph
 *
 * @FileName JCallGraph.java
 * 
 * @FileCreated Oct 24, 2013
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
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import observer.Adder;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

public class JCallGraph {
    public static void main(String[] args) {
	ClassParser cp;
	try {
	    for (String arg : args) {

		File f = new File(arg);

		if (!f.exists()) {
		    System.err.println("Jar file " + arg + " does not exist");
		}

		JarFile jar = new JarFile(f);

		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
		    JarEntry entry = entries.nextElement();
		    if (entry.isDirectory())
			continue;

		    if (!entry.getName().endsWith(".class"))
			continue;

		    Class<?> cls = Adder.class;

		    String resourceName = cls.getName().replace('.', '/')
			    + ".class";
		    JavaClass javaClass = null;
		    try {
			InputStream classInputStream = cls.getClassLoader()
				.getResourceAsStream(resourceName);
			javaClass = new ClassParser(classInputStream,
				resourceName).parse();
		    } catch (Exception e) {

		    }

		    // InputStream classInputStream =
		    // cls.getClassLoader()
		    // .getResourceAsStream(resourceName);
		    // cp = new ClassParser(classInputStream, resourceName);

		    cp = new ClassParser(arg, entry.getName());
		    JavaClass jc = cp.parse();
		    ClassVisitor visitor = new ClassVisitor(javaClass);
		    visitor.start();
		    break;
		}
	    }
	} catch (IOException e) {
	    System.err.println("Error while processing jar: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
