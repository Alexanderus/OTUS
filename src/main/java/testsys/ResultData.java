package testsys;

import java.util.Optional;

public interface ResultData<T> {
    String fileExt = "out";

    void loadResults(String pathToData);

    void addResult(Optional result);

    int size();

    String getTestResult(int testNumber);

    Optional<T> getActualResult(int testNumber);


}
