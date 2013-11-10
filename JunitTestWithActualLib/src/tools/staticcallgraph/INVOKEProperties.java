/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKEProperties.java
 * 
 * @FileCreated Nov 5, 2013
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
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.Type;

import tools.staticcallgraph.MethodVisitor.INVOKEType;

public abstract class INVOKEProperties {
    private Description description = null;
    private JavaClass javaClass = null;
    private MethodGen methodGen = null;
    // means method that is currently using
    private INVOKEMehtodProperties methodCallTo = null;
    // means method that is called by methodCall
    private INVOKEMehtodProperties methodCallingFrom = null;
    // means the class name that is called
    private String classCalling = null;
    protected INVOKEType type = null;

    public INVOKEProperties(JavaClass javaClass, MethodGen methodGen,
	    String classCalling) {
	this.javaClass = javaClass;
	this.methodGen = methodGen;
	this.classCalling = classCalling;
    }

    protected void addMethodCalling(Description description, String name,
	    Type[] types) {
	// this.methodCallingFrom = new INVOKEMehtodProperties(description,
	// name,
	// types);
	this.methodCallTo = new INVOKEMehtodProperties(description, name, types);
    }

    protected void addMethodCall(Description description) {
	// this.methodCallTo = new INVOKEMehtodProperties(description,
	// this.methodGen.getName(), this.methodGen.getArgumentTypes());
	this.methodCallingFrom = new INVOKEMehtodProperties(description,
		this.methodGen.getName(), this.methodGen.getArgumentTypes());
    }

    public abstract INVOKEType getType();

    // this is to get description of the class quickly, it the call object not
    // calling from
    protected void addDescription(Description description) {
	this.description = description;
    }

    public Description getDescription() {
	return this.description;
    }

    public String getClassNameCallFrom() {
	return this.javaClass.getClassName();
    }

    // call to
    public INVOKEMehtodProperties getMethodCallingFrom() {
	return this.methodCallTo;
    }

    public String getClassNameCalling() {
	return this.classCalling;
    }

    // call from
    public INVOKEMehtodProperties getMethodCallTo() {
	return this.methodCallingFrom;
    }
}