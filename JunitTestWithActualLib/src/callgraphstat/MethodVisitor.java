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
 * Linnaeus University, V�xj�, Sweden
 *
 */
package callgraphstat;

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

public class MethodVisitor extends EmptyVisitor {
    JavaClass visitedClass;
    private MethodGen mg;
    private ConstantPoolGen cp;
    private String format;

    public MethodVisitor(MethodGen m, JavaClass jc) {
	visitedClass = jc;
	mg = m;
	cp = mg.getConstantPool();
	format = "M:" + visitedClass.getClassName() + ":" + mg.getName() + " "
		+ "(%s)%s:%s";
    }

    public void start() {
	if (mg.isAbstract() || mg.isNative())
	    return;
	for (InstructionHandle ih = mg.getInstructionList().getStart(); ih != null; ih = ih
		.getNext()) {
	    Instruction i = ih.getInstruction();

	    if (!visitInstruction(i))
		i.accept(this);
	}
    }

    private boolean visitInstruction(Instruction i) {
	short opcode = i.getOpcode();

	return ((InstructionConstants.INSTRUCTIONS[opcode] != null)
		&& !(i instanceof ConstantPushInstruction) && !(i instanceof ReturnInstruction));
    }

    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL i) {
	System.out.println(String.format(format, "M", i.getReferenceType(cp),
		i.getMethodName(cp)));

	// String s = i.getName(cp);
	// Type[] ss = i.getArgumentTypes(cp);
	// for (Type t : ss) {
	// System.out.println("\t\tTYPES: " + t);
	// }
    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE i) {
	System.out.println(String.format(format, "I", i.getReferenceType(cp),
		i.getMethodName(cp)));
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL i) {
	System.out.println(String.format(format, "O", i.getReferenceType(cp),
		i.getMethodName(cp)));
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC i) {
	System.out.println(String.format(format, "S", i.getReferenceType(cp),
		i.getMethodName(cp)));
    }
}
