/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName OPCodeProperties.java
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

import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKEINTERFACE;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.Type;

public class OPCodeProperties {
    private List<INVOKEProperties> interfaceCall = new ArrayList<INVOKEProperties>();
    // keep method name with parameters type, this method is the method which is
    // inside the class
    // ex: TestClass.method(); here method()
    private INVOKEMehtodProperties method = null;
    private List<INVOKEProperties> methodCall = new ArrayList<INVOKEProperties>();
    private List<INVOKEProperties> objectCall = new ArrayList<INVOKEProperties>();
    private List<INVOKEProperties> staticCall = new ArrayList<INVOKEProperties>();

    public void addInterfaceCall(Description parentDescription,
	    Description callingDescription, JavaClass javaClass,
	    MethodGen methodGen, ConstantPoolGen constantPoolGen,
	    INVOKEINTERFACE interfaceCall) {
	this.interfaceCall.add(new INVOKEINTERFACEProperties(parentDescription,
		callingDescription, javaClass, methodGen, constantPoolGen,
		interfaceCall));
    }

    public void addMethod(Description description, String name, Type[] types) {
	this.method = new INVOKEMehtodProperties(description, name, types);
    }

    public void addObjectCall(Description parentDescription,
	    Description callingDescription, JavaClass javaClass,
	    MethodGen methodGen, ConstantPoolGen constantPoolGen,
	    INVOKESPECIAL objectCall) {
	this.objectCall.add(new INVOKESPECIALProperties(parentDescription,
		callingDescription, javaClass, methodGen, constantPoolGen,
		objectCall));
    }

    public void addStaticCall(Description parentDescription,
	    Description callingDescription, JavaClass javaClass,
	    MethodGen methodGen, ConstantPoolGen constantPoolGen,
	    INVOKESTATIC staticCall) {
	this.staticCall.add(new INVOKESTATICProperties(parentDescription,
		callingDescription, javaClass, methodGen, constantPoolGen,
		staticCall));
    }

    public void addtMethodCall(Description parentDescription,
	    Description callingDescription, JavaClass javaClass,
	    MethodGen methodGen, ConstantPoolGen constantPoolGen,
	    INVOKEVIRTUAL methodCall) {
	this.methodCall.add(new INVOKEVIRTUALProperties(parentDescription,
		callingDescription, javaClass, methodGen, constantPoolGen,
		methodCall));
    }

    public List<INVOKEProperties> getInterfaceCall() {
	return this.interfaceCall;
    }

    public INVOKEMehtodProperties getMethod() {
	return this.method;
    }

    public List<INVOKEProperties> getMethodCall() {
	return this.methodCall;
    }

    public List<INVOKEProperties> getObjectCall() {
	// SPECIAL
	return this.objectCall;
    }

    public List<INVOKEProperties> getStaticCall() {
	return this.staticCall;
    }
}