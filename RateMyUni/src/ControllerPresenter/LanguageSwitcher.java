package ControllerPresenter;

import ControllerPresenter.Dictionaries.*;

import java.util.Scanner;

/**
 * This is a controller-like class that allows users to choose interfaces with different languages.
 * Right now, we're offering an English version and a Chinese version. LanguageSwitcher takes user input
 * and outputs an appropriate PromptDictionary, which stores all the relevant prompts for teh RateMyUni interface.
 */
public class LanguageSwitcher {


    /**
     * Asks user to choose either English or Chinese and initialize the appropriate PromptDictionary
     * @return an appropriate PromptDictionary
     */
    public PromptDictionary askForLanguage() {
        boolean valid = false;
        PromptDictionary pd = null;
        while (!valid) {
            System.out.println("Please choose a language preference:\n1) English\n2) 中文\n");
            Scanner s = new Scanner(System.in);
            String ans = s.nextLine();
            switch (ans){
                case "1":
                    pd = new EnglishPromptDictionary();
                    valid = true;
                    break;
                case "2":
                    pd = new ChinesePromptDictionary();
                    valid = true;
                    break;
                default:
                    break;
            }

        }
        return pd;
    }

}
