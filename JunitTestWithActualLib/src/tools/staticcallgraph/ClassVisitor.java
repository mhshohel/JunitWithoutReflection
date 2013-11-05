/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.code.gen
 *
 * @FileName ClassVisitor.java
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

import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.MethodGen;

public class ClassVisitor extends EmptyVisitor {
    private OPCodeDescription opCodeDescription = null;
    private Description entryDescription = null;
    private List<Description> classDescriptions = null;
    private Class<?> clss = null;
    private JavaClass javaClass = null;
    private ConstantPoolGen constants = null;

    public ClassVisitor(OPCodeDescription opCodeDescription,
	    Description description, Class<?> clss, JavaClass jc) {
	this.opCodeDescription = opCodeDescription;
	this.entryDescription = description;
	this.clss = clss;
	this.javaClass = jc;
	this.constants = new ConstantPoolGen(this.javaClass.getConstantPool());
    }

    public ClassVisitor(Class<?> clss, JavaClass jc, Description description,
	    List<Description> classDescriptions) {
	this.entryDescription = description;
	this.classDescriptions = classDescriptions;
	this.clss = clss;
	this.javaClass = jc;
	this.constants = new ConstantPoolGen(this.javaClass.getConstantPool());
    }

    public void visitJavaClass(JavaClass jc) {
	Method[] methods = jc.getMethods();
	for (int i = 0; i < methods.length; i++) {
	    // if (name.charAt(0) != '<')
	    methods[i].accept(this);
	}
    }

    @Override
    public void visitMethod(Method method) {
	MethodGen methodGen = new MethodGen(method,
		this.javaClass.getClassName(), this.constants);
	// MethodVisitor visitor = new MethodVisitor(this.clss, this.javaClass,
	// this.entryDescription, this.classDescriptions, methodGen);
	MethodVisitor visitor = new MethodVisitor(this.opCodeDescription,
		this.entryDescription, this.clss, this.javaClass, methodGen);
	visitor.start();
    }

    public void start() {
	visitJavaClass(this.javaClass);
    }
}
