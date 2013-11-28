/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName Node.java
 * 
 * @FileCreated Nov 10, 2013
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

import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.Type;

public class Node implements Comparable<Node> {
    private Method method = null;
    private String node = "";

    public Node(Method method, String javaClassName) {
	this.method = method;
	Type[] types = method.getArgumentTypes();
	int length = types.length;
	String type = "(";
	for (int i = 0; i < length; i++) {
	    type += ((i + 1) == length) ? types[i] : types[i] + ",";
	}
	type += ")";
	node = javaClassName + "." + method.getName() + type
		+ method.getReturnType();
    }

    public Method getMethod() {
	return this.method;
    }

    public String toString() {
	return this.node;
    }

    @Override
    public int compareTo(Node node) {
	return getMethod().getName().compareTo(node.getMethod().getName());
    }
}
