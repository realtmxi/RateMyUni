package Gateway;

import ReviewSystem.MainManager;

import java.io.*;

/**
 * MainGateway is a gateway class responsible for serialization of objects and store them in .ser file.
 * @author Yuou Lei
 */
public class MainGateway implements MainIGateway {
    /**
     * Save the mainManger object in the ser file with filepath provided by filePath
     * @param filePath file path of the file that mainManager object will be stored on
     * @param mainManager the manager that have all other managers as variable in it.
     */
    public void saveToFile(String filePath, Object mainManager) {
        try {
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);


            output.writeObject(mainManager);
            output.close();

        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("File was not found");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Read the information from a ser file and create a mainManger object.
     * @param fileName the name of the serializable file.
     * @return MainManger object
     */
    public MainManager readFromFile(String fileName) {
        createFile(fileName);
        MainManager mainManager = new MainManager();
        try {
            InputStream file = new FileInputStream(fileName);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);


            mainManager = (MainManager) input.readObject();
            input.close();

        }
        catch (EOFException EOFException){
            System.out.println("Your file was empty");
        }
        catch (IOException | ClassNotFoundException ioException) {
            System.out.println("File was not found ");
            ioException.printStackTrace();
            System.exit(2);
        }
//        catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        return mainManager;
    }
    private void createFile(String fileName) {

        File newFile = new File(fileName);
        try{
            if (newFile.createNewFile()) {
                System.out.println("A new File is created");
            } else {
                System.out.println("File was found");
            }}
        catch(IOException ioException){
            System.err.println(ioException.getMessage());
        }
    }
}