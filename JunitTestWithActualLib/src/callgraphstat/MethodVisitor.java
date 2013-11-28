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
import org.apache.bcel.generic.LineNumberGen;
import org.apache.bcel.generic.LocalVariableGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.NEW;
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

    @Override
    public void visitNEW(NEW obj) {
	// System.out.println(obj + "   --->   "
	// + obj.getLoadClassType(cp).getClassName());
    }

    public void start() {
	// InstructionHandle li;
	// InstructionHandle lj;
	// String a = "";
	// String b = "";
	// LocalVariableGen[] lv = mg.getLocalVariables();
	// if (lv.length > 2) {
	// li = lv[2].getStart();
	// lj = lv[2].getEnd();
	// a = li.getInstruction().toString(cp.getConstantPool());
	// b = lj.getInstruction().toString(cp.getConstantPool());
	// }

	if (mg.isAbstract() || mg.isNative())
	    return;
	for (InstructionHandle ih = mg.getInstructionList().getStart(); ih != null; ih = ih
		.getNext()) {
	    Instruction i = ih.getInstruction();

	    // if (i instanceof BranchInstruction) {
	    // if (i instanceof Select) { // Special cases LOOKUPSWITCH and
	    // // TABLESWITCH
	    // Select s = (Select) i;
	    // int[] matchs = s.getMatchs();
	    // InstructionHandle[] targets = s.getTargets();
	    //
	    // if (s instanceof TABLESWITCH) {
	    // System.out.println("\ttableswitch " + matchs[0] + " "
	    // + matchs[matchs.length - 1]);
	    //
	    // for (int j = 0; j < targets.length; j++)
	    // System.out.println("\t\t" + targets[j].toString());
	    //
	    // } else { // LOOKUPSWITCH
	    // System.out.println("\tlookupswitch ");
	    //
	    // for (int j = 0; j < targets.length; j++)
	    // System.out.println("\t\t" + matchs[j] + " : "
	    // + targets[j].toString());
	    // }
	    //
	    // System.out.println("\t\tdefault: "
	    // + s.getTarget().toString());
	    // // Applies
	    // // for
	    // // both
	    // } else {
	    // BranchInstruction bi = (BranchInstruction) i;
	    // ih = bi.getTarget();
	    // System.out.println("\t"
	    // + Constants.OPCODE_NAMES[bi.getOpcode()]);
	    // }
	    // } else {

	    System.out.println("\t" + i + "     "
		    + i.toString(cp.getConstantPool()));
	    // }
	    if (!visitInstruction(i)) {
		i.accept(this);
	    }
	    String a1 = "";

	}
    }

    void print(Object s) {
	System.out.println("\t" + s);
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
	System.out.println("------------------------");
    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE i) {
	// String s = i.getType()(cp).toString();
	LocalVariableGen[] f = mg.getLocalVariables();
	LineNumberGen[] lns = mg.getLineNumbers();
	System.out.println(String.format(format, "I", i.getReferenceType(cp),
		i.getMethodName(cp)));
	System.out.println("------------------------");
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL i) {
	System.out.println(String.format(format, "O", i.getReferenceType(cp),
		i.getMethodName(cp)));
	System.out.println("------------------------");
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC i) {
	System.out.println(String.format(format, "S", i.getReferenceType(cp),
		i.getMethodName(cp)));
	System.out.println("------------------------");
    }
}
