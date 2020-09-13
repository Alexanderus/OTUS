package home_2.prime;

import testsys.InData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PrimeNumber {

    public Function<InData, Optional<Integer>> primesByBruteForce = x -> {
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<Integer> res = this.getPrimesByBruteForce(a);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Поиск простых числе перебором.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<Integer>> primesByBruteForceWithOptimize = x -> {
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<Integer> res = this.getPrimesByBruteForceWithOptimize(a);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Поиск простых числе оптимизированным перебором.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<Integer>> primesByClassicEratosfen = x -> {
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<Integer> res = this.getPrimesByClassicEratosfen(a);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Поиск простых числе перебором.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Function<InData, Optional<Integer>> primesWithLinearDiff = x -> {
        String rawData = x.getNext();
        int a = Integer.parseInt(rawData.trim());

        long startTime = System.nanoTime();
        Optional<Integer> res = this.getPrimesWithLinearDiff(a);
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;
//        System.out.println("Поиск простых числе перебором.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "A = %s.\n" +
                "Результат = %s.\n" +
                "Время работы : %s наносекунд. \n\n\n", x.getTestNumber(), a, res.get().toString(), duration));
        return res;
    };

    public Optional<Integer> getPrimesWithLinearDiff(int num) {
        if (num < 1) return Optional.empty();
        if (num == 1) return Optional.of(1);
        if (num == 2) return Optional.of(2);
        if (num == 3) return Optional.of(3);

        int[] numbers = new int[num + 1];
        Arrays.fill(numbers, 0);
        int maxToAvoidOverflow = Integer.MAX_VALUE / num;

        List<Integer> primes = new ArrayList<Integer>();

        numbers[2] = 2;
        numbers[4] = 2;
        primes.add(2);
        for (int i = 3; i <= num; i++) {
            if (numbers[i] == 0) {
                numbers[i] = i;
                primes.add(i);
            }
            for (Integer prime : primes) {
                if (prime < maxToAvoidOverflow && prime * i <= num && prime <= numbers[i]) {
                    numbers[prime * i] = prime;
                }
            }
        }
        return Optional.of(primes.size());
    }

    public Optional<Integer> getPrimesByClassicEratosfen(int number) {
        boolean[] arraysOfPrimes = new boolean[number + 1];
        Arrays.fill(arraysOfPrimes, true);

        arraysOfPrimes[0] = arraysOfPrimes[1] = false;
        for (int i = 2; Math.pow(i, 2) <= number; i++) {
            if (arraysOfPrimes[i]) {
                for (int j = (int) Math.pow(i, 2); j <= number; j += i) {
                    arraysOfPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean arraysOfPrime : arraysOfPrimes) {
            if (arraysOfPrime) {
                count++;
            }
        }
        return Optional.of(count);
    }

    public Optional<Integer> getPrimesByBruteForce(int number) {
        if (number == 0) {
            return Optional.of(0);
        }
        if (number == 1) {
            return Optional.of(1);
        }

        int primCount = 0;
        int prim = 0;
        for (int i = 2; i <= number; i++) {
            prim = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    prim++;
                }

            }
            if (prim == 2) {
                primCount++;
            }
        }
        return Optional.of(primCount);
    }

    public Optional<Integer> getPrimesByBruteForceWithOptimize(int number) {
        if (number == 1) {
            return Optional.of(1);
        }

        int count = 0;
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return Optional.of(count);
    }


    private boolean isPrime(long number) {
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        long sq = (long) Math.sqrt(number);
        for (int i = 3; i <= sq; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}