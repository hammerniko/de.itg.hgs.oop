package L1_Baeume;

public class Node {
	private Node left;
	private double value;
	private Node right;

	public Node(Node left, double value, Node right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public double getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
	
	public int size() {
		int sizeLeft = 0;
		int sizeRight = 0;
		if (left != null) {
		sizeLeft = left.size();
		}
		if (right != null) {
		sizeRight = right.size();
		}
		return 1 + sizeLeft + sizeRight;
		}
	
	public double sum() {
		double sumLeft = 0;
		double sumRight = 0;
		if (left != null) {
		sumLeft = left.sum();
		}
		if (right != null) {
		sumRight = right.sum();
		}
		return value + sumLeft + sumRight;
		}
}
