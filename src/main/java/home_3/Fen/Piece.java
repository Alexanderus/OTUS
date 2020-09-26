package home_3.Fen;

import java.util.Arrays;
import java.util.Optional;

public enum Piece {
    WHITE_PAWNS('P'),
    WHITE_NIGHTS('N'),
    WHITE_BISHOPS('B'),
    WHITE_ROOKS('R'),
    WHITE_QUEENS('Q'),
    WHITE_KING('K'),
    BLACK_PAWNS('p'),
    BLACK_NIGHTS('n'),
    BLACK_BISHOPS('b'),
    BLACK_ROOKS('r'),
    BLACK_QUEENS('q'),
    BLACK_KING('k');

    private final char ch;

    Piece(char ch) {
        this.ch = ch;
    }

    public static Optional<Piece> valueOf(char ch) {
        return Arrays.stream(values())
                .filter(p -> p.ch == ch)
                .findFirst();
    }
}