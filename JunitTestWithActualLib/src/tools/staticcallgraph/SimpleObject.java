/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName SimpleObject.java
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
package tools.staticcallgraph;

import java.util.ArrayList;
import java.util.List;

public class SimpleObject {
    private List<Class<?>> classes = new ArrayList<Class<?>>();

    public void addClassForMethod(Class<?> clss) {
	// if (!this.classes.contains(clss)) {
	this.classes.add(clss);
	// }
    }

    public List<Class<?>> getClasses() {
	return this.classes;
    }
}
