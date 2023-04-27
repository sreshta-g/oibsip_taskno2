import java.util.Scanner;
import java.util.Random;

//Game class
class RoundGames{
	
	int inputFromSystem;
	int inputFromUser;
	int countGuesses=0;
	
	//Generating random number in default constructor
	RoundGames(){
		Random random=new Random();
		this.inputFromSystem=random.nextInt(100)+1;
	}
	
	//method to take user guesses
	public boolean takeUserInput() {
		if(countGuesses <10) {
			System.out.print("number guess :");
			this.inputFromUser=GuessTheNumber.takeIntegerInput(100);
			countGuesses++;
			return false;
		}
		else {
			System.out.println("oof attempts finised...next time better luck");
			return true;
			
		}
	}
	
	//method to check user guess status
	
	public boolean isCorrectGuess() {
		if(inputFromSystem==inputFromUser) {
			System.out.println("you found number , congo : "+inputFromSystem+"in"+countGuesses+"guesses");
			switch(countGuesses) {
			case 1:
				System.out.println("100 score points");
				break;
			case 2:
				System.out.println( "90 score points");
				break;
			case 3:
				System.out.println("80 score points");
				break;
			case 4:
				System.out.println(" 70 score points");
				break;
			case 5:
				System.out.println("60 score points");
				break;
			case 6:
				System.out.println("50 score points");
				break;
			case 7:
				System.out.println("40 score points");
				break;
			case 8:
				System.out.println(" 30 score points");
				break;
			case 9:
				System.out.println(" 20 score points");
				break;
			case 10:
				System.out.println("10 score points");
				break;
			}
			System.out.println();
			return true;
		}
		else if(countGuesses < 10 && inputFromUser>inputFromSystem) {
			if(inputFromUser-inputFromSystem>10) {
				System.out.println("very High");
			}
			else {
				System.out.println("bit High");
			}
		}
		else if(countGuesses<10 && inputFromUser<inputFromSystem) {
			if(inputFromSystem -inputFromUser >10) {
				System.out.println("very Low");
			}
			else {
				System.out.println("bit Low");
			}
		}
		return false;
	}
}
 //main class
public class GuessTheNumber {
 
	public static int takeIntegerInput(int limit) {
		int inputs=0;
		boolean temp =false;
		
		while(!temp) {
			try {
				Scanner sc=new Scanner(System.in);
				inputs=sc.nextInt();
				temp=true;
				
				if(temp && inputs>limit ||inputs <1) {
					System.out.println("Choose the number  between 1 to "+limit);
					temp=false;
					
				}
			}
			catch(Exception e) {
				System.out.println("Enter only integer value :");
				temp=false;
			}
		};
		return inputs;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//input for start the game
		System.out.println("1.Start the game \n2.Exit");
		System.out.println("Enter your choice :");
		int choice =takeIntegerInput(2);
		int nextRounds=1;
		int roundNo=0;
		
		if(choice ==1) {
			//to check next round is there or not
			
			while(nextRounds ==1) {
				//creating object of Game class
				RoundGames game=new RoundGames();
				boolean isMatches =false;
				boolean isLimitCrosses=false;
				System.out.println("\nRound "+ ++roundNo + "status ...");
				
				//to check correct guess and limit cross
				while(!isMatches && !isLimitCrosses){
					isLimitCrosses =game.takeUserInput();
					isMatches =game.isCorrectGuess();
					
				}
				//input for next round
				System.out.println("1.Next Round \n2.Exit");
				System.out.println("Enter your choice : ");
				nextRounds= takeIntegerInput(2);
				if(nextRounds != 1) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}


	}

}