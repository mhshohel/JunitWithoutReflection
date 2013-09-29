/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName testCasesesFromInternet.two
 *
 * @FileName AccountTest.java
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

public class AccountTest {
    @Test
    @Category(IntegrationTests.class)
    public void thisTestWillTakeSomeTime() {
	System.out.println("thisTestWillTakeSomeTime");
    }

    @Test
    @Category(IntegrationTests.class)
    public void thisTestWillTakeEvenLonger() {
	System.out.println("thisTestWillTakeEvenLonger");
    }

    @Test
    public void thisOneIsRealFast() {
	System.out.println("thisOneIsRealFast");
    }
}
