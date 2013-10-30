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

import graphs.test.TestAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

		    Class<?> cls = TestAlgorithms.class;

		    // String resourceName = cls.getName().replace('.', '/')
		    // + ".class";
		    // InputStream classInputStream =
		    // cls.getClassLoader()
		    // .getResourceAsStream(resourceName);
		    // cp = new ClassParser(classInputStream, resourceName);

		    cp = new ClassParser(arg, entry.getName());
		    JavaClass jc = cp.parse();
		    ClassVisitor visitor = new ClassVisitor(jc);
		    visitor.start();
		}
	    }
	} catch (IOException e) {
	    System.err.println("Error while processing jar: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
