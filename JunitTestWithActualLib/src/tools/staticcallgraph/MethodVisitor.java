/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraph
 *
 * @FileName MethodVisitor.java
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

import java.util.List;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.ConstantPushInstruction;
import org.apache.bcel.generic.EmptyVisitor;
import org.apache.bcel.generic.INVOKEINTERFACE;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ReturnInstruction;
import org.apache.bcel.generic.Type;

import tools.code.gen.MainClass;

public class MethodVisitor extends EmptyVisitor {
    private OPCodeDescription opCodeDescription = null;
    private Description entryDescription = null;
    private List<Description> classDescriptions = null;
    private Class<?> clss = null;
    private JavaClass visitedClass = null;
    private MethodGen methodGen = null;
    private ConstantPoolGen constantPoolGen = null;
    private String format = null;
    private boolean isGeneratedCode = false;

    public MethodVisitor(OPCodeDescription opCodeDescription,
	    Description description, Class<?> clss, JavaClass jc,
	    MethodGen methodGen) {
	this.opCodeDescription = opCodeDescription;
	this.entryDescription = description;
	this.clss = clss;
	this.visitedClass = jc;
	this.methodGen = methodGen;
	this.constantPoolGen = methodGen.getConstantPool();
	this.isGeneratedCode = false;
	this.format = "M:" + this.visitedClass.getClassName() + ":"
		+ this.methodGen.getName() + " " + "(%s)%s:%s";
    }

    public MethodVisitor(Class<?> clss, JavaClass jc, Description description,
	    List<Description> classDescriptions, MethodGen methodGen) {
	this.classDescriptions = classDescriptions;
	this.entryDescription = description;
	this.clss = clss;
	this.visitedClass = jc;
	this.methodGen = methodGen;
	this.constantPoolGen = methodGen.getConstantPool();
	this.isGeneratedCode = true;
	this.format = "M:" + this.visitedClass.getClassName() + ":"
		+ this.methodGen.getName() + " " + "(%s)%s:%s";
    }

    public void start() {
	if (this.methodGen.isAbstract() || this.methodGen.isNative()) {
	    return;
	}
	for (InstructionHandle ih = this.methodGen.getInstructionList()
		.getStart(); ih != null; ih = ih.getNext()) {
	    Instruction i = ih.getInstruction();

	    if (!visitInstruction(i)) {
		i.accept(this);
	    }
	}
    }

