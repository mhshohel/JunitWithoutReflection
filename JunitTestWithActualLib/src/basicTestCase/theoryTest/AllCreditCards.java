/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase.theoryTest
 *
 * @FileName AllCreditCards.java
 * 
 * @FileCreated Nov 7, 2012
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-R119
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, Växjö, Sweden
 *
 */
package basicTestCase.theoryTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;



@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(CreditCardSupplier.class)
public @interface AllCreditCards {
}