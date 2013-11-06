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

public abstract class INVOKEProperties {
    private JavaClass javaClass = null;
    private MethodGen methodGen = null;
    // means method that is currently using
    private INVOKEMehtodProperties methodCall = null;
    // means method that is called by methodCall
    private INVOKEMehtodProperties methodCalling = null;
    // means the class name that is called
    private String classCalling = null;

    public INVOKEProperties(JavaClass javaClass, MethodGen methodGen,
	    String classCalling, INVOKEMehtodProperties methodCalling) {
	this.javaClass = javaClass;
	this.methodGen = methodGen;
	this.classCalling = classCalling;
	this.methodCall = new INVOKEMehtodProperties(this.methodGen.getName(),
		this.methodGen.getArgumentTypes());
	this.methodCalling = methodCalling;
    }

    public String getClassNameCallFrom() {
	return this.javaClass.getClassName();
    }

    public INVOKEMehtodProperties getMethodCall() {
	return this.methodCall;
    }

    public String getClassNameCalling() {
	return this.classCalling;
    }

    public INVOKEMehtodProperties getMethodCalling() {
	return this.methodCalling;
    }
}