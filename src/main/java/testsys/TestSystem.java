package testsys;

import java.util.Optional;
import java.util.function.Function;


public class TestSystem<T> {
    private final InData inData;
    private final ResultData<T> resultData;

    public TestSystem() {
        this.inData = new InDataImpl();
        this.resultData = new ResultDataImpl<T>();
    }

    public void loadTestData(String path) {
        this.inData.loadIncomingData(path);
        this.resultData.loadResults(path);
    }

    public void runTests(Function<InData, Optional<T>> test) {
        while (inData.hasNext()) {
            this.resultData.addResult(test.apply(inData));
        }
    }

    public void checkResults() {
        for (int i = 0; i < resultData.size(); i++) {
            System.out.println(String.format("Ожидаемый результат теста %s. \n Полученный %s.\n\n\n",
                    resultData.getTestResult(i), resultData.getActualResult(i).get().toString()
            ));
        }
    }
}
