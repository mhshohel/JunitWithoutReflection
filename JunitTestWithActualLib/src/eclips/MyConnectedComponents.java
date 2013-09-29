package eclips;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * 
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    /*
     * (non-Javadoc)
     * 
     * @see graphs.ConnectedComponents#computeComponents(graphs.DirectedGraph)
     */
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
	// TODO Auto-generated method stub
	MyDFS<E> dfs = new MyDFS<E>();
	Collection<Collection<Node<E>>> transitive = new LinkedList<Collection<Node<E>>>();
	List<Node<E>> nodes = new LinkedList<Node<E>>();

	for (Node<E> node : dg) {
	    if (!nodes.contains(node)) {
		nodes = dfs.dfs(dg, node);
		for (int i = 0; i < nodes.size(); i++) {
		    for (Iterator<Node<E>> n = nodes.get(i).predsOf(); n
			    .hasNext();) {
			Node<E> subNode = n.next();
			if (!nodes.contains(subNode)) {
			    nodes.add(subNode);
			}
		    }
		}

		transitive.add(nodes);
	    }
	}
	return transitive;
    }

}
