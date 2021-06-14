/**
 * SnakeAndLadder 
 * 
 * Snake And Ladder game simulation.
 * 
 * Program to simulate SnakeAndLadder game with 2 Players.
 * 
 * Rolling dice one by one
 * Also checking the playing condition.
 * i.e No Play / Ladder / Snake
 * For ladder playing game once again
 * Rolling the dice till exact winning condition is reached.
 * Displaying the winner
 * 
 * @author    Abhishek Shigavan
 */
public class SnakeAndLadder {

	//constant... Playing Conditions of Game
	public static final int NO_PLAY =0;
	public static final int IS_LADDER=1;
	public static final int IS_SNAKE=2;
	public static final int START_POSITION=0;
	public static final int WIN_POSITION=100;
/**
 * 
 * This method creates random number between 1-3
 * and according to it select playing condition
 * 
 *  according to playing condition returns result
 * 
 * @return returning result (i.e dice no)
 *         
 */	
	public static int playCondition(int diceNumber) {
		
		int playingOption = (int)(Math.floor(Math.random() * 10) % 3);
		int result =0;
		
			if(playingOption == IS_LADDER) {
				result += diceNumber;	//returning dice no 
			}
			else if(playingOption == IS_SNAKE){
				result = 0 - diceNumber;	//returning negative dice no
			}
			else {
				result= 0;	//NO_PLAY condition
			}
		return result;
		
	}
/**
 * 
 * This method computes creates random no 
 * between 1-6 and returns it as dice number
 * 
 * @return dice number
 *         
 */	
	public static int getDiceNumber() {
	
		 int diceNumber = (int)(Math.floor(Math.random() * 10) % 6)+1;
		 return diceNumber;
	}
	
	public static void main(String[] args) {

		//initial player1 position
		int player1Position =0;
		
		//initial player2 position
		int player2Position =0;
		
		int diceNumber=0;
		int gameCounter=0;
		int player1Result = 0;
		int player2Result = 0;
		
		int flag = 1;
		int winnerFlag =0;
		
		System.out.println("Welocme to Snake and Ladder Game...!!!");
		
		while(player1Position <= WIN_POSITION && player2Position <= WIN_POSITION ) {
			
			flag =1;	//to start game from Player1
			gameCounter++;
			
				// player1
				while(flag == 1) {
					diceNumber = getDiceNumber();
					player1Result = playCondition(diceNumber);
					player1Position += player1Result;
						
						//checking for ladder
						if(player1Position >=0 && player1Result == diceNumber) {
							flag =1;	//playing again
						}
						else if(player1Position < 0){
							// if position is below 0 then again start from 0 
							player1Position = START_POSITION;	
							flag = 2;
						}
						else {
							flag =2;	//moving to player2
						}
						
						//checking for exact win position...going back to previous position if it exceed
						if(player1Position > WIN_POSITION ) {
							
							player1Position -= player1Result;
						}
				}
			
				// player2
				while(flag == 2) {
					diceNumber = getDiceNumber();
					player2Result = playCondition(diceNumber);
					player2Position += player2Result;
					
						//playing again if got ladder
						if(player2Position >= 0 && player2Result == diceNumber) {
							flag =2;	//to run loop again
						}
						//again starting from 0 if position < 0
						else if(player2Position < 0){
							player2Position = START_POSITION;
							flag =1;
						}
						else {
							flag =1;
						}
						
						//going back to previous position if it exceed Winning position 
						if(player2Position > WIN_POSITION ) {
							
							player2Position -= player2Result;
						}
				
				}
				
				// checking for winner 
				if(player1Position == WIN_POSITION) {
					winnerFlag =1;
					break;
				}
				else if(player2Position == WIN_POSITION) {
					winnerFlag =2;
					break;
				}
			
		}

		System.out.println("Total games played : "+gameCounter);
		System.out.println("Player 1 position : "+player1Position);
		System.out.println("Player 2 position : "+player2Position);
		
		//Displaying Winner
		if(winnerFlag == 1) {
			System.out.println("Player 1 is the Winner...!!!");
		}
		else {
			System.out.println("Player 2 is the Winner...!!!");
		}

	}
}


