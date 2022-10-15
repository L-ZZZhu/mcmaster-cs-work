package linkedlist;

public class lla {
    public static void main(String[] args){
        ExamLinkedList fuck=new ExamLinkedList();
        System.out.println(fuck.isEmpty());
        fuck.appendFront(1);
        fuck.appendFront(2);
        fuck.appendFront(3);
        fuck.appendFront(4);
        fuck.appendFront(5);
        fuck.appendFront(6);
        fuck.appendFront(7);
        fuck.appendFront(8);
        fuck.appendFront(9);
        fuck.appendFront(10);
        ExamLinkedList love=new ExamLinkedList();
        for (int i=11;i<25;i++){
            love.appendFront(i);
        }
        ExamNode lal=new ExamNode(5);
        fuck.interleave(love);



    }
}
