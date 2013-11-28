/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraphstat
 *
 * @FileName Description.java
 * 
 * @FileCreated Nov 28, 2013
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

import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.Type;

public class Description implements Comparable<Description> {
    public enum ClassCategory {
	GENERATED("Generated Code"), REGULAR("Regular Class"), TEST(
		"Test Class");
	private String category;

	private ClassCategory(String category) {
	    this.category = category;
	}

	public String toString() {
	    return this.category;
	}
    }

    public enum ClassType {
	INTERFACE("interface"), ABSTRACT("abstract"), FINAL("final"), ENUM(
		"enum"), CLASS("class");
	private String category;

	private ClassType(String category) {
	    this.category = category;
	}

	public String toString() {
	    return this.category;
	}
    }

    private Class<?> clas = null;
    private JavaClass javaClass = null;
    private ClassVisitor classVisitor = null;
    private List<Description> classDescriptions = null;
    private ClassCategory classCategory = null;
    private InputStream classInputStream = null;
    private ClassType classType = null;
    private Map<Method, Node> methods = new HashMap<Method, Node>();
    private List<String> nodes = new ArrayList<String>();

    public Description(Class<?> clas, ClassCategory classCategory,
	    List<Description> classDescriptions) throws Exception {
	this.classCategory = classCategory;
	initialize(clas, classDescriptions);
    }

    public Description(Class<?> clas, List<Description> classDescriptions)
	    throws Exception {
	this.classCategory = ClassCategory.REGULAR;
	initialize(clas, classDescriptions);
    }

    private void initialize(Class<?> clas, List<Description> classDescriptions)
	    throws Exception {
	this.clas = clas;
	this.classDescriptions = classDescriptions;
	try {
	    String resourceName = clas.getName().replace('.', '/') + ".class";
	    InputStream classInputStream = clas.getClassLoader()
		    .getResourceAsStream(resourceName);
	    this.javaClass = new ClassParser(classInputStream, resourceName)
		    .parse();
	    this.classVisitor = new ClassVisitor(javaClass);
	} catch (Exception e) {
	    throw new Exception("Cannot parse Class to JavaClass.");
	}
	int modifier = this.clas.getModifiers();
	if (this.clas.isInterface()) {
	    this.classType = ClassType.INTERFACE;
	} else if (Modifier.isAbstract(modifier)) {
	    this.classType = ClassType.ABSTRACT;
	} else if (Modifier.isFinal(modifier)) {
	    this.classType = ClassType.FINAL;
	} else if (this.clas.isEnum()) {
	    this.classType = ClassType.ENUM;
	} else {
	    this.classType = ClassType.CLASS;
	}
	// Inner Class as Application
	for (Class<?> cls : this.clas.getDeclaredClasses()) {
	    this.classDescriptions.add(new Description(cls,
		    ClassCategory.REGULAR, this.classDescriptions));
	}
	if (!this.clas.isInterface()) {
	    // Methods as Node
	    Node node = null;
	    for (Method method : this.javaClass.getMethods()) {
		node = new Node(method, this.javaClass.getClassName());
		this.methods.put(method, node);
		this.nodes.add(node.toString());
	    }
	}
	Collections.sort(this.nodes);
    }

    public List<String> getNode() {
	return this.nodes;
    }

    public String printNode() {
	StringBuilder sb = new StringBuilder();
	for (String node : this.nodes) {
	    sb.append(node).append("\n");
	}
	return sb.toString();
    }

    @Override
    public int compareTo(Description description) {
	return this.getActualClass().getName()
		.compareTo(description.getActualClass().getName());
    }

    public ClassVisitor getClassVisitor() {
	return this.classVisitor;
    }

    public Class<?> getActualClass() {
	return this.clas;
    }

    public void setClassCategory(ClassCategory classCategory) {
	this.classCategory = classCategory;
    }

    public ClassCategory getClassCategory() {
	return this.classCategory;
    }

    public InputStream getClassInputStream() {
	return classInputStream;
    }

    public String getClassName() {
	return clas.getName();
    }

    public ClassType getClassType() {
	return this.classType;
    }

    public JavaClass getJavaClass() {
	return javaClass;
    }

    public Method getMethodByNameAndTypeArgs(String methodName,
	    Type[] methodTypeArgs) {
	String name = null;
	Type[] types = null;
	Method method = null;
	for (Entry<Method, Node> entry : this.methods.entrySet()) {
	    if (methodName != null) {
		method = entry.getKey();
		name = method.getName();
		types = method.getArgumentTypes();
		if (methodName.equalsIgnoreCase(name)) {
		    if (Arrays.deepEquals(methodTypeArgs, types)) {
			return method;
		    }
		}
	    } else {
		return null;
	    }
	}
	return null;
    }

    public String getMethodFullName(Method method) {
	return method.toString().substring(0,
		(method.toString().indexOf(')') + 1));
    }

    public String getMethodName(Method method) {
	return method.getName();
    }

    public Map<Method, Node> getMethods() {
	return this.methods;
    }

    public Node getSimpleObjectByNameAndTypeArgs(String methodName,
	    Type[] methodTypeArgs) {
	String name = null;
	Type[] types = null;
	Method method = null;
	for (Entry<Method, Node> entry : this.methods.entrySet()) {
	    if (methodName != null) {
		method = entry.getKey();
		name = method.getName();
		types = method.getArgumentTypes();
		if (methodName.equalsIgnoreCase(name)) {
		    if (Arrays.deepEquals(methodTypeArgs, types)) {
			return entry.getValue();
		    }
		}
	    } else {
		return null;
	    }
	}

	return null;
    }

    public Node getNodeByMethod(Method method) {
	return this.methods.get(method);
    }

    public boolean isGeneratedCode() {
	return (this.classCategory == ClassCategory.GENERATED);
    }

    public boolean isRegularClass() {
	return (this.classCategory == ClassCategory.REGULAR);
    }

    public boolean isTestClass() {
	return (this.classCategory == ClassCategory.TEST);
    }

    public String toString() {
	return this.getActualClass().getName();
    }
}
