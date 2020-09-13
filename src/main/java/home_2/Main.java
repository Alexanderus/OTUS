package home_2;

import home_2.euclid.Euclidean;
import home_2.fibo.Fibonacci;
import home_2.pow.PowManager;
import home_2.prime.PrimeNumber;
import testsys.TestSystem;
import utils.TestDataPatches;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//        testEuclidean();
//        testPowManager();
        testPrimes();
//        testFibo();
    }

    public static void testEuclidean() {
        Euclidean euclidean = new Euclidean();
        TestSystem<BigInteger> testSystem = new TestSystem<BigInteger>();

        testSystem.loadTestData(TestDataPatches.EUCLIDEAN_TEST_DATA);
//        testSystem.runTests(euclidean.gcdByRemain);
//        testSystem.runTests(euclidean.gcdBySubtraction);
        testSystem.runTests(euclidean.gdcByBitwise);
        testSystem.checkResults();
    }

    public static void testPowManager() {
        PowManager powManager = new PowManager();
        TestSystem<Double> testSystem = new TestSystem<Double>();

        testSystem.loadTestData(TestDataPatches.POW_TEST_DATA);
        testSystem.runTests(powManager.powByTwoDecomposition);
        testSystem.checkResults();
    }

    public static void testPrimes() {
        PrimeNumber primeNumber = new PrimeNumber();
        TestSystem<Integer> testSystem = new TestSystem<Integer>();

        testSystem.loadTestData(TestDataPatches.PRIMES_TEST_DATA);
//        testSystem.runTests(primeNumber.primesByBruteForce);
//        testSystem.runTests(primeNumber.primesByBruteForceWithOptimize);
//        testSystem.runTests(primeNumber.primesByClassicEratosfen);
        testSystem.runTests(primeNumber.primesWithLinearDiff);
        testSystem.checkResults();
    }

    public static void testFibo() {
        Fibonacci fibonacci = new Fibonacci();
        TestSystem<BigInteger> testSystem = new TestSystem<BigInteger>();

        testSystem.loadTestData(TestDataPatches.FIBONACCI_TEST_DATA);
        testSystem.runTests(fibonacci.fibonacciMatrixMultiply);
//        testSystem.runTests(fibonacci.fibonacciRecursion);
//        testSystem.runTests(fibonacci.fibonacciGoldenRatio);
//        testSystem.runTests(fibonacci.fibonacciIteration);
        testSystem.checkResults();
    }
}
