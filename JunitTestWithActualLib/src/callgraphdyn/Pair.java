/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraphdyn
 *
 * @FileName Pair.java
 * 
 * @FileCreated Oct 25, 2013
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
package callgraphdyn;


public class Pair<A, B> {
    public A first;
    public B second;

    public Pair(A first, B second) {
	this.first = first;
	this.second = second;
    }

    @Override
    public String toString() {
	StringBuffer b = new StringBuffer(first.toString());
	b.append(" ");
	b.append(second);
	return b.toString();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (obj.getClass() != getClass())
	    return false;

	Pair p = (Pair) obj;

	return first.equals(p.first) && second.equals(p.second);
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 31 * hash + (null == first ? 0 : first.hashCode());
	hash = 31 * hash + (null == second ? 0 : second.hashCode());
	return hash;
    }
}
