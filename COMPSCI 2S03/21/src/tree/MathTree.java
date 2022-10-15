package tree;

public class MathTree {

	private MathTree[] children;
	private String value;

	public MathTree(String value) {
		this.value = value;
		children = new MathTree[5];
	}

	public boolean isOperator() {
		return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
	}

	public boolean isTerminal() {
		return !isOperator();
	}

	public MathTree[] getChildren() {
		return children;
	}

	public String toString() {
		String ans = "";
		int number = 0;
		System.out.println(children[2].value);
		ans = to(ans, number);
		return ans;
	}

	private String to(String ans, int number) {
		for (int i = 0; i < 5; i++) {
			if (getChildren()[i] != null) {
				ans = ans + getChildren()[i].value;
				for (int x = 0; x < 5; x++) {
					if (getChildren()[i].getChildren()[x] != null) {
						ans = ans + getChildren()[i].getChildren()[x];
					}

				}
			}
		}
		return ans;
	}
}
