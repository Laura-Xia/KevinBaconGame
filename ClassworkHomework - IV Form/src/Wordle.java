import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Wordle {
	//setup 2d array for game board display
	public void setup(String[][] arr) {
		arr[0][0] = "What is your guess?";
		//space for user input and user feedback
		for(int i=1; i<13; i++) {
			arr[i][0] = "[";
			arr[i][1] = "     ";
			arr[i][2] = "]";
		}
		//instructions
		arr[13][0] = "* = letter in correct position, @ = letter is present, X = letter not found";
		//show remaining valid letters.
		arr[14][0] = "Letters remaining: ";
		for(int i = 1; i<27; i++) {
			arr[14][i] = Character.toString(i+64)+" ";
		}
		arr[15][0] = "What is your guess?";
		arr[16][0] = "Enter guess: ";
	}
	//print out the game board
	public void out(String[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]!=null&&j<=arr[i].length-2) System.out.print(arr[i][j]);
				else if(arr[i][j]!=null&&j==arr[i].length-1) System.out.println(arr[i][j]+"\n");
				else if(arr[i][j]==null&&j==arr[i].length-1&&i!=arr.length-1) System.out.println("\n");
			}
		}
	}
	//refer to the wordle word list to check if the word is valid
	public boolean valid(String w)throws Exception{    
        FileReader fr=new FileReader("wordle.txt");    
        BufferedReader br=new BufferedReader(fr);    
        //read the .txt file 
        while (br.ready()) {
        	//see if words in file match input
            if (br.readLine().equalsIgnoreCase(w)) {
           	 br.close();    
                fr.close(); 
           	 return true; 
            }
        }
        br.close();    
        fr.close();    
        return false;
	}    
	//return string of user feedback and remove invalid letters, w is the user input, ans is the target word
	public String check(String w, String ans, String[] arr) {
		String res = "";
		for (int i = 0; i<5; i++) {
			if (w.charAt(i)==ans.charAt(i)) {
				//if letter at right position, add *
				res += "*";
			}
			else {
				for (int j = 0; j<6; j++) {
					if (j<5) {
						if (w.charAt(i)==ans.charAt(j)) {
							//if letter present but not at right position, add @
							res += "@";
							//if printed @, break, so don't print X
							break;
						}
					}
					else {
						//if letter not present, add X
						res += "X";
						//"kill" invalid letters from display board
						kill(w.charAt(i), arr);
					}
				}
			}
		}
		//return string of user feedback
		return res;
	}
	//tell user if the input is not a word
	public String output(boolean b) {
		if (b==false) {
			return "This is not a valid word";
		}
		else {
			return null;
		}
	}
	//randomly select word to be the answer of the game
	public String word() throws IOException {
		int i = ThreadLocalRandom.current().nextInt(1, 2316);
		String line;
		try (Stream<String> lines = Files.lines(Paths.get("Dictionary.txt"))) {
			//generate random number to access the word on the line marked with that number
		    line = lines.skip(i-1).findFirst().get();
		}
		return line;
	}
	//remove letters that had been guessed and are not present in the final answer
	public String[] kill(char w, String[] arr) {
		for(int i = 0; i<5; i++) {
			//ignore case of input and convert to ascii of the capitalized letter. 
			int inter = Character.toUpperCase(w);
			arr[inter-64] = "# ";
		}
		return arr;
	}
	
	public static void main(String[] args) throws Exception {
		//construct array for game board
		String[][] arr = new String[17][27];
		//mark which valid input the user is on, help to place user input on game board
		int index = 1;
		Scanner in = new Scanner(System.in);
		Wordle r = new Wordle();
		//generate random target word 
		String tar = r.word();
		//boolean to decide if the word is guessed
		boolean g = false;
		//mark which valid input the user is on, help move through the while loop
		int i = 0;
		//setup the array
		r.setup(arr);
		//print out the initial game board
		r.out(arr);
		//give user 6 chances
		while(i<6) {
			//get user input
			String guess = in.nextLine();
			//if word guessed is not a five letter word, tell them input is invalid
			if(guess.length()!=5) {
				System.out.println(r.output(false));
				r.out(arr);
			}
			//if word is not a valid word, tell them input is invalid
			else if(r.valid(guess)==false) {
				System.out.println(r.output(false));
				r.out(arr);
			}
			//progress if word inputed is valid
			else {
				guess = guess.toLowerCase();
				//convert guess to lower case and input in game board
				arr[index][1] = guess;
				//print out user feedback
				arr[index+1][1] = r.check(guess, tar, arr[14]);
				//display game board
				r.out(arr);
				//move on to next guess
				index+=2;
				//if the word is completely correct
				if (r.check(guess, tar, arr[14]).equals("*****")){
					//tell user they won
					System.out.println("Congratulations! You got it");
					//indicate user they won so the output that tells them if they lost will not appear
					g = true;
					//break from while loop, no more guesses
					break;
				}
				//if the word is not completely correct, proceed with the guess
				else{
					i++;
					continue;
				}
			}
		}
		//if the guess chances are all used up and g is still false(word is still not guessed)
		if (g==false) {
			//tell them they lost and give them the answer
			System.out.println("\n");
			System.out.println("You lost. boo");
			System.out.println("The word is "+tar);
		}
	}
}
