package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    Title title = new Title();
    private char[] hiddenWordChar;
    private char[] visibleWordChar;
    private int quessCounter = 15;
    private String letter;
    private int randomIndex;
    private String randomWord;

    public void printRandomWord(){

        randomWord = title.getRandomWord();
        randomIndex = title.getIndex();

        System.out.println("Number: " + randomIndex);
        //System.out.println("Title:  " + randomWord);
        hiddenWordChar = randomWord.toCharArray();
        visibleWordChar = hiddenWordChar.clone();
        for (int i = 0; i < hiddenWordChar.length ; i++){
            hiddenWordChar[i] = '_';
        }
    }

    public void printHiddenRandomWord() {
        System.out.print("Title:  ");
        for (int i = 0; i < hiddenWordChar.length; i++) {
            if (visibleWordChar[i] == ' ') {
                System.out.print(' ');
            } else {
                System.out.print(hiddenWordChar[i] + " ");
            }
        }
            System.out.println();
        }

    public void typeWord() {
        printHiddenRandomWord();
        if (quessCounter > 0) {
            System.out.println("Quess the word, you can try " + quessCounter + " times");
            System.out.println("Type your letter:");
            Scanner scanner = new Scanner(System.in);
            letter = scanner.nextLine();
            System.out.println("***** You typed: " + letter);
            quessCounter--;
            quessWordCheck();
        } else {
            System.out.println("***** You loose!!! *****");
            System.out.println("Title was: " + randomWord);
            //System.exit(1);
        }
    }

    public void quessWordCheck() {
        if(Arrays.equals(letter.toCharArray(), visibleWordChar)){
            System.out.println("***** You WIN !!! *****");
        } else if (letter.length() == 1) {
                for (int i = 0; i < visibleWordChar.length; i++) {
                    if (visibleWordChar[i] == letter.charAt(0) || visibleWordChar[i] == ' ') {
                        hiddenWordChar[i] = visibleWordChar[i];
                    }
                }
                if(Arrays.equals(hiddenWordChar, visibleWordChar)) {
                System.out.println("***** You WIN !!! *****");
                } else {
                typeWord();
                }
        } else {
          System.out.println("***** Type just one letter! *****");
          typeWord();
          }
    }

    public void startGame() throws Exception{
        title.getWordsFromFile();
        printRandomWord();
        typeWord();
    }
}