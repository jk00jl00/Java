public class Ship{
	char dir;
	int length;
	char[] graphics;


	public Ship(char d, int l){
		dir = d;
		length = l;
		graphics = new char[length];
		switch(dir){
			case 'N': for(int i = 0; i < length; i++){
					if(i == 0){
						graphics[i] = '-';
					}
					else if (i == length - 1) {
						graphics[i] = 'A';
					}
					else{
						graphics[i] = 'I';
					}
				}
				break;

			case 'E': for(int i = 0; i < length; i++){
					if(i == 0){
						graphics[i] = 'I';
					}
					else if (i == length - 1) {
						graphics[i] = '>';
					}
					else{
						graphics[i] = '=';
					}
				}
				break;

			case 'S': for(int i = 0; i < length; i++){
					if(i == 0){
						graphics[i] = '-';
					}
					else if (i == length - 1) {
						graphics[i] = 'V';
					}
					else{
						graphics[i] = 'I';
					}
				}
				break;
			case 'W': for(int i = 0; i < length; i++){
					if(i == 0){
						graphics[i] = 'I';
					}
					else if (i == length - 1) {
						graphics[i] = '<';
					}
					else{
						graphics[i] = '=';
					}
				}
				break;
		}
	}
	public int getLength(){
		return length;
	}
	public char getGraphics(int a){
		return graphics[a];
	}
	public char getDir(){
		return dir;
	}
}