/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKEINTERFACEProperties.java
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
import org.apache.bcel.generic.INVOKEINTERFACE;
import org.apache.bcel.generic.MethodGen;

import tools.code.gen.MainClass;

public class INVOKEINTERFACEProperties extends INVOKEProperties {
    private INVOKEINTERFACE invokeinterface = null;

    public INVOKEINTERFACEProperties(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKEINTERFACE invokeinterface) {
	super(javaClass, methodGen, invokeinterface.getReferenceType(
		constantPoolGen).toString(), new INVOKEMehtodProperties(
		invokeinterface.getName(constantPoolGen),
		invokeinterface.getArgumentTypes(constantPoolGen)));
	this.invokeinterface = invokeinterface;
	Description description = MainClass
		.getDescriptionByActualClassName(this.invokeinterface
			.getReferenceType(constantPoolGen).toString());
	if (description != null) {
	    addDescription(description);
	}
    }

    public INVOKEINTERFACE getInvokeinterface() {
	return this.invokeinterface;
    }
}
