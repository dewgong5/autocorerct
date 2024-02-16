package model;

import java.util.ArrayList;

//Represents a list of DifficultWords which the user can view, add a word, and remove a word
//This list would also get be the one used in main game to test the user on the spelling accuracy of these words
public class DifficultWordsList {
    private ArrayList<DifficultWords> listOfDifficultWords;

    //EFFECTS: creates a new list of Difficult Words
    public DifficultWordsList() {
        listOfDifficultWords = new ArrayList<>();
    }

    //REQUIRES: difficultWord.length() != 0 && difficultWord cannot contain whitespace
    // !listOfDifficultWords.contains(difficultWord)
    //MODIFIES: this
    //EFFECTS: adds the given word into listOfDifficultWords
    public void addWord(DifficultWords difficultWord) {
        listOfDifficultWords.add(difficultWord);
    }

    //REQUIRES: listOfDifficultWords.contains(difficultWord)
    //MODIFIES: this
    //EFFECTS: removes the given word into listOfDifficultWords
    public void removeWord(DifficultWords difficultWord) {
        listOfDifficultWords.remove(difficultWord);
    }

    public ArrayList<DifficultWords> getListOfDifficultWords() {
        return listOfDifficultWords;
    }
}
