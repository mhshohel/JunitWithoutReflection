/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName testCasesesFromInternet.two
 *
 * @FileName AccountIntegrationTest.java
 * 
 * @FileCreated Mar 22, 2013
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
package testCasesesFromInternet.two;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTests.class)
public class AccountIntegrationTest {
    @Test
    public void thisTestWillTakeSomeTime() {
	System.out.println("thisTestWillTakeSomeTime");
    }

    @Test
    public void thisTestWillTakeEvenLonger() {
	System.out.println("thisTestWillTakeEvenLonger");
    }
}