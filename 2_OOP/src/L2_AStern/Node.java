package L2_AStern;

public class Node {
	int x,y; //Position im Feld
	int g; //Kosten zur nächste Node 10 oder 14
	int h; //Kosten zum Ziel
	int f; //Gesamtkosten f=g+h
	Node from;
	Node to;
	
	public Node(int x, int y) {
		
		this.x=x;
		this.y=y;
				
		calcCosts();
	};
	
	public int calcCosts() {
				
		//Prüfen ob der Weg hierher gerade oder diagonal
		//ist
		if(from.y == y || from.x == x) {
			g=10;
		}
		else {
			g=14;
		}
		
		h = g * (Math.abs(to.x-x +to.y-y)); 
				
		f=g+h;
		return f;
	}

	public Node getFrom() {
		return from;
	}

	public void setFrom(Node from) {
		this.from = from;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}
	
	
	

}
