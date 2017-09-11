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

			//try{
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
				System.out.println(inArray);
				int shipX = (int) inArray[0] - (int) 'A' + 1; // sparar X koordinaten
				if(shipX < 1 || shipX > 25){
					System.out.print("The X value was too big or small");
					System.out.print("Try again");
					continue;
				}
				System.out.println(shipX);
				int shipY = (int) inArray[2] - (int) '0' + 1; // spara Y koordinaten
				if (shipY < 1 || shipY > 10){
					System.out.print("The Y value was too big or small");
					System.out.print("Try again");
					continue;
				}
				System.out.println(shipY);
				char shipDir = inArray[4]; // Sparar riktningen (N, E, S, W)
				System.out.println(shipDir);
				String shipType = new String(); // För lopen nedan
				int shipLength = 0; // För att sedan kolla längd mot typ

				for (int i = 6; i < input.length(); i++){ // skriver in skepptyp i en string
					shipType += inArray[i];
					System.out.println(shipType);
				}
				if(shipType.equals("Carrier")){ // kollar vilken skepptyp det är och ger den rätt längd
					shipLength = 5;
					if (shipX < 5 && shipDir == 'W'){
						System.out.println("A Carrier would not fit here if placed to the west.");
						continue;
					}
					else if (shipX > 21 && shipDir == 'E') {
						System.out.println("A Carrier would not fit here if placed to the east.");
						continue;
					}
					else if (shipY > 6 && shipDir == 'S') {
						System.out.println("A Carrier would not fit here if placed to the south.");
						continue;
					}
					else if (shipY < 5 && shipDir == 'N') {
						System.out.println("A Carrier would not fit here if placed to the north.");
						continue;
					}
				}
				else if(shipType.equals("Battleship")){
					shipLength = 4;
					if (shipX < 5 && shipDir == 'W'){
						System.out.println("A Battleship would not fit here if placed to the west.");
						continue;
					}
					else if (shipX > 22 && shipDir == 'E') {
						System.out.println("A Battleship would not fit here if placed to the east.");
						continue;
					}
					else if (shipY > 7 && shipDir == 'S') {
						System.out.println("A Battleship would not fit here if placed to the south.");
						continue;
					}
					else if (shipY < 4 && shipDir == 'N') {
						System.out.println("A Battleship would not fit here if placed to the north.");
						continue;
					}
				}
				else if(shipType.equals("Submarine")){
					shipLength = 3;
					if (shipX < 3 && shipDir == 'W'){
						System.out.println("A Submarine would not fit here if placed to the west.");
						continue;
					}
					else if (shipX > 23 && shipDir == 'E') {
						System.out.println("A Submarine would not fit here if placed to the east.");
						continue;
					}
					else if (shipY > 8 && shipDir == 'S') {
						System.out.println("A Submarine would not fit here if placed to the south.");
						continue;
					}
					else if (shipY < 3 && shipDir == 'N') {
						System.out.println("A Submarine would not fit here if placed to the north.");
						continue;
					}
				} 
				else if(shipType.equals("Destroyer")){
					shipLength = 2;
					if (shipX < 3 && shipDir == 'W'){
						System.out.println("A carrier would not fit here if placed to the west.");
						continue;
					}
					else if (shipX > 24 && shipDir == 'E') {
						System.out.println("A carrier would not fit here if placed to the east.");
						continue;
					}
					else if (shipY > 9 && shipDir == 'S') {
						System.out.println("A carrier would not fit here if placed to the south.");
						continue;
					}
					else if (shipY < 2 && shipDir == 'N') {
						System.out.println("A carrier would not fit here if placed to the north.");
						continue;
					}
				}
				else{
					System.out.println("You must have entered the input wrong try again");
				}

				Ship toPlace = new Ship(shipDir, shipLength, shipX, shipY); // Gör ettt nytt skepp med rätt riktning och längd
				System.out.println(toPlace.length + " " + toPlace.dir);
				placeShip(toPlace, playerBoard, fiveShips);


				
		//	}catch (java.lang.ArrayIndexOutOfBoundsException e){ // Om man inte har skrivit in alla värden
		//		System.out.println("The input was entered incorectly");
		//		System.out.println("Try to enter it more like this:");
		//		System.out.println("C 4 E Destroyer");
		//	}
		}
		


		System.out.println(" "); // gör mellanrum
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		printBoard(playerBoard); // skriver ut spelarens sida
		
	}

	public static void printBoard(char[] board){ // skriver ut spelbrädor  Så att de ser 2d ut
		for(int y = 0; y < 11; y++){
				for(int x = 0; x < 26; x++){
					if (y == 0 && x == 0){
						System.out.print(board[(26*y) + x] + "  ");
					}
					else{
						System.out.print(board[(26*y) + x] + " ");
					}
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

	public static void placeShip(Ship ship, char[] board, int[] shipAmmount){
		if(shipAmmount[0] < 1){
			System.out.println("a");
			if(canPlace(ship, board)){
				System.out.println("b");
				for (int i = 0; i < ship.length; i++){
					System.out.print(ship.coordArray[2*i] + ", ");
					System.out.println(board[26 * (ship.coordArray[1 + (2 * i)] + ship.coordArray[2 * i])]);
					board[26*(ship.coordArray[1 + (2*i)]) +	ship.coordArray[2 * i]] = ship.looks[i];					
				}
				shipAmmount[0]++;
			}

		}
		if(shipAmmount[0] < 2){
			if(canPlace(ship, board)){
				for (int i = 0; i < ship.length; i++){
					board[26*(ship.coordArray[1 + (2*i)]) +	ship.coordArray[0 + (2*i)]] = ship.looks[i];					
				}
				shipAmmount[0]++;
			}

		}
		if(shipAmmount[0] < 4){
			if(canPlace(ship, board)){
				for (int i = 0; i < ship.length; i++){
					board[26*(ship.coordArray[1 + (2*i)]) +	ship.coordArray[0 + (2*i)]] = ship.looks[i];					
				}
				shipAmmount[0]++;
			}

		}
		if(shipAmmount[0] < 5){
			if(canPlace(ship, board)){
				for (int i = 0; i < ship.length; i++){
					board[26*(ship.coordArray[1 + (2*i)]) +	ship.coordArray[0 + (2*i)]] = ship.looks[i];					
				}
				shipAmmount[0]++;
			}

		}
	}

	/* Kolla riktningen, Kolla start koordinater, om den går norrut koll om dedn ligger på botten eller mot någon
	*/
	public static boolean canPlace(Ship ship, char[] board){
		for (int i = 0; i < ship.length; i++){
			if (board[26*(ship.sideCoords[1 + (2*i)]) + ship.sideCoords[0 + (2*i)]] != 'X'){
			return false;
			}
		}

	return true;
		
	}

}
