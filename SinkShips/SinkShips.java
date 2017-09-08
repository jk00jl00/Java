import java.util.*;

public class SinkShips{

	public static void main(String[] args) {
		int[] fiveShips ={0}; // Dirty sätt att kunna kolla hur många av de olika skeppen som används
		int[] fourShips ={0}; 
		int[] threeShips ={0};
		int[] twoShips ={0};
		char[] playerBoard = new char[11*26]; //Spelarens spelplan 286 totala plattser
		
		boardMaker(playerBoard);
		while(fiveShips[0] + fourShips[0] + threeShips[0] + twoShips[0] < 13 ){ // Placera skepp medans det ä under finns under 13
			Scanner playerInput = new Scanner(System.in); // för att få input från spelaren

			try{
				System.out.println("To place: " + (1 - fiveShips[0]) + " Carrier, " + (2 - fourShips[0]) + " Battleship(s), " + (4 - threeShips[0]) + " Submarine(s), " + (5 - twoShips[0]) + " Destroyer(S).");
				printBoard(playerBoard); // den tidagre raden visar vad du kan placera och den här visar spelplanen
				System.out.println("Enter x cord y cord direction and what ship to place");
				System.out.println("Plaese enter it like this:");
				System.out.println("X Y Dir ship");
				String input = playerInput.nextLine(); // tar input
				if (input.equals("Exit")){ // Igentligen ett test men får va kvar
					break;
				}
				char[] inArray = input.toCharArray(); // Gör om input så att jag kan komma åt enskillda element
				char shipX = inArray[0]; // sparar X koordinaten
				int shipY = (int) inArray[2] - (int) '0'; // spara Y koordinaten
				char shipDir = inArray[4]; // Sparar riktningen (N, E, S, W)
				String shipType = new String(); // För lopen nedan
				int shipLength = 0; // För att sedan kolla längd mot typ

				for (int i = 6; i < input.length(); i++){ // skriver in skepptyp i en string
					shipType += inArray[i];
				}
				if(shipType.equals("Carrier")){ // kollar vilken skepptyp det är och ger den rätt längd
					shipLength = 5;
				}
				else if(shipType.equals("Battleship")){
					shipLength = 4;
				}
				else if(shipType.equals("Submarine")){
					shipLength = 3;
				} 
				else if(shipType.equals("Destroyer")){
					shipLength = 2;
				}
				else{
					System.out.println("You must have entered the input wrong try again");
				}

				Ship toPlace = new Ship(shipDir, shipLength); // Gör ettt nytt skepp med rätt riktning och längd

				switch(shipLength){ //Kollar vilken längd och skickar med rätt int lista för att den ska öka
					case 5: placeShips(shipX, shipY, playerBoard, toPlace, fiveShips); // Kallar även placeShips som placerar skeppen på spelplanen
					break;
					case 4: placeShips(shipX, shipY, playerBoard, toPlace, fourShips);
					break;
					case 3: placeShips(shipX, shipY, playerBoard, toPlace, threeShips);
					break;
					case 2: placeShips(shipX, shipY, playerBoard, toPlace, twoShips);
					break;
				}

				
			}catch (java.lang.ArrayIndexOutOfBoundsException e){ // Om man inte har skrivit in alla värden
				System.out.println("The input was entered incorectly");
				System.out.println("Try to enter it more like this:");
				System.out.println("C 4 E Destroyer");
			}
		}
		


		System.out.println(" "); // gör mellanrum
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		printBoard(playerBoard); // skriver ut spelarens sida
		
	}

