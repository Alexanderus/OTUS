package home_3.Night;

import testsys.InData;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Function;

public class Night {
    public Function<InData, Optional<BigInteger>> knightMoves = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");
        Integer a = Integer.parseInt(incomingData[0]);

        Optional<BigInteger> res = this.move(a);
        System.out.println("Шахматные биты. Ход коня.");
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

        BigInteger leftSingleBorder = BigInteger.valueOf(1).shiftLeft(0).add(
                BigInteger.valueOf(1).shiftLeft(8)).add(
                BigInteger.valueOf(1).shiftLeft(16)).add(
                BigInteger.valueOf(1).shiftLeft(24)).add(
                BigInteger.valueOf(1).shiftLeft(32)).add(
                BigInteger.valueOf(1).shiftLeft(40)).add(
                BigInteger.valueOf(1).shiftLeft(48)).add(
                BigInteger.valueOf(1).shiftLeft(56));

        BigInteger leftDoubleBorder = leftSingleBorder.add(
                BigInteger.valueOf(1).shiftLeft(1)).add(
                BigInteger.valueOf(1).shiftLeft(9)).add(
                BigInteger.valueOf(1).shiftLeft(17)).add(
                BigInteger.valueOf(1).shiftLeft(25)).add(
                BigInteger.valueOf(1).shiftLeft(33)).add(
                BigInteger.valueOf(1).shiftLeft(41)).add(
                BigInteger.valueOf(1).shiftLeft(49)).add(
                BigInteger.valueOf(1).shiftLeft(57));

        BigInteger rightSingleBorder = BigInteger.valueOf(1).shiftLeft(7).add(
                BigInteger.valueOf(1).shiftLeft(15)).add(
                BigInteger.valueOf(1).shiftLeft(23)).add(
                BigInteger.valueOf(1).shiftLeft(31)).add(
                BigInteger.valueOf(1).shiftLeft(39)).add(
                BigInteger.valueOf(1).shiftLeft(47)).add(
                BigInteger.valueOf(1).shiftLeft(55)).add(
                BigInteger.valueOf(1).shiftLeft(63));

        BigInteger rightDoubleBorder = rightSingleBorder.add(
                BigInteger.valueOf(1).shiftLeft(6)).add(
                BigInteger.valueOf(1).shiftLeft(14)).add(
                BigInteger.valueOf(1).shiftLeft(22)).add(
                BigInteger.valueOf(1).shiftLeft(30)).add(
                BigInteger.valueOf(1).shiftLeft(38)).add(
                BigInteger.valueOf(1).shiftLeft(46)).add(
                BigInteger.valueOf(1).shiftLeft(54)).add(
                BigInteger.valueOf(1).shiftLeft(62));

        BigInteger topSingleBorder = BigInteger.valueOf(1).shiftLeft(56).add(
                BigInteger.valueOf(1).shiftLeft(57)).add(
                BigInteger.valueOf(1).shiftLeft(58)).add(
                BigInteger.valueOf(1).shiftLeft(59)).add(
                BigInteger.valueOf(1).shiftLeft(60)).add(
                BigInteger.valueOf(1).shiftLeft(61)).add(
                BigInteger.valueOf(1).shiftLeft(62)).add(
                BigInteger.valueOf(1).shiftLeft(63));

        BigInteger topDoubleBorder = topSingleBorder.add(
                BigInteger.valueOf(1).shiftLeft(48)).add(
                BigInteger.valueOf(1).shiftLeft(49)).add(
                BigInteger.valueOf(1).shiftLeft(50)).add(
                BigInteger.valueOf(1).shiftLeft(51)).add(
                BigInteger.valueOf(1).shiftLeft(52)).add(
                BigInteger.valueOf(1).shiftLeft(53)).add(
                BigInteger.valueOf(1).shiftLeft(54)).add(
                BigInteger.valueOf(1).shiftLeft(55));

        topDoubleBorder = topDoubleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        topSingleBorder = topSingleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        leftSingleBorder = leftSingleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        leftDoubleBorder = leftDoubleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        rightSingleBorder = rightSingleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));
        rightDoubleBorder = rightDoubleBorder.xor(BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE));

        BigInteger topRight = startCell.and(topDoubleBorder).and(rightSingleBorder).shiftLeft(17);
        BigInteger topLeft = startCell.and(topDoubleBorder).and(leftSingleBorder).shiftLeft(15);
        BigInteger rightTop = startCell.and(rightDoubleBorder).and(topSingleBorder).shiftLeft(10);
        BigInteger rightDown = startCell.and(rightDoubleBorder).shiftRight(6);
        BigInteger leftTop = startCell.and(leftDoubleBorder).and(topSingleBorder).shiftLeft(6);
        BigInteger leftDown = startCell.and(leftDoubleBorder).shiftRight(10);
        BigInteger downLeft = startCell.and(leftSingleBorder).shiftRight(17);
        BigInteger downRight = startCell.and(rightSingleBorder).shiftRight(15);

        return Optional.of(topRight
                .add(topLeft)
                .add(rightTop)
                .add(rightDown)
                .add(leftTop)
                .add(leftDown)
                .add(downLeft)
                .add(downRight));
    }
}
