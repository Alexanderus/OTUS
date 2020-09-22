package testsys;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultDataImpl<T> implements ResultData<T> {
    private List<String> resultData;
    private List<Optional<T>> actualResult = new ArrayList<>();

    @Override
    public void addResult(Optional result) {
        actualResult.add(result);
    }

    @Override
    public void loadResults(String pathToData) {
        resultData = FileReader.getTestFiles(pathToData, ResultData.fileExt).stream()
                .sequential()
                .map(FileReader::getTestData)
                .collect(Collectors.toList());
    }

    @Override
    public int size() {
        return resultData == null ? 0 : resultData.size();
    }

    @Override
    public String getTestResult(int testNumber) {
        return this.resultData.get(testNumber);
    }

    @Override
    public Optional<T> getActualResult(int testNumber) {
        return this.actualResult.get(testNumber);
    }
}
