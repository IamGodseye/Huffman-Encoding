package huffman_encoding_for_size_reduction;

import java.util.*; 

public class HuffmanEncoder {
	// 2 hash maps for encoding and decoding the string
	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	//Create Node of the tree and put them in min heap (here implemented using Priority queue)
	private class Node implements Comparable<Node>{
		char data;
		int cost;
		Node left;
		Node right;
		Node(char data,int cost){
			this.data=data;
			this.cost=cost;
			this.left=this.right=null;
		}
			
		public int compareTo(Node n) {
			return this.cost-n.cost;
		}
	}
	

	public HuffmanEncoder(String s) {
		//Create frequency map of the string
		HashMap<Character, Integer> frequency_map=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char current_char= s.charAt(i);
			if(frequency_map.containsKey(current_char)) {
				int old_freq=frequency_map.get(current_char);
				old_freq++;
				frequency_map.put(current_char,old_freq);
			}
			else {
				frequency_map.put(current_char,1);
			}
		}
	
	//minimum heap with priority queue
		PriorityQueue<Node> p=new PriorityQueue<>();
		
		for(char c:frequency_map.keySet()) {
			int cost=frequency_map.get(c);
			Node n = new Node(c,cost);
			p.add(n);
		}
	
		//work on it till we get priority queue of size 1 
		//as usual remove 2 nodes and add 1 big node in priority queue
		
		while(p.size()!=1) {
			Node n1=p.remove();
			Node n2=p.remove();
			
			int cost=n1.cost+n2.cost;
			char data='\0';
			
			Node big_node=new Node(data,cost);
			big_node.left=n1;
			big_node.right=n2;
			
			p.add(big_node);
		}
		
		//Now fill the encoder and decoder
		//First initialize the hash maps
		
		this.encoder=new HashMap<>();
		this.decoder=new HashMap<>();
		Node last=p.remove();
		fill_Encoder_Decoder(last,"");
		
		System.out.println(encoder);
		System.out.println(decoder);
	
	
	}
	private void fill_Encoder_Decoder(Node l,String s) {
		//Base case => return when we hit leaf node
		if(l.left==null && l.right==null) {
			encoder.put(l.data,s);
			decoder.put(s,l.data);
			return;
		}
		//Add 0 to the string for left child
		//and 1 to the string for right child
		fill_Encoder_Decoder(l.left,s+"0");
		fill_Encoder_Decoder(l.right,s+"1");
	}
	//To encode the string
	public String encode(String s) {
		String ans="";
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			ans+=encoder.get(c);
		}
		return ans;
	}
	//To decode the string 
	public String decode(String s) {
		String ans="";
		String key="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			key+=c;
			if(decoder.containsKey(key)) {
				ans+=decoder.get(key);
				key="";
				
			}
		}
		return ans;
	}
}
