package Queue;

public class ExamQueue {

	private int[] values;
	private int length;
	private int front;
	private int back;
	
	public ExamQueue() {
		this.values = new int[100];
		this.length = 0;
		this.front = 0;
		this.back = 0;
	}
	
	public void removeBack() {
		if (length==0) return;
		int number=front;
		removeBack_help(number);
	}

	private void removeBack_help(int number){
		if (number==front+length){
			values[number]=0;
			length--;
			back--;
		}
		else {
			number++;
			removeBack_help(number);
		}

	}


	public void add(int value) {
		values[back] = value;
		length++;
		if(back == values.length - 1) {
			back = 0;
		}
		else {
			back++;
		}
	}
	
	public int remove() {
		int value = values[front];
		length--;
		if(front == values.length - 1) {
			front = 0;
		}
		else {
			front++;
		}
		return value;
	}
	
	public boolean isEmpty() {
		return front == back;
	}
	
	public int getLength() {
		return length;
	}
	
	public void print() {
		for(int i = front; i < back; i++) {
			System.out.print(values[i] + ",");
		}
		System.out.print("\n");
	}
}
