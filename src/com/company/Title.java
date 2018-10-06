package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Title {

    private File file = new File("movies.txt");
    private List<String> words = new ArrayList<>();
    private int randomIndex;
    private String randomWord;

    public void getWordsFromFile() throws Exception{
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            words.add(line);
        }
        System.out.println("Number of titles: " + words.size());
    }

    public String getRandomWord() {
        randomIndex = (int) (Math.random()*words.size());
        randomWord = words.get(randomIndex);
        return randomWord;
    }

    public int getIndex(){
        this.randomIndex = randomIndex;
        return randomIndex;
    }
}
