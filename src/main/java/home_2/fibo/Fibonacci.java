package home_2.fibo;

import testsys.InData;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class Fibonacci {

    public Function<InData, Optional<BigInteger>> fibonacciRecursion = x -> {
        //        System.out.println("Поиск фибоначчи рекурсией.");
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getFibonacciRecursion(BigInteger.valueOf(a));
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<BigInteger>> fibonacciGoldenRatio = x -> {
        //        System.out.println("Поиск фибоначчи и использованием золотого сечения.");
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getFibonacciGoldenRatio(BigInteger.valueOf(a));
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<BigInteger>> fibonacciMatrixMultiply = x -> {
        //        System.out.println("Поиск фибоначчи перемножением матриц.");
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getFibonacciMatrixMultiply(a);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<BigInteger>> fibonacciIteration = x -> {
        //        System.out.println("Поиск фибоначчи динамическим подсчетом.");
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<BigInteger> res = this.getFibonacciIteration(BigInteger.valueOf(a));
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Optional<BigInteger> getFibonacciRecursion(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) return Optional.of(BigInteger.ZERO);
        if (n.compareTo(BigInteger.TWO) < 0) return Optional.of(BigInteger.ONE);
        return Optional.of(getFibonacciRecursion(n.subtract(BigInteger.ONE)).get().add(getFibonacciRecursion(n.subtract(BigInteger.TWO)).get()));
    }

    public Optional<BigInteger> getFibonacciIteration(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) return Optional.of(BigInteger.ZERO);
        if (n.compareTo(BigInteger.TWO) < 0) return Optional.of(BigInteger.ONE);
        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        BigInteger f3 = BigInteger.ZERO;
        for (int i = 2; i <= n.intValue(); i++) {
            f3 = f2.add(f1);
            f1 = f2;
            f2 = f3;
        }
        return Optional.of(f3);
    }

    public Optional<BigInteger> getFibonacciMatrixMultiply(int n) {
        if (n == 0) return Optional.of(BigInteger.ZERO);
        if (n == 1 || n == 2) return Optional.of(BigInteger.ONE);
        BigInteger[][] F = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        F = matrixPower(F, n - 1);
        return Optional.of(F[0][0]);
    }

    public Optional<BigInteger> getFibonacciGoldenRatio(BigInteger n) {
        double phi = (1 + Math.sqrt(5d)) / 2;
        double f = (Math.pow(phi, n.doubleValue()) / Math.sqrt(5) + 0.5);
        return Optional.of(BigInteger.valueOf((int) f));
    }

    private BigInteger[][] matrixPower(BigInteger[][] x, int n) {
        BigInteger a = x[0][0].add(x[0][1]);
        BigInteger b = x[0][0];
        BigInteger c = x[1][0].add(x[1][1]);
        BigInteger d = x[1][0];
        if (n == 2) {
            return new BigInteger[][]{{a, b}, {c, d}};
        } else {
            return matrixPower(new BigInteger[][]{{a, b}, {c, d}}, n - 1);
        }
    }
}
