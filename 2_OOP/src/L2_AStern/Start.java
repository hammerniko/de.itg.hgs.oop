package L2_AStern;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {
		
		int[][] feld =  {
				{0,0,0,0,0,0,0},
				{0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0},
				{0,0,0,0,0,0,0},
		};
		
		Node start = new Node(1,2);
		Node ziel = new Node(5,5);
		
	}
	
	public ArrayList<Node> sucheWeg(Node start, Node ziel, int[][] feld ){
		int minCost=Integer.MAX_VALUE;
		Node from;
		Node to;
		
		//Wenn Start und Ziel identisch sind
		ArrayList<Node> way = new ArrayList<Node>();
		if(start == ziel) {
			way.add(ziel);
			return way;
		}
		
		
		ArrayList<Node> oL = new ArrayList<Node>();
		ArrayList<Node> cL = new ArrayList<Node>();
		
		//Füge Startpunkt der openList hinzu
		if(feld[start.x][start.y]==0) {
			oL.add(start);
		}
		else {
			//Wenn Start auf einer Barriere liegt
			return null;
		}
		
		//Suche alle Nachbarn die Node mit den günstigsten Kosten
		//in der openList
		int nodeNr=0;
		for (Node node : oL) {
			if(minCost>node.calcCosts()) {
				minCost = node.calcCosts();
				nodeNr = oL.indexOf(node);
			}
			
		}
		
		//Wähle Node für nächsten Schritt
		from = oL.get(nodeNr);
		
		
		
		
		
		return null;
	}

}
