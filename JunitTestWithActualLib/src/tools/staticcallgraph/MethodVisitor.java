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

    public MethodVisitor(OPCodeDescription opCodeDescription,
	    Description description, Class<?> clss, JavaClass jc,
	    MethodGen methodGen) {
	this.opCodeDescription = opCodeDescription;
	this.entryDescription = description;
	this.clss = clss;
	this.visitedClass = jc;
	this.methodGen = methodGen;
	this.constantPoolGen = methodGen.getConstantPool();
	this.format = "M:" + this.visitedClass.getClassName() + ":"
		+ this.methodGen.getName() + " " + "(%s)%s:%s";
    }

    public MethodVisitor(Class<?> clss, JavaClass jc, Description description,
	    List<Description> classDescriptions, MethodGen methodGen) {
	this.classDescriptions = classDescriptions;
	this.clss = clss;
	this.visitedClass = jc;
	this.methodGen = methodGen;
	this.constantPoolGen = methodGen.getConstantPool();
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
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	if (description != null) {
	    System.out.println(String.format(this.format, "M",
		    invokevirtual.getReferenceType(this.constantPoolGen),
		    invokevirtual.getMethodName(this.constantPoolGen)));
	    if (methodGenName.charAt(0) == '<') {
		this.opCodeDescription.getOneTimeUseOnly().addtMethodCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokevirtual);
	    } else {
		this.opCodeDescription.getOthers().addtMethodCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokevirtual);
	    }
	}
    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE invokeinterface) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokeinterface.getReferenceType(
		this.constantPoolGen).toString();
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	if (description != null) {
	    System.out.println(String.format(this.format, "I",
		    invokeinterface.getReferenceType(this.constantPoolGen),
		    invokeinterface.getMethodName(this.constantPoolGen)));
	    if (methodGenName.charAt(0) == '<') {
		this.opCodeDescription.getOneTimeUseOnly().addInterfaceCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokeinterface);
	    } else {
		this.opCodeDescription.getOthers().addInterfaceCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokeinterface);
	    }
	}
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL invokespecial) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokespecial.getReferenceType(
		this.constantPoolGen).toString();
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	if (description != null) {
	    System.out.println(String.format(this.format, "O",
		    invokespecial.getReferenceType(this.constantPoolGen),
		    invokespecial.getMethodName(this.constantPoolGen)));
	    if (methodGenName.charAt(0) == '<') {
		this.opCodeDescription.getOneTimeUseOnly().addObjectCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokespecial);
	    } else {
		this.opCodeDescription.getOthers().addObjectCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokespecial);
	    }
	}
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC invokestatic) {
	String methodGenName = this.methodGen.getName();
	String referenceType = invokestatic.getReferenceType(
		this.constantPoolGen).toString();
	Description description = MainClass
		.getDescriptionByActualClassName(referenceType);
	if (description != null) {
	    System.out.println(String.format(this.format, "S",
		    invokestatic.getReferenceType(this.constantPoolGen),
		    invokestatic.getMethodName(this.constantPoolGen)));
	    if (methodGenName.charAt(0) == '<') {
		this.opCodeDescription.getOneTimeUseOnly().addStaticCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokestatic);
	    } else {
		this.opCodeDescription.getOthers().addStaticCall(
			this.visitedClass, this.methodGen,
			this.constantPoolGen, invokestatic);
	    }
	}
    }

    // private void visitMethod(Method method, Description entryDescription) {
    // Class<?> clss = entryDescription.getActualClass();
    // JavaClass javaClass = entryDescription.getJavaClass();
    // ConstantPoolGen constants = new ConstantPoolGen(
    // javaClass.getConstantPool());
    // MethodGen methodGen = new MethodGen(method, javaClass.getClassName(),
    // constants);
    // MethodVisitor visitor = new MethodVisitor(clss, javaClass,
    // entryDescription, this.classDescriptions, methodGen);
    // visitor.start();
    // }

    private void addInstructions() {
	// if (methodName.charAt(0) == '<') {
	//
	// }
    }
}
