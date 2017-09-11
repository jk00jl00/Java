public class Ship{
	char dir;
	int length;
	char[] looks;
	int[] coordArray;
	int[] sideCoords;


	public Ship(char d, int l, int xCoord, int yCoord){
		dir = d;
		length = l;
		looks = new char[length];
		int[] coordArray = new int[2*length];
        if (yCoord == 1 || yCoord == 10 && (xCoord != 1 || xCoord!= 25)){
            int[] sideCoords = new int[2*(2*l + 3)];
        }
        else if ((yCoord == 1  || yCoord == 10) && (xCoord == 1 || xCoord == 25)) {
            int[] sideCoords = new int[2*(l + 2)];
        }
        else {
            int[] sideCoords = new int[2*(2*l + 6)];
        }
		
		looks = getLooks(dir, length);
		coordArray = getCoords(xCoord, yCoord, dir, length);
		sideCoords = getSideCoords(xCoord, yCoord, dir, length);
        for (int i = 0; i < length; i++){
            System.lineSeparator();
            System.out.print(coordArray[2*i] + ", ");
            System.out.println(coordArray[1 + (i * 2)]);
            System.lineSeparator();
        }
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
                    System.out.println(intArray[1 + (2* i)]);
				}
                return intArray;

			case 'S': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x;
					intArray[1 + (i * 2)] = y + i;
                    System.out.println(intArray[i]);
				}
				break;
			case 'W': 
				for(int i = 0; i < length; i++){
					intArray[0 + (2*i)] = x - i;
					intArray[1 + (i * 2)] = y;
                    System.out.println(intArray);
				}
				break;
		}
		return intArray;
	}
	protected int[] getSideCoords(int x, int y, char d, int l){
		switch(d){
			case 'N': 
				if (y == l && (x != 1 && x != 25)){
					int[] sideCoordArray = new int[2*(2*l + 3)]; 
					for (int i = 0; i < (l +1); i++){
						sideCoordArray[2 * i] = x + 1;   // (0, 3) (2, 3) (4, 3) (6, 3) (8,3)
						sideCoordArray[1 + (2 * i)] = (y + 1) - i; // (1, 5) (3, 4) (5, 3) (7, 2) (9, 1) 
						sideCoordArray[2*(l+1) + (2 * i)] = x - 1; // (10, 1) (12, 1) (14, 1) (16, 1) (18, 1)
						sideCoordArray[2*(l+1) + 1 + (2 * i)] = (y + 1) - i; // (11, 5) (13, 4) (15, 3) (17, 2) (19, 1)
                	}
                    sideCoordArray[4*(l+1)] = x; // (20, 2)
                    sideCoordArray[4*(l + 1) + 1] = y + 1; // (21, 5)
                    return sideCoordArray;
				}
				else if (y == l && x == 1) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x + 1;  
                        sideCoordArray[1 + (2 * i)] = (y + 1) - i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y + 1;
                    return sideCoordArray;
                }
                else if (y == l && x == 25) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x - 1;  
                        sideCoordArray[1 + (2 * i)] = (y + 1) - i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y + 1;
                    return sideCoordArray;
                }
                else if (y == 10 && (x != 1 && x != 25)) {
                    int[] sideCoordArray = new int[2 * (2 * l + 3)];
                    for(int i = 0; i < (l + 1); i++){
                        sideCoordArray[2 * i] = x + 1;
                        sideCoordArray[1 + (2 * i)] = y - i;  
                        sideCoordArray[2*(l+1) + (2 * i)] = x - 1; 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = y - i;
                    }
                    sideCoordArray[4*(l + 1)] = x;
                    sideCoordArray[4*(l + 1) + 1] = y - l;
                    return sideCoordArray;
                }   
                else if (y == 10 && x == 1) {
                    int[] sideCoordArray = new int[2 * (l +2)];
                    for (int i = 0; i <  (l + 1); i++){
                        sideCoordArray[i * 2] = x + 1;
                        sideCoordArray[1 + (i * 2)] = y - i;
                    }
                    sideCoordArray[2 * (l +1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y - l;
                        return sideCoordArray;
                }
                else if (y == 10 && x == 25) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x - 1;  
                        sideCoordArray[1 + (2 * i)] = y - i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y + 1;
                    return sideCoordArray;
                }
                else{
                    int[] sideCoordArray = new int[2* (2 * l + 6)];
                    for(int i = 0; i < (l + 2); i++){
                        sideCoordArray[2 * i] = x + 1;
                        sideCoordArray[1 + (2 * i)] = (y + 1) - i;
                        sideCoordArray[2* (l + 2)] = x - 1;
                        sideCoordArray[1 + 2 *(l + 2)] = (y + 1) - i;
                    }
                    sideCoordArray[2 * (2* (l + 2))] = x;
                    sideCoordArray[1 + 2 * (2 * (l + 2))] = y + 1;
                    sideCoordArray[2 + 2 * (2 + (l + 2))] = x;
                    sideCoordArray[3 + 2 * (2 + (l + 2))] = y - l;
                    return sideCoordArray;
                }
            case 'E':
                if (x == 25 - (l -1) && (y != 1 && y != 10)){
                    int[] sideCoordArray = new int[2*(2*l + 3)]; 
                    for (int i = 0; i <  (l +1); i++){
                        sideCoordArray[2 * i] = (x - 1) + i;   //
                        sideCoordArray[1 + (2 * i)] = (y + 1); // 
                        sideCoordArray[2*(l+1) + (2 * i)] = (x + i) - 1; // 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = (y - 1); // 
                    }
                    sideCoordArray[4*(l+1)] = x - 1; 
                    sideCoordArray[4*(l + 1) + 1] = y; // 
                    return sideCoordArray;
                }
                else if (x == 1 && y == 1) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i <  l + 1 + 1; i++){ 
                        sideCoordArray[2 * i] = x + i;  
                        sideCoordArray[1 + (2 * i)] = y + 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x + l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else if (x == 1 && y == 10) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < l +1; i++){ 
                        sideCoordArray[2 * i] = x + i;  
                        sideCoordArray[1 + (2 * i)] = y - 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x + l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else if (x == 1 && (y != 1 && y != 10)) {
                    int[] sideCoordArray = new int[2 * (2 * l + 3)];
                    for(int i = 0; i < 4 * ( l +1); i++){
                        sideCoordArray[2 * i] = x + i;
                        sideCoordArray[1 + (2 * i)] = y + 1;  
                        sideCoordArray[2*(l+1) + (2 * i)] = x + i; 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = y - 1;
                        System.out.println((char)((int) '0' + i));
                    }
                    sideCoordArray[4*( + 1) * l] = x + l;
                    sideCoordArray[4*(l + 1) + 1] = y;
                    return sideCoordArray;
                }   
                else if (x == 25 - (l - 1) && y == 1) {
                    int[] sideCoordArray = new int[2 * (l +2)];
                    for (int i = 0; i < 2 * (l + 1); i++){
                        sideCoordArray[i * 2] = (x - 1) + i;
                        sideCoordArray[1 + (i * 2)] = y + 1;
                    }
                    sideCoordArray[2 * (l +1)] = x - 1;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                        return sideCoordArray;
                }
                else if (y == 10 && x == 25 - (l - 1)) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < 2* (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = (x - 1) + i;  
                        sideCoordArray[1 + (2 * i)] = y - 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x - 1;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else{
                    int[] sideCoordArray = new int[2* (2 * l + 6)];
                    for(int i = 0; i < (2* (l + 2)); i++){
                        sideCoordArray[2 * i] = (x - 1) + i;
                        sideCoordArray[1 + (2 * i)] = y + 1;
                        sideCoordArray[2* (l + 2)] = (x - 1) + i;
                        sideCoordArray[1 + 2 *(l + 2)] = (y + 1);
                    }
                    sideCoordArray[2 * (2* (l + 2))] = x - 1;
                    sideCoordArray[1 + 2 * (2 * (l + 2))] = y;
                    sideCoordArray[2 + 2 * (2 + (l + 2))] = x + l;
                    sideCoordArray[3 + 2 * (2 + (l + 2))] = y;
                    return sideCoordArray;
                }
            case 'S':
                if (y == 1 && (x != 1 && x != 25)){
                    int[] sideCoordArray = new int[2*(2*l + 3)]; 
                    for (int i = 0; i < (l +1); i++){
                        sideCoordArray[2 * i] = x + 1;   // (0, 3) (2, 3) (4, 3) (6, 3) (8,3)
                        sideCoordArray[1 + (2 * i)] = y + i; // (1, 5) (3, 4) (5, 3) (7, 2) (9, 1) 
                        sideCoordArray[2*(l+1) + (2 * i)] = x - 1; // (10, 1) (12, 1) (14, 1) (16, 1) (18, 1)
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = y + i; // (11, 5) (13, 4) (15, 3) (17, 2) (19, 1)
                    }
                    sideCoordArray[4*(l+1)] = x; // (20, 2)
                    sideCoordArray[4*(l + 1) + 1] = y + l; // (21, 5)
                    return sideCoordArray;
                }
                else if (y == 1 && x == 1) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x + 1;  
                        sideCoordArray[1 + (2 * i)] = y + i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y + l;
                    return sideCoordArray;
                }
                else if (y == 1 && x == 25) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x - 1;  
                        sideCoordArray[1 + (2 * i)] =  y + i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y + l;
                    return sideCoordArray;
                }
                else if (y == 10 - (l -1) && (x != 1 && x != 25)) {
                    int[] sideCoordArray = new int[2 * (2 * l + 3)];
                    for(int i = 0; i < (l + 1); i++){
                        sideCoordArray[2 * i] = x + 1;
                        sideCoordArray[1 + (2 * i)] = (y - 1) + i;  
                        sideCoordArray[2*(l+1) + (2 * i)] = x - 1; 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = (y - 1) + i;
                    }
                    sideCoordArray[4*(l + 1)] = x;
                    sideCoordArray[4*(l + 1) + 1] = y - 1;
                    return sideCoordArray;
                }   
                else if (y == 10 - (l -1) && x == 1) {
                    int[] sideCoordArray = new int[2 * (l +2)];
                    for (int i = 0; i <  (l + 1); i++){
                        sideCoordArray[i * 2] = x + 1;
                        sideCoordArray[1 + (i * 2)] = (y - 1) + i;
                    }
                    sideCoordArray[2 * (l +1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y - 1;
                        return sideCoordArray;
                }
                else if (y == 10 - (l -1) && x == 25) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x - 1;  
                        sideCoordArray[1 + (2 * i)] = (y - 1) + i;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x;
                    sideCoordArray[1 + (2 * (l + 1))] = y - 1;
                    return sideCoordArray;
                }
                else{
                    int[] sideCoordArray = new int[2* (2 * l + 6)];
                    for(int i = 0; i < (l + 2); i++){
                        sideCoordArray[2 * i] = x + 1;
                        sideCoordArray[1 + (2 * i)] = (y - 1) + i;
                        sideCoordArray[2* (l + 2)] = x - 1;
                        sideCoordArray[1 + 2 *(l + 2)] = (y - 1) + i;
                    }
                    sideCoordArray[2 * (2* (l + 2))] = x;
                    sideCoordArray[1 + 2 * (2 * (l + 2))] = y - 1;
                    sideCoordArray[2 + 2 * (2 + (l + 2))] = x;
                    sideCoordArray[3 + 2 * (2 + (l + 2))] = y + l;
                    return sideCoordArray;
                }
            case 'W':
                if (x == 25 && (y != 1 && y != 10)){
                    int[] sideCoordArray = new int[2*(2*l + 3)]; 
                    for (int i = 0; i <  (l +1); i++){
                        sideCoordArray[2 * i] = x - i;   //
                        sideCoordArray[1 + (2 * i)] = (y + 1); // 
                        sideCoordArray[2*(l+1) + (2 * i)] = x - i; // 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = (y - 1); // 
                    }
                    sideCoordArray[4*(l+1)] = x - l; 
                    sideCoordArray[4*(l + 1) + 1] = y; // 
                    return sideCoordArray;
                }
                else if (x ==  l && y == 1) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i <  l + 1 + 1; i++){ 
                        sideCoordArray[2 * i] = x - i;  
                        sideCoordArray[1 + (2 * i)] = y + 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x - l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else if (x == l && y == 10) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < l +1; i++){ 
                        sideCoordArray[2 * i] = x - i;  
                        sideCoordArray[1 + (2 * i)] = y - 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x - l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else if (x == l && (y != 1 && y != 10)) {
                    int[] sideCoordArray = new int[2 * (2 * l + 3)];
                    for(int i = 0; i < 4 * ( l +1); i++){
                        sideCoordArray[2 * i] = x - i;
                        sideCoordArray[1 + (2 * i)] = y + 1;  
                        sideCoordArray[2*(l+1) + (2 * i)] = x - i; 
                        sideCoordArray[2*(l+1) + 1 + (2 * i)] = y - 1;
                    }
                    sideCoordArray[4*( + 1) * l] = x - l;
                    sideCoordArray[4*(l + 1) + 1] = y;
                    return sideCoordArray;
                }   
                else if (x == 25 && y == 1) {
                    int[] sideCoordArray = new int[2 * (l +2)];
                    for (int i = 0; i < 2 * (l + 1); i++){
                        sideCoordArray[i * 2] = x - i;
                        sideCoordArray[1 + (i * 2)] = y + 1;
                    }
                    sideCoordArray[2 * (l +1)] = x - l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                        return sideCoordArray;
                }
                else if (y == 10 && x == 25) {
                    int[] sideCoordArray = new int[2* (l + 2)];
                    for (int i = 0; i < 2* (l +1) + 1; i++){ 
                        sideCoordArray[2 * i] = x - i;  
                        sideCoordArray[1 + (2 * i)] = y - 1;
                    }
                    sideCoordArray[ 2 * (l + 1)] = x - l;
                    sideCoordArray[1 + (2 * (l + 1))] = y;
                    return sideCoordArray;
                }
                else{
                    int[] sideCoordArray = new int[2* (2 * l + 6)];
                    for(int i = 0; i < (2* (l + 2)); i++){
                        sideCoordArray[2 * i] = (x + 1) - i;
                        sideCoordArray[1 + (2 * i)] = y + 1;
                        sideCoordArray[2* (l + 2)] = (x - 1) + i;
                        sideCoordArray[1 + 2 *(l + 2)] = (y + 1);
                    }
                    sideCoordArray[2 * (2* (l + 2))] = x + 1;
                    sideCoordArray[1 + 2 * (2 * (l + 2))] = y;
                    sideCoordArray[2 + 2 * (2 + (l + 2))] = x + l;
                    sideCoordArray[3 + 2 * (2 + (l + 2))] = y;
                    return sideCoordArray;
                }
            }
        return this.sideCoords;
	}
}
