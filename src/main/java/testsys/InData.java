package testsys;

public interface InData {
    String fileExt = "in";

    void loadIncomingData(String pathToData);

    boolean hasNext();

    String getNext();

    int getTestNumber();

    int size();
}
