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

import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.MethodGen;

public class ClassVisitor extends EmptyVisitor {
    private ConstantPoolGen constants = null;
    private Description entryDescription = null;
    private boolean isGeneratedCode = false;
    private JavaClass javaClass = null;
    private OPCodeDescription opCodeDescription = null;

    public ClassVisitor(JavaClass jc, Description description,
	    boolean isGeneratedCode) {
	initialize(jc, description);
	this.constants = new ConstantPoolGen(this.javaClass.getConstantPool());
	this.isGeneratedCode = isGeneratedCode;
    }

    public ClassVisitor(OPCodeDescription opCodeDescription,
	    Description description, JavaClass jc) {
	initialize(jc, description);
	this.opCodeDescription = opCodeDescription;
	this.constants = new ConstantPoolGen(this.javaClass.getConstantPool());
    }

    private void initialize(JavaClass jc, Description description) {
	this.entryDescription = description;
	this.javaClass = jc;
    }

    public void start() {
	visitJavaClass(this.javaClass);
    }

    public void visitJavaClass(JavaClass jc) {
	Method[] methods = jc.getMethods();
	for (int i = 0; i < methods.length; i++) {
	    methods[i].accept(this);
	}
    }

    @Override
    public void visitMethod(Method method) {
	MethodGen methodGen = new MethodGen(method,
		this.javaClass.getClassName(), this.constants);
	MethodVisitor visitor = null;
	if (this.isGeneratedCode) {
	    visitor = new MethodVisitor(this.javaClass, this.entryDescription,
		    methodGen);
	} else {
	    visitor = new MethodVisitor(this.opCodeDescription,
		    this.entryDescription, this.javaClass, methodGen);
	}
	visitor.start();
    }
}
