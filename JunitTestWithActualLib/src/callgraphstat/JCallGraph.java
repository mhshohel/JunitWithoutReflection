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
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

import callgraphstat.testclasses.JonasTestMain;

public class JCallGraph {
    private static File file;
    private static List<Description> classDescriptions = new ArrayList<Description>();

    public static void main(String[] args) {
	file = new File(
		"G:\\lnu\\5DV001 - Thesis Project\\Thesis - Jonas\\ThesisBackup\\JunitWithoutReflection.git.first\\JunitTestWithActualLib\\bin\\callgraphstat");
	readFiles(file, "", "callgraphstat");
	try {
	    Class<?> cls = null;
	    // for (Class<?> c : allClasses) {
	    // if (c.getSimpleName().equalsIgnoreCase("TestDFS")) {
	    // cls = c;
	    // break;
	    // }
	    // }

	    // HINTS: DO NOT GET NODE FOR INTERFACE
	    cls = JonasTestMain.class;
	    String resourceName = cls.getName().replace('.', '/') + ".class";
	    JavaClass javaClass = null;
	    try {
		InputStream classInputStream = cls.getClassLoader()
			.getResourceAsStream(resourceName);
		javaClass = new ClassParser(classInputStream, resourceName)
			.parse();
	    } catch (Exception e) {

	    }
	    ClassVisitor visitor = new ClassVisitor(javaClass);
	    visitor.start();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private static void readFiles(final File folder, final String nameFilter,
	    final String pack) {
	try {
	    String pac = (pack.trim().equalsIgnoreCase("") ? "" : pack
		    .concat("."));
	    for (final File fileEntry : folder.listFiles()) {
		if (fileEntry.isDirectory()) {
		    if (fileEntry.getName().equalsIgnoreCase("testclasses")) {
			readFiles(fileEntry, nameFilter,
				pac.concat(fileEntry.getName()));
		    }
		} else {
		    if (pac.equalsIgnoreCase("callgraphstat.testclasses."))
			if (fileEntry.getName().endsWith(".class")) {
			    try {
				URL url = file.toURI().toURL();
				URL[] urls = new URL[] { url };
				String cls = pac.concat(fileEntry.getName()
					.replaceAll(".class", ""));
				@SuppressWarnings("resource")
				Class<?> clas = new URLClassLoader(urls)
					.loadClass(cls);
				// System.out.println("\t" + clas.getName());
				classDescriptions.add(new Description(clas,
					classDescriptions));
				if (cls.equalsIgnoreCase(nameFilter)) {
				    // testClasses.add(clas);
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
