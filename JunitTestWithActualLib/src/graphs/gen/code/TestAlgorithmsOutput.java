/**
 *
 * @ProjectName JUnitWithoutReflection
 *
 * @FileName TestAlgorithmsOutput.java
 *
 * @FileCreated Sep 26, 2013 - 14:45:57
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
package graphs.gen.code;

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
        }catch(Exception e) {
            e.printStackTrace();
        }catch(Throwable t) {
            t.printStackTrace();
        }
    }
}
