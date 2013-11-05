/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName tools.staticcallgraph
 *
 * @FileName OPCodeDescription.java
 * 
 * @FileCreated Nov 5, 2013
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

public class OPCodeDescription {
    private Description description = null;
    // whenever a class calls must call oneTimeUseOnly, means new ClassA(), it
    // means we have to call below method first and only once
    private OPCodeProperties oneTimeUseOnly = null;
    private OPCodeProperties others = null;

    public OPCodeDescription() {
	this.oneTimeUseOnly = new OPCodeProperties();
	this.others = new OPCodeProperties();
    }

    public OPCodeProperties getOneTimeUseOnly() {
	return this.oneTimeUseOnly;
    }

    public OPCodeProperties getOthers() {
	return this.others;
    }
}
