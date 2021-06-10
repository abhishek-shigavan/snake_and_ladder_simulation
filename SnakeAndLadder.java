/**
 * SnakeAndLadder 
 *
 * Program to roll dice and get result.
 * Also checking the playing condition.
 * i.e No Play / Ladder / Snake
 * Rolling the dice till winning condition is reached.
 * 
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
	
	public static void main(String[] args) {

		//initial player position
		int playerPosition=0;
		
		System.out.println("Welocme to Snake and Ladder Game...!!!");
		
		while(playerPosition < WIN_POSITION) {

			if(playerPosition >= START_POSITION ) {
				int diceNumber = (int)(Math.floor(Math.random() * 10) % 6)+1;
		
				int playingOption = (int)(Math.floor(Math.random() * 10) % 3);
		
				if(playingOption == IS_LADDER) {
					playerPosition +=diceNumber;
				}
				else if(playingOption == IS_SNAKE){
					playerPosition -=diceNumber;
				}
				else {
					playerPosition=playerPosition; //NO_PLAY condition
				}
			}
			else {
				//if player position is less than 0 (i.e START_POSITION) then again start from 0
				playerPosition=START_POSITION; 
			}
		}
		System.out.println("Player reach at "+playerPosition+" We got winner");
	}
}

