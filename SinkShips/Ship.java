public class Ship{
	char dir;
	int length;
	char[] looks;
	int[] coordArray;
	String sideCoords;




	public Ship(char d, int l, int xCoord, int yCoord){
		dir = d;
		length = l;
		looks = new char[length];
		coordArray = new int[2*length];
		sideCoords = new String();
		looks = getLooks(dir, length);
		coordArray = getCoords(xCoord, yCoord, dir, length);
		getSideCoords();
    	}


	protected char[] getLooks(char d, int length){
		char[] lookArray= new char[length];
		switch(d){
			case 'N': for(int i = 0; i < length; i++){
					if(i == 0){
						lookArray[i] = '-';
					}
					else if (i == length - 1) {
						lookArray[i] = 'A';
					}
					else{
						lookArray[i] = 'I';
					}
				}
				break;

			case 'E': for(int i = 0; i < length; i++){
					if(i == 0){
						lookArray[i] = 'I';
					}
					else if (i == length - 1) {
						lookArray[i] = '>';
					}
					else{
						lookArray[i] = '=';
					}
				}
				break;

			case 'S': for(int i = 0; i < length; i++){
					if(i == 0){
						lookArray[i] = '-';
					}
					else if (i == length - 1) {
						lookArray[i] = 'V';
					}
					else{
						lookArray[i] = 'I';
					}
				}
				break;
			case 'W': for(int i = 0; i < length; i++){
					if(i == 0){
						lookArray[i] = 'I';
					}
					else if (i == length - 1) {
						lookArray[i] = '<';
					}
					else{
						lookArray[i] = '=';
					}
				}
				break;
		}
		return lookArray;
	}

	protected int[] getCoords(int x, int y, char d, int length){
		int[] intArray = new int[2*length];
		switch(d){
			case 'N': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x;
					intArray[1 + (i * 2)] = y - i;
				}
				break;

			case 'E': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x + i;
					intArray[1 + (i * 2)] = y;
				}
                return intArray;

			case 'S': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x;
					intArray[1 + (i * 2)] = y + i;
				}
				break;
			case 'W': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x - i;
					intArray[1 + (i * 2)] = y;
				}
				break;
		}
		return intArray;
	}
	protected void getSideCoords(){
        for(int i = 0; i < this.length;i++){
            sideCoords += (char)coordArray[i * 2];
            sideCoords += (char)coordArray[1 + (i * 2)];
            System.out.println("0");
            if(coordArray[i * 2] + 1 < 25){ // ett till höger
                sideCoords += (char)(coordArray[i * 2] + 1);
                sideCoords += (char)coordArray[1 + (i * 2)];   
                System.out.println("1");
            }

            if (coordArray[i * 2] - 1 > -1) { // ett till vänster
                sideCoords += (char)(coordArray[i * 2] - 1);
                sideCoords += (char)coordArray[1 + (i * 2)]; 
                System.out.println("2");
            } 
                    
            if (coordArray[i * 2] + 1 < 25 && coordArray[1 + (i * 2)] - 1 > -1) { 
                sideCoords += (char)(coordArray[i * 2] + 1);
                sideCoords += (char)(coordArray[1 + (i * 2)] - 1);
                System.out.println("3");
            }
                    
            if (coordArray[i * 2] - 1 > -1 && coordArray[1 + (i * 2)] - 1 > -1) {
                sideCoords += (char)(coordArray[i * 2] - 1);
                sideCoords += (char)(coordArray[1 + (i * 2)] - 1);
                System.out.println("4");
            }

            if (coordArray[i * 2] - 1 > -1 && coordArray[1 + (i * 2)] + 1 < 10) {
                sideCoords += (char)(coordArray[i * 2] - 1);
                sideCoords += (char)(coordArray[1 + (i * 2)] + 1);
                System.out.println("5");
            }

            if (coordArray[i * 2] + 1 < 25 && coordArray[1 + (i * 2)] + 1 < 10) {
                sideCoords += (char)(coordArray[i * 2] + 1);
                sideCoords += (char)(coordArray[1 + (i * 2)] + 1);
                System.out.println("6");
            }
                    
            if (coordArray[1 + (i * 2)] + 1 < 10) {
                sideCoords += (char)coordArray[i * 2];
                sideCoords += (char)(coordArray[1 + (i * 2)] + 1);
                System.out.println("7");
            }
                    
            if (coordArray[1 + (i * 2)] - 1 > -1) {
                sideCoords += (char)coordArray[i * 2];
                sideCoords += (char)(coordArray[1 + (i * 2)] - 1);   
                System.out.println("8");
            }
        }

	}
}


