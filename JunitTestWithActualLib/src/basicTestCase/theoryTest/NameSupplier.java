package basicTestCase.theoryTest;

/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase.theoryTest
 *
 * @FileName NameSupplier.java
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

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class NameSupplier extends ParameterSupplier {

    @Override
    public List getValueSources(ParameterSignature signature) {

	// Problem will be for Signature
	// AllNames annotation = signature.getAnnotation(AllNames.class);
	// System.out.println("just wanted to show that I can access it "
	// + annotation);
	// System.err.println(signature.getType().getSimpleName());

	ArrayList result = new ArrayList();

	result.add(PotentialAssignment.forValue("Alf", "Alf"));
	result.add(PotentialAssignment.forValue("Willie", "Willie"));
	result.add(PotentialAssignment.forValue("Tanner", "Tanner"));
	result.add(PotentialAssignment.forValue("Cat", "Cat"));

	return result;
    }
}
