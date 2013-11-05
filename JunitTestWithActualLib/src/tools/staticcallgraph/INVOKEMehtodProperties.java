/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName INVOKEMehtodProperties.java
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

import org.apache.bcel.generic.Type;

public class INVOKEMehtodProperties {
    private String methodName = null;
    private Type[] types = null;

    public INVOKEMehtodProperties(String methodName, Type[] types) {
	this.methodName = methodName;
	this.types = types;
    }

    public String getMethodName() {
	return this.methodName;
    }

    public Type[] getTypes() {
	return this.types;
    }
}
