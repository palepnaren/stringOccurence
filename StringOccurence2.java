
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class StringOccurence2 {

//	asdjkdAj
	public static void main(String[] args) {
		int count =0;
		
		System.out.println("Enter the String: ");
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		
		char[] charArray = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		LinkedList<Mapping> list = new LinkedList<Mapping>();
		
		for(char c: charArray) {
			Mapping repetetive = checkStringIfRepetetive(c,str);
			list.add(repetetive);
		}


		Collections.sort(list, new ValueSort().thenComparing(new KeySort()));
		
		System.out.println(list);
		
		
		for (Mapping mapping : list) {
			
//			System.out.println(mapping.getKey()+"--"+mapping.getValue());
			
			if(mapping.getValue() ==1) {
				builder.append(mapping.getKey());
			} else {
				builder.append(mapping.getKey());	
			}
			
		}
		
		System.out.println("You first non-repetitive string is: "+list.get(0).getKey());
		System.out.println("Final Solution String: "+ builder.toString());
		
		
		
	}

	private static Mapping checkStringIfRepetetive(char c, String str) {
		int count = 0;
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			if(Character.toString(str.charAt(i)).equalsIgnoreCase(Character.toString(c))) {
				count++;
			}
		}
		
		
		Mapping mapping = new Mapping();
		mapping.setKey(c);
		mapping.setValue(count);
		
		return mapping;
		
	}

}

class Mapping{
	private Character key;
	private int value;
	
	public char getKey() {
		return key;
	}
	public void setKey(Character key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		
		return "{Char: " +key+" value: "+value+"}";
	}
	
}

class ValueSort implements Comparator<Mapping>{

	@Override
	public int compare(Mapping o1, Mapping o2) {
		return o1.getValue() - o2.getValue();
	}
	
}

class KeySort implements Comparator<Mapping>{

	@Override
	public int compare(Mapping o1, Mapping o2) {
		if(o1.getValue() >1 && o2.getValue()>1) {
			if(Character.toString(o2.getKey()).compareTo(Character.toString(o1.getKey()).toUpperCase()) == 0) {
				System.out.println("I am inside: "+o1.getKey()+" comparing with "+o2.getKey());
				return Character.toString(o2.getKey()).compareToIgnoreCase(Character.toString(o1.getKey()));
			} 
			else {
				return Character.toString(o2.getKey()).compareTo(Character.toString(o1.getKey()));
			}
//			return Character.toString(o1.getKey()).compareTo(Character.toString(o2.getKey()));
				
		}
			
		else
			return o1.getValue() - o2.getValue();
	}
	
}
