package L3_ASternMitGui;

import L3_ASternMitGui.Frame.Screen;




public class Pathfinder {
	
	//Fenster spezifische Variablen
	private final short width, height;
	private final short tileSize;
	//
	
	//Kosten Arrays und Listen
	private short[][] GCost; //Speichert an der Stelle [X][Y] die GKosten des Tiles an der Position (X/Y);
	private short[][] HCost; //Speichert an der Stelle X die HKosten des Tiles X (X wird beim aufnehmen in den binary heap zugewiesen
	private short[] FCost; //siehe HCost
	
	private short[] openList, openX, openY; //Im openList Array werden die Tiles als Zahl gespeichert;
	private short itemsOnOpenList;			//In openX und openY dieser Stelle werden die entsprechenden Koordinaten gespeichert (in Tile Koordinaten);
											//z.B.: Tile X wird die Zahl 4 im binary heap zugewiesen, also sind die Koordinaten von TileX in openX[4] und openY[4] gespeichert;
	private short newOpenListItemID; //F�rs hinzuf�gen neuer nodes in den Heap
	private short[] closedX, closedY; //Das explizite speichern der closed List gegenst�nde ist eigentlich nicht notwendig, da schlussendlich der path nur durch
	private short itemsOnClosedList;			  //die aneinandereihung der Parents des Targets erfolgt. In diesem Programm wird es jedoch f�rs zeichnen ben�tigt!
	private byte whichList[][]; //Speichert in welcher Liste sich das Tile an der Position (X/Y) befindet; (siehe "Codes f�r Arrays")
	
	private static boolean[][] walkable; //Speichert ob ein Tile an der Position (X/Y) begehbar ist.
	//
	
	//Parent Variablen
	private short[][] parentX; //Speichert die X-Koordinate des Parent des Tiles (X/Y) an der Stelle [X][Y];
	private short[][] parentY; //siehe parentX; Diese sind vor allem beim sp�teren speichern des gefundenen Paths wichtig;
	private short curParentX, curParentY;
	//
			
	//Codes f�r pathfinder Status
	private byte pathStatus = 0; //Speichert immer den derzeitigen Status des Pathfinders
	public static final byte FOUND = 2, NON_EXISTENT = 3, NOT_FINISHED = 1, NOT_STARTED = 0;
	//
	
	//Codes f�r WhichList
	private static final byte ON_CLOSED_LIST = 1, ON_OPEN_LIST = 2;
	//
	
	private boolean listReordered = false; //Sp�ter zum sortieren im Binary Heap verwendet
	
