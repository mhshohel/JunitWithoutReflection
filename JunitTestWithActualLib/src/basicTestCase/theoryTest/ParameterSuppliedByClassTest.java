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
package basicTestCase.theoryTest;

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
public class ParameterSuppliedByClassTest {// extends TheoryTest {

    private ParameterSuppliedByClassTest testSubject;

    @Theory
    public void te() {
	System.out.println("ParameterSuppliedByClassTest.class : te()");
    }

    public static class LibraryIdSupplier extends ParameterSupplier {
	@Override
	public List getValueSources(ParameterSignature sig) {
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
    public void testGetItems3(
	    @ParametersSuppliedBy(SearchTextSupplier.class) String[] libraryId,
	    @ParametersSuppliedBy(LibraryIdSupplier.class) String Id,
	    @ParametersSuppliedBy(ItemTypeSupplier.class) String itemType,
	    @ParametersSuppliedBy(SearchIDSupplier.class) int[][] iid) {

	System.out
		.println("ParameterSuppliedByClassTest.class: testGetItems2() -> "
			+ libraryId + Id);
    }

    public static class SearchIDSupplier extends ParameterSupplier {
	@Override
	public List getValueSources(ParameterSignature sig) {
	    List list = new ArrayList();
	    list.add(PotentialAssignment.forValue("", new int[][] { { 1, 2 },
		    { 3, 4 }, { 5, 6 } }));
	    list.add(PotentialAssignment.forValue("", new int[][] { { 1, 2 },
		    { 3, 4 }, { 5, 6 } }));
	    list.add(PotentialAssignment.forValue("", new int[][] { { 1, 2 },
		    { 3, 4 }, { 5, 6 } }));
	    return list;
	}
    }

    @Theory
    public void testGetItems(
	    @ParametersSuppliedBy(LibraryIdSupplier.class) String libraryId,
	    @ParametersSuppliedBy(ItemTypeSupplier.class) String itemType,
	    @ParametersSuppliedBy(SearchTextSupplier.class) String[] searchText,
	    @ParametersSuppliedBy(SearchIDSupplier.class) int[][] iid) {
	System.out
		.println("ParameterSuppliedByClassTest.class: testGetItems() -> "
			+ libraryId);
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