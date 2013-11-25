/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraphstat
 *
 * @FileName JonasAClass.java
 * 
 * @FileCreated Nov 21, 2013
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-0533
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, V�xj�, Sweden
 *
 */
package callgraphstat;

public class JonasAClass implements JonasInterface {

    @Override
    public void interfaceMethod() {
	s.dck();
	methodA();
    }

    public void methodA() {
	new JonasSimpleClass().someMethod();
    }

}
