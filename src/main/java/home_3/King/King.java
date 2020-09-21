package home_3.King;

import testsys.InData;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class King {

    public Function<InData, Optional<BigInteger>> kingMoves = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        Integer a = Integer.parseInt(incomingData[0]);

        Optional<BigInteger> res = this.move(a);
        System.out.println("Шахматные биты. Ход короля.");
        System.out.println(String.format("Тест номер %s. \n" +
                "Входные параметры: \n" +
                "Исходная клетка = %s.\n" +
                "Результат = %s.\n\n\n", x.getTestNumber(), a, res.get().toString()));
        return res;
    };


    public Optional<BigInteger> move(int cell) {
        if (cell > 63 || cell < 0) {
            return Optional.empty();
        }
        BigInteger startCell = BigInteger.valueOf(1).shiftLeft(cell);

        BigInteger leftBorder = BigInteger.valueOf(1).shiftLeft(0).add(
                BigInteger.valueOf(1).shiftLeft(8)).add(
                BigInteger.valueOf(1).shiftLeft(16)).add(
                BigInteger.valueOf(1).shiftLeft(24)).add(
                BigInteger.valueOf(1).shiftLeft(32)).add(
                BigInteger.valueOf(1).shiftLeft(40)).add(
                BigInteger.valueOf(1).shiftLeft(48)).add(
                BigInteger.valueOf(1).shiftLeft(56));

        BigInteger rightBorder = BigInteger.valueOf(1).shiftLeft(7).add(
                BigInteger.valueOf(1).shiftLeft(15)).add(
                BigInteger.valueOf(1).shiftLeft(23)).add(
                BigInteger.valueOf(1).shiftLeft(31)).add(
                BigInteger.valueOf(1).shiftLeft(39)).add(
                BigInteger.valueOf(1).shiftLeft(47)).add(
                BigInteger.valueOf(1).shiftLeft(55)).add(
                BigInteger.valueOf(1).shiftLeft(63));

        BigInteger topBorder = BigInteger.valueOf(1).shiftLeft(56).add(
                BigInteger.valueOf(1).shiftLeft(57)).add(
                BigInteger.valueOf(1).shiftLeft(58)).add(
                BigInteger.valueOf(1).shiftLeft(59)).add(
                BigInteger.valueOf(1).shiftLeft(60)).add(
                BigInteger.valueOf(1).shiftLeft(61)).add(
                BigInteger.valueOf(1).shiftLeft(62)).add(
                BigInteger.valueOf(1).shiftLeft(63));

        topBorder = topBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        leftBorder = leftBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        rightBorder = rightBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));

        BigInteger rightTop = startCell.and(topBorder).and(rightBorder).shiftLeft(9);
        BigInteger top = startCell.and(topBorder).shiftLeft(8);
        BigInteger leftTop = startCell.and(topBorder).and(leftBorder).shiftLeft(7);
        BigInteger right = startCell.and(rightBorder).shiftLeft(1);
        BigInteger left = startCell.and(leftBorder).shiftRight(1);
        BigInteger leftDown = startCell.and(leftBorder).shiftRight(9);
        BigInteger down = startCell.shiftRight(8);
        BigInteger rightDown = startCell.and(rightBorder).shiftRight(7);

        return Optional.of(leftDown
                .add(down)
                .add(rightDown)
                .add(right)
                .add(left)
                .add(leftTop)
                .add(top)
                .add(rightTop));
    }
}
