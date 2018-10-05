package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private File file = new File("movies.txt");
    private List<String> words = new ArrayList<>();
    private int randomIndex;
    private String randomWord;
    private char[] hiddenWordChar1;
    private char[] hiddenWordChar2;
    private int quessCounter = 10;
    private String letter;

    public void getWordsFromFile() throws Exception{
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            words.add(line);
        }
        System.out.println("Number of titles: " + words.size());
    }

    public void printRandomWord(){
        randomIndex = (int) (Math.random()*words.size());
        randomWord = words.get(randomIndex);
        System.out.println("Number: " + randomIndex);
        //System.out.println("Title:  " + randomWord);
        hiddenWordChar1 = randomWord.toCharArray();
        hiddenWordChar2 = hiddenWordChar1.clone();
        for (int i = 0 ; i < hiddenWordChar1.length ; i++){
            hiddenWordChar1[i] = '_';
        }
    }

    public void printHiddenRandomWord() {
        System.out.print("Title:  ");
        for (int i = 0; i < hiddenWordChar1.length; i++) {
            if (hiddenWordChar2[i] == ' ') {
                System.out.print(' ');
            } else {
                System.out.print(hiddenWordChar1[i] + " ");
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
            System.out.println("***** You loose!!!");
            System.out.println("Title was: " + randomWord);

        }
    }

    public void quessWordCheck() {

        if(Arrays.equals(letter.toCharArray(),hiddenWordChar2)){
            System.out.println("***** You WIN !!!");

        } else if (letter.length() == 1) {
                for (int i = 0 ; i < hiddenWordChar2.length; i++) {
                    if (hiddenWordChar2[i] == letter.charAt(0)) {
                        hiddenWordChar1[i] = hiddenWordChar2[i];
                    }
                }
                typeWord();
        } else {
            System.out.println("*** Type just one letter!");
            typeWord();
            }
    }

    public void startGame() throws Exception{
        getWordsFromFile();
        printRandomWord();
        typeWord();
    }
}