	private boolean nextStep = false; //Nur f�rs schrittweise Zeichnen
	
	
////// Konstruktor: �bergeben der Fenster spezifischen Variablen und festlegen der entsprechenden Gr��e der Kosten Arrays und der Listen
	public Pathfinder(short width, short height, short tileSize){
		width /= tileSize; //Konvertieren von pixel zu Tiles
		height /= tileSize;
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		
		//festlegen der Array gr��en
		GCost = new short[width][height]; 
		HCost = new short[width][height];
		FCost = new short[width * height];
		
		whichList = new byte[width][height];
		openList = new short[width * height];
		openX = new short[width * height];
		openY = new short[width * height];
		
		//Nur f�rs Zeichnen
		closedX = new short[width * height];
		closedY = new short[width * height];
		
		parentX = new short[width][height];
		parentY = new short[width][height];
		
		initWalkable();
		
		
	}
	
	
	//Methode die das walkable Array initialisiert (bzw. an das tileType Array aus Frame angleicht)
		private void initWalkable(){
			walkable = new boolean[width][height];
			
			for(short i = 0; i<Screen.getTileType().length; i++){
				for(short j = 0; j<Screen.getTileType()[0].length; j++){
					if(Screen.getTileType()[i][j] == Screen.WALL){
						walkable[i][j] = false;
					}else{
						walkable[i][j] = true;
					}
				}
			}
		}
		public static void setWalkable(short x, short y, boolean walkable){
			Pathfinder.walkable[x][y] = walkable;
		}
		
		
		
		
		
	
	
//////////////////////// Methode zur Wegfindung ////////////////////////
	public void findPath(int startX, int startY, int targetX, int targetY, boolean wholePath){ //der boolean wholePath ist nur f�r das schrittweise Wegfinden und damit nur f�rs Zeichnen notwendig
		
		//Initialisieren einiger Variablen
		short newItemPos; //Sp�ter zum hinzuf�gen neuer Nodes in die Openlist ben�tigt
		short nbX, nbY; //Nachtbar koordinate X und Y, beim bestimmen der Nachbarn verwendet
		short addedGCost = 0, tempGCost = 0; //Beim Updaten von GCosts verwendet (beim Analysieren von Nachbarn)
		boolean walkCorner; //Ebenfalls beim bestimmen von Nachbarn verwendet
		short temp, pathX, pathY, cellPosition; //Sp�ter f�r das analysieren des Verwendeten Paths verwendet
		
		if(wholePath || pathStatus == FOUND || pathStatus == NOT_STARTED){ //If nur f�rs schrittweise Zeichnen
			//Zur�cksetzen einiger Variablen 
			itemsOnOpenList = 0;
			itemsOnClosedList = 0;
			newOpenListItemID = 0;
			pathStatus = NOT_STARTED;
			
			//�berpr�fung ob der Weg �berhaupt berechnet werden muss
			if(startX == targetX && startY == targetY){ //Start = Target
				pathStatus = FOUND;
			}else if(targetX <= -1 || targetY <= -1 || targetX > width || targetY > height){ //Target au�erhalb des Fensters
				pathStatus = NON_EXISTENT;
			}else if(walkable[targetX][targetY] == false){ //Target ist nicht begehbar
				pathStatus = NON_EXISTENT;
			}
			//
			
			//Zur�cksetzen der whichList
			for(int x = 0; x<width; x++){
				for(int y = 0; y<height; y++){
					whichList[x][y] = 0;
				}
			}
			//
			
			GCost[startX][startY] = 0;
			
			//F�ge Start Node zur OpenList hinzu
			itemsOnOpenList = 1;
			openList[1] = 1; //an Stelle 1 und nicht 0 da es sonst mit dem sortieren im Binary Heap probleme geben w�rde
			openX[1] = (short) startX; openY[1] = (short) startY;
			
			Screen.setTileType((short) startX, (short) startY, Screen.PATHSTART); //Nur f�rs zeichnen notwendig
			//
		}
		
		pathStatus = NOT_FINISHED;
		nextStep = true; //nur f�rs Zeichnen
		
		
		/////// ### Pathfinding Loop ### ///////
		while(pathStatus == NOT_FINISHED && nextStep){ //nextStep nur f�rs schrittweise Zeichnen
			if(itemsOnOpenList != 0){ //Wenn es keine Nodes mehr in der OpenList gibt sind alle erreichbaren in der Closed (Ziel nicht erreichbar)
				//Die erste Node der OpenList wird auf die ClosedList gesetzt (durch den Binary Heap immer die mit der kleinsten FCost
					//Der Parent f�r die n�chste Node ist nun das zur ClosedList hinzugef�gte Objekt
				curParentX = openX[openList[1]];
				curParentY = openY[openList[1]];
					//
				whichList[openX[openList[1]]][openY[openList[1]]] = ON_CLOSED_LIST;
				//Nur f�rs Zeichnen Notwendig
				closedX[itemsOnClosedList] = curParentX; closedY[itemsOnClosedList] = curParentY;
				itemsOnClosedList++;
				if(openX[openList[1]] != startX || openY[openList[1]] != startY){
					Screen.setTileType(openX[openList[1]], openY[openList[1]], Screen.CLOSED);
				}
				//
				openList[1] = openList[itemsOnOpenList]; //Die erste Position in der openList und damit im Heap wird durch die letzte ersetzt und danach neu geordnet
				itemsOnOpenList--;
				listReordered = false;
				//
				
				// OpenList (Binary Heap) neu Ordnen
				reorderOpenList();
				
				//// # Nachbar-Berechnung # ////
				for(nbY = (short) (curParentY - 1); nbY<=curParentY + 1; nbY++){ //For Schleife die die Koordinaten aller Nachbarn des derzeitigen Parents �berpr�ft
					for(nbX = (short) (curParentX - 1); nbX<=curParentX + 1; nbX++){
						if(nbX >= 0 && nbY >= 0 && nbX < width && nbY < height){ //Wenn der Nachbar innerhalb des Feldes liegt
							if(whichList[nbX][nbY] != ON_CLOSED_LIST && walkable[nbX][nbY] == true){ //und der Nachbar noch nicht auf der ClosedList ist, bzw. �berhaupt begehbar ist
								
								//�berpr�fung ob die Diagonale begehbar ist
								walkCorner = checkCorner(nbX, nbY);
								
								if(walkCorner){ //Wenn der Nachbar alle vorherigen if-Abfragen erf�llt hat und auch durchquerbar ist wird er jetzt zur OpenList hinzugef�gt
									if(whichList[nbX][nbY] != ON_OPEN_LIST){
										newOpenListItemID++; //Die Neue ID im Heap wird erh�ht
										newItemPos = (short) (itemsOnOpenList + 1);
										openList[newItemPos] = newOpenListItemID; //An der Stelle newItemPos wird eine Node mit der ID newOpenListItemID hinzugef�gt
										openX[newOpenListItemID] = nbX; //Die Koordinaten werden in openX und openY gespeichert
										openY[newOpenListItemID] = nbY;
										
										//GKosten der neuen Node werden berechnet (Strecke Parent zu neuen Node)
										if(Math.abs(nbX - curParentX) == 1 && Math.abs(nbY - curParentY) == 1){ //Diagonale hat die Kosten von 14
											addedGCost = 14;
										}else{ //Gerade hat Kosten von 10
											addedGCost = 10;
										}
										GCost[nbX][nbY] = (short) (GCost[curParentX][curParentY] + addedGCost); //GKosten der neuen Node = neue Kosten + GKosten des Parents
										
										//Berechnung der H und F Kosten
										HCost[openX[openList[newItemPos]]][openY[openList[newItemPos]]] = (short) (10 * (Math.abs(nbX - targetX) + Math.abs(nbY - targetY))); //Berechnet mit der Manhattan Methode (Abgespeichert im HKosten Array an der Stelle der NodeID)
										FCost[openList[newItemPos]] = (short) (GCost[nbX][nbY] + HCost[openX[openList[newItemPos]]][openY[openList[newItemPos]]]); //FKosten = GKosten + HKosten
										
										parentX[nbX][nbY] = curParentX; parentY[nbX][nbY] = curParentY; //Abspeichern des Parents der neuen Node in parentX und Y Arrays
										
										//Richtige Positionierung der neuen Node im Heap
										while(newItemPos != 1){
											if(FCost[openList[newItemPos]] <= FCost[openList[newItemPos / 2]]){ //Wenn die FKosten der neuen Node kleiner sind als die des Parents im Heap (!= Parent im Path!!) werden sie getauscht
												temp = openList[newItemPos / 2];
												openList[newItemPos / 2] = openList[newItemPos];
												openList[newItemPos] = temp;
												newItemPos /= 2;
											}else break;
										}
										itemsOnOpenList++;
										whichList[nbX][nbY] = ON_OPEN_LIST;
										//Nur f�rs zeichnen
										if(nbX != targetX || nbY != targetY){
											Screen.setTileType(nbX, nbY, Screen.OPEN); 
										}
										//
										
									}else{ //Wenn die Node bereits in der OpenList ist werden nur die GKosten neu berechnet
										if(Math.abs(nbX - curParentX) == 1 && Math.abs(nbY - curParentY) == 1){ //Diagonale
											addedGCost = 14;
										}else{ //Gerade
											addedGCost = 10;
										}
										tempGCost = (short) (GCost[curParentX][curParentY] + addedGCost);
										
										//Wenn die neu berechneten GKosten kleiner sind als vorher wird der Parent der Node gewechselt
										if(tempGCost < GCost[nbX][nbY]){
											parentX[nbX][nbY] = curParentX;
											parentY[nbX][nbY] = curParentY;
											GCost[nbX][nbY] = tempGCost;
											
											
											//Suche nach der richtigen Node, um auch F kosten upzudaten
											for(short i = 1; i <= itemsOnOpenList; i++){
												if(openX[openList[i]] == nbX && openY[openList[i]] == nbY){
													FCost[openList[i]] = (short) (GCost[nbX][nbY] + HCost[openX[openList[i]]][openY[openList[i]]]);
													
													//Repositionierung im Heap
													newItemPos = i;
													while(newItemPos != 1){
														if(FCost[openList[newItemPos]] < FCost[openList[newItemPos / 2]]){
															temp = openList[newItemPos / 2];
															openList[newItemPos / 2] = openList[newItemPos];
															openList[newItemPos] = temp;
															newItemPos /= 2;
														}else break;
													}
													break;
												}
											}
										}
									}//Ende der "WalkCorner" if-Abfrage
								}
							}
						}
					}
				}// Ende der Nachbar-Berechnung //
			}else{ //Wenn keine Items auf der OpenList mehr sind
				pathStatus = NON_EXISTENT;
				break;
			}
			
			if(whichList[targetX][targetY] == ON_OPEN_LIST){ //Nachdem jedes Mal alle Nachbarn �berpr�ft wurden und wenn m�glich auf die OpenList gesetzt wurden,
				pathStatus = FOUND;							 //wird �berpr�ft ob sich das Ziel bereits auf der OpenList befindet. Wenn dem so ist, ist der Weg gefunden.
				Screen.setTileType((short) targetX, (short) targetY, Screen.PATHTARGET); //Nur f�rs zeichnen
				break;
			}
			//Nur f�rs schrittweise Zeichnen.
			if(!wholePath){
				nextStep = false;
			}
		}//Ende des Pathfinding loops
		
		//Wenn aus der While Schleife gesprungen wurde und der Path gefunden ist wird nun normal der Path gebanked um sp�ter wieder gelesen zu werden
	}
	
//////////////////////// Ende der Wegfindungs-Methode ////////////////////////
	

	
	
	
	
	
	
	
	//// Methode zum Neuordnen der OpenList/des Binary Heaps ////
	private void reorderOpenList(){
		int posChild, posParent;
		short temp;
		
		posChild = 1;
		while(listReordered == false){
			posParent = posChild; //Das Child vom letzten Durchgang ist nun der Parent
			if(2 * posParent + 1 <= itemsOnOpenList){ //Wenn beide Childs existieren
				if(FCost[openList[posParent]] >= FCost[openList[2 * posParent]]){ //Wenn das erste Child kleinere Kosten besitzt als der Parent
					posChild = 2 * posParent;
				}
				if(FCost[openList[posChild]] >= FCost[openList[2 * posParent + 1]]){ //Wenn das zweite Child ...
					posChild = 2 * posParent + 1;
				}
			
			}else if(2 * posParent <= itemsOnOpenList){ //Wenn nur ein Child existiert
				if(FCost[openList[posParent]] >= FCost[openList[2 * posParent]]){ //Wenn dieses niedregere Kosten hat
					posChild = 2 * posParent;
				}
			}
			if(posChild != posParent){ //Wenn das Child niedrigere Kosten hatte und somit nicht mehr die gleiche Position wie sein Parent hat
				//Vertauschen von Parent und Child
				temp = openList[posParent];
				openList[posParent] = openList[posChild];
				openList[posChild] = temp;
				//
			}else{ //Wenn keine Childs existieren oder gr��er sind ist die Liste neu geordnet
				listReordered = true;
			}
		}
	}
	
