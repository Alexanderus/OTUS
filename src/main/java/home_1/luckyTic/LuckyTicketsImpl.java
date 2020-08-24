package home_1.luckyTic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LuckyTicketsImpl implements LuckyTickets {

    public Optional<Long> getLuckyTickets(int n) {
        if (n < 0 || 11 < n) {
            return Optional.empty();
        }

        List<Long> sumOfAnyNumbers = new ArrayList<>(9 * n + 1);
        for (int i = 0; i < 9 * n + 1; i++) {
            sumOfAnyNumbers.add(i, 0L);
        }

        long fullMatches = 0L;

        findMatchesPerSumOfNumbers(0, n, sumOfAnyNumbers);

        for (Long numbersSum : sumOfAnyNumbers) {
            fullMatches = fullMatches + numbersSum * numbersSum;
        }

        return Optional.of(fullMatches);
    }

    private void findMatchesPerSumOfNumbers(Integer index, Integer n, List<Long> numbers) {
        for (int i = 0; i < 10; i++) {
            if (n > 1) {
                findMatchesPerSumOfNumbers(index + i, n - 1, numbers);
            } else {
                numbers.set(index + i, numbers.get(index + i) + 1);
            }
        }
    }
}
