package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import javax.swing.text.Position;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    void whenPosition() {
        Cell start = Cell.findBy(7, 2);
        BishopBlack bishopBlack = new BishopBlack(start);
        Cell finish = bishopBlack.position();
        assertThat(finish).isEqualTo(start);
    }

    @Test
    void whenCopy() {
        Cell finish = Cell.findBy(7, 2);
        BishopBlack bishopBlackCopy = new BishopBlack(finish);
        assertThat(bishopBlackCopy.position()).isEqualTo(finish);
    }

    @Test
    void whenWay() {
        Cell start = Cell.findBy(7, 2);
        BishopBlack bishopBlack = new BishopBlack(start);
        Cell dest = Cell.findBy(2, 7);
        Cell[] steps = bishopBlack.way(dest);
        assertThat(steps).containsExactly(
                Cell.findBy(6, 3),
                Cell.findBy(5, 4),
                Cell.findBy(4, 5),
                Cell.findBy(3, 6),
                Cell.findBy(2, 7)
        );
    }

    @Test
    void whenWayNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () ->
                bishopBlack.way(Cell.C2));
        assertEquals("Could not way by diagonal from C1 to C2",
                exception.getMessage()
        );
    }
}