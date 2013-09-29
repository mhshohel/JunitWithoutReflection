package actualSeperatedCode;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AfterAfterClassBeforeBeforeClassIgnore3 {

    @Category({ FastTests.class, SlowTests.class, IntegrationTests.class })
    @Test
    public void testMethodSix() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore3.class: testMethodSix()_IntegrationTests");
    }

    @Category({ IntegrationTests.class })
    @Test
    public void testMethodSixs() {
	System.out
		.println("AfterAfterClassBeforeBeforeClassIgnore3.class: testMethodSixs()_IntegrationTests");
    }
}