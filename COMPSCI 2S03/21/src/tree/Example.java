package tree;

public class Example {

	public static void main(String[] args) {
		MathTree tree1 = new MathTree("+");
		tree1.getChildren()[0] = new MathTree("2");
		tree1.getChildren()[1] = new MathTree("*");
		tree1.getChildren()[2] = new MathTree("-");
		tree1.getChildren()[3] = new MathTree("y");
		tree1.getChildren()[4] = new MathTree("/");

		tree1.getChildren()[1].getChildren()[0] = new MathTree("3");
		tree1.getChildren()[1].getChildren()[1] = new MathTree("x");
		
		tree1.getChildren()[2].getChildren()[0] = new MathTree("x");
		tree1.getChildren()[2].getChildren()[1] = new MathTree("k");
		tree1.getChildren()[2].getChildren()[2] = new MathTree("1");
		
		tree1.getChildren()[4].getChildren()[0] = new MathTree("k");
		tree1.getChildren()[4].getChildren()[1] = new MathTree("+");
		
		tree1.getChildren()[4].getChildren()[1].getChildren()[0] = new MathTree("y");
		tree1.getChildren()[4].getChildren()[1].getChildren()[1] = new MathTree("x");

		System.out.println(tree1.toString()); //Should output: 2+(3*x)+(x-k-1)+y+(k/(y+x))


			//MathTree tree2 = new MathTree("-");
			//tree2.getChildren()[0] = new MathTree("x");
			//tree2.getChildren()[1] = new MathTree("y");
			//tree2.getChildren()[2] = new MathTree("1");

			//System.out.println(tree2.toString()); //Should output: x-y-1

			//MathTree tree3 = new MathTree("-");
			//tree3.getChildren()[0] = new MathTree("x");
			//tree3.getChildren()[1] = new MathTree("-");

			//tree3.getChildren()[1].getChildren()[0] = new MathTree("y");
			//tree3.getChildren()[1].getChildren()[1] = new MathTree("1");

			//System.out.println(tree3.toString()); //Should output: x-(y-1)

			//MathTree tree4 = new MathTree("x");

			//System.out.println(tree4.toString()); //Should output: x

	}
	
}
