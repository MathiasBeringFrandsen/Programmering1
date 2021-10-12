package model;

public class StringApp {

    public static void main(String[] args) {

        String tekst = "Goddag";
        int len = tekst.length();
      
        System.out.println("Teksten: " + tekst + " " + "har længde " + len);
        System.out.println(tekst.charAt(1));
        System.out.println(tekst.charAt(5));
        String tekst1 = tekst.substring(3);
        tekst1.toLowerCase();
        System.out.println(tekst1);
        String tekst2 = tekst.substring(0, 3);
        System.out.println(tekst2);
        String tekst3 = tekst.toLowerCase();
        System.out.println(tekst3);
        System.out.println("Hello\nWorld");
        
        //Hvad kan jeg med Strings ?
        //tekst.

    }

}
