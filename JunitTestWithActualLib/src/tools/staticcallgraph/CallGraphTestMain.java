/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName CallGraphTestMain.java
 * 
 * @FileCreated Nov 25, 2013
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
package tools.staticcallgraph;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.staticcallgraph.Description.ClassCategory;

public class CallGraphTestMain {
    private static Set<Class<?>> allClasses = new HashSet<Class<?>>();
    private static File file = null;
    private static List<Description> classDescriptions = new ArrayList<Description>();
    private static List<Description> testDescriptionList;

    /**
     * @param CallGraphTestMain
     */
    public static void main(String[] args) {
	file = new File("C:\\temp\\o");
	System.out.println("Reading class files\n");
	readFiles(file, "", "");
	for (Class<?> cls : allClasses) {
	    try {
		classDescriptions.add(new Description(cls,
			ClassCategory.REGULAR, classDescriptions));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	System.out.println("\nReading bytecode of class\n");
	readOpCodeOfClasses();
	System.out.println("\n\nDONE!");
    }

    private static void readOpCodeOfClasses() {
	// test classes from OPCode
	for (Description description : classDescriptions) {
	    System.out.print("\t" + description.getActualClass().getName()
		    + ": ");
	    // for each test class
	    OPCodeDescription opCodeDescription = new OPCodeDescription(
		    description);
	    new JCallGraph(classDescriptions, testDescriptionList)
		    .lookInsideClass(opCodeDescription, description,
			    description.getJavaClass());
	    description.addOPCodeDescription(opCodeDescription);
	    System.out.print("DONE!\n");
	}
    }

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
