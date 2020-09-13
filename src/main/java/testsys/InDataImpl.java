package testsys;

import utils.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class InDataImpl implements InData {
    private int testNumber = 0;
    private List<String> inTestData;

    @Override
    public int getTestNumber() {
        return testNumber;
    }

    @Override
    public boolean hasNext() {
        return testNumber < inTestData.size();
    }

    @Override
    public void loadIncomingData(String pathToData) {
        inTestData = FileReader.getTestFiles(pathToData, InData.fileExt).stream()
                .sequential()
                .map(FileReader::getTestData)
                .collect(Collectors.toList());
    }

    @Override
    public int size() {
        return inTestData == null ? 0 : inTestData.size();
    }

    @Override
    public String getNext() {
        this.testNumber++;
        return this.inTestData.get(testNumber - 1);
    }
}
