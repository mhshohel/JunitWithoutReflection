/**
 *
 * @ProjectName SimpleGoldBenchmarkTest
 *
 * @PackageName testpack
 *
 * @FileName MainClass.java
 * 
 * @FileCreated Sep 2, 2013
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
package testpack;

public class MainClass {
    private String name;
    private int num;

    public static void main(String[] args) {
	System.out.println("HI.....");
	MainClass mc = new MainClass("Shohel");
	String name = mc.getName();
	mc.setName("Another");
	mc.setName("Other", 1);
    }

    public MainClass(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String s, int n) {
	this.name = s;
	this.num = n;
    }

    public void setName(String s) {
	this.name = s;
    }
}
