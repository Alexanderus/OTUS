package home_3.Truckers;

import home_3.Fen.Fen;
import testsys.InData;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class Truck {

    public Function<InData, Optional<BigInteger[]>> moves = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");

        Optional<BigInteger[]> rawResult = this.getMoves(incomingData[0]);
        BigInteger[] result = rawResult.get();
        System.out.println("Шахматные биты. Дальнобойщики.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "Исходная фен нотация = %s.\n" +
                "Результат: \n %s \n %s \n %s \n\n\n", x.getTestNumber(), incomingData[0], result[0], result[1], result[2]));
        return rawResult;
    };

    public Optional<BigInteger[]> getMoves(String rawFen) {
        Optional<BigInteger[]> bitBoardOpt = new Fen().parseBitBoard(rawFen);
        if (bitBoardOpt.isEmpty()) {
            return Optional.empty();
        }

        BigInteger[] bitBoard = bitBoardOpt.get();

        BigInteger blackPieces = BigInteger.ZERO;
        BigInteger whitePieces = BigInteger.ZERO;
        for (int i = 66; i < 83; i++) {
            if (bitBoard[i] != null) {
                whitePieces = whitePieces.add(bitBoard[i]);
            }
        }

        for (int i = 98; i < 115; i++) {
            if (bitBoard[i] != null) {
                blackPieces = blackPieces.add(bitBoard[i]);
            }
        }

        BigInteger rookMoves = new Rook().getMoves(bitBoard, whitePieces, blackPieces);
        BigInteger bishopMoves = new Bishop().getMoves(bitBoard, whitePieces, blackPieces);
        BigInteger queenMoves = new Queen().getMoves(bitBoard, whitePieces, blackPieces);

        return Optional.of(new BigInteger[]{rookMoves, bishopMoves, queenMoves});
    }
}
