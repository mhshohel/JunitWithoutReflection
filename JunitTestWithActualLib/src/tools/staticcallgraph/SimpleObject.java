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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tools.code.gen.MainClass;

public class SimpleObject {
    private Map<Class<?>, Integer> classes = new HashMap<Class<?>, Integer>();

    public void addClassForMethod(Class<?> clss) {
	Integer value = 0;
	if (this.classes.containsKey(clss)) {
	    value = this.classes.get(clss);
	}
	this.classes.put(clss, ++value);
    }

    public Set<Class<?>> getClasses() {
	return this.classes.keySet();
    }

    public int getCountedSizeOfEachMethodCall() {
	Object[] values = this.classes.values().toArray();
	int size = 0;
	for (Object value : values) {
	    size += (Integer) value;
	}
	return size;
    }

    public int getCountedSizeOfEachMethodCallByKey(Class<?> key) {
	return this.classes.get(key);
    }

    public String isTestClassByKey(Class<?> key) {
	Description description = MainClass.getDescriptionByActualClassName(key
		.getName());
	if (description != null && description.isTestClass()) {
	    return "Yes";
	}
	return "No";
    }

    public int size() {
	return this.classes.size();
    }
}
