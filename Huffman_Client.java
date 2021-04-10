package huffman_encoding_for_size_reduction;
import java.util.*;
public class Huffman_Client {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string you want to encode => ");
		System.out.println("(the string should not be a null string)");
		
		String s=sc.nextLine();

		HuffmanEncoder hf = new HuffmanEncoder(s) ;
		
		String codedString=hf.encode(s);
		System.out.println("encoded String => " + codedString);
		
		String output=hf.decode(codedString);
		System.out.println("decoded String => " +output);
		
		BitSet bitset=new BitSet(codedString.length());
		int bitscnt=0;
		for(Character c: codedString.toCharArray()) {
			if(c.equals('1')) {
				bitset.set(bitscnt);
			}
			bitscnt++;
		}
		byte array[]=bitset.toByteArray();
		//each character takes 2 bytes in JAVA
		System.out.println("Normal String size in bytes => " + s.length()*2);
		System.out.println("Encoded String size in bytes => "+ array.length);
		float percent=200*s.length()/array.length;
		System.out.println("Reduced size by "+ percent+"%");
	}
}
