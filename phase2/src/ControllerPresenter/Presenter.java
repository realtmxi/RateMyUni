package ControllerPresenter;

import ControllerPresenter.Dictionaries.*;

import java.util.Scanner;

/**
 * The parent class of all presenter classes
 */
public class Presenter {

    PromptDictionary pd;


    /**
     * @param pd initializes a new presenter with the PromptDictionary in chosen language
     */
    public Presenter(PromptDictionary pd){
        this.pd = pd;
    }


    /**
     * A general method that scans the next line of user input and returns it
     * @return the String from user input
     */
    public String getStringChoice() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * A general method that scans the next long that the user inputted and returns it
     * @return the long from user input
     */
    public Long getLongChoice() {
        Scanner s = new Scanner(System.in);
        return s.nextLong();
    }

    /**
     * print out a message telling users that this choice is invalid
     */
    public void invalidChoice() {
        System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.InvalidChoice));
    }
}
