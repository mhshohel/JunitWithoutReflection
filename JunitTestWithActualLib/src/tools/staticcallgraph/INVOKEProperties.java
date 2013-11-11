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
    // means the class name that is called
    private String classCalling = null;
    private Description description = null;
    private JavaClass javaClass = null;
    // means method that is called by methodCall
    private INVOKEMehtodProperties methodCallingFrom = null;
    // means method that is currently using
    private INVOKEMehtodProperties methodCallTo = null;
    private MethodGen methodGen = null;
    protected INVOKEType type = null;

    public INVOKEProperties(JavaClass javaClass, MethodGen methodGen,
	    String classCalling) {
	this.javaClass = javaClass;
	this.methodGen = methodGen;
	this.classCalling = classCalling;
    }

    // this is to get description of the class quickly, it the call object not
    // calling from
    protected void addDescription(Description description) {
	this.description = description;
    }

    protected void addMethodCall(Description description, String name,
	    Type[] types) {
	this.methodCallTo = new INVOKEMehtodProperties(description, name, types);
    }

    protected void addMethodCalling(Description description) {
	this.methodCallingFrom = new INVOKEMehtodProperties(description,
		this.methodGen.getName(), this.methodGen.getArgumentTypes());
	String n = this.methodGen.getName();
    }

    public String getClassNameCallFrom() {
	return this.javaClass.getClassName();
    }

    public String getClassNameCalling() {
	return this.classCalling;
    }

    public Description getDescription() {
	return this.description;
    }

    // call to
    public INVOKEMehtodProperties getMethodCallingFrom() {
	return this.methodCallingFrom;
    }

    // call from
    public INVOKEMehtodProperties getMethodCallTo() {
	return this.methodCallTo;
    }

    public abstract INVOKEType getType();
}