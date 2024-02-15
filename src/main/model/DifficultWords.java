package model;

//Represents an individual difficult word to be used in the game
// Each have a correct spelling of a word, the level of difficulty, and typing progress
public class DifficultWords {
    private String spelling;
    private int difficultyLevel;
    private boolean isTyped;
    private String leftToType;

    //EFFECTS: creates a new difficult word instance with a spelling, level of difficulty, and typing progress
    public DifficultWords(String word) {
        this.spelling = word;
        checkDifficulty();
        isTyped = false;
        leftToType = spelling;

    }

    //MODIFIES: this
    //EFFECTS: checks the difficulty of a word, sets the difficultyLevel 2 if length of string is bigger than 10
    // and 1 otherwise
    public void checkDifficulty() {
        if (spelling.length() > 10) {
            this.difficultyLevel = 2;
        } else {
            this.difficultyLevel = 1;
        }
    }

    //REQUIRES: leftToType.length() > 0
    //MODIFIES: this
    //EFFECTS: returns the next char of spelling to be typed
    public String getNextChar() {
        return leftToType.substring(0,1);

    }

    //REQUIRES: input not be an empty string and input.length() = 1
    //MODIFIES: this
    //EFFECTS: types a single character
    // if true, updates the remaining characters to type
    // if false, don't update the remaining characters
    public void typeChar(String input) {
        if (input.equals(getNextChar())) {
            leftToType = leftToType.substring(1);
        }

    }

    public String getSpelling() {
        return spelling;
    }

    public int getLevel() {
        return difficultyLevel;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public boolean getStatus() {
        return isTyped;
    }

    public String getLeftToType() {
        return leftToType;
    }

    //MODIFIES: this
    //EFFECTS; sets the progress of typing to be true
    public void setAlreadyTyped() {
        isTyped = true;
    }

}
