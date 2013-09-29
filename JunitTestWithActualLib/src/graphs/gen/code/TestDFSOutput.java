/**
 *
 * @ProjectName JUnitWithoutReflection
 *
 * @FileName TestDFSOutput.java
 *
 * @FileCreated Sep 26, 2013 - 14:52:49
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

import graphs.test.TestDFS;

public class TestDFSOutput {
    public static void main(String[] args) {
        try {
            TestDFS testDFS = new TestDFS();
            testDFS.setUp();
            testDFS.testBFS();
            testDFS.tearDown();
            testDFS.setUp();
            testDFS.testCyclic();
            testDFS.tearDown();
            testDFS.setUp();
            testDFS.testDFS();
            testDFS.tearDown();
            testDFS.setUp();
            testDFS.testPostOrder();
            testDFS.tearDown();
        }catch(Exception e) {
            e.printStackTrace();
        }catch(Throwable t) {
            t.printStackTrace();
        }
    }
}
