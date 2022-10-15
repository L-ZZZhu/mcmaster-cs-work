package Queue;

public class ajalksjd {
    public static void main(String[] args){
        ExamQueue fuck=new ExamQueue();
        System.out.println(fuck.isEmpty());
        fuck.add(1);
        fuck.add(2);
        fuck.add(3);
        fuck.print();
        System.out.println(fuck.getLength());
        System.out.println(fuck.remove());
        System.out.println(fuck);
        fuck.remove();
        fuck.print();
        fuck.add(4);
        fuck.print();
        fuck.removeBack();
        fuck.print();
    }
}
