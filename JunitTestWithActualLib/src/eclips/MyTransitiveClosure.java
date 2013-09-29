package eclips;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

    /*
     * (non-Javadoc)
     * 
     * @see graphs.TransitiveClosure#computeClosure(graphs.DirectedGraph)
     */
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
	// TODO Auto-generated method stub
	Map<Node<E>, Collection<Node<E>>> transitiveClouser = new HashMap<Node<E>, Collection<Node<E>>>();
	MyDFS<E> dfs = new MyDFS<E>();

	for (Node<E> node : dg) {
	    transitiveClouser.put(node, dfs.dfs(dg, node));
	}

	return transitiveClouser;
    }

}
