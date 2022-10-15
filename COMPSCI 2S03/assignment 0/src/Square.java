import java.util.Scanner;

public class Square {
    public static void main(String[] agr){
        Scanner myscan=new Scanner(System.in);
        double width;
        System.out.println("please give me the width of the Square");
        width=myscan.nextDouble();
        double length;
        System.out.println("please give me the length of the Square");
        length=myscan.nextDouble();
        myscan.close();
        double ans=area(width,length);
        System.out.println("-area(" + width + "," + length + ") returns " + ans);
    }
     public static double area(double x, double y){

        return x * y;
    }

}
