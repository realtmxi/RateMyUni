//import phase1.AppController;
//import phase1.LogInController;
//import phase1.MainGateway;
//import phase1.MainIGateway;
//import phase1.MainManager;
//import phase1.User;

import ControllerPresenter.*;
import ControllerPresenter.Dictionaries.*;
import Gateway.*;
import ReviewSystem.MainManager;
import UserProfileSystem.UserSystem.User;

import java.io.IOException;

public class Phase2Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MainIGateway mainGateway = new MainGateway();
        MainManager mainManager = mainGateway.readFromFile("phase2Saver.ser");
        LanguageSwitcher ls = new LanguageSwitcher();
        PromptDictionary pd = ls.askForLanguage();
        LogInController lc = new LogInController(pd);
        User loggedInUser = lc.run(mainManager.getUserManager()); //asks user to either login or create account
        AppController ac = new AppController(mainManager,loggedInUser,pd);
        ac.run(); //after login, display user options
        mainGateway.saveToFile("phase2Saver.ser", mainManager);

    }
}
