# Project: Wordle

To use app, download wordle.jar and then open a terminal in the directory you saved the download to and run the following command. Requires Java 17.0.4 installed to run.

```
java -jar wordle.jar
```

If you would like to build the project yourself see the instructions at the [end of this](#getting-started) README.

![Screenshot of wordle running in terminal](./wordle_ui.png)

## MVP

-   Recreate a simplified version of the game Wordle to be played in a Java console application
-   The game should be able to randomly select a 5-letter word from the provided word list
-   The user will be able to enter a guess word that is also 5 characters long
-   For each letter, the application will tell the user if that letter is correct, right letter in the wrong position, or wrong letter
-   After the user guesses 6 times incorrectly, the game is over and the user loses
-   If the user guesses the word correctly, the game is over and the user wins
-   In addition you must implement one of the following extensions, or an extension of your own design as approved by a coach

### Extensions

-   Read the word list directly from the file when the application starts
-   Create a history file that keeps track of user wins/losses and how many letters they guessed it in
-   When the game finishes and the secret word is shown, also display the dictionary definition for that word
    -   Hint: Use a free API (https://dictionaryapi.dev/)
-   Generate an output of the word/guesses and copy it to the user's clipboard so they can share it on socials
    -   Bonus: Use emojis

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

-   `src`: the folder to maintain sources
-   `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
