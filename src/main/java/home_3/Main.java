package home_3;

import home_3.King.King;
import home_3.Fen.Fen;
import home_3.Night.Night;
import home_3.Truckers.Truck;
import testsys.TestSystem;
import utils.TestDataPatches;

import java.math.BigInteger;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        kingMovesTests();
//        knightMovesTests();
//        fenTests();
        truckTests();
    }

    public static void kingMovesTests() {
        King king = new King();
        TestSystem<BigInteger> testSystem = new TestSystem<>();

        testSystem.loadTestData(TestDataPatches.KING_MOVES_TEST_DATA);
        testSystem.runTests(king.kingMoves);
        testSystem.checkResults();
    }

    public static void knightMovesTests() {
        Night night = new Night();
        TestSystem<BigInteger> testSystem = new TestSystem<>();

        testSystem.loadTestData(TestDataPatches.KNIGHT_MOVES_TEST_DATA);
        testSystem.runTests(night.knightMoves);
        testSystem.checkResults();
    }

    public static void fenTests() {
        Fen fen = new Fen();
        TestSystem<BigInteger[]> testSystem = new TestSystem<>();

        testSystem.loadTestData(TestDataPatches.FEN_TEST_DATA);
        testSystem.runTests(fen.parseBitBoard);
    }

    public static void truckTests() {
        Truck truck = new Truck();
        TestSystem<BigInteger[]> testSystem = new TestSystem<>();

        testSystem.loadTestData(TestDataPatches.TRUCKERS_TEST_DATA);
        testSystem.runTests(truck.moves);
    }
}
