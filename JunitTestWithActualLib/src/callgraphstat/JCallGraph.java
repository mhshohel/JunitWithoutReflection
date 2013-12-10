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
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JCallGraph {

    public static void main(String[] args) {
	try {
	    File file = new File(
		    "G:\\lnu\\5DV001 - Thesis Project\\Thesis - Jonas\\ThesisBackup\\JunitWithoutReflection.git.first\\JunitTestWithActualLib\\bin\\callgraphstat");
	    JCallGraph jCallGraph = new JCallGraph(file, "callgraphstat");
	    Description des = jCallGraph.getClassDescriptions().get(
		    "callgraphstat.testclasses.JonasTestMain");
	    // System.out.println(des.printNode());
	    // make single call means check edges first
	    if (des != null) {
		des.getClassVisitor().start();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private Map<String, Description> classDescriptions = new HashMap<String, Description>();
    private File file = null;

    public JCallGraph(File file, String pack) throws Exception {
	this.file = file;
	readFiles(this.file, pack);
	initializeInterfacesAndSuperClasses();
    }

    public Map<String, Description> getClassDescriptions() {
	return this.classDescriptions;
    }

    private void initializeInterfacesAndSuperClasses() throws Exception {
	for (Entry<String, Description> description : this.classDescriptions
		.entrySet()) {
	    description.getValue().initializeInterfacesAndSuperClasses();
	}
    }

    private void readFiles(final File folder, final String pack)
	    throws Exception {
	String pac = (pack.trim().equalsIgnoreCase("") ? "" : pack.concat("."));
	for (final File fileEntry : folder.listFiles()) {
	    if (fileEntry.isDirectory()) {
		if (fileEntry.getName().equalsIgnoreCase("testclasses")) {
		    readFiles(fileEntry, pac.concat(fileEntry.getName()));
		}
	    } else {
		if (pac.equalsIgnoreCase("callgraphstat.testclasses."))
		    if (fileEntry.getName().endsWith(".class")) {
			URL url = this.file.toURI().toURL();
			URL[] urls = new URL[] { url };
			String cls = pac.concat(fileEntry.getName().replaceAll(
				".class", ""));
			@SuppressWarnings("resource")
			Class<?> clas = new URLClassLoader(urls).loadClass(cls);
			this.classDescriptions.put(clas.getName(),
				new Description(clas, this.classDescriptions));
		    }
	    }
	}
    }
}
