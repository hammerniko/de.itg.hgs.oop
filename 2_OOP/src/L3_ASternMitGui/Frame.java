package L3_ASternMitGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/////////////////////// Frame (Klasse zum erstellen des Fensters) ///////////////////////

public class Frame extends JFrame{
		
	
	public final static Screen screen = new Screen();
	//Button zum wechseln zwischen Wand und Start/Ziel setzen
	private final static JButton switchButton = new JButton("Start/Ziel neu setzen");
	public static boolean setWalls = true;

	private static Pathfinder pathfinder;
	
	
	
	
	
	
	
	public Frame(short width, short height){
		super("Pathfinding mit Hilfe des A* Algorithmus");
				
		//Festsetzen diverser Fenster Variablen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		screen.setPreferredSize(new Dimension(width, height));
		switchButton.setBounds(10, 10, 151, 25);
		switchButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(setWalls) switchButton.setText("Hindernisse setzen");
				else switchButton.setText("Start/Ziel neu setzen");
				setWalls = !setWalls;
				screen.requestFocus();
			}
		});
		screen.add(switchButton);
		setContentPane(screen);
		screen.addMouseListener(new Mouse());
		screen.addKeyListener(new Keyboard());
		pack();
		setLocationRelativeTo(null);
		screen.requestFocus();
		
		setVisible(true);
		//
		
		pathfinder = new Pathfinder(width, height, Main.TILESIZE);
		
	}
	
	
	
	
	
	
	
	
