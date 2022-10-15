package a;

import java.util.ArrayList;

public class work {
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        char h ='l';
        ArrayList<String> b = new ArrayList<String>();
        b.add("kakak");
        b.add("kakad");
        String buffer=h+b.get(0);
        System.out.println(buffer);
        System.out.println(b.get(0).length());
        String man="one";
        WordTree lo=new WordTree();
        lo.insertWord(man);
        man="or";
        lo.insertWord(man);
        man="oranges";
        System.out.println(lo.numOfWords());
        System.out.println(b);
        System.out.println(lo.numOfWords());
        System.out.println(lo.addToEach('a',b));
        a=lo.addToEach('a',b);
        System.out.println(a);
        System.out.println(lo.numOfWords());
        lo.insertWord(man);
        lo.insertWord("oranget");
        String love="oranges";
        char f='p';
        System.out.println(lo.letterToInt('o'));
        System.out.println(lo.contains(love));
        System.out.println(lo.numOfWords());
        System.out.println(lo.contains(man));
        System.out.println(lo.numOfWords());
        System.out.println(lo.contains("oranges"));
        System.out.println(lo.contains("orangets"));
        WordTree fuck=new WordTree();
        fuck.insertWord("app");
        fuck.insertWord("apple");
        fuck.insertWord("appleh");
        fuck.insertWord("applehe");
        fuck.insertWord("appleheh");
        fuck.insertWord("applo");
        System.out.println(fuck.suggestAutoCompletes("app"));

        System.out.println(fuck.suggestCorrections("xxx",7));




    }
}
