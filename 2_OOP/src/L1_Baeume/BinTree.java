package L1_Baeume;

import java.util.NoSuchElementException;

public class BinTree {
	private Node root;

	/** Erzeugt den leeren Baum */
	public BinTree() {
		root = null;
	}

	/** Erzeugt einen Baum mit einem einzigen Knoten */
	public BinTree(double v) {
		root = new Node(null, v, null);
	}

	/**
	 * Konstruiert einen Baum, aus zwei gegebenen Teilbaeumen und einer neuen Wurzel
	 * mit Wert v.
	 */
	public BinTree(BinTree left, double v, BinTree right) {
		root = new Node(left.root, v, right.root);
	}

	public double getRoot() {
		if (root == null) {
			throw new NoSuchElementException("Ein leerer Baum hat keine Wurzel.");
		}
		return root.getValue();
	}

	public BinTree getLeft() {
		if (root == null) {
			throw new NoSuchElementException("Ein leerer Baum hat keinen linken Teilbaum.");
		}
		BinTree l = new BinTree();
		l.root = root.getLeft();
		return l;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		if (root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	public double sum() {
		if (root == null) {
			return 0;
		} else {
			return root.sum();
		}
	}

	public DFIterator dfIterator() {
		return new DFIterator(root);
	}

	public BFIterator bfIterator() {
		return new BFIterator(root);
	}
}
