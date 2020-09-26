package home_3.Truckers;

import java.math.BigInteger;

public class BitBoard {

    public static final BigInteger FULL_BOARD_MASK = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);

    public static final BigInteger LEFT_BORDER_MASK = BigInteger.valueOf(1).shiftLeft(0).add(
            BigInteger.valueOf(1).shiftLeft(8)).add(
            BigInteger.valueOf(1).shiftLeft(16)).add(
            BigInteger.valueOf(1).shiftLeft(24)).add(
            BigInteger.valueOf(1).shiftLeft(32)).add(
            BigInteger.valueOf(1).shiftLeft(40)).add(
            BigInteger.valueOf(1).shiftLeft(48)).add(
            BigInteger.valueOf(1).shiftLeft(56)).xor(FULL_BOARD_MASK);

    public static final BigInteger RIGHT_BORDER_MASK = BigInteger.valueOf(1).shiftLeft(7).add(
            BigInteger.valueOf(1).shiftLeft(15)).add(
            BigInteger.valueOf(1).shiftLeft(23)).add(
            BigInteger.valueOf(1).shiftLeft(31)).add(
            BigInteger.valueOf(1).shiftLeft(39)).add(
            BigInteger.valueOf(1).shiftLeft(47)).add(
            BigInteger.valueOf(1).shiftLeft(55)).add(
            BigInteger.valueOf(1).shiftLeft(63)).xor(FULL_BOARD_MASK);

    public static final BigInteger TOP_BORDER_MASK = BigInteger.valueOf(1).shiftLeft(56).add(
            BigInteger.valueOf(1).shiftLeft(57)).add(
            BigInteger.valueOf(1).shiftLeft(58)).add(
            BigInteger.valueOf(1).shiftLeft(59)).add(
            BigInteger.valueOf(1).shiftLeft(60)).add(
            BigInteger.valueOf(1).shiftLeft(61)).add(
            BigInteger.valueOf(1).shiftLeft(62)).add(
            BigInteger.valueOf(1).shiftLeft(63)).xor(FULL_BOARD_MASK);


    public static BigInteger getRightTopDiagonal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(TOP_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(RIGHT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getRightTopDiagonal(startCell.shiftLeft(9), whitePieces, blackPieces));
    }

    public static BigInteger getLeftTopDiagonal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(TOP_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(LEFT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getLeftTopDiagonal(startCell.shiftLeft(7), whitePieces, blackPieces));
    }

    public static BigInteger getRightDownDiagonal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(RIGHT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getRightDownDiagonal(startCell.shiftRight(7), whitePieces, blackPieces));
    }

    public static BigInteger getLeftDownDiagonal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(LEFT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getLeftDownDiagonal(startCell.shiftRight(9), whitePieces, blackPieces));
    }

    public static BigInteger getTopVertical(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(TOP_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getTopVertical(startCell.shiftLeft(8), whitePieces, blackPieces));
    }

    public static BigInteger getLeftHorizontal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(LEFT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getLeftHorizontal(startCell.shiftRight(1), whitePieces, blackPieces));
    }

    public static BigInteger getRightHorizontal(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.and(RIGHT_BORDER_MASK).compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getRightHorizontal(startCell.shiftLeft(1), whitePieces, blackPieces));
    }

    public static BigInteger getDownVertical(BigInteger startCell, BigInteger whitePieces, BigInteger blackPieces) {
        if (startCell.and(whitePieces).compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (startCell.compareTo(BigInteger.ZERO) == 0 ||
                startCell.and(blackPieces).compareTo(BigInteger.ZERO) == 0) {
            return startCell;
        }
        return startCell.add(getDownVertical(startCell.shiftRight(8), whitePieces, blackPieces));
    }
}
