/**
 * Ett spel där man presenteras ett antal ord och ska gissa antal konsonanter i orden.
 * @author Joakim Vallin, joaval-6
 */
import java.util.Scanner;
public class Tentamen_HT16_joaval6
{
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String[] words = new String[10];
		int correctAnswer;
		int yourAnswer;
		int numberOfAnswers;
		int numberOfWrongAnswers;
		int end = 1;
		
		while (end == 1)
		{
			numberOfAnswers = 0;
			numberOfWrongAnswers = 0;
			
			System.out.println("\nVälkommen till konsonantspelet.\nI det här spelet så är målet att gissa antal konsonanter i ett ord.\n");
			int gameMode = input("Välj spelläge.\n1. Stora bokstäver.\n2. Små bokstäver.\n");
			
			while (gameMode > 2 || gameMode < 1)
			{
				gameMode = input("Ange siffran 1 eller 2 för att välja spelläge. ");
			}
			
			fillArray(words,gameMode);
			
			for (int i = 0; i < words.length; i++)
			{
				correctAnswer = answer(words[i]);
				yourAnswer = input("Hur många konsonanter innehåller ordet " + words[i] + "? ");
				numberOfAnswers++;
				while (correctAnswer != yourAnswer)
				{
					yourAnswer = input("Det var tyvärr fel, försök igen. ");
					numberOfAnswers++;
					numberOfWrongAnswers++;
				}
				System.out.println("Rätt! Följande är konsonanter " + removeVowels(words[i]) + ".\n");
			}
			
			System.out.println("\nDu gissade totalt " + numberOfAnswers + " gånger och " + numberOfWrongAnswers + " gånger gissade du fel.");
			
			end = input("Vill du spela igen? 1. Ja 2. Avsluta ");
			while (end > 2 || end < 1)
			{
				end = input("Felaktig inmatning. Ange 1 för att spela igen eller 2 för att avsluta. ");
			}
		}
		System.out.println("\nTack för att du spelade!");
	}
	
	public static int input(String msg) 
	{
		System.out.print(msg);  
		while (in.hasNextInt()) 
		{
				return Math.abs(in.nextInt());
		}
		in.next(); 
		return (input("Ange en siffra. ")); 
	}
	
	public static String[] fillArray (String words[], int gameMode)
	{
		words[0] = "stad";
		words[1] = "inledning";
		words[2] = "ledarskap";
		words[3] = "vägledning";
		words[4] = "lärare";
		words[5] = "pilot";
		words[6] = "rättvisa";
		words[7] = "demonstration";
		words[8] = "fiktion";
		words[9] = "bedömning";
		
		if (gameMode == 1)
		{
			for (int i = 0; i < words.length; i++)
			{
				words[i] = words[i].toUpperCase();
			}
		}
		
		return words;
	}
	
	public static int answer(String word) 
	{
		final String CONSONANTS = "bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ"; 
		String oneChar = ""; 
		int numberOfConsonants = 0;
		for(int i = 0; i < word.length(); i++) 
		{
			oneChar = word.substring(i, i+1); 
			if (CONSONANTS.indexOf(oneChar) != -1)
			{
				numberOfConsonants++;
			} 
		} 
		return numberOfConsonants;
	}
	
	public static String removeVowels(String word)
	{
		final String CONSONANTS = "bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ"; 
		String oneChar = ""; 
		String withoutVowels = "";
		for(int i = 0; i < word.length(); i++) 
		{
			oneChar = word.substring(i, i+1); 
			if (CONSONANTS.indexOf(oneChar) != -1)
			{
				withoutVowels += oneChar;
			} 
		} 
		return withoutVowels;
	}
}
