/**
 *
 * @ProjectName JUnitWithoutReflection
 *
 * @FileName TestDirectedGraphOutput.java
 *
 * @FileCreated Sep 26, 2013 - 14:58:54
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

import graphs.test.TestDirectedGraph;

public class TestDirectedGraphOutput {
    public static void main(String[] args) {
        try {
            TestDirectedGraph testDirectedGraph = new TestDirectedGraph();
            testDirectedGraph.setUp();
            testDirectedGraph.testCreateAdd();
            testDirectedGraph.tearDown();
            testDirectedGraph.setUp();
            testDirectedGraph.testExceptions();
            testDirectedGraph.tearDown();
            testDirectedGraph.setUp();
            testDirectedGraph.testGML();
            testDirectedGraph.tearDown();
            testDirectedGraph.setUp();
            testDirectedGraph.testIterator();
            testDirectedGraph.tearDown();
            testDirectedGraph.setUp();
            testDirectedGraph.testRemove();
            testDirectedGraph.tearDown();
        }catch(Exception e) {
            e.printStackTrace();
        }catch(Throwable t) {
            t.printStackTrace();
        }
    }
}
