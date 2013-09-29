package eclips;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * 
 */
public class MyDFS<E> implements DFS<E> {
    private List<Node<E>> graph = null;
    private Stack<Node<E>> visitedNode = new Stack<Node<E>>();
    private int flag = 0;
    private int number = 0;

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#dfs(Eclips.DirectedGraph, Eclips.Node)
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
	// TODO Auto-generated method stub
	if (flag == 0) {
	    this.graph = new LinkedList<Node<E>>();
	}

	if (!this.graph.contains(root)) {
	    this.graph.add(root);
	    root.num = number;
	    number++;
	}

	for (Iterator<Node<E>> i = root.succsOf(); i.hasNext();) {
	    Node<E> node = i.next();
	    if (!this.graph.contains(node)) {
		this.graph.add(node);
		node.num = number;

		number++;
		flag++;

		dfs(graph, node);

		flag--;
	    }
	}
	return this.graph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#dfs(Eclips.DirectedGraph)
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
	// TODO Auto-generated method stub
	List<Node<E>> dfsGraph = new LinkedList<Node<E>>();
	number = 0;

	for (Iterator<Node<E>> i = graph.iterator(); i.hasNext();) {
	    Node<E> nod = i.next();
	    if (nod.inDegree() == 0) {
		for (Node<E> n : dfs(graph, nod)) {
		    if (!dfsGraph.contains(n)) {
			dfsGraph.add(n);
		    }
		}
	    }
	}
	return dfsGraph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#postOrder(Eclips.DirectedGraph, Eclips.Node)
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
	// TODO Auto-generated method stub
	if (flag == 0) {
	    graph = new LinkedList<Node<E>>();
	}

	if (!graph.contains(root)) {
	    visitedNode.push(root);
	}

	flag++;
	for (Iterator<Node<E>> i = root.succsOf(); i.hasNext();) {
	    Node<E> node = i.next();
	    if (visitedNode.search(root) < 0) {
		visitedNode.push(root);
	    }

	    if (visitedNode.search(node) < 0 && !graph.contains(node)) {
		postOrder(g, node);
	    }
	}
	flag--;

	Node<E> node = visitedNode.pop();
	node.num = number;
	number++;
	graph.add(node);

	return graph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#postOrder(Eclips.DirectedGraph)
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
	// TODO Auto-generated method stub
	List<Node<E>> postOrderGraph = new LinkedList<Node<E>>();
	number = 0;

	for (Iterator<Node<E>> i = g.iterator(); i.hasNext();) {
	    Node<E> node = i.next();
	    if (node.inDegree() == 0) {
		for (Node<E> n : postOrder(g, node)) {
		    if (!postOrderGraph.contains(n)) {
			postOrderGraph.add(n);
		    }
		}
	    }
	}

	return postOrderGraph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#postOrder(Eclips.DirectedGraph, boolean)
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
	// TODO Auto-generated method stub
	List<Node<E>> postOrderGraph = new LinkedList<Node<E>>();
	number = 0;

	for (Iterator<Node<E>> i = g.iterator(); i.hasNext();) {
	    Node<E> nod = i.next();
	    if (attach_dfs_number == true) {
		nod.num = number;
		number++;
		postOrderGraph.add(nod);
	    } else {
		postOrderGraph.add(nod);
	    }
	}

	return postOrderGraph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#isCyclic(Eclips.DirectedGraph)
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
	// TODO Auto-generated method stub
	for (Iterator<Node<E>> j = graph.iterator(); j.hasNext();) {
	    Node<E> node = j.next();
	    for (Iterator<Node<E>> i = node.succsOf(); i.hasNext();) {
		if (node.equals(i.next())) {
		    return true;
		}
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Eclips.DFS#topSort(Eclips.DirectedGraph)
     */
    @Override
    public List<Node<E>> topSort(DirectedGraph<E> dfs) {
	// TODO Auto-generated method stub
	List<Node<E>> dfsNode = new LinkedList<Node<E>>();

	for (E item : dfs.allItems()) {
	    dfsNode.add(new MyNode<E>(item));
	}

	return dfsNode;
    }

}
