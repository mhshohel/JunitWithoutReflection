/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase.theoryTest
 *
 * @FileName CreditCardSupplier.java
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

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class CreditCardSupplier extends ParameterSupplier {

    @Override
    public List getValueSources(ParameterSignature signature) {
	ArrayList result = new ArrayList();

	result.add(PotentialAssignment.forValue("Amex", "Amex"));
	result.add(PotentialAssignment.forValue("Master", "Master"));
	result.add(PotentialAssignment.forValue("Visa", "Visa"));

	return result;
    }
}
