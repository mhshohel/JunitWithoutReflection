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
    private List<INVOKEVIRTUALProperties> methodCall = new ArrayList<INVOKEVIRTUALProperties>();
    private List<INVOKEINTERFACEProperties> interfaceCall = new ArrayList<INVOKEINTERFACEProperties>();
    private List<INVOKESPECIALProperties> objectCall = new ArrayList<INVOKESPECIALProperties>();
    private List<INVOKESTATICProperties> staticCall = new ArrayList<INVOKESTATICProperties>();
    // keep method name with parameters type, this method is the method which is
    // inside the class
    // ex: TestClass.method(); here method()
    private INVOKEMehtodProperties method = null;

    public void addMethod(String name, Type[] types) {
	this.method = new INVOKEMehtodProperties(name, types);
    }

    public INVOKEMehtodProperties getMethod() {
	return this.method;
    }

    /**
     * @return the methodCall
     */
    public List<INVOKEVIRTUALProperties> getMethodCall() {
	return this.methodCall;
    }

    /**
     * @param methodCall
     *            the methodCall to set
     */
    public void addtMethodCall(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKEVIRTUAL methodCall) {
	this.methodCall.add(new INVOKEVIRTUALProperties(javaClass, methodGen,
		constantPoolGen, methodCall));
    }

    /**
     * @return the interfaceCall
     */
    public List<INVOKEINTERFACEProperties> getInterfaceCall() {
	return this.interfaceCall;
    }

    /**
     * @param interfaceCall
     *            the interfaceCall to set
     */
    public void addInterfaceCall(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKEINTERFACE interfaceCall) {
	this.interfaceCall.add(new INVOKEINTERFACEProperties(javaClass,
		methodGen, constantPoolGen, interfaceCall));
    }

    /**
     * @return the objectCall
     */
    public List<INVOKESPECIALProperties> getObjectCall() {
	return this.objectCall;
    }

    /**
     * @param objectCall
     *            the objectCall to set
     */
    public void addObjectCall(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKESPECIAL objectCall) {
	this.objectCall.add(new INVOKESPECIALProperties(javaClass, methodGen,
		constantPoolGen, objectCall));
    }

    /**
     * @return the staticCall
     */
    public List<INVOKESTATICProperties> getStaticCall() {
	return this.staticCall;
    }

    /**
     * @param staticCall
     *            the staticCall to set
     */
    public void addStaticCall(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKESTATIC staticCall) {
	this.staticCall.add(new INVOKESTATICProperties(javaClass, methodGen,
		constantPoolGen, staticCall));
    }

}