    private boolean visitInstruction(Instruction i) {
	short opcode = i.getOpcode();

	return ((InstructionConstants.INSTRUCTIONS[opcode] != null)
		&& !(i instanceof ConstantPushInstruction) && !(i instanceof ReturnInstruction));
    }

    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL invokevirtual) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokevirtual.getReferenceType(
		this.constantPoolGen).toString();
	String methodName = invokevirtual.getMethodName(this.constantPoolGen)
		.toString();
	Type[] types = invokevirtual.getArgumentTypes(constantPoolGen);
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	INVOKEMehtodProperties methodCall = null;
	if (description != null) {
	    if (this.isGeneratedCode) {
		System.out.println(String.format(this.format, "M",
			invokevirtual.getReferenceType(this.constantPoolGen),
			invokevirtual.getMethodName(this.constantPoolGen)));
		methodCall = new INVOKEMehtodProperties(description,
			methodName, types);
		write(this.entryDescription, description, methodCall,
			INVOKEType.VIRTUAL);
	    } else {
		if (methodGenName.charAt(0) == '<') {
		    this.opCodeDescription.getOneTimeUseOnly().addtMethodCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokevirtual);
		    System.out.println(String.format(this.format, "M",
			    invokevirtual
				    .getReferenceType(this.constantPoolGen),
			    invokevirtual.getMethodName(this.constantPoolGen)));
		} else {
		    this.opCodeDescription.getOtherMethodByNameAndType(
			    this.methodGen.getName(),
			    this.methodGen.getArgumentTypes()).addtMethodCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokevirtual);
		    System.out.println(String.format(this.format, "M",
			    invokevirtual
				    .getReferenceType(this.constantPoolGen),
			    invokevirtual.getMethodName(this.constantPoolGen)));
		}
	    }
	}
    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE invokeinterface) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokeinterface.getReferenceType(
		this.constantPoolGen).toString();
	String methodName = invokeinterface.getMethodName(this.constantPoolGen)
		.toString();
	Type[] types = invokeinterface.getArgumentTypes(constantPoolGen);
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	INVOKEMehtodProperties methodCall = null;
	if (description != null) {
	    if (this.isGeneratedCode) {
		System.out.println(String.format(this.format, "I",
			invokeinterface.getReferenceType(this.constantPoolGen),
			invokeinterface.getMethodName(this.constantPoolGen)));
		methodCall = new INVOKEMehtodProperties(description,
			methodName, types);
		write(this.entryDescription, description, methodCall,
			INVOKEType.INTERFACE);
	    } else {
		if (methodGenName.charAt(0) == '<') {
		    this.opCodeDescription.getOneTimeUseOnly()
			    .addInterfaceCall(this.entryDescription,
				    description, this.visitedClass,
				    this.methodGen, this.constantPoolGen,
				    invokeinterface);
		    System.out
			    .println(String.format(
				    this.format,
				    "I",
				    invokeinterface
					    .getReferenceType(this.constantPoolGen),
				    invokeinterface
					    .getMethodName(this.constantPoolGen)));
		} else {
		    this.opCodeDescription.getOtherMethodByNameAndType(
			    this.methodGen.getName(),
			    this.methodGen.getArgumentTypes())
			    .addInterfaceCall(this.entryDescription,
				    description, this.visitedClass,
				    this.methodGen, this.constantPoolGen,
				    invokeinterface);
		    System.out
			    .println(String.format(
				    this.format,
				    "I",
				    invokeinterface
					    .getReferenceType(this.constantPoolGen),
				    invokeinterface
					    .getMethodName(this.constantPoolGen)));
		}
	    }
	}
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL invokespecial) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokespecial.getReferenceType(
		this.constantPoolGen).toString();
	String methodName = invokespecial.getMethodName(this.constantPoolGen)
		.toString();
	Type[] types = invokespecial.getArgumentTypes(constantPoolGen);
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	INVOKEMehtodProperties methodCall = null;
	if (description != null) {
	    if (this.isGeneratedCode) {
		System.out.println(String.format(this.format, "O",
			invokespecial.getReferenceType(this.constantPoolGen),
			invokespecial.getMethodName(this.constantPoolGen)));
		methodCall = new INVOKEMehtodProperties(description,
			methodName, types);
		write(this.entryDescription, description, methodCall,
			INVOKEType.SPECIAL);
	    } else {
		if (methodGenName.charAt(0) == '<') {
		    this.opCodeDescription.getOneTimeUseOnly().addObjectCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokespecial);
		    System.out.println(String.format(this.format, "O",
			    invokespecial
				    .getReferenceType(this.constantPoolGen),
			    invokespecial.getMethodName(this.constantPoolGen)));
		} else {
		    this.opCodeDescription.getOtherMethodByNameAndType(
			    this.methodGen.getName(),
			    this.methodGen.getArgumentTypes()).addObjectCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokespecial);
		    System.out.println(String.format(this.format, "O",
			    invokespecial
				    .getReferenceType(this.constantPoolGen),
			    invokespecial.getMethodName(this.constantPoolGen)));
		}
	    }
	}
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC invokestatic) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokestatic.getReferenceType(
		this.constantPoolGen).toString();
	String methodName = invokestatic.getMethodName(this.constantPoolGen)
		.toString();
	Type[] types = invokestatic.getArgumentTypes(constantPoolGen);
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	INVOKEMehtodProperties methodCall = null;
	if (description != null) {
	    if (this.isGeneratedCode) {
		System.out.println(String.format(this.format, "S",
			invokestatic.getReferenceType(this.constantPoolGen),
			invokestatic.getMethodName(this.constantPoolGen)));
		methodCall = new INVOKEMehtodProperties(description,
			methodName, types);
		write(this.entryDescription, description, methodCall,
			INVOKEType.STATIC);
	    } else {
		if (methodGenName.charAt(0) == '<') {
		    this.opCodeDescription.getOneTimeUseOnly().addStaticCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokestatic);
		    System.out
			    .println(String.format(
				    this.format,
				    "S",
				    invokestatic
					    .getReferenceType(this.constantPoolGen),
				    invokestatic
					    .getMethodName(this.constantPoolGen)));
		} else {
		    this.opCodeDescription.getOtherMethodByNameAndType(
			    this.methodGen.getName(),
			    this.methodGen.getArgumentTypes()).addStaticCall(
			    this.entryDescription, description,
			    this.visitedClass, this.methodGen,
			    this.constantPoolGen, invokestatic);
		    System.out
			    .println(String.format(
				    this.format,
				    "S",
				    invokestatic
					    .getReferenceType(this.constantPoolGen),
				    invokestatic
					    .getMethodName(this.constantPoolGen)));
		}
	    }
	}
    }

    // pass src, det, method, invoke type, look into once or method depending on
    // method
    private void write(Description who, Description whom,
	    INVOKEMehtodProperties method, INVOKEType type) {
	String methodName = method.getMethodName();
	Type[] methoTypes = method.getTypes();
	Description methodsDescription = method.getDescription();
	System.out.println("\t" + who + "\n\t\t" + whom + "\n\t\t\t"
		+ methodName);
	OPCodeProperties list = null;

	if (type == INVOKEType.SPECIAL) {
	    System.out.println("!SPECIAL!");
	    if (method.getMethodName().charAt(0) == '<') {
		whom.addClassToCalledByTestClasses(who.getActualClass());
		list = whom.getOPCodeDescription().getOneTimeUseOnly();
	    } else {
		write(whom, methodsDescription, method, INVOKEType.VIRTUAL);
	    }
	} else if (type == INVOKEType.VIRTUAL) {
	    System.out.println("!VIRTUAL!");
	    list = whom.getOPCodeDescription().getOtherMethodByNameAndType(
		    methodName, methoTypes);
	} else if (type == INVOKEType.STATIC) {
	    System.out.println("!STATIC!");
	    list = whom.getOPCodeDescription().getOtherMethodByNameAndType(
		    methodName, methoTypes);
	} else if (type == INVOKEType.INTERFACE) {
	    System.out.println("!INTERFACE!");
	    list = whom.getOPCodeDescription().getOtherMethodByNameAndType(
		    methodName, methoTypes);
	}

	System.out.println("--------------" + list + "--------------");

	// must check iterations
	if (list != null) {
	    for (INVOKEProperties object : list.getObjectCall()) {
		write(object.getMethodCallingFrom().getDescription(), object
			.getMethodCallTo().getDescription(),
			object.getMethodCallTo(), INVOKEType.SPECIAL);
	    }

	    for (INVOKEProperties object : list.getMethodCall()) {
		write(object.getMethodCallingFrom().getDescription(), object
			.getMethodCallTo().getDescription(),
			object.getMethodCallTo(), INVOKEType.VIRTUAL);
	    }

	    for (INVOKEProperties object : list.getStaticCall()) {
		write(object.getMethodCallingFrom().getDescription(), object
			.getMethodCallTo().getDescription(),
			object.getMethodCallTo(), INVOKEType.STATIC);
	    }

	    for (INVOKEProperties object : list.getInterfaceCall()) {
		write(object.getMethodCallingFrom().getDescription(), object
			.getMethodCallTo().getDescription(),
			object.getMethodCallTo(), INVOKEType.INTERFACE);
	    }
	}

	System.out.println("DONE!");
    }

    public enum INVOKEType {
	VIRTUAL("Method"), STATIC("Static"), INTERFACE("Interface"), SPECIAL(
		"Object");
	private String category;

	private INVOKEType(String category) {
	    this.category = category;
	}

	public String toString() {
	    return this.category;
	}
    }

}
