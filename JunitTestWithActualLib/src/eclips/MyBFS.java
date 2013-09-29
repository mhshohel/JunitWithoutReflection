package eclips;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * 
 */
public class MyBFS<E> implements BFS<E> {
    private List<Node<E>> bfsGraph = null;
    private Queue<Node<E>> queue = new LinkedList<Node<E>>();
    private int count = 0;

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.BFS#bfs(Eclips.DirectedGraph, Eclips.Node)
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
	// TODO Auto-generated method stub
	bfsGraph = new LinkedList<Node<E>>();

	if (queue.isEmpty()) {
	    bfsGraph.add(root);
	    queue.add(root);
	    root.num = count;
	    count++;
	}

	while (!queue.isEmpty()) {
	    for (Iterator<Node<E>> i = this.queue.poll().succsOf(); i.hasNext();) {
		Node<E> node = i.next();
		if (!bfsGraph.contains(node)) {
		    bfsGraph.add(node);
		    queue.add(node);
		    node.num = count;
		    count++;
		}
	    }
	}
	return bfsGraph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.BFS#bfs(Eclips.DirectedGraph)
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
	// TODO Auto-generated method stub
	List<Node<E>> bfsGraph = new LinkedList<Node<E>>();
	count = 0;

	for (Iterator<Node<E>> i = graph.iterator(); i.hasNext();) {
	    Node<E> nod = i.next();
	    if (nod.inDegree() == 0) {
		for (Node<E> n : bfs(graph, nod)) {
		    bfsGraph.add(n);
		}
	    }
	}
	return bfsGraph;
    }
}
