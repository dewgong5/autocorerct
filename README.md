# My Personal Project: Autocorerct

## What is Autocorect?

- The application, **Autocorerct** is a Java game where the players try to type unordered and randomly scattered letters into one correct spelling of a word, this aims to increase the spelling accuracy of players.
- Players are able to add words that are tested in the game, so the game would be **personalized** to which words you are having difficulty with.

## What else should I know?
Who will use it?
- This project is for anyone aiming to increase typing accuracy while playing a game and having fun. The ideal target is anyone from the ten to forty year old age demographic.


Why is this project of interest to you?
- This project seems simple as essentially it boils down to implementing a way to type and randomly scattering letters, however the code to build these kinds of simple projects is often complex and challenging which allows me to only recall important lecture concepts but also implement concepts in a creative way.
- Creating a game to increase typing accuracy seems interesting as it solves a real problem where digital users often struggle with the spelling of words as they are dependent on autocorrect. I’m able to solve this problem while packaging it in a fun way, hence the project is interesting. 

## User Stories
Here are several user stories for the project:
- As a user, I want to be able to **add** a new word to a list of words that appear in the game. 
- As a user, I want to be able to **view** a personalized list of words that I have added 
- As a user, I want to be able to **delete** certain words from my personalized list.
- As a user, I want to be able to **view** randomly scattered and unordered letters of a word in a game level. 
- As a user, I want to be able to **play the game** by typing the correct order of letters.
- As a user, I want to be able to **get feedback** on the accuracy of my typing and obtaining a score for every correct spelling of a word.
- As a user, I want to be able to be reminded to **save** the current list of difficult words and choose whether to save or not.
- As a user, I want to be able to **load** a previous list of difficult words when I start the application.

## Instructions for Grader
Here are several specific instructions:
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by pressing the Customize button, typing any word within the add word text field,
 and pressing enter would add the DifficultWords into the DifficultWordsList. You can repeat this process for as many times as you want.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" (removing words) by pressing Customize and typing on the remove word text field and pressing enter to remove a word, 
 make sure the word has been added before trying to remove it and the changes will take effect immediately.
- You can locate my visual component by pressing the Image button to show a certain image and close to close the image.
- You can save the state of my application by pressing the Save button at the Home screen
- You can load the state of my application by pressing the Load button at the Home screen (make sure to have something to load otherwise, it'll reset everything)

## Phase 4: Task 2
- Sample code for logging events:
-  Sun Apr 07 23:51:01 PDT 2024
  added aba to list 
-  Sun Apr 07 23:51:01 PDT 2024
  added baba to list
-  Sun Apr 07 23:51:01 PDT 2024
  added laba to list

## Phase 4: Task 3
- Looking at the design, I would refactor the AutocorectApp class to contain smaller classes, each dedicated to a specific part of the game. The problem right now is the class feels like a mess of codes with different functionality and just mashed up together so it can run.
- Ideally, I would have wanted both the AppGUI and AutocorectApp to work together, where changes in one aspect would be seen in the other and it would make the code more clean and structured, only depending on one superclass which can be called by main.