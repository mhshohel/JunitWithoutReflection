/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKESTATICProperties.java
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
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.MethodGen;

import tools.code.gen.MainClass;

public class INVOKESTATICProperties extends INVOKEProperties {
    private INVOKESTATIC invokestatic = null;

    public INVOKESTATICProperties(JavaClass javaClass, MethodGen methodGen,
	    ConstantPoolGen constantPoolGen, INVOKESTATIC invokestatic) {
	super(javaClass, methodGen, invokestatic.getReferenceType(
		constantPoolGen).toString(), new INVOKEMehtodProperties(
		invokestatic.getName(constantPoolGen),
		invokestatic.getArgumentTypes(constantPoolGen)));
	this.invokestatic = invokestatic;
	Description description = MainClass
		.getDescriptionByActualClassName(this.invokestatic
			.getReferenceType(constantPoolGen).toString());
	if (description != null) {
	    addDescription(description);
	}
    }

    public INVOKESTATIC getInvokestatic() {
	return this.invokestatic;
    }
}