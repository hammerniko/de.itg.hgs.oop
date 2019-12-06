package L1_Baeume;

/*
 * Beispiel eines Binaerbaumes mit der Huffmann 
 * Kodierung. Bei dieser Kodierung wird haeufig vorkommenden
 * Buchstaben ein kurzer Code zugewiesen, seltener vorkommenden Buchstaben 
 * wird ein laengerer Code zugewiesen.
 * 
 * isEmpty() testet, ob ein Baum leer ist.
 * 
 *  Selektoren:
 *  getLeft() gibt den linken Teilbaum zurueck.
 *  
 *  getRoot() gibt den Wert an der Wurzel zurueck.
 *  
 *  getRight() gibt den rechten Teilbaum zurueck.
 *  
 *  size() berechnet die Anzahl der Knoten im Baum.
 *  
 *  sum() berechnet die Summe der in den
 *  Knoten gespeicherten Zahlen.
 * 
 */

public class BinTreeTestBreitendurchlauf {
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
		BFIterator it = a.bfIterator();
		while (it.hasNext()) {
		System.out.print(it.next() + " ");
		}
		}
	}
