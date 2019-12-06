package L1_Baeume;

import java.util.LinkedList;

public class BFIterator {
// Liste der Wurzeln aller noch zu besuchender Teilbaeume,
// in der Reihenfolge, in der sie besucht werden sollen.
	LinkedList<Node> toVisit;

// Der Iterator besucht den Baum mit Wurzel n als
// Breitendurchlauf.
	public BFIterator(Node n) {
		toVisit = new LinkedList<Node>();
		if (n != null) {
			toVisit.addFirst(n);
		}
	}

	public boolean hasNext() {
		return !toVisit.isEmpty();
	}
	
	public double next() {
		Node n = toVisit.removeFirst();
		Node left = n.getLeft();
		Node right = n.getRight();
		// Im Unterschied zum Tiefendurchlauf werden die beiden
		// Teilbaeume von n hier hinten angefuegt.
		if (left != null) {
		toVisit.addLast(left);
		}
		if (right != null) {
		toVisit.addLast(right);
		}
		return n.getValue();
		}
		}