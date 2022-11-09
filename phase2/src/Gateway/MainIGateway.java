package Gateway;//import phase1.MainManager;

import ReviewSystem.MainManager;

import java.io.IOException;

/**
 * MainIGateway is the interface for gateway class such as MainGateway.
 * @author Yuou Lei
 */
public interface MainIGateway {
        void saveToFile(String filepath, Object o) throws IOException;
        MainManager readFromFile(String filepath) throws IOException, ClassNotFoundException;

    }


