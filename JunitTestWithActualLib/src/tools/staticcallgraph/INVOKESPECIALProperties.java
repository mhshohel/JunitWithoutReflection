/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKESPECIALProperties.java
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
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.MethodGen;

public class INVOKESPECIALProperties extends INVOKEProperties {
    private INVOKESPECIAL invokespecial = null;

    public INVOKESPECIALProperties(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKESPECIAL invokespecial) {
	super(javaClass, methodGen, invokespecial.getReferenceType(
		constantPoolGen).toString(), new INVOKEMehtodProperties(
		invokespecial.getName(constantPoolGen),
		invokespecial.getArgumentTypes(constantPoolGen)));
	this.invokespecial = invokespecial;
    }

}