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
package tools.staticcallgraph;

import java.util.List;

import org.apache.bcel.classfile.JavaClass;

public class JCallGraph {
    public static void lookInsideClass(Class<?> clss, JavaClass javaClass,
	    Description entryDescription, List<Description> classDescriptions,
	    boolean isGeneratedCode) {
	ClassVisitor visitor = new ClassVisitor(clss, javaClass,
		entryDescription, classDescriptions, true);
	visitor.start();
    }

    public static void lookInsideClass(OPCodeDescription opCodeDescription,
	    Description description, Class<?> clss, JavaClass javaClass) {
	ClassVisitor visitor = new ClassVisitor(opCodeDescription, description,
		clss, javaClass);
	visitor.start();
    }
}
