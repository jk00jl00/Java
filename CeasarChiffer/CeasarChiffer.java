import java.util.*;
import java.io.*;

public class CeasarChiffer{

	public static void main(String[] args) {
		String inPut = "";
		System.out.println("Enter ");
		int shift = 0;
		String pause = "";
		while (shift == 0){
			Scanner sc = new Scanner(System.in);
			try{
				shift = sc.nextInt();
			}catch (java.util.InputMismatchException e){
				System.out.println("Enter a integer insted");
			}	

			if (shift > 25){
				System.out.println("Enter a lower integer");
			}
			else if (shift < -25) {
				System.out.println("enter a higher integer");
			}
		}

		System.out.println("Fill in the input.txt and press enter");
		Scanner sc = new Scanner(System.in);
		pause = sc.nextLine();


		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			while (inFile.hasNextLine()){
				inPut = inPut + inFile.nextLine();
			}

		}catch(java.io.FileNotFoundException ex){
			System.out.println("No input found");
		}

		char[] inArray = new char[inPut.length()];
		inArray = inPut.toCharArray();


		for (int i = 0; i < inPut.length(); i++){
			if (inArray[i] != ' ' && !((int) inArray[i] + shift > (int) 'z' || ((int) inArray[i] + shift > 'Z' && (int) inArray[i] < (int) 'a'))){
				int a = (int)inArray[i];
				a = a + shift;
				inArray[i] = (char) a;
			}

			else if (((int)inArray[i] + shift > (int)'z')|| ((int)inArray[i] + shift > (int)'Z' && (int)inArray[i] + shift <= (int)'a' )) {
				int a = (int)inArray[i];
				a = a + shift;
				a = a - 26;
				inArray[i] = (char) a;
				
			}

		}
		String outPut = new String(inArray);

		try(Writer outWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"))) {
			outWriter.write(outPut);
		} catch (IOException e){
			System.out.println("hi");
		}
		System.out.println("All done");
	
	}
}