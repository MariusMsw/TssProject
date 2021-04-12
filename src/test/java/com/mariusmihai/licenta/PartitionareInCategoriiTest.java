package com.mariusmihai.licenta;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PartitionareInCategoriiTest {

    // Wrong K
    @Test
    void givenK_0_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setK(-0));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_Large_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setK((int) Math.pow(10, 9)));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_VeryLarge_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setK((int) Math.pow(10, 10)));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    // Correct K
    @Test
    void givenK_1_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setK(1));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(2, result.get().getX());
        assertEquals(3, result.get().getY());
    }

    @Test
    void givenK_100_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setK(100));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenK_MaxAcceptableValue_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    // Wrong N
    @Test
    void givenN_0_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setN(-0));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenN_Large_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setN((int) Math.pow(10, 5)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenN_VeryLarge_whenSolveProblem_thenThrowsException() {
        Utils.writeInFile(correctValues().setN((int) Math.pow(10, 10)));
        assertThrows(ValueNotInRangeException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    // Correct N
    @Test
    void givenN_1_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setN(1).setS(List.of(new Interval(1, 10))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());
    }

    @Test
    void givenN_2_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setN(2));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
    }

    @Test
    void givenN_MaxAcceptableValue_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setN((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    //Combinations
    @Test
    void givenLowBoundaryValues_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setK(1).setN(1).setM(1).setS(List.of(new Interval(1, 10))).setT(List.of(new Interval(2, 4))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
    }

    @Test
    void givenHighBoundaryValues_whenSolveProblem_thenOk() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN((int) (Math.pow(10, 5) - 1)).setM((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_1_othersMax_ValueTest_thenOk() {
        Utils.writeInFile(correctValues().setK(1).setN((int) (Math.pow(10, 5) - 1)).setM((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenN_1_othersMax_ValueTest() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN(1).setM((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenM_1_othersMax_ValueTest() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN((int) (Math.pow(10, 5) - 1)).setM(1));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_100_othersMax_ValueTest_thenOk() {
        Utils.writeInFile(correctValues().setK(100).setN((int) (Math.pow(10, 5) - 1)).setM((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenN_100_othersMax_ValueTest() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN(100).setM((int) (Math.pow(10, 5) - 1)));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenM_100_othersMax_ValueTest() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN((int) (Math.pow(10, 5) - 1)).setM(100));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_1_N_100_M_Max_thenOK() {
        Utils.writeInFile(correctValues().setK(1).setN(100).setM((int) (Math.pow(10, 5) - 1)).setM(100));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_1_N_Max_M_100_thenOK() {
        Utils.writeInFile(correctValues().setK(1).setN((int) (Math.pow(10, 5) - 1)).setM(100));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_100_N_Max_M_100_thenOK() {
        Utils.writeInFile(correctValues().setK(100).setN((int) (Math.pow(10, 5) - 1)).setM(100));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_100_N_1_M_1_thenOK() {
        Utils.writeInFile(correctValues().setK(100).setN(1).setM(1).setS(List.of(new Interval(1, 10))).setT(List.of(new Interval(2, 4))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenK_Max_N_1_M_1_thenOK() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN(1).setM(1).setS(List.of(new Interval(1, 10))).setT(List.of(new Interval(2, 4))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isEmpty());
    }

    @Test
    void givenK_Max_N_Max_M_1_thenOK() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN((int) (Math.pow(10, 5) - 1)).setM(1)
                .setS(List.of(new Interval(1, 10))).setT(List.of(new Interval(2, 4))));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    @Test
    void givenK_Max_N_Max_M_Max_thenOK() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)).setN((int) (Math.pow(10, 5) - 1)).setM((int) (Math.pow(10, 5) - 1))
                .setS(List.of(new Interval(1, 10))).setT(List.of(new Interval(2, 4))));
        assertThrows(NoSuchElementException.class, () -> new SolveLicentaProblem().solveProblem());
    }

    private FileInput correctValues() {
        return new FileInput()
                .setK(4)
                .setN(2)
                .setS(List.of(new Interval(1, 10), new Interval(11, 13)))
                .setM(2)
                .setT(List.of(new Interval(2, 4), new Interval(5, 12)));
    }
}
