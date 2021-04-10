package com.mariusmihai.licenta;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnalizaValorilorDeFrontieraTest {

    @Test
    void givenCorrectK_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues());
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());

        Utils.writeInFile(correctValues().setK(1));
        result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
    }

    @Test
    void givenTooSmallK_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setK(-1));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenTooLargeK_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setK((int) Math.pow(10, 9)));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenCorrectN_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues());
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());

        Utils.writeInFile(correctValues().setN(1).setS(List.of(new Interval((int) Math.pow(10, 9) - 2, (int) Math.pow(10, 9) - 1))));
        result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenTooSmallN_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setN(-1));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenTooLargeN_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setN((int) Math.pow(10, 5) + 1));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenCorrectM_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues());
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());

        Utils.writeInFile(correctValues().setM(1).setT(List.of(new Interval(70, 150))));
        result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenCorrectSInterval_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues());
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());

        Utils.writeInFile(correctValues().setS(List.of(new Interval(5, 7), new Interval(120, 185))));
        result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenWrongSInterval_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setS(List.of(new Interval(5, 7), new Interval(-1, -1))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());

        Utils.writeInFile(correctValues().setS(List.of(new Interval(5, 7), new Interval(2, 1))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());

        Utils.writeInFile(correctValues().setS(List.of(new Interval(5, 7), new Interval(1, (int) (Math.pow(10, 9))))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenCorrectTInterval_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues());
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());

        Utils.writeInFile(correctValues().setT(List.of(new Interval(0, 1), new Interval(0, 1))));
        result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenWrongTInterval_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setT(List.of(new Interval(0, 1), new Interval(-1, 185))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());

        Utils.writeInFile(correctValues().setT(List.of(new Interval(0, 1), new Interval((int) Math.pow(10, 9), (int) Math.pow(10, 9) - 1))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());

        Utils.writeInFile(correctValues().setT(List.of(new Interval(0, 1), new Interval(1, (int) (Math.pow(10, 9))))));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    private FileInput correctValues() {
        return new FileInput()
                .setK(4)
                .setN(2)
                .setS(List.of(new Interval(1, 10), new Interval(11, 13)))
                .setM(2)
                .setT(List.of(new Interval(2, 4), new Interval(5, 12)));
    }

}