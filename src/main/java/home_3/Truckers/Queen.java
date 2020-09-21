package home_3.Truckers;

import java.math.BigInteger;

public class Queen {
    public BigInteger getMoves(BigInteger[] bitBoard, BigInteger whitePieces, BigInteger blackPieces) {
        BigInteger startCell = bitBoard['Q'];

        whitePieces = whitePieces.subtract(startCell).xor(BitBoard.FULL_BOARD_MASK);
        blackPieces = blackPieces.xor(BitBoard.FULL_BOARD_MASK);

        return BitBoard.getRightTopDiagonal(startCell, whitePieces, blackPieces).subtract(startCell).add(
                BitBoard.getLeftTopDiagonal(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getRightDownDiagonal(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getLeftDownDiagonal(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getTopVertical(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getDownVertical(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getLeftHorizontal(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getRightHorizontal(startCell, whitePieces, blackPieces).subtract(startCell));
    }
}