	public static void placeShips(char x, int y, char[] board, Ship ship, int[] shipAmount){ // placerar skepp
		int xCord = 1 + ((int) x - (int)'A'); // för att få X till en int och räkna med förskjutningen på selplanen
		int yCord = 1 + y; // samma som med X bara det att det redan är en int

		if (ship.getLength() == 5){ // kollar om skeppet har längden 5
			if(shipAmount[0] < 1){ // kollar så att alla skepp av typen är placerade
				if (canPlace(board, xCord, yCord, ship)){
					switch(ship.getDir()){ // kollar riktningen på skeppet
						case 'N': if((yCord - ship.getLength()) >= 0){ //kollar så att det ryms på spelplanen
							for (int i = 0; i < ship.getLength(); i++){  // lopar igenom skepplängden
								board[(26*(yCord - i)) + xCord] = ship.getGraphics(i); // och sätter den kooardinaten i spelplanen till skeppets char 
							}
							shipAmount[0]++; // ökar mänden skepp av typen som är placerade 
							break;
							}
							else{ // Om skeppet inte rymms
								System.out.println("That ship does not fit there");
								break;
							}

						case 'E': if((xCord + ship.getLength()) < 27){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26* yCord) + (xCord + i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'S': if((yCord + ship.getLength()) < 12){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord + i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
							}

						case 'W': if((xCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*yCord) + (xCord - i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}
					}
				} 
			}
			else{ // om alla skepp är placerade 
				System.out.println("You've placed all your Carriers");
			}
		}
		else if(ship.getLength() == 4){ // samma som med fem skeppen fast med fyror
			if(shipAmount[0] < 2){
				if (canPlace(board, xCord, yCord, ship)){
					switch(ship.getDir()){
						case 'N': if((yCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord - i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0] += 1;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'E': if((xCord + ship.getLength()) < 27){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26* yCord) + (xCord + i)] = ship.getGraphics(i);
							}
							shipAmount[0] += 1;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'S': if((yCord + ship.getLength()) < 12){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord + i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
							}

						case 'W': if((xCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*yCord) + (xCord - i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}
					}
				}
			}
			else{
				System.out.println("You've placed all your Battleships");
			}
		}
		else if(ship.getLength() == 3){
			if(shipAmount[0] < 4){
				if (canPlace(board, xCord, yCord, ship)){
					switch(ship.getDir()){
						case 'N': if((yCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord - i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'E': if((xCord + ship.getLength()) < 27){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26* yCord) + (xCord + i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'S': if((yCord + ship.getLength()) < 12){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord + i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
							}

						case 'W': if((xCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*yCord) + (xCord - i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}
					}
				}
			}
			else{
				System.out.println("You've placed all your Submarines");
			}
		}
		else if(ship.getLength() == 2){
			if(shipAmount[0] < 5){
				if (canPlace(board, xCord, yCord, ship)){
					switch(ship.getDir()){
						case 'N': if((yCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord - i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'E': if((xCord + ship.getLength()) < 27){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26* yCord) + (xCord + i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}

						case 'S': if((yCord + ship.getLength()) < 12){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*(yCord + i)) + xCord] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
							}

						case 'W': if((xCord - ship.getLength()) >= 0){
							for (int i = 0; i < ship.getLength(); i++){
								board[(26*yCord) + (xCord - i)] = ship.getGraphics(i);
							}
							shipAmount[0]++;
							break;
							}
							else{
								System.out.println("That ship does not fit there");
								break;
							}
					}
				}
			}
			else{
				System.out.println("You've placed all your Destroyers");
			}
		}

		return;
	}
	public static void printBoard(char[] board){ // skriver ut spelbrädor  Så att de ser 2d ut
		for(int y = 0; y < 11; y++){
			for(int x = 0; x < 26; x++){
				System.out.print(board[(26*y) + x] + " ");
		}
		System.out.print(System.lineSeparator());
	}

	}

	public static void boardMaker(char[] board){
		for(int a = 0; a < 11; a++){
			for (int b = 0; b < 26; b++){
				if(a > 0){
					if(b == 0){
						board[(a*26)] = (char)((int) '0' + (a - 1));
					}
					else {
						board[(a*26) + b] = 'X';
					}
				}
				else{
					if(b != 25){
						board[b +1] = (char)((int) 'A' + b);
					}
				}
			}
		} // fyller spelbrädan med X och säter ut  koordinaters
	}


	public static boolean canPlace(char[] board, int xCord, int yCord, Ship ship){
		boolean isPlaceble = true;
		switch (ship.getDir()){
			case 'N': 
				for (int i = 0; i < ship.getLength(); i++){
					if ( ship.graphics[i] == board[(yCord -i)*26 + xCord] || ship.graphics[1] == board[(yCord -i) *26 + xCord]
				 		|| ship.graphics[ship.getLength() - 1] == board[(yCord -i) *26 + xCord]){
				 		isPlaceble = false;
				 		break;
				 	}
					else if (i == ship.getLength() - 1){
						break;
					}
				}
			case 'E': 
				for (int i = 0; i < ship.getLength(); i++){
					if ( ship.getGraphics(i) == board[yCord *26 + (xCord + i)] || ship.getGraphics(2) == board[yCord *26 + (xCord + i)]
					 || ship.getGraphics(ship.getLength() - 1) == board[yCord *26 + (xCord + i)]){
					 	isPlaceble = false;
				 		break;
					 }
					else{
						break;
					}
				}
			case 'S':
				for (int i = 0; i < ship.getLength(); i++){
					if ( ship.getGraphics(i) == board[(yCord +i)*26 + xCord] || ship.getGraphics(2) == board[(yCord +i) *26 + xCord]
					 || ship.getGraphics(ship.getLength() - 1) == board[(yCord +i) *26 + xCord]){
					 	isPlaceble = false;
					 	break;
					 }
					else{
						break;
					}
				}
			case 'W': 
				for (int i = 0; i < ship.getLength(); i++){
					if ( ship.getGraphics(i) == board[(yCord -i)*26 + xCord] || ship.getGraphics(2) == board[(yCord -i) *26 + xCord]
					 || ship.getGraphics(ship.getLength() - 1) == board[(yCord -i) *26 + xCord]){
						isPlaceble = false;
					 	break;
					 }
					else{
						break;
					}
				}
		}
		return isPlaceble;
	} 
}
