package a;
import java.util.ArrayList;

public class WordTree {
	
	private TreeNode root;

	public WordTree() {
		root = new TreeNode(); 
	}
	
	public int numOfWords(){
		return numOfWordsRec(root);
	}
	
	private int numOfWordsRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int childrenWords = 0;
		for(int i = 0; i < 26; i++) {
			childrenWords += numOfWordsRec(node.children[i]);
		}
		if(node.isWord) {
			return 1 + childrenWords;
		}
		return childrenWords;
	}
	
	public void insertWord(String word) {
		insertWordRec(root, word);
	}
	
	private void insertWordRec(TreeNode node, String word) {
		char firstChar = word.charAt(0);
		if(word.length() == 1) {
			if(node.children[letterToInt(firstChar)] == null) {
				node.children[letterToInt(firstChar)] = new TreeNode();
				node.children[letterToInt(firstChar)].isWord = true;
			}
			else {
				node.children[letterToInt(firstChar)].isWord = true;
			}
		}
		else {
			String restOfWord = word.substring(1);
			if(node.children[letterToInt(firstChar)] == null) {
				node.children[letterToInt(firstChar)] = new TreeNode();
				insertWordRec(node.children[letterToInt(firstChar)], restOfWord);
			}
			else {
				insertWordRec(node.children[letterToInt(firstChar)], restOfWord);
			}
		}
	}
	
	public boolean contains(String word) {
		return containsRec(root, word);
	}
	
	public boolean containsRec(TreeNode node, String word) {
		if(word == "") {
			return node.isWord;
		}
		char firstChar = word.charAt(0);
		if(node.children[letterToInt(firstChar)] == null) {
			return false;
		}
		else {
			String restOfWord;
			if(word.length()==1) {
				restOfWord = "";
			}
			else {
				restOfWord = word.substring(1);
			}
			return containsRec(node.children[letterToInt(firstChar)], restOfWord);
		}
	}
	
	public ArrayList<String> suggestCorrections(String word, int offBy){
		TreeNode work=root;
		int length=word.length();
		int num=0;
		ArrayList<String> ans=new ArrayList<String>();
		String front="";
		String wodd="";
		for (int i=0;i<word.length();i++){
			if (word.charAt(i)=='x'){
				num++;
			}
			if (num==word.length()){
				Auto_Suggest(offBy,front,wodd,ans,work);
				return ans;
			}
		}
		for (int i=0;i<length;i++){
			char firstChar=word.charAt(i);
			if (work.children[letterToInt(firstChar)]==null){
				return ans;
			}
			if (i==(length-1) && work.children[letterToInt(firstChar)].isWord){
				ans.add(word);
			}
			work=work.children[letterToInt(firstChar)];
		}
		String back="";
		Auto_Suggest(offBy,word,back,ans,work);
		return ans;
	}

	private ArrayList<String> Auto_Suggest(int num, String front, String back, ArrayList<String> ans, TreeNode node) {
		if (num != 0) {
			for (int x = 0; x < 26;x++) {
				if (node.children[x] == null) {
					continue;
				}
				if (node.children[x] != null) {
					if (node.children[x].isWord) {
						back = back + intToLetter(x);
						ans.add(front + back);
						node = node.children[x];
						num--;
						System.out.println("lov " + x + "  " + num);
						try {
							Auto_Suggest(num, front, back, ans, node);
						} catch (NullPointerException e) {
							break;
						}
						break;
					}

					try {
						if (!node.children[x].isWord) {
							back = back + intToLetter(x);
							num--;
							node = node.children[x];
							Auto_Suggest(num, front, back, ans, node);
							break;
						}
					} catch (NullPointerException e) {
						break;
					}
				}
			}
		}
		return ans;

	}
	
	public ArrayList<String> suggestAutoCompletes(String prefix){
		TreeNode work=root;
		int length=prefix.length();
		ArrayList<String> ans=new ArrayList<String>();
		String front=prefix;
		for (int i=0;i<length;i++){
			char firstChar=front.charAt(i);
			if (work.children[letterToInt(firstChar)]==null){
				return ans;
			}
			if (i==(length-1) && work.children[letterToInt(firstChar)].isWord){
				ans.add(prefix);
			}
			work=work.children[letterToInt(firstChar)];

		}

		String buffer="";
		ans=Auto_help(prefix,buffer,work,ans);


		return ans;
	}
	private ArrayList<String> Auto_help(String the_front, String back, TreeNode node, ArrayList<String> ans){
		for (int i=0;i<26;i++){
			if (node.children[i]!=null){
				if (node.children[i].isWord){
					back=back+intToLetter(i);
					node=node.children[i];
					ans.add(the_front+back);
					try {
						Auto_help(the_front, back, node, ans);
					}catch (NullPointerException e){
						break;
					}
				}
				try {
					if (!node.children[i].isWord) {
						back = back + intToLetter(i);
						node = node.children[i];
						try {
							Auto_help(the_front, back, node, ans);
						} catch (NullPointerException e) {
							break;
						}
					}
				}catch (NullPointerException e) {
					break;
				}
			}
			else continue;
		}
		return ans;
	}
	
	public ArrayList<String> addToEach(char c, ArrayList<String> words) {
		TreeNode the_word =new TreeNode();
		TreeNode ans=the_word;
		the_word.children[letterToInt(c)]=root;
		ArrayList<String> work=new ArrayList<String>();
		String buffer;
		for( int i=0;i<words.size();i++){
			buffer=c+words.get(i);
			work.add(buffer);
		}

		for (int i=0;i<words.size();i++){
			TreeNode love =root;
			String lalal= words.get(i);
			for (int x=0;x<words.get(i).length();x++){
				char local=lalal.charAt(x);
				if(love.children[letterToInt(local)] == null) {
					love.children[letterToInt(local)] = new TreeNode();
				}
				love=love.children[letterToInt(local)];
				if (x==lalal.length()-1){
					love.children[letterToInt(local)] = new TreeNode();
					love.children[letterToInt(local)].isWord=true;
				}
			}
		}
		return work;
	}
	
	//Will return 0 for 'a', 25 for 'z', etc.
	public int letterToInt(char c) {
		return c - 97;
	}
	
	public char intToLetter(int i) {
		return (char)(i + 97);
	}
	
}
