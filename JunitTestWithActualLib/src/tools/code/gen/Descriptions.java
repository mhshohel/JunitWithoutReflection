/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.code.gen
 *
 * @FileName Descriptions.java
 * 
 * @FileCreated Oct 3, 2013
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
package tools.code.gen;


/**
 * <li><strong>Description</strong></li>
 * 
 * <pre>
 * public class Description
 * </pre>
 * <p>
 * This class contains all basic information of a class. For example, list of
 * methods, how many method does it contains, what is the type of this class,
 * what are the JUnit test classes used this class, is it interface or other
 * type of class etc. to create a report.
 * </p>
 * <br/>
 * 
 * @author Shohel Shamim
 */
public class Descriptions {
    // /* Keep Original Class */
    // private Class<?> clas = null;
    // /* Return type of class: abstract, final, enum, final, interface */
    // private String classType = "";
    // /* Keep class package name */
    // private String packageName = "";
    // /*
    // * classCategory: isIt a JUnit Test Class? Generated Code for a Test
    // Class?
    // * or Regular Class?
    // */
    // private ClassCategory classCategory = null;
    // /*
    // * Keep list of inner classes. Key: Class Name, Value: counter (how many
    // * times it used)
    // */
    // private Map<String, Integer> innerClasses = new HashMap<String,
    // Integer>();
    // /* list of Fields, Key: Filed name, Value: counter (how many times it
    // used) */
    // private Map<String, SimpleObject> fields = new HashMap<String,
    // SimpleObject>();
    // /*
    // * list of Methods, Key: Method name, Value: counter (how many times it
    // * used)
    // */
    // private Map<String, SimpleObject> methods = new HashMap<String,
    // SimpleObject>();;
    // /* What are the JUnit Test classes that used this class */
    // private List<Class<?>> calledByTestClasses = new ArrayList<Class<?>>();
    //
    // /**
    // * <li><strong><i>Description</i></strong></li>
    // *
    // * <pre>
    // * public Description(Class<?> clas, boolean isTestClass)
    // * </pre>
    // *
    // * <p>
    // * Write something here...
    // * </p>
    // *
    // * @param clas
    // * - a class name with .class extension or Class Type
    // *
    // * @param isTestClass
    // * - boolean mark it if it is JUnit test class or not.
    // *
    // * @author Shohel Shamim
    // */
    // public Description(Class<?> clas, ClassCategory classCategory) {
    // this.clas = clas;
    // this.classCategory = classCategory;
    // this.packageName = this.clas.getPackage().getName();
    // // Modifier
    // int modifier = this.clas.getModifiers();
    // if (Modifier.isAbstract(modifier)) {
    // this.classType = "abstract";
    // } else if (Modifier.isFinal(modifier)) {
    // this.classType = "final";
    // } else if (this.clas.isEnum()) {
    // this.classType = "enum";
    // } else if (this.clas.isInterface()) {
    // this.classType = "interface";
    // } else {
    // this.classType = "class";
    // }
    // // Inner Class as Application
    // for (Class<?> cls : this.clas.getDeclaredClasses()) {
    // MainClass.classDescriptions.add(new Description(cls,
    // ClassCategory.REGULAR));
    // this.innerClasses.put(cls.getSimpleName(), 0);
    // }
    // // Fields isSynthetic, to remove extra field like this$1 etc.
    // for (Field field : this.clas.getDeclaredFields()) {
    // if (!field.isSynthetic()) {
    // this.fields.put(field.getName(), new SimpleObject(field));
    // }
    // }
    // // Methods
    // int len;
    // Class<?>[] paramType;
    // for (Method method : this.clas.getDeclaredMethods()) {
    // String param = "(";
    // len = method.getParameterTypes().length;
    // paramType = method.getParameterTypes();
    // for (int i = 0; i < len; i++) {
    // param += paramType[i].getSimpleName();
    // if (i + 1 != len) {
    // param = param.concat(".");
    // }
    // }
    // param = param.concat(")");
    // this.methods.put(method.getName().concat(param), new SimpleObject(
    // method));
    // }
    // }
    //
    // public Class<?> getActualClass() {
    // return this.clas;
    // }
    //
    // /**
    // * <li><strong><i>getClassName</i></strong></li>
    // *
    // * <pre>
    // * public String getClassName()
    // * </pre>
    // *
    // * <p>
    // * Return Ooriginal class name.
    // * </p>
    // *
    // * @return Class<?> - a class type.
    // *
    // * @author Shohel Shamim
    // */
    // public String getClassName() {
    // return clas.getSimpleName();
    // }
    //
    // /**
    // * <li><strong><i>getClassType</i></strong></li>
    // *
    // * <pre>
    // * public String getClassType()
    // * </pre>
    // *
    // * <p>
    // * Return type of class: abstract, final, enum, final, interface
    // * </p>
    // *
    // * @return String - a String format class type.
    // *
    // * @author Shohel Shamim
    // */
    // public String getClassType() {
    // return this.classType;
    // }
    //
    // /**
    // * <li><strong><i>getPackageName</i></strong></li>
    // *
    // * <pre>
    // * public String getPackageName()
    // * </pre>
    // *
    // * <p>
    // * Return package name.
    // * </p>
    // *
    // * @return String - a String format package name.
    // *
    // * @author Shohel Shamim
    // */
    // public String getPackageName() {
    // return this.packageName;
    // }
    //
    // /**
    // * <li><strong><i>getClassCategory</i></strong></li>
    // *
    // * <pre>
    // * public String getClassCategory()
    // * </pre>
    // *
    // * <p>
    // * Return class category: Regular, Test or GenCode
    // * </p>
    // *
    // * @return String - a String format category.
    // *
    // * @author Shohel Shamim
    // */
    // public String getClassCategory() {
    // return this.classCategory.toString();
    // }
    //
    // /**
    // * <li><strong><i>getInnerClasses</i></strong></li>
    // *
    // * <pre>
    // * public Map<String, Integer> getInnerClasses()
    // * </pre>
    // *
    // * <p>
    // * Return list of inner classes. Integer is a counter that count how many
    // * times its used by Test class.
    // * </p>
    // *
    // * @return Map<String, Integer> - a Map of all inner classes.
    // *
    // * @author Shohel Shamim
    // */
    // public Map<String, Integer> getInnerClasses() {
    // return this.innerClasses;
    // }
    //
    // /**
    // * <li><strong><i>getFields</i></strong></li>
    // *
    // * <pre>
    // * public Map<String, Integer> getFields()
    // * </pre>
    // *
    // * <p>
    // * Return fields of class. Integer is a counter that count how many times
    // * its used by Test class.
    // * </p>
    // *
    // * @return Map<String, Integer> - a Map of field name.
    // *
    // * @author Shohel Shamim
    // */
    // public Map<String, SimpleObject> getFields() {
    // return fields;
    // }
    //
    // /**
    // * <li><strong><i>getMethods</i></strong></li>
    // *
    // * <pre>
    // * public Map<String, Integer> getMethods()
    // * </pre>
    // *
    // * <p>
    // * Return methods of class. Integer is a counter that count how many times
    // * its used by Test class.
    // * </p>
    // *
    // * @return Map<String, Integer> - a String format Method type.
    // *
    // * @author Shohel Shamim
    // */
    // public Map<String, SimpleObject> getMethods() {
    // return methods;
    // }
    //
    // // /*-----------------------------------Exmine later
    // /**
    // * @return the calledByTestClasses
    // */
    // private List<Class<?>> getCalledByTestClasses() {
    // return calledByTestClasses;
    // }
    //
    // /**
    // * @param calledByTestClasses
    // * the calledByTestClasses to set
    // */
    // private void setCalledByTestClasses(List<Class<?>> calledByTestClasses) {
    // this.calledByTestClasses = calledByTestClasses;
    // }
    //
    // /*******************************************************/
    // /**
    // * <li><strong>ClassCategory</strong></li>
    // *
    // * <pre>
    // * public enum ClassCategory
    // * </pre>
    // * <p>
    // * This class used to mark class category as Regular, Test and Generated
    // * Class.
    // * </p>
    // * <br/>
    // *
    // * @author Shohel Shamim
    // */
    // public enum ClassCategory {
    // REGULAR("Regular Class"), TEST("Test Class"), GENERATED(
    // "Generated Code");
    // private String category;
    //
    // private ClassCategory(String category) {
    // this.category = category;
    // }
    //
    // public String toString() {
    // return this.category;
    // }
    // }
    //
    // /**
    // * <li><strong><i>toString</i></strong></li>
    // *
    // * <pre>
    // * public String toString()
    // * </pre>
    // *
    // * <p>
    // * Return formated output of this class.
    // * </p>
    // *
    // * @return String - a String format output.
    // *
    // * @author Shohel Shamim
    // */
    // public String toString() {
    // int counter = 0;
    // int innerClassSize = this.getInnerClasses().size();
    // int methodsSize = this.getMethods().size();
    // int fieldsSize = this.getFields().size();
    // int maxCount = Math.max(Math.max(innerClassSize, methodsSize),
    // fieldsSize);
    // String[] classes = new String[innerClassSize];
    // String[] fields = new String[fieldsSize];
    // String[] methods = new String[methodsSize];
    // int i = 0;
    // for (Entry<String, Integer> entry : this.getInnerClasses().entrySet()) {
    // classes[i] = entry.getKey() + "(" + entry.getValue() + ")";
    // i++;
    // }
    // i = 0;
    // for (Entry<String, SimpleObject> entry : this.getFields().entrySet()) {
    // fields[i] = entry.getKey() + "("
    // + ((SimpleObject) entry.getValue()).getCounter() + ")";
    // i++;
    // }
    // i = 0;
    // for (Entry<String, SimpleObject> entry : this.getMethods().entrySet()) {
    // methods[i] = entry.getKey() + "("
    // + ((SimpleObject) entry.getValue()).getCounter() + ")";
    // i++;
    // }
    // i = 0;
    // StringBuffer sb = new StringBuffer();
    // sb.append("Package,Class Type,Class Name,Class Category,Inner Class Size,Inner Classes,Fields Size,Fields Name,Methods Size,Methods Name\n");
    // while (counter < maxCount) {
    // if (counter == 0) {
    // sb.append(this.getPackageName() + ",");
    // sb.append(this.getClassType() + ",");
    // sb.append(this.getClassName() + ",");
    // sb.append(this.getClassCategory() + ",");
    // sb.append(innerClassSize + ",");
    // } else {
    // sb.append(",,,,,");
    // }
    // if (counter < innerClassSize) {
    // sb.append(classes[counter] + ",");
    // } else {
    // sb.append(",");
    // }
    // if (counter == 0) {
    // sb.append(fieldsSize + ",");
    // } else {
    // sb.append(",");
    // }
    // if (counter < fieldsSize) {
    // sb.append(fields[counter] + ",");
    // } else {
    // sb.append(",");
    // }
    // if (counter == 0) {
    // sb.append(methodsSize + ",");
    // } else {
    // sb.append(",");
    // }
    // if (counter < methodsSize) {
    // sb.append(methods[counter] + ",");
    // } else {
    // sb.append(",");
    // }
    // sb.append("\n");
    // counter++;
    // }
    // return sb.toString();
    // }
    //
    // public Field getFieldByName(String name) {
    // for (Entry<String, SimpleObject> entry : this.getFields().entrySet()) {
    // if (name.equalsIgnoreCase(entry.getKey())) {
    // return (Field) entry.getValue().getObject();
    // }
    // }
    // return null;
    // }
    //
    // // public Field getMethodByName(String name) {
    // // for (Entry<String, SimpleObject> entry : this.getMethods().entrySet())
    // {
    // // if (name.equalsIgnoreCase(entry.getKey())) {
    // // return (Field) entry.getValue().getObject();
    // // }
    // // }
    // // return null;
    // // }
    //
    // public boolean equals(Object description) {
    // if (description instanceof Description) {
    // return this.getActualClass().equals(
    // ((Description) description).getActualClass());
    // } else {
    // return false;
    // }
    // }
    //
    // class SimpleObject {
    // private Object object = null;
    // private int counter = 0;
    //
    // public SimpleObject(Object object) {
    // this.object = object;
    // }
    //
    // public void incrementCounter() {
    // this.counter++;
    // }
    //
    // public int getCounter() {
    // return this.counter;
    // }
    //
    // public Object getObject() {
    // return this.object;
    // }
    // }
}
