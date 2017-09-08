import java.util.*;

public class GuessNumber{
	public static void main(String[] args) {
        int a = 0;
        int play = 1;
        while (true){
            int guesses = 6;
            double doubleNumber = Math.floor(Math.random() * 100);
            int number = (int) doubleNumber;
            if (play == 1){
                while(guesses > 0){
                    System.out.println("Guess an integer Between 0 and 100");
                    try {
                        int input = getInput();
                        if (number == input){
                            System.out.println("You guessed the number!");
                            System.out.println("It was " + number + ".");
                            play = 0;
                            break;

                        }
                        else if (input <= 100 && input >= 0 && input < number) {
                            System.out.println(input + " is lower than the number.");
                            guesses--;
                                
                        }   
                        else if (input <= 100 && input >= 0 && input > number){
                            System.out.println(input + " is higher than the number.");
                            guesses--;
                        }
                        else{
                            System.out.println(input + " isn't between 0 and 100");
                        }

                        if (guesses == 0){
                            System.out.println("You ran out of guesses, the integer was " + number + ".");
                            play = 0;
                        }
                    }
                    catch(java.util.InputMismatchException e){
                        System.out.println("It looks like you tried to enter something that was not an integer,");
                        System.out.println("Try again");
                    }
                }
            }


            System.out.println("Do you want to play again, 1/0?");

            try {
                int input = getInput();
                if (0 == input){
                    break;                    
                }

                else if (1 == input){
                    play = 1;
                }
                else{
                    System.out.println(input + " is not 1 or 0, please make sure to enter the correct input!");                    
                }
                
            }

            catch(java.util.InputMismatchException e){
                System.out.println("Try to enter an integer next time!");
            }
            
            
        }
    }

    public static int getInput(){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        return a;
    }
}