/////////////////////// Screen (Klasse zum Zeichnen im Fenster) ///////////////////////
	
	public static class Screen extends JLabel{
		
		//Farben
		private final Color C_BACKGROUND = new Color(0, 0, 75);	//Hintergrundfarbe
		private final Color C_WALL = new Color(0, 0, 200);
		private final Color C_TARG = new Color(50, 230, 50);
		private final Color C_START = new Color(230, 0, 0);
		private final Color C_OPEN = new Color(50, 200, 25);
		private final Color C_PARENT_D = new Color(150, 150, 150);
		//
		private final static short NR_TILES_ROW = Main.WIDTH / Main.TILESIZE; //Anzahl der Tiles pro Reihe
		private final static short NR_TILES_COL = Main.HEIGHT / Main.TILESIZE;	//Anzahl der Tiles pro Spalte
		private static byte[][] tileType = new byte[NR_TILES_ROW][NR_TILES_COL]; //Array welches die verschiedene Tile Typen speichert
		
		private static Point curStartPos;
		private static Point curTargPos;
		
		public static final byte EMPTY = 0, WALL = 1, CLOSED  = 2, OPEN = 3, START = 4, TARGET = 5, PATHSTART = 6, PATHTARGET = 7, HIGHEST_TYPE = 7; //Codes für tileType
		
		public static final byte DIST = 2, DISTA = 1; //Distanz zwischen den gezeichneten tiles
		private static final byte R = 14, L = 18; //Radius des Parent-Zeiger Kreises, Länge der Zeigerlinie
		private static final byte UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, LU = 4, LD = 5, RU = 6, RD = 7; //Codes für Parent Richtungen
		private static final byte S_DISTX = 7, S_DISTY = 15, S_W = 6; //Abstand der Kosten Strings vom Tile Rand; S_W steht für String Width, gemeint ist die breite eines Pixels des Strings
		
		
		public Screen(){
			//Festlegen der Startfelder
			tileType[2][3] = START;
			curStartPos = new Point(2, 3);
			tileType[7][3] = TARGET;
			curTargPos = new Point(7, 3);
			tileType[4][3] = WALL;
			tileType[4][4] = WALL;
			tileType[4][2] = WALL;
		}
		
		
		// ## Überschriebene Methode von JLabel zum Zeichnen im Fenster ## //
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//Hintergrund wird Dunkelblau gefärbt
			g.setColor(C_BACKGROUND);
			g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
			
			//Zeichnen des Koordinatengitters
			g.setColor(Color.DARK_GRAY);
			for(int i = 0; i<NR_TILES_ROW; i++){
				for(int j = 0; j<NR_TILES_COL; j++){
					g.drawLine(i * Main.TILESIZE, j * Main.TILESIZE, i * Main.TILESIZE, Main.HEIGHT);
					g.drawLine(i * Main.TILESIZE, j * Main.TILESIZE, Main.WIDTH, j * Main.TILESIZE);

				}
			}
			
			//Zeichnen der einzelnen Tiles
			for(short row = 0; row<tileType.length; row++){
				for(short col = 0; col<tileType[0].length; col++){
					
					//Überprüfung um welche Art von Tile es sich handelt und entsprechende Farbwahl mit darauffolgendem Zeichnen
					switch (tileType[row][col]){
					case EMPTY:
						break;
					case WALL:
						g.setColor(C_WALL);
						g.fillRect(Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DISTA, Main.TILESIZE - DISTA);
						break;
					case CLOSED:
						drawThickRect(Color.CYAN, Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DIST, Main.TILESIZE - DIST, g);
						break;
					case OPEN:
						drawThickRect(C_OPEN, Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DIST, Main.TILESIZE - DIST, g);
						break;
					case START:
						g.setColor(C_START);
						g.fillRect(Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DISTA, Main.TILESIZE - DISTA);
						break;
					case TARGET:
						g.setColor(C_TARG);
						g.fillRect(Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DISTA, Main.TILESIZE - DISTA);
						break;
					case PATHSTART:
						g.setColor(C_START);
						g.fillRect(Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DISTA, Main.TILESIZE - DISTA);
						drawThickRect(Color.CYAN, Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DIST, Main.TILESIZE - DIST, g);
						break;
					case PATHTARGET:
						g.setColor(C_TARG);
						g.fillRect(Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DISTA, Main.TILESIZE - DISTA);
						drawThickRect(Color.CYAN, Main.TILESIZE * row + DISTA, Main.TILESIZE * col + DISTA, Main.TILESIZE - DIST, Main.TILESIZE - DIST, g);
						break;
					default:
						System.out.println("Error: Unknown Tiletype at Row: " + row + " and Column: " + col);
						break;
					}
				}
			}
			//

			
			
			
			//Zeichnen der Parent Richtung und der Kosten
			short nodeID, nodeX, nodeY, nodeWX, nodeWY; //WX und WY stehen für WorldX und WorldY also in Screen Koordinaten
			String HCost;
				//Open List
			if(pathfinder.getSizeOfOpenList()>0){
				for(int i = 1; i<=pathfinder.getSizeOfOpenList(); i++){
					nodeID = pathfinder.getOpenList(i);
					nodeX = pathfinder.getOpenX(nodeID);
					nodeY = pathfinder.getOpenY(nodeID);
					if(tileType[nodeX][nodeY] == OPEN || tileType[nodeX][nodeY] == PATHTARGET){ //Überprüfung ob es sich auch wirklich um ein richtiges Tile handelt (wichtig falls ein Tile nach dem finden des Paths seinen typ ändert)
						nodeWX = convertToScreenCoord(nodeX);
						nodeWY = convertToScreenCoord(nodeY);
						//Kosten
						g.setColor(Color.WHITE);
						//FKosten
						g.drawString(Short.toString(pathfinder.getFCost(nodeID)), nodeWX + S_DISTX, nodeWY + S_DISTY);
						//GKosten
						g.drawString(Short.toString(pathfinder.getGCost(nodeX, nodeY)), nodeWX + S_DISTX, nodeWY + Main.TILESIZE - S_DISTY / 2);
						//HKosten
						HCost = Short.toString(pathfinder.getHCost(nodeX, nodeY));
						g.drawString(HCost, nodeWX + Main.TILESIZE - HCost.length()*S_W - S_DISTX, nodeWY + Main.TILESIZE - S_DISTY / 2);
						//
						g.setColor(C_PARENT_D);
						//Parent Richtung
						//(Kreis)
						g.drawOval(nodeWX + Main.TILESIZE / 2 - R/2, nodeWY + Main.TILESIZE / 2 - R/2, R, R);
						//(Richtungslinie)
						drawParentDirection(g, nodeX, nodeY, nodeWX, nodeWY);
						//
					}
				}
			}
				//Closed List (siehe OpenList)
					//Zeichnen der FGH beschreibung ins Start Tile
			if(pathfinder.getSizeOfClosedList() >= 1){
				nodeX = pathfinder.getClosedX(0);
				nodeY = pathfinder.getClosedY(0);
				nodeWX = convertToScreenCoord(nodeX);
				nodeWY = convertToScreenCoord(nodeY);
				if(tileType[nodeX][nodeY] == PATHSTART){
					g.setColor(Color.WHITE);
					g.drawString("F", nodeWX + S_DISTX, nodeWY + S_DISTY);
					g.drawString("G", nodeWX + S_DISTX, nodeWY + Main.TILESIZE - S_DISTY / 2);
					g.drawString("H", nodeWX + Main.TILESIZE - S_DISTX - S_W, nodeWY + Main.TILESIZE - S_DISTY / 2);
				}
			}
					//
			if(pathfinder.getSizeOfClosedList()>1){
				for(int i = 1; i<pathfinder.getSizeOfClosedList(); i++){
					nodeX = pathfinder.getClosedX(i);
					nodeY = pathfinder.getClosedY(i);
					if(tileType[nodeX][nodeY] == CLOSED){
						nodeWX = convertToScreenCoord(nodeX);
						nodeWY = convertToScreenCoord(nodeY);
						
						g.setColor(Color.WHITE);
						g.drawString(Short.toString(pathfinder.getFCost(nodeX, nodeY)), nodeWX + S_DISTX, nodeWY + S_DISTY);
						g.drawString(Short.toString(pathfinder.getGCost(nodeX, nodeY)), nodeWX + S_DISTX, nodeWY + Main.TILESIZE - S_DISTY / 2);
						HCost = Short.toString(pathfinder.getHCost(nodeX, nodeY));
						g.drawString(HCost, nodeWX + Main.TILESIZE - HCost.length()*6 - S_DISTX, nodeWY + Main.TILESIZE - S_DISTY / 2);
						
						g.setColor(C_PARENT_D);
						g.drawOval(nodeWX + Main.TILESIZE / 2 - R/2, nodeWY + Main.TILESIZE / 2 - R/2, R, R);
						drawParentDirection(g, nodeX, nodeY, nodeWX, nodeWY);
					}
				}
			}
			//
			
			//Zeichnen der Legende
			drawCaption(g);
			
		}
		// ## Ende der Paint Methode ## //
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Hilfsmethode um 2 Pixel breite rechtecke zu Zeichnen
		private void drawThickRect(Color c, int x, int y, int width, int height, Graphics g){
			g.setColor(c);
			g.drawRect(x, y, width, height);
			g.drawRect(x + 1, y + 1, width - 2, height - 2);
		}
		
		//Hilfsmethode um die Richtung des Parent pfeils festzustellen
		private byte determineParentDirection(short nodeX, short nodeY){
			short parentX = pathfinder.getParentX(nodeX, nodeY);
			short parentY = pathfinder.getParentY(nodeX, nodeY);
			
			if(parentX > nodeX){
				//Rechts
				if(parentY == nodeY)return RIGHT;
				//Rechts unten
				else if(parentY > nodeY)return RD;
				//Rechts oben
				else if(parentY < nodeY)return RU;
			}else if(parentX < nodeX){
				//Links
				if(parentY == nodeY)return LEFT;
				//Links unten
				if(parentY > nodeY)return LD;
				//Links oben
				if(parentX < nodeX && parentY < nodeY)return LU;
			}else if(parentX == nodeX){
				//Oben
				if(parentX == nodeX && parentY < nodeY)return UP;
				//Unten
				if(parentX == nodeX && parentY > nodeY)return DOWN;
			}else{
				System.out.println("Unkown Parentdirection in determining process (NodeX: " + nodeX + " NodeY: " + nodeY + ")");
				return -1;
			}
			return -1;
		}
		//Hilfsmethode zum Zeichnen der Parent-Richtungslinie
		private void drawParentDirection(Graphics g, short nodeX, short nodeY, short nodeWX, short nodeWY){
			switch (determineParentDirection(nodeX, nodeY)){
			case UP:
				g.drawLine(nodeWX + Main.TILESIZE / 2, nodeWY + Main.TILESIZE / 2 - R/2, nodeWX + Main.TILESIZE / 2, nodeWY + Main.TILESIZE / 2 - L);
				break;
			case DOWN:
				g.drawLine(nodeWX + Main.TILESIZE / 2, nodeWY + Main.TILESIZE / 2 + R/2, nodeWX + Main.TILESIZE / 2, nodeWY + Main.TILESIZE / 2 + L);
				break;
			case LEFT:
				g.drawLine(nodeWX + Main.TILESIZE / 2 - R/2, nodeWY + Main.TILESIZE / 2, nodeWX + Main.TILESIZE / 2 - L, nodeWY + Main.TILESIZE / 2);
				break;
			case RIGHT:
				g.drawLine(nodeWX + Main.TILESIZE / 2 + R/2, nodeWY + Main.TILESIZE / 2, nodeWX + Main.TILESIZE / 2 + L, nodeWY + Main.TILESIZE / 2);
				break;
			case LU:
				g.drawLine(nodeWX + Main.TILESIZE / 2 - R/2 + 2, nodeWY + Main.TILESIZE / 2 - R/2 + 2, nodeWX + Main.TILESIZE / 2 - (int) (L*0.75), nodeWY + Main.TILESIZE / 2 - (int) (L*0.75));
				break;
			case LD:
				g.drawLine(nodeWX + Main.TILESIZE / 2 - R/2 + 2, nodeWY + Main.TILESIZE / 2 + R/2 - 2, nodeWX + Main.TILESIZE / 2 - (int) (L*0.75), nodeWY + Main.TILESIZE / 2 + (int) (L*0.75));
				break;
			case RU:
				g.drawLine(nodeWX + Main.TILESIZE / 2 + R/2 - 2, nodeWY + Main.TILESIZE / 2 - R/2 + 2, nodeWX + Main.TILESIZE / 2 + (int) (L*0.75), nodeWY + Main.TILESIZE / 2 - (int) (L*0.75));
				break;
			case RD:
				g.drawLine(nodeWX + Main.TILESIZE / 2 + R/2 - 2, nodeWY + Main.TILESIZE / 2 + R/2 - 2, nodeWX + Main.TILESIZE / 2 + (int) (L*0.75), nodeWY + Main.TILESIZE / 2 + (int) (L*0.75));
				break;
			default:
				System.out.println("Error: Unknow Parentdirection for NodeX: " + nodeWX + " NodeY: " + nodeWY);
				break;
			}
		}
		
		//Hilfsmethode zum Zeichnen der Legende
		private void drawCaption(Graphics g){
			final int SIZE = 10; //Pixelgröße eines Rechtecks zum erläutern der Bedeutung der Farben
			
			//OpenList
			final String OPEN = "OpenList";
			drawThickRect(C_OPEN, Main.WIDTH - 80, 9, SIZE, SIZE, g);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Main.WIDTH - 81, 8, SIZE + 2, SIZE + 2);
			g.drawString(OPEN, Main.WIDTH - 80 + SIZE + 7, 19);
			
			//ClosedList
			final String CLOSED = "ClosedList";
			drawThickRect(Color.CYAN, Main.WIDTH - 80, 24, SIZE, SIZE, g);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Main.WIDTH - 81, 23, SIZE + 2, SIZE + 2);
			g.drawString(CLOSED, Main.WIDTH - 80 + SIZE + 7, 34);
			
			//Start
			final String START = "Start";
			g.setColor(C_START);
			g.fillRect(Main.WIDTH - 80, 39, SIZE, SIZE);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Main.WIDTH - 81, 38, SIZE + 1, SIZE + 1);
			g.drawString(START, Main.WIDTH - 80 + SIZE + 7, 49);
			
			//Ziel
			final String TARG = "Ziel";
			g.setColor(C_TARG);
			g.fillRect(Main.WIDTH - 80, 54, SIZE, SIZE);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Main.WIDTH - 81, 53, SIZE + 1, SIZE + 1);
			g.drawString(TARG, Main.WIDTH - 80 + SIZE + 7, 64);
			
			//Hinderniss
			final String WALL = "Hindernis";
			g.setColor(C_WALL);
			g.fillRect(Main.WIDTH - 80, 69, SIZE, SIZE);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Main.WIDTH - 81, 68, SIZE + 1, SIZE + 1);
			g.drawString(WALL, Main.WIDTH - 80 + SIZE + 7, 79);
		}
		
		
		//Methode zum konvertieren von Screen Koordinaten zu Tile Koordinaten
		public static void convertToTilePos(Point pos){
			//Zuerst überprüfen ob die Koordinaten überhaupt im Fenster liegen
			if(pos.x<=Main.WIDTH && pos.x>=0 && pos.y<=Main.HEIGHT && pos.y>=0){
				pos.x /= Main.TILESIZE;
				pos.y /= Main.TILESIZE;
			}else{
				System.out.println("Error: Point could not be converted to TilePos (Out of Range)!");
				return;
			}
		}
		public static short convertToTileCoord(short coord){
			return (short) (coord / Main.TILESIZE);
		}
		
		//Methode zum konvertieren von Tile Koordinaten zu Screen Koordinaten
		public static short convertToScreenCoord(short coord){
			return (short) (coord * Main.TILESIZE);
		}

		//Methode um einen Tile Typ im tileType Array zu ändern
		public static void setTileType(short x, short y, byte type){
			if(type>HIGHEST_TYPE){
				System.out.println("Error: SetTileType type too high!");
			}else{
				if(type == WALL){
					Pathfinder.setWalkable(x, y, false);
				}else{
					Pathfinder.setWalkable(x, y, true);
				}
				tileType[x][y] = type;
			}
		}
		public static byte[][] getTileType(){
			return tileType;
		}
		
		
		
		public static Point getCurStartPos(){
			return curStartPos;
		}
		//Methode um den Startpunkt neu zu setzen; Löscht gleichzeitig den alten Startpunkt;
		public static void setNewStartPos(Point pos){
			if(pos.x>=0 && pos.y>=0 && pos.x<=convertToTileCoord(Main.WIDTH) && pos.y<=convertToTileCoord(Main.WIDTH)){ //Überprüfe ob das neue Start innerhalb des Fensters liegt
				tileType[pos.x][pos.y] = START;
				if(curStartPos.x != pos.x || curStartPos.y != pos.y){ //Wenn der neue Start nicht der Alte ist
					if(tileType[curStartPos.x][curStartPos.y] == START || tileType[curStartPos.x][curStartPos.y] == PATHSTART){ //Überprüfe ob das zu löschende Tile auch wirklich noch ein Start Tile ist
						tileType[curStartPos.x][curStartPos.y] = EMPTY;
						Pathfinder.setWalkable((short) curStartPos.x, (short) curStartPos.y, true);
						resetPath();
					}
					curStartPos = pos;
				}
			}
		}
		public static Point getCurTargPos(){
			return curTargPos;
		}
		//(siehe setNewStartPos)
		public static void setNewTargPos(Point pos){
			if(pos.x>=0 && pos.y>=0 && pos.x<=convertToTileCoord(Main.WIDTH) && pos.y<=convertToTileCoord(Main.WIDTH)){ //Überprüfe ob das neue Target innerhalb des Fensters liegt
				tileType[pos.x][pos.y] = TARGET;
				if(curTargPos.x != pos.x || curTargPos.y != pos.y){
					if(tileType[curTargPos.x][curTargPos.y] == TARGET || tileType[curTargPos.x][curTargPos.y] == PATHTARGET){
						tileType[curTargPos.x][curTargPos.y] = EMPTY;
						Pathfinder.setWalkable((short) curStartPos.x, (short) curStartPos.y, true);
						resetPath();
					}
					curTargPos = pos;
				}
			}
		}
		
		//Methode um entweder den Gesamten Weg oder einen Teilschritt zu berechnen
		public static void findPath(boolean wholePath){
			//Wenn ein komplett neuer Path gefunden werden soll oder der Pathfinder bereits den Weg gefunden hat soll der letzte weg wieder gelöscht werden.
			if(wholePath || pathfinder.getStatus() == Pathfinder.FOUND){
				resetPath();
			}
			pathfinder.findPath(curStartPos.x, curStartPos.y, curTargPos.x, curTargPos.y, wholePath);
			screen.repaint();
		}
		
		//Methode zum löschen des vorherigen Paths
		public static void resetPath(){
			if(pathfinder.getStatus() != Pathfinder.NOT_STARTED){
				for(short x = 0; x<Screen.getTileType().length; x++){
					for(short y = 0; y<Screen.getTileType()[0].length; y++){
						if(Screen.getTileType()[x][y] == Screen.CLOSED || Screen.getTileType()[x][y] == Screen.OPEN){
							Screen.setTileType(x, y, Screen.EMPTY);
						}else if(Screen.getTileType()[x][y] == Screen.PATHSTART){
							Screen.setTileType(x, y, Screen.START);
						}else if(Screen.getTileType()[x][y] == Screen.PATHTARGET){
							Screen.setTileType(x, y, Screen.TARGET);
						}
						screen.repaint();
					}
				}
			}
			pathfinder.setStatusNotStarted();
		}
	}
}
