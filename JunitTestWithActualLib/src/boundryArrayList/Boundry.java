/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName boundryArrayList
 *
 * @FileName Boundry.java
 * 
 * @FileCreated Nov 21, 2013
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
package boundryArrayList;

import java.util.ArrayList;
import java.util.List;

public class Boundry {

    public static void main(String[] args) {
	Bon b = new Bon();
	b.test();
	b = null;
    }

}

class Bon {

    List test = new ArrayList<>();

    void test() {
	test = new ArrayList<>();

	long s = System.currentTimeMillis();
	try {
	    for (int i = 0; i < 214748364; i++) {
		System.out.println("Adding...  " + i);
		test.add(i);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	long e = System.currentTimeMillis();

	double r = (e - s) / 1000;

	System.out.println(r + "s");
	System.err.println(test.size());
	System.err.println(Integer.MAX_VALUE);
    }
}
