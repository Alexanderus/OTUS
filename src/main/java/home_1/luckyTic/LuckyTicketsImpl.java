package home_1.luckyTic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LuckyTicketsImpl implements LuckyTickets {

    public BigInteger getLuckyTickets(int n) {
        if (n < 0 || 11 < n)
            return null;

        List<BigInteger> numbers = new ArrayList<>(9*n + 1);
        for (int i=0; i<9*n +1; i++)
            numbers.add(i, BigInteger.valueOf(0));

        BigInteger count = BigInteger.valueOf(0);

        summ(0, n, numbers);

        for (int i = 0; i < 9*n+1; i++)
            count = count.add(numbers.get(i).multiply(numbers.get(i)));

        return count;
    }

    private void summ(Integer index, Integer n, List<BigInteger> numbers) {
        for (int i=0; i<10; i++) {
            if (n > 1) {
                summ(index + i, n - 1, numbers);
            }
            else {
                numbers.set(index + i, numbers.get(index + i).add(BigInteger.valueOf(1)));
            }
        }
    }
}
