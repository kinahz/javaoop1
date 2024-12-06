package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner cin = new Scanner(System.in);
        //System.out.println("_____");
     /*   int score = 5;
        while (score != 5) {
            int a = (int)(Math.random() * 11);
            int b = (int)(Math.random() * 11);
            System.out.println(a + "+" + b + "=" + "?");
            int ans = cin.nextInt();
            if (a + b == ans)
                score++;
            else
                score--;
        } */
        int score = 5;
        while (score > 0 && score < 10) {
            for (int i = 0; i < score; i++) {
                System.out.print(" ");
            }
            System.out.println(0);
            int a = (int)(Math.random() * 11);
            int b = (int)(Math.random() * 11);
            System.out.println(a + "+" + b + "=" + "?");
            int ans = cin.nextInt();
            if (a + b == ans)
                score++;
            else
                score--;
        }
        if (score == 0) {
            System.out.println("WW");
        }
        else
            System.out.println("LL");
    }
}
