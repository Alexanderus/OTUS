package home_2.euclid;

import testsys.InData;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class Euclidean {

    public Function<InData, Optional<BigInteger>> gcdBySubtraction = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        BigInteger a = new BigInteger(incomingData[0]);
        BigInteger b = new BigInteger(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getGCDBySubtraction(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Нахождение НОД методом вычитания.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<BigInteger>> gcdByRemain = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        BigInteger a = new BigInteger(incomingData[0]);
        BigInteger b = new BigInteger(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getGCDByRemain(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Нахождение НОД методом остатка от деления.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<BigInteger>> gdcByBitwise = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        BigInteger a = new BigInteger(incomingData[0]);
        BigInteger b = new BigInteger(incomingData[1]);

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getGCDByBitwise(a, b);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Нахождение НОД методом разложения по степени 2.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "B = %s. \n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, b, res.get().toString(), duration));
        return res;
    };

    public Optional<BigInteger> getGCDBySubtraction(BigInteger a, BigInteger b) {
        if (a.signum() <= 0 || b.signum() <= 0) {
            return Optional.empty();
        }

        while (!(a.compareTo(b) == 0)) {
            if (a.compareTo(b) > 0) {
                a = a.subtract(b);
            } else {
                b = b.subtract(a);
            }
        }
        return Optional.of(a);
    }

    public Optional<BigInteger> getGCDByRemain(BigInteger a, BigInteger b) {
        if (a.signum() <= 0 || b.signum() <= 0) {
            return Optional.empty();
        }

        while (a.compareTo(BigInteger.ZERO) != 0 && b.compareTo(BigInteger.ZERO) != 0) {
            if (a.compareTo(b) > 0) {
                a = a.mod(b);
            } else {
                b = b.mod(a);
            }
        }
        return Optional.of(a.add(b));
    }

    public Optional<BigInteger> getGCDByBitwise(BigInteger a, BigInteger b) {
        if (a.signum() <= 0 || b.signum() <= 0) {
            return Optional.empty();
        }

        int powOfTwo = 0;
        while (a.signum() == 1 && b.signum() == 1) {
            if (a.xor(BigInteger.ONE).compareTo(a.add(BigInteger.ONE)) == 0
                    && b.xor(BigInteger.ONE).compareTo(b.add(BigInteger.ONE)) == 0) {
                a = a.shiftRight(1);
                b = b.shiftRight(1);
                powOfTwo++;
                continue;
            }

            while (a.xor(BigInteger.ONE).compareTo(a.add(BigInteger.ONE)) == 0) {
                a = a.shiftRight(1);
            }

            while (b.xor(BigInteger.ONE).compareTo(b.add(BigInteger.ONE)) == 0) {
                b = b.shiftRight(1);
            }

            if (a.compareTo(b) == 0) {
                return Optional.of(BigDecimal.valueOf(Math.pow(2, powOfTwo)).toBigInteger().multiply(a));
            }
            if (a.compareTo(b) > 0) {
                a = a.subtract(b);
            }
            if (a.compareTo(b) < 0) {
                b = b.subtract(a);
            }
        }
        return Optional.of(BigDecimal.valueOf(Math.pow(2, powOfTwo)).toBigInteger());
    }
}
