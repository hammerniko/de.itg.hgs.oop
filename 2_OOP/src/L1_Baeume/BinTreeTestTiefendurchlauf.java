package L1_Baeume;

public class BinTreeTestTiefendurchlauf {

	public static void main(String[] args) {
		BinTree k = new BinTree(8);
		BinTree j = new BinTree(7);
		BinTree f = new BinTree(j, 5, k);
		BinTree e = new BinTree(6);
		BinTree b = new BinTree(e, 2, f);
		BinTree g = new BinTree(4);
		BinTree empty = new BinTree();
		BinTree c = new BinTree(empty, 3, g);
		BinTree a = new BinTree(b, 1, c);
		DFIterator it = a.dfIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
