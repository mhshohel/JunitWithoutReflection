package eclips;

import graphs.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * 
 */
public class MyNode<E> extends Node<E> {
    final private List<Node<E>> successor;
    final private List<Node<E>> predecessor;

    /**
     * @param item
     */
    protected MyNode(E item) {
	// TODO Auto-generated constructor stub
	super(item);
	successor = new LinkedList<Node<E>>();
	predecessor = new LinkedList<Node<E>>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#hasSucc(graphs.Node)
     */
    @Override
    public boolean hasSucc(Node<E> node) {
	// TODO Auto-generated method stub
	if (successor.contains(node)) {
	    return true;
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#outDegree()
     */
    @Override
    public int outDegree() {
	// TODO Auto-generated method stub
	return successor.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#succsOf()
     */
    @Override
    public Iterator<Node<E>> succsOf() {
	// TODO Auto-generated method stub
	return successor.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#hasPred(graphs.Node)
     */
    @Override
    public boolean hasPred(Node<E> node) {
	// TODO Auto-generated method stub
	if (predecessor.contains(node)) {
	    return true;
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#inDegree()
     */
    @Override
    public int inDegree() {
	// TODO Auto-generated method stub
	return predecessor.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#predsOf()
     */
    @Override
    public Iterator<Node<E>> predsOf() {
	// TODO Auto-generated method stub
	return predecessor.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#addSucc(graphs.Node)
     */
    @Override
    protected void addSucc(Node<E> succ) {
	// TODO Auto-generated method stub
	successor.add(succ);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#removeSucc(graphs.Node)
     */
    @Override
    protected void removeSucc(Node<E> succ) {
	// TODO Auto-generated method stub
	successor.remove(succ);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#addPred(graphs.Node)
     */
    @Override
    protected void addPred(Node<E> pred) {
	// TODO Auto-generated method stub
	predecessor.add(pred);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#removePred(graphs.Node)
     */
    @Override
    protected void removePred(Node<E> pred) {
	// TODO Auto-generated method stub
	predecessor.remove(pred);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.Node#disconnect()
     */
    @Override
    protected void disconnect() {
	// TODO Auto-generated method stub
	successor.clear();
	predecessor.clear();
    }

}
