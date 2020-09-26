package home_3.Fen;

import testsys.InData;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class Fen {

    public Function<InData, Optional<BigInteger[]>> parseBitBoard = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");

        Optional<BigInteger[]> rawResult = this.parseBitBoard(incomingData[0]);
        BigInteger[] chessPieces = rawResult.get();
        System.out.println("Шахматные биты. Фен нотация.");
        System.out.println(String.format("Тест номер %s. \n" +
                        "Фен нотация: %s .\n" +
                        "Результат:\n" +
                        chessPieces['P'].toString() + "\n" +
                        chessPieces['N'].toString() + "\n" +
                        chessPieces['B'].toString() + "\n" +
                        chessPieces['R'].toString() + "\n" +
                        chessPieces['Q'].toString() + "\n" +
                        chessPieces['K'].toString() + "\n" +
                        chessPieces['p'].toString() + "\n" +
                        chessPieces['n'].toString() + "\n" +
                        chessPieces['b'].toString() + "\n" +
                        chessPieces['r'].toString() + "\n" +
                        chessPieces['q'].toString() + "\n" +
                        chessPieces['k'].toString() + "\n"
                , x.getTestNumber(), incomingData[0]));
        return rawResult;
    };

    public Optional<BigInteger[]> parseBitBoard(String rawFen) {
        String[] rawLines = rawFen.split("/");

        BigInteger[] chessPieces = new BigInteger['r' + 1];

        chessPieces['r'] = BigInteger.ZERO;
        chessPieces['n'] = BigInteger.ZERO;
        chessPieces['b'] = BigInteger.ZERO;
        chessPieces['q'] = BigInteger.ZERO;
        chessPieces['k'] = BigInteger.ZERO;
        chessPieces['p'] = BigInteger.ZERO;
        chessPieces['P'] = BigInteger.ZERO;
        chessPieces['R'] = BigInteger.ZERO;
        chessPieces['N'] = BigInteger.ZERO;
        chessPieces['B'] = BigInteger.ZERO;
        chessPieces['Q'] = BigInteger.ZERO;
        chessPieces['K'] = BigInteger.ZERO;

        int currentCell = 63;
        for (int i = 0; i < rawLines.length; i++) {
            char[] line = rawLines[i].toCharArray();
            for (int j = line.length - 1; 0 <= j; j--) {
                if (line[j] < 60) {
                    currentCell -= Integer.parseInt(Character.toString(line[j]));
                } else {
                    chessPieces[line[j]] = chessPieces[line[j]].add(BigInteger.ONE.shiftLeft(currentCell));
                    currentCell -= 1;
                }
            }
        }
        return Optional.of(chessPieces);
    }
}
