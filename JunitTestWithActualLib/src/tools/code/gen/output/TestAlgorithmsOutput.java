/**
 *
 * @ProjectName JUnitWithoutReflection
 *
 * @FileName TestAlgorithmsOutput.java
 *
 * @FileCreated Oct 01, 2013 - 13:26:27
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
package tools.code.gen.output;

import graphs.test.TestAlgorithms;

public class TestAlgorithmsOutput {
    public static void main(String[] args) {
	try {
	    TestAlgorithms testAlgorithms = new TestAlgorithms();
	    testAlgorithms.setUp();
	    testAlgorithms.testConnectedComponents();
	    testAlgorithms.tearDown();
	    testAlgorithms.setUp();
	    testAlgorithms.testTransitiveClosure();
	    testAlgorithms.tearDown();
	} catch (Exception e) {
	    e.printStackTrace();
	} catch (Throwable t) {
	    t.printStackTrace();
	}
    }
}
