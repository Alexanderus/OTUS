package home_2.pow;

import testsys.InData;

import java.util.Optional;
import java.util.function.Function;

public class PowManager {

    public Function<InData, Optional<Double>> powByMultiply = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        Double a = Double.parseDouble(incomingData[0]);
        long b = Long.parseLong(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<Double> res = this.getPowByMultiply(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Возведение в степень методом умножения.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<Double>> powByTwoDecomposition = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        Double a = Double.parseDouble(incomingData[0]);
        long b = Long.parseLong(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<Double> res = this.getPowByTwoDecomposition(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Возведение в степень методом разложения степени на 2.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<Double>> powByTwoWithMultiply = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        Double a = Double.parseDouble(incomingData[0]);
        long b = Long.parseLong(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<Double> res = this.getPowByTwoWithMultiply(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Возведение в степень методом разложения степени на 2.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Optional<Double> getPowByMultiply(Double number, long pow) {
        Double res = 1D;

        for (long i = 0; i < pow; i++) {
            res = res * number;
        }
        return Optional.of(res);
    }

    public Optional<Double> getPowByTwoWithMultiply(Double number, long pow) {
        if (pow == 0) return Optional.of(1D);

        long temp = 1L;
        long powOfTwo = 0L;
        Double result = 0D;

        while (pow >= temp) {
            powOfTwo++;
            temp = 1L << powOfTwo;
        }

        powOfTwo -= 1;
        pow -= 1L << powOfTwo;
        result = number;

        while (powOfTwo > 0) {
            result *= result;
            powOfTwo -= 1;
        }

        while (pow > 0) {
            result *= number;
            pow--;
        }

        return Optional.of(result);
    }

    public Optional<Double> getPowByTwoDecomposition(Double number, long pow) {
        if (pow == 0) return Optional.of(1D);

        double rawMaxPowOfTwo = Math.log(pow) / Math.log(2);
        int maxPowOfTwo = (int) rawMaxPowOfTwo;

        double result = 1D;
        for (int i = 0; i < maxPowOfTwo + 1; i++) {
            if ((pow >> i & 1) > 0) {
                result *= number;
            }
            number *= number;
        }
        return Optional.of(result);
    }
}
