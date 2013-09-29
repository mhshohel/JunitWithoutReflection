package actualSeperatedCode;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AfterAfterClassBeforeBeforeClassIgnore2 {
    @Category({ FastTests.class, SlowTests.class })
    @Test
    public void testMethodThree() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore2.class: testMethodThree()_IntegrationTests");
    }

    @Test
    @Category({ SlowTests.class, IntegrationTests.class })
    public void tesssstMethodFour() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore2.class: tesssstMethodFour()_SlowTests");
    }

    @Test
    @Category({ IntegrationTests.class })
    public void testMethodEight() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore2.class: testMethodEight()_IntegrationTests");
    }

    @Category({})
    @Test
    public void testMethodNine() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore2.class: testMethodNine()_");
    }

    @Test
    public void tesssstMethodFive() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore2.class: tesssstMethodFive()_Normal");
    }
}