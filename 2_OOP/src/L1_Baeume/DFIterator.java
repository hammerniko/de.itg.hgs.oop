package L1_Baeume;

import java.util.LinkedList;

/**
 * Iterator fuer Tiefendurchlauf des Baumes
 * 
 * @author hr
 *
 */
public class DFIterator {
// Liste der Wurzeln aller noch zu besuchender Teilbaeume,
// in der Reihenfolge, in der sie besucht werden sollen.
	LinkedList<Node> toVisit;

// Der Iterator besucht den Baum mit Wurzel n als
// Tiefendurchlauf.
	public DFIterator(Node n) {
		this.toVisit = new LinkedList<Node>();
		if (n != null) {
			toVisit.addFirst(n);
		}
	}

	public boolean hasNext() {
		return !toVisit.isEmpty();
	}

	// Die Methode soll nur aufgerufen werden, wenn vorher mit hasNext() getestet
	// wurde,
	// dass es ein naechstes Element gibt.
	public double next() {
		// Das erste Element der Liste toVisit ist die Wurzel des
		// naechsten zu besuchenden Baums. Beim Tiefendurchlauf
		// soll diese Wurzel als naechster Knoten besucht werden.
		Node n = toVisit.removeFirst();
		Node left = n.getLeft();
		Node right = n.getRight();
		// Als naechstes muss der Baum mit Wurzel left besucht werden
		// und danach der Baum mit Wurzel right.
		if (right != null) {
			toVisit.addFirst(right);
		}
		if (left != null) {
			toVisit.addFirst(left);
		}
		// Nun ist left ganz vorne in toVisit, gefolgt von right.
		return n.getValue(); // Rueckgabe des Werts der aktuellen Wurzel
	}
}
