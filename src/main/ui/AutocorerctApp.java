package ui;

import model.DifficultWords;
import model.DifficultWordsList;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class AutocorerctApp {
    private final Scanner input;
    private final DifficultWordsList list;
    private boolean firstCustomization;
    private final DifficultWordsList gameOrder;


    //EFFECTS: creates an AutocorectApp class and runs the app
    public AutocorerctApp() {
        list = new DifficultWordsList();
        firstCustomization = true;
        input = new Scanner(System.in);
        gameOrder = new DifficultWordsList();
        startApp();

    }

    //MODIFIES: this
    //EFFECTS: starts the app and displays the Home section and takes user inputs
    private void startApp() {
        displayHome();
        String userType = input.next();
        int response = Integer.parseInt(userType);
        produceResponse(response);

    }

    //CITATION: displayHome method is inspired displayMenu method from UBC CPSC 210's TellerApp
    //EFFECTS: displays the home screen of the game, where the user can add/remove words
    //, view current list of words, and order them by difficulty
    private void displayHome() {
        System.out.println("=======================================================");
        System.out.println("      Welcome to Autocorect (Beta Version 1.0)");
        System.out.println("=======================================================");
        System.out.println("\n Let's see whether you can do without autocorrect :)");
        System.out.println("\t [1] Play");
        System.out.println("\t [2] Customization");
        System.out.println("\t [3] Exit");
        System.out.print("\n Please type a number to continue: ");


    }

    //REQUIRES: inputted value to be either 1,2, or 3
    //EFFECTS: moves the app into the appropriate section from either Play, Customization, or Exit
    private void produceResponse(int i) {
        if (i == 1) {
            System.out.println();
            playApp();
        } else if (i == 2) {
            System.out.println();
            displayCustomization();
        } else if (i == 3) {
            System.out.println();
            System.out.println("Quitting....");
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }


    //EFFECTS: shows the customization screen consisting of a list of words added to the game
    // user is able to add more or remove certain words.
    private void displayCustomization() {
        if (firstCustomization) {
            firstCustomization();
        }

        System.out.println("Here is a list of already added words:");
        if (list.getListOfDifficultWords().size() == 0) {
            System.out.println("\n");
        }
        for (int i = 0; i < list.getListOfDifficultWords().size(); i++) {
            String printNum = Integer.toString(i + 1);
            System.out.println(printNum + ". " + list.getListOfDifficultWords().get(i).getSpelling());
        }

        displayCustomizationChoices();

    }

    //MODIFIES: this
    //EFFECTS: when the list of difficult words is blank, adds an initial first word
    // and word cannot contain space, numbers, or capital letters
    private void firstCustomization() {
        System.out.println("Spaces, numbers, and capslock are not allowed!");
        System.out.print("Please add your first word: ");
        String userType = input.next();
        list.addWord(new DifficultWords(userType));
        firstCustomization = false;

    }

    //EFFECTS: shows the choices in customization and respond accordingly, user must click either 1,2,3
    private void displayCustomizationChoices() {
        System.out.println("Please choose your action:");
        System.out.println("\t [1] Add a word");
        System.out.println("\t [2] Remove a word");
        System.out.println("\t [3] Return to Home");
        System.out.print("Choose a number: ");
        String userType = input.next();
        int response = Integer.parseInt(userType);

        if (response == 1) {
            addNewWord();
        } else if (response == 2) {
            removeWord();
        } else {
            startApp();
        }

    }

    //MODIFIES: this
    //EFFECTS: adds a word into a list of difficult words,
    // word cannot contain space, numbers, or capital letters
    private void addNewWord() {
        System.out.println("Spaces, numbers, and capslock are not allowed!");
        System.out.print("Please add your word: ");
        String userType = input.next();
        list.addWord(new DifficultWords(userType));
        displayCustomization();
    }

    //MODIFIES: this
    //EFFECTS: removes a word into a list of difficult words,
    // word cannot contain space, numbers, or capital letters
    // tells the user when it detects invalid input
    private void removeWord() {
        DifficultWords wordRemoved = new DifficultWords(" ");

        System.out.println("With no typos, please type the word you'd like to delete");
        System.out.print("Please type your word: ");
        String userType = input.next();

        for (int i = 0; i < list.getListOfDifficultWords().size(); i++) {
            if (list.getListOfDifficultWords().get(i).getSpelling().equals(userType)) {
                wordRemoved = list.getListOfDifficultWords().get(i);
            }
        }

        if (!wordRemoved.getSpelling().equals(" ")) {
            list.removeWord(wordRemoved);
            System.out.println("Successfully deleted " + wordRemoved.getSpelling());
        } else {
            System.out.println("You made a mistake, make sure the word exist and no typos");
        }
        displayCustomization();
    }

    //EFFECTS: shows the game level using the words in the customization
    private void playApp() {
        isItFirstCustomization();
        System.out.println("Ready or not, here it begins!");
        playTheGame();
        startApp();

    }

    //MODIFIES: this
    //EFFECTS: allows the user to play the game  level, the user can see the random words
    //, type their guesses and get feedback (right or wrong), it ends the round once the score is 10
    private void playTheGame() {
        boolean playGame = true;
        int score = 0;
        int attempts = 0;
        while (playGame) {
            createRandomOrder();
            String correctAnswer = pickRandomWord();
            System.out.print("Type your answer: ");
            String userType = input.next();
            if (userType.equals(correctAnswer)) {
                System.out.println("Correct! +1 score");
                score++;
            } else {
                System.out.println("Wrong! -1 score");
                score--;
            }
            attempts++;
            System.out.println("Your score is: " + score);

            if (score == 10) {
                System.out.println("Congratulations, you've finished one round!");
                System.out.println("You did it in" + attempts + "attempts!");
                playGame = false;
            }
        }
    }


    //MODIFIES: this
    //EFFECTS: creates a random word order to be used in the game, runs randomization on each element
    private void createRandomOrder() {
        for (int i = 0; i < list.getListOfDifficultWords().size(); i++) {
            gameOrder.addWord(list.getListOfDifficultWords().get(i));
        }

        Collections.shuffle(gameOrder.getListOfDifficultWords());

        for (int i = 0; i < gameOrder.getListOfDifficultWords().size(); i++) {
            boolean isDuplicate = true;
            DifficultWords impactedWord = gameOrder.getListOfDifficultWords().get(i);
            if (impactedWord.getSpelling().length() == 1) {
                impactedWord.randomizeWord();
            }
            while (isDuplicate && impactedWord.getSpelling().length() > 1) {
                impactedWord.randomizeWord();
                if (!impactedWord.getSpellingRandomized().equals(impactedWord.getSpelling())) {
                    isDuplicate = false;
                }
            }

        }
    }

    //EFFECTS: picks a random DifficultWords element from the gameOrder and prints it
    private String pickRandomWord() {
        Random random = new Random();
        int randomInt = random.nextInt(gameOrder.getListOfDifficultWords().size());
        DifficultWords randomWord = gameOrder.getListOfDifficultWords().get(randomInt);
        System.out.println("Your word is: " + randomWord.getSpellingRandomized());
        return randomWord.getSpelling();
    }

    //EFFECTS: checks whether the user has added any words to customization,
    // if not prompts the user to add a word
    private void isItFirstCustomization() {
        if (firstCustomization) {
            System.out.println("You can't play yet, go add a word first");
            displayCustomization();
        }
    }



}
