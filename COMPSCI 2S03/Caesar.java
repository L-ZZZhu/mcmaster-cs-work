public class Caesar {
	
	public static void main(String[] args) {
		String message = "O&gs&ixuyyotm&znk&X{hoiut4";
		
		System.out.println(message);
		System.out.println(suggest_key(message, ' '));
		System.out.println(decrypt(message, suggest_key(message, ' ')));
		
		
		//message = encrypt("the mitochondria is the powerhouse of the cell", 55);
		//System.out.println(message);
		//System.out.println(decrypt(message, 55));
		
		
	}
	
	public static String encrypt(String message, int key) {
		String s = "";
		for(int i = 0; i < message.length(); i++) {
			s = s + (char)(message.charAt(i) + key);
		}
		return s;
	}
	
	public static String decrypt(String message, int key) {
		String s = "";
		for(int i = 0; i < message.length(); i++) {
			s = s + (char)(message.charAt(i) - key);
		}
		return s;
	}
	
	public static int num_of_occurrences(char c, String s) {
		int occ = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				occ++;
			}
		}
		return occ;
		
	}
	
	public static int suggest_key(String message, char guess) {
		int most_occ = 0;
		char most_occ_char = message.charAt(0);
		for(int i = 0; i < message.length(); i++) {
			if(num_of_occurrences(message.charAt(i), message) > most_occ) {
				most_occ = num_of_occurrences(message.charAt(i), message);
				most_occ_char = message.charAt(i);
			}
		}
		return most_occ_char - guess;
		
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * public static String encrypt(String message, int key) {
		String s = "";
		for(int i = 0; i < message.length(); i++) {
			s = s + (char)(message.charAt(i) + key);
		}
		return s;
	}
	
	public static String decrypt(String message, int key) {
		String s = "";
		for(int i = 0; i < message.length(); i++) {
			s = s + (char)(message.charAt(i) - key);
		}
		return s;
	}
	
	public static int suggestKey(String message, char guess) {
		char common = 'a';
		int mostOcc = 0;
		for(int i = 0; i < message.length(); i++) {
			if(numOfOccurrences(message.charAt(i),message) > mostOcc) {
				mostOcc = numOfOccurrences(message.charAt(i),message);
				common = message.charAt(i);
			}
		}
		return (int)(common-guess);
		
	}
	
	public static int numOfOccurrences(char c, String s) {
		int total = 0;
		for(int i = 0; i< s.length(); i++) {
			if(s.charAt(i) == c) {
				total++;
			}
		}
		return total;
	}
	 */
}
