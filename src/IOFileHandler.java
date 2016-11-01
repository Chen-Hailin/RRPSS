import java.io.*;

/**
* Class to handle read from file and write to file
*/
class IOFileHandler {

    /**
    * @param fileName the file name
    * @return the object which read from the file
    */
    public ObjectInputStream readFileObject (String fileName) {
        FileInputStream fin;
        ObjectInputStream i = null;

        try {
            fin = new FileInputStream (fileName);
            i = new ObjectInputStream (fin);
        } catch (FileNotFoundException nf) {

        } catch (IOException io) {

        }

        return i;
    }

    /**
    * @param fileName the file name
    * @return the object which write to the file
    */
    public ObjectOutputStream writeFileObject (String fileName) {
        FileOutputStream fout;
        ObjectOutputStream o = null;

        try {
            fout = new FileOutputStream (fileName);
            o = new ObjectOutputStream (fout);
        } catch (FileNotFoundException nf) {

        } catch (IOException io) {

        }

        return o;
    }

    /**
    * @param fileName the file name
    * @param obj a serializable object which is going to be stored
    * example :
    * IOFileHandler io = new IOFileHandler();
    * io.writeObj(fileName, smth);
    */
    public void writeObj (String fileName, Object obj) {
        try {
            writeFileObject(fileName).writeObject(obj);
        } catch (IOException io) {
            return;
        }
    }

    /**
    * @param fileName the file name
    * @return the object that going to be read
    * example :
    * IOFileHandler io = new IOFileHandler();
    * someClass smth = (SomeClass) io.readObj(fileName);
    */
    public Object readObj (String fileName) {
        try {
            return readFileObject(fileName).readObject();
        } catch (IOException io) {
            return null;
        } catch (ClassNotFoundException c) {
            return null;
        }
    }
}
