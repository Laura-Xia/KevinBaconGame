import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		HashMap<String, String> m=new HashMap<String, String>();
		BufferedReader br = null;
		try {
			br=new BufferedReader(new FileReader("wordDictionary.txt"));
			String contentLine = br.readLine();
			   while (contentLine != null) {
				  String word="";
				  int stop = 0;
				  for(int i=0; i<contentLine.length(); i++) {
					  if(contentLine.charAt(i)=='|') {
						  stop=i;
						  break;
					  }
					  word+=contentLine.charAt(i);
				  }
				  String def=contentLine.substring(stop);
				  m.put(word, def);
//				  System.out.println(contentLine);
//				  System.out.println(def);
			      contentLine = br.readLine();
			   }
		}
		catch (IOException ioe) 
	       {
		   ioe.printStackTrace();
	       } 
	       finally 
	       {
		   try {
		      if (br != null)
			 br.close();
		   } 
		   catch (IOException ioe) 
	           {
			System.out.println("Error in closing the BufferedReader");
		   }
		}
		System.out.println("Word: ");
		String w=s.nextLine();
		if(m.get(w)==null) {
			System.out.println("I don't know this word");
		}
		else {
			System.out.println(m.get(w));
		}
		System.out.println(m.size());
	}
}
