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

import org.apache.bcel.classfile.JavaClass;

public class JCallGraph {
    public static void lookInsideClass(JavaClass javaClass,
	    Description entryDescription, boolean isGeneratedCode) {
	ClassVisitor visitor = new ClassVisitor(javaClass, entryDescription,
		true);
	visitor.start();
    }

    public static void lookInsideClass(OPCodeDescription opCodeDescription,
	    Description entryDescription, JavaClass javaClass) {
	ClassVisitor visitor = new ClassVisitor(opCodeDescription,
		entryDescription, javaClass);
	visitor.start();
    }
}
