import java.io.*;

/**
* Class to handle read from file and write to file
*/
class IOFileHandler {

    /**
    * return the object to read from the file which store an object
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
    * return the object to write the file which will store the object data
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
    * store the object passed to the corresponding file
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
    * return the object that going to be read
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
