/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKEVIRTUALProperties.java
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
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.MethodGen;

import tools.code.gen.MainClass;

public class INVOKEVIRTUALProperties extends INVOKEProperties {
    private INVOKEVIRTUAL invokevirtual = null;

    public INVOKEVIRTUALProperties(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKEVIRTUAL invokevirtual) {
	super(javaClass, methodGen, invokevirtual.getReferenceType(
		constantPoolGen).toString(), new INVOKEMehtodProperties(
		invokevirtual.getName(constantPoolGen),
		invokevirtual.getArgumentTypes(constantPoolGen)));
	this.invokevirtual = invokevirtual;
	Description description = MainClass
		.getDescriptionByActualClassName(this.invokevirtual
			.getReferenceType(constantPoolGen).toString());
	if (description != null) {
	    addDescription(description);
	}
    }

    public INVOKEVIRTUAL getInvokevirtual() {
	return this.invokevirtual;
    }
}
