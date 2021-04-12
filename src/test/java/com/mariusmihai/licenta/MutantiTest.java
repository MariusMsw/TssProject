package com.mariusmihai.licenta;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MutantiTest {

    // if (minim - maxim >= K) -> if (minim - maxim > K)
    @Test
    public void higherShouldPass() {
        Utils.writeInFile(correctValues().setK(1).setN(1).setM(1).setS(List.of(new Interval(4, 7)))
                .setT(List.of(new Interval(5, 8))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert(result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(6, result.get().getY());
    }

    @Test
    public void EqualShouldPass() {
        Utils.writeInFile(correctValues().setK(2).setN(1).setM(1).setS(List.of(new Interval(4, 7)))
                .setT(List.of(new Interval(5, 8))));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert(result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(7, result.get().getY());
    }

    //return Optional.empty() -> return null;
    @Test
    public void killSecondMutant() {
        Utils.writeInFile(correctValues().setK((int) (Math.pow(10, 9) - 1)));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assertNotNull(result);
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
