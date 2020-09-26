package home_3.Truckers;

import java.math.BigInteger;

public class Rook {

    public BigInteger getMoves(BigInteger[] bitBoard, BigInteger whitePieces, BigInteger blackPieces) {
        BigInteger startCell = bitBoard['R'];

        whitePieces = whitePieces.subtract(startCell).xor(BitBoard.FULL_BOARD_MASK);
        blackPieces = blackPieces.xor(BitBoard.FULL_BOARD_MASK);

        return BitBoard.getTopVertical(startCell, whitePieces, blackPieces).subtract(startCell).add(
                BitBoard.getDownVertical(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getLeftHorizontal(startCell, whitePieces, blackPieces).subtract(startCell)).add(
                BitBoard.getRightHorizontal(startCell, whitePieces, blackPieces).subtract(startCell));
    }
}