	//// Methode um zu �berpr�fen ob die diagonalen eines Parent durchquerbar sind
	private boolean checkCorner(short nbX, short nbY){
		if(nbX == curParentX - 1){
			if(nbY == curParentY - 1){
				if(walkable[curParentX - 1][curParentY] == false || walkable[curParentX][curParentY - 1] == false){
					 return false;
				}
			}else if(nbY == curParentY + 1){
				if(walkable[curParentX][curParentY + 1] == false || walkable[curParentX - 1][curParentY] == false){
					return false;
				}
			}
			
		}else if(nbX == curParentX + 1){
			if(nbY == curParentY - 1){
				if(walkable[curParentX][curParentY - 1] == false || walkable[curParentX + 1][curParentY] == false){ 
					return false;
				}
			}else if(nbY == curParentY + 1){
				if(walkable[curParentX + 1][curParentY] == false || walkable[curParentX][curParentY + 1] == false){
					return false;
				}
			}
		}
		return true;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public byte getStatus(){
		return pathStatus;
	}
	public void setStatusNotStarted(){
		pathStatus = NOT_STARTED;
	}
	
	
	/// OpenList Getter ///
	public short getOpenList(int index){
		return openList[index];
	}
	public short getOpenX(int ID){
		return openX[ID];
	}
	public short getOpenY(int ID){
		return openY[ID];
	}
	public short getSizeOfOpenList(){
		return itemsOnOpenList;
	}
	
	
	/// ClosedList Getter ///
	public short getClosedX(int index){
		return closedX[index];
	}
	public short getClosedY(int index){
		return closedY[index];
	}
	public short getSizeOfClosedList(){
		return itemsOnClosedList;
	}
	
	
	
	/// Kosten Getter ///
	public short getGCost(int x, int y){
		return GCost[x][y];
	}
	public short getHCost(int x, int y){
		return HCost[x][y];
	}
	public short getFCost(int ID){
		return FCost[ID];
	}
	public short getFCost(int x, int y){
		return (short) (getHCost(x, y) + getGCost(x, y));
	}
	
	
	/// Parent Getter ///
	public short getParentX(short nodeX, short nodeY){
		return parentX[nodeX][nodeY];
	}
	public short getParentY(short nodeX, short nodeY){
		return parentY[nodeX][nodeY];
	}
}
