package comm.example_3;
import java.util.*;
public class LetterSequence {

	private String sentence;

	
	public LetterSequence() {
		super();
	}


	public LetterSequence(String sentence) {
		super();
		this.sentence = sentence;
	}


	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	private TreeMap<Character,Integer> computeFrequency(){
		char[] c=sentence.replaceAll(" ", "").toCharArray();
        int[] freq=new int[26];
        TreeMap<Character,Integer> tMap=new TreeMap<Character,Integer>();
        
        //getting the frequency of the characters and inserting into the freq array.
        for(int i=0;i<c.length;i++) {
        	
        	if(c[i]>='A' && c[i]<='Z')
        	{
        		
        		freq[(Integer)(c[i]-'A')]++;
        	}
        	else if(c[i]>='a' && c[i]<='z') {
        		freq[(Integer)(c[i]-'a')]++;
        	}
        }
        
        //storing into the treeMap
        for(int i=0;i<26;i++) {
        	if(freq[i]>0) {
        		tMap.put((char)(i+'a'),freq[i]);
        	}
        }
        
		return tMap;
	}
	public void displayLetterfrequency(TreeMap<Character,Integer>frequencyMap) {
		
		
	}
}
