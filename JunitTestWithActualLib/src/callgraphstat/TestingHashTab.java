/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraphstat
 *
 * @FileName TestingHashTab.java
 * 
 * @FileCreated Nov 3, 2013
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingHashTab {
    static Map<String, String> abc = new HashMap<String, String>();
    static Map<String, String> def = new HashMap<String, String>();
    static List<AClass> a = new ArrayList<AClass>();
    static List<AClass> aa = new ArrayList<AClass>();

    /**
     * @param TestingHashTab
     */
    public static void main(String[] args) {
	AClass b = new AClass();
	b.val = 1;
	a.add(b);
	b = new AClass();
	b.val = 2;
	a.add(b);
	b = new AClass();
	b.val = 3;
	a.add(b);
	b = new AClass();
	b.val = 4;
	a.add(b);
	b = new AClass();
	b.val = 5;
	a.add(b);

	for (AClass c : a) {
	    aa.add(c.copy());
	}

	aa.get(0).val = 700;

	for (AClass ac : a) {
	    System.out.println(ac.val);
	}

	System.out.println(aa.get(0).val);
    }
}

class AClass {
    public int val;

    public AClass() {
    }

    AClass(AClass a) {
	this.val = a.val;
    }

    public AClass copy() {
	return new AClass(this);
    }
}