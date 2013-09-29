package eclips;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 * 
 */
public class MyGML<E> extends GML<E> {

    /**
     * @param dg
     */
    public MyGML(DirectedGraph<E> dg) {
	super(dg);
	// TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphs.GML#toGML()
     */
    @Override
    public String toGML() {
	// TODO Auto-generated method stub
	List<Node<E>> graph = new LinkedList<Node<E>>();
	List<String> hex = new LinkedList<String>();

	hex.add("#CCDDFF");
	hex.add("#FFFF88");
	hex.add("#BBFFBB");
	hex.add("#000000");
	hex.add("#FBBFF0");

	Random rand = new Random();

	StringBuilder gml = new StringBuilder("Creator \""
		+ this.getClass().getName().toString() + "\"\n");
	gml.append("graph [ \n");

	for (E item : super.graph.allItems()) {
	    int i = rand.nextInt(hex.size());

	    gml.append("node [ id " + item + "\n");
	    gml.append("\t label \"" + item + "\"\n");
	    gml.append("\t graphics [ type \"roundrectangle\" fill \""
		    + hex.get(i) + "\" ] ]\n");

	    graph.add(super.graph.getNodeFor(item));
	}

	for (Node<E> node : graph) {
	    for (int i = 0; i < graph.size(); i++) {
		if (node.hasSucc(graph.get(i))) {
		    gml.append("edge [\n");
		    gml.append("\t source " + node + "  target " + graph.get(i)
			    + "\n");
		    gml.append("\t graphics [width 1 type \"line\" fill \""
			    + hex.get(3) + "\" arrow \"last\"] ]\n");
		}
	    }
	}

	gml.append("]");

	return gml.toString();
    }
}
