package linkedlist;

public class ExamLinkedList {

	public ExamNode front;
	public ExamNode back;
	private int length;

	public ExamLinkedList(ExamNode node) {
		front = node;
		back = node;
		length = 1;
	}

	public ExamLinkedList() {
		length = 0;
	}

	public void interleave(ExamLinkedList L) {
		ExamNode node=front;
		ExamNode side=L.front;
		ExamNode work=front;
		int L_length=L.getLength();
		int Length=getLength();
		int number=0;
		node=node.next;
		int l=0;
		if (L_length>Length){
			l=2*Length;
		}else l=2*L_length;

		front=work;
		interleave_help(number,side,node,l,work,Length,L_length);
		length=(Length+L_length);
		//System.out.println(length);


	}
	private void interleave_help(int number,ExamNode L,ExamNode ans,int length,ExamNode work,int Length,int L_Length){
		//System.out.println(work.value);
		if (number < length) { //System.out.println(number+"   "+length);
			if (number % 2 == 0) {//System.out.println(L.value);
				work.next = L;
				if (work.next != null) {
					work = work.next;
				}
				if (L.next != null) {
					L = L.next;
				}
				number++;
				interleave_help(number, L, ans, length, work,Length,L_Length);
			} else if (number % 2 == 1) {//System.out.println(ans.value);
				work.next = ans;
				if (work.next != null) {
					work = work.next;
				}
				if (ans.next != null) {
					ans = ans.next;
				}
				number++;
				interleave_help(number, L, ans, length, work,Length,L_Length);
			}
		}
		else if (Length>L_Length){//System.out.println(number+" da  "+length);
			work.next=L;
			//System.out.println(L.next.value);
		}
		else if (L_Length>Length){
			work.next=ans;
			//System.out.println(number+" da  "+length);
		}
		else return;
	}




	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int getLength() {
		return length;
	}
	
	public void appendFront(int value) {
		ExamNode node = new ExamNode(value);
		if(isEmpty()) {
			front = node;
			back = node;
		}
		else {
			node.next = front;
			front = node;
		}
		length++;
	}
	
	public void appendBack(int value) {
		ExamNode node = new ExamNode(value);
		if(isEmpty()) {
			front = node;
			back = node;
		}
		else {
			back.next = node;
			back = node;
		}
		length++;
	}
	
}
