package eclips;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * 
 */
public class MyGraph<E> implements DirectedGraph<E> {
    final private List<Node<E>> graph;
    private int nodeIndex = 0; // Whenever containsNodeFor method called it will
			       // keep the index number

    // Whenever containsEdgeFor method called it will keep the index number of
    // from and to
    // ----------------------------------------
    private int fromNodeIndex = 0;
    private int toNodeIndex = 0;

    // ----------------------------------------

    public MyGraph() {
	graph = new LinkedList<Node<E>>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#addNodeFor(java.lang.Object)
     */
    @Override
    public Node<E> addNodeFor(E item) {
	// TODO Auto-generated method stub
	if (item == null) {
	    throw new NullPointerException();
	}

	Node<E> node = null;

	if (containsNodeFor(item)) {
	    node = graph.get(nodeIndex);
	} else {
	    node = new MyNode<E>(item);
	    graph.add(node);
	}

	return node;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#getNodeFor(java.lang.Object)
     */
    @Override
    public Node<E> getNodeFor(E item) {
	// TODO Auto-generated method stub
	if (item == null) {
	    throw new NullPointerException();
	}

	if (containsNodeFor(item)) {
	    return graph.get(nodeIndex);
	} else {
	    throw new NullPointerException();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#addEdgeFor(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean addEdgeFor(E from, E to) {
	// TODO Auto-generated method stub
	if (from == null || to == null) {
	    throw new NullPointerException();
	}

	Node<E> nodeFrom = null;
	Node<E> nodeTo = null;

	if (containsEdgeFor(from, to)) {
	    return false;
	} else {
	    nodeFrom = addNodeFor(from);
	    nodeTo = addNodeFor(to);

	    ((MyNode<E>) nodeFrom).addSucc(nodeTo);
	    ((MyNode<E>) nodeTo).addPred(nodeFrom);
	}

	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#containsNodeFor(java.lang.Object)
     */
    @Override
    public boolean containsNodeFor(E item) {
	// TODO Auto-generated method stub
	if (item == null) {
	    throw new NullPointerException();
	}

	int index = 0;
	for (Node<E> node : graph) {
	    if (node.item() == item) {
		nodeIndex = index;
		return true;
	    }
	    index++;
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#nodeCount()
     */
    @Override
    public int nodeCount() {
	// TODO Auto-generated method stub
	return graph.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#iterator()
     */
    @Override
    public Iterator<Node<E>> iterator() {
	// TODO Auto-generated method stub
	return graph.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#heads()
     */
    @Override
    public Iterator<Node<E>> heads() {
	// TODO Auto-generated method stub
	List<Node<E>> head = new LinkedList<Node<E>>();

	for (Node<E> node : graph) {
	    if (node.inDegree() == 0) {
		head.add(node);
	    }
	}

	return head.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#headCount()
     */
    @Override
    public int headCount() {
	// TODO Auto-generated method stub
	int head = 0;
	for (Node<E> node : graph) {
	    if (node.inDegree() == 0) {
		head++;
	    }
	}
	return head;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#tails()
     */
    @Override
    public Iterator<Node<E>> tails() {
	// TODO Auto-generated method stub
	List<Node<E>> tail = new LinkedList<Node<E>>();

	for (Node<E> node : graph) {
	    if (node.outDegree() == 0) {
		tail.add(node);
	    }
	}

	return tail.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#tailCount()
     */
    @Override
    public int tailCount() {
	// TODO Auto-generated method stub
	int tail = 0;
	for (Node<E> node : graph) {
	    if (node.outDegree() == 0) {
		tail++;
	    }
	}
	return tail;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#allItems()
     */
    @Override
    public List<E> allItems() {
	// TODO Auto-generated method stub
	List<E> itemList = new LinkedList<E>();

	for (Node<E> node : graph) {
	    itemList.add(node.item());
	}

	return itemList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#edgeCount()
     */
    @Override
    public int edgeCount() {
	// TODO Auto-generated method stub
	int edge = 0;

	for (Node<E> node : graph) {
	    edge += node.outDegree();
	}

	return edge;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#removeNodeFor(java.lang.Object)
     */
    @Override
    public void removeNodeFor(E item) {
	// TODO Auto-generated method stub
	Node<E> getNode = null;

	if (item != null && containsNodeFor(item)) {
	    getNode = graph.get(nodeIndex);
	} else {
	    throw new NullPointerException();
	}

	for (Node<E> node : graph) {
	    if (node.hasPred(getNode)) {
		((MyNode<E>) node).removePred(getNode);
	    }

	    if (node.hasSucc(getNode)) {
		((MyNode<E>) node).removeSucc(getNode);
	    }
	}

	graph.remove(nodeIndex);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#containsEdgeFor(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    public boolean containsEdgeFor(E from, E to) {
	// TODO Auto-generated method stub
	if (from == null || to == null) {
	    throw new NullPointerException();
	}

	Node<E> nodeFrom = null;
	Node<E> nodeTo = null;

	if (containsNodeFor(from)) {
	    nodeFrom = graph.get(nodeIndex);
	    fromNodeIndex = nodeIndex;
	}

	if (containsNodeFor(to)) {
	    nodeTo = graph.get(nodeIndex);
	    toNodeIndex = nodeIndex;
	}

	if (nodeFrom != null && nodeTo != null) {
	    if (nodeFrom.hasSucc(nodeTo) && nodeTo.hasPred(nodeFrom)) {
		return true;
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.DirectedGraph#removeEdgeFor(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    public boolean removeEdgeFor(E from, E to) {
	// TODO Auto-generated method stub
	if (from == null || to == null) {
	    throw new NullPointerException();
	}

	if (containsEdgeFor(from, to)) {
	    Node<E> nodeFrom = graph.get(fromNodeIndex);
	    Node<E> nodeTo = graph.get(toNodeIndex);

	    ((MyNode<E>) nodeFrom).removeSucc(((MyNode<E>) nodeTo));
	    ((MyNode<E>) nodeTo).removePred(((MyNode<E>) nodeFrom));

	    return true;
	}

	return false;
    }

    public String toString() {
	StringBuilder sketchGraph = new StringBuilder(
		"Sketch Graph:\n-------------\n");
	for (Node<E> node : graph) {
	    for (Iterator<Node<E>> i = node.succsOf(); i.hasNext();) {
		sketchGraph.append(node + " -> " + i.next() + "\n");
	    }

	}
	return sketchGraph.toString();
    }

}
