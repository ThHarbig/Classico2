package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Node enthaelt Informationen zu einem Knoten im Baum.
 * Er beinhaltet den Namen des Knotens, die Kantenlaenge zum Elternknoten, den Elternknoten und die Knoten der Kinder.
 * 
 * @author Katrin Fischer
 *
 */
public class Node {
	
	private int id;
	private Map<Integer,Set<String>> label = new HashMap<Integer, Set<String>>();
	private String name;
	private double length;
	private Node parent;
	private List<Node> children = new ArrayList<Node>();

	
	/**
	 * Konstruktor f�r einen Knoten
	 * @param nodename Name des Knotens
	 * @param branchlength Kantenl�nge zum Elternknoten
	 */
	public Node(String nodename, double branchlength) {
		name = nodename;
		length = branchlength;
	}
	


	/**
	 * Gibt einen String zur�ck, mit dem Knoten und dessen Kindern im Newickformat
	 * @return String im Newickformat
	 */
	public String toNewickString() {
		//Stellt die L�nge in Englischer Schreibweise dar
		Locale.setDefault(Locale.ENGLISH);
		String childrenToString = "";
		// Kindknoten in Newickformat hinzuf�gen, falls vorhanden
		if (!children.isEmpty()) {
			for (Node i : children) {
				//Kinder werden durch Komma getrennt
				if (childrenToString.equals("")) {
					childrenToString = i.toNewickString();
				} else {
					childrenToString = childrenToString + "," + i.toNewickString();
				}
			}
			// Daten des Knotens mit Kindern ausgeben
			return ("(" + childrenToString + ")" + name + ":" + String.format( "%.3f", length ));
		} else {
			// Daten des Knotens ohne Kinder ausgeben
			return (name + ":" + String.format( "%.3f", length ));
		}
	}
	
	
	/**
	 * Gibt nur die Informationen des Knotens zur�ck
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return (name + ":" + String.format( "%.8f", length ) + "-" + id);
	}

	public List<Node> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public double getLength() {
		return length;
	}

	public Node getParent() {
		return parent;
	}

	
	/**
	 * Fuegt der Liste der Kindknoten einen Knoten hinzu
	 * @param child der neue Kindknoten
	 */
	public void addChild(Node child) {
		this.children.add(child);
	}


	/**
	 * Setzt den Elternknoten des Knoten
	 * @param parent der Elternknoten
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Map<Integer, Set<String>> getLabel() {
		return label;
	}


	public void setLabel(Map<Integer, Set<String>> label) {
		this.label = label;
	}

}
