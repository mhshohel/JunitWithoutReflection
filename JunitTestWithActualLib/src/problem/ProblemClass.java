/**
 *
 * @ProjectName JunitTestAnnotationCodes
 *
 * @PackageName basicTestCase.theoryTest
 *
 * @FileName ParameterSuppliedByClassTest.java
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
package problem;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ProblemClass {// extends TheoryTest {

    private ProblemClass testSubject;

    public static class LibraryIdSupplier extends ParameterSupplier {
	@Override
	public List getValueSources(ParameterSignature sig) {

	    // Here is the problem if I write System out here then in generation
	    // it will give a error, because Sig is null there,
	    System.err.println(sig.getClass().getSimpleName());

	    List list = new ArrayList();
	    list.add(PotentialAssignment.forValue("", "ebook"));
	    list.add(PotentialAssignment.forValue("", "book"));
	    return list;
	}

    }

    public static class ItemTypeSupplier extends ParameterSupplier {
	@Override
	public List getValueSources(ParameterSignature sig) {
	    List list = new ArrayList();
	    list.add(PotentialAssignment.forValue("", "abook"));
	    list.add(PotentialAssignment.forValue("", "bbook"));
	    list.add(PotentialAssignment.forValue("", "cbook"));
	    list.add(PotentialAssignment.forValue("", "dbook"));

	    return list;
	}

    }

    public static class SearchTextSupplier extends ParameterSupplier {
	@Override
	public List getValueSources(ParameterSignature sig) {
	    List list = new ArrayList();
	    list.add(PotentialAssignment.forValue("", new String[] { "potter",
		    "poppins", "superman" }));
	    list.add(PotentialAssignment.forValue("",
		    new String[] { "spiderman" }));

	    return list;
	}
    }

    @Theory
    public void testGetItems2(
	    @ParametersSuppliedBy(LibraryIdSupplier.class) String libraryId,
	    @ParametersSuppliedBy(ItemTypeSupplier.class) String itemType,
	    @ParametersSuppliedBy(SearchTextSupplier.class) String[] searchText) {

	System.out
		.println("ParameterSuppliedByClassTest.class: testGetItems2() -> "
			+ libraryId + itemType + searchText);
    }
}