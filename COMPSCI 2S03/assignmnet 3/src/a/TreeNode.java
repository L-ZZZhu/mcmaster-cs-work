package a;
public class TreeNode {

	public boolean isWord;
	public TreeNode[] children;
	
	public TreeNode() {
		isWord = false; //This being true corresponds to the node being green in the .pdf
		children = new TreeNode[26];
	}
}
