package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String a = "abcdefghijklmnopqrstuvwxyz";
        String s = cin.nextLine();
        StringBuilder asdf = new StringBuilder(s);


        for (int i = 0; i < s.length(); i++)  {
            for (int j = 0; j < a.length(); j++) {
                if (s.charAt(i) == 'x')
                    asdf.setCharAt(i, a.charAt(0));
                else
                if (s.charAt(i) == 'y')
                    asdf.setCharAt(i, a.charAt(1));
                else
                if (s.charAt(i) == 'z')
                    asdf.setCharAt(i, a.charAt(2));
                else
                if (s.charAt(i) == a.charAt(j)) {
                    asdf.setCharAt(i, a.charAt(j + 3));
                }
            }
        }
        System.out.println(asdf);
    }
}
